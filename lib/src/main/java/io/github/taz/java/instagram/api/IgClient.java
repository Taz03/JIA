package io.github.taz.java.instagram.api;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.github.taz.java.instagram.api.requests.IgRequest;
import io.github.taz.java.instagram.api.requests.accounts.AccountsLoginRequest;
import io.github.taz.java.instagram.api.requests.qe.QeSyncRequest;
import io.github.taz.java.instagram.api.responses.IgBaseResponse;
import io.github.taz.java.instagram.api.responses.IgResponse;

import java.io.ByteArrayOutputStream;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.concurrent.CompletableFuture;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class IgClient {
    private final String username, password;
    private String authorization, cookies;
    private HttpClient httpClient = HttpClient.newHttpClient();

    public IgClient(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAuthorization() {
        return authorization;
    }

    public String getCookies() {
        return cookies;
    }

    public void login() throws Exception {
        httpClient.sendAsync(new QeSyncRequest().formRequest(this), BodyHandlers.discarding())
            .thenAccept(response -> {
                HttpHeaders headers = response.headers();
                String encryptionId = headers.firstValue("ig-set-password-encryption-key-id").get();
                String encryptionKey = headers.firstValue("ig-set-password-encryption-pub-key").get();

                try {
                    String encryptedPassword = encryptPassword(password, encryptionId, encryptionKey);
                    sendRequest(new AccountsLoginRequest(username, encryptedPassword)).join();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            })
            .join();
    }

    public <T extends IgResponse> CompletableFuture<T> sendRequest(IgRequest<T> request) {
        return httpClient.sendAsync(request.formRequest(this), BodyHandlers.ofString())
                .thenApply(response -> {
                    setFromResponseHeaders(response.headers());
                    try {
                        return request.parseResponse(response.body());
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    public void setFromResponseHeaders(HttpHeaders headers) {
        headers.firstValue("ig-set-authorization").ifPresent(value -> this.authorization = value);

        this.cookies = "";
        headers.allValues("set-cookie").forEach(cookie -> this.cookies += cookie);
    }

    public static String encryptPassword(String password, String encryptionId, String encryptionKey) throws Exception {
        final int versionNumber = 4; // the encryption format being used, probably to future-proof the encryption process
        final int ivSize = 12;       // is the size of the initialization vector used for AES
        final int aesKeySize = 32;   // aes key size
        final int gcmTagSize = 16;   // authentication tag that is generated by the AES/GCM encryption

        byte[] randomKey = new byte[aesKeySize];  // random key used for AES encryption
        byte[] iv = new byte[ivSize];  // initialization vector for AES encryption
        SecureRandom sran = new SecureRandom();
        sran.nextBytes(randomKey);
        sran.nextBytes(iv);
        String time = String.valueOf(System.currentTimeMillis() / 1000);  // current timestamp

        // Decode and sanitize the public key
        String decodedPublicKey = new String(Base64.getDecoder().decode(encryptionKey), StandardCharsets.UTF_8)
                        .replaceAll("-(.*)-|\n", "");

        // Encrypt random key with RSA
        Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
        rsaCipher.init(Cipher.ENCRYPT_MODE, KeyFactory.getInstance("RSA")
                .generatePublic(
                        new X509EncodedKeySpec(Base64.getDecoder().decode(decodedPublicKey))));
        byte[] randKeyEncrypted = rsaCipher.doFinal(randomKey);

        // Encrypt password with AES
        Cipher aesGcmCipher = Cipher.getInstance("AES/GCM/NoPadding");
        aesGcmCipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(randomKey, "AES"),
                new GCMParameterSpec(128, iv));
        aesGcmCipher.updateAAD(time.getBytes());
        byte[] encryptedPassword = aesGcmCipher.doFinal(password.getBytes());

        // Write all data to final byte array
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(Integer.valueOf(1).byteValue());
        out.write(Integer.valueOf(encryptionId).byteValue());
        out.write(iv);
        out.write(ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN).putChar((char) randKeyEncrypted.length).array());
        out.write(randKeyEncrypted);
        out.write(Arrays.copyOfRange(encryptedPassword, encryptedPassword.length - gcmTagSize, encryptedPassword.length));
        out.write(Arrays.copyOfRange(encryptedPassword, 0, encryptedPassword.length - gcmTagSize));

        // Return final string formatted as "#PWD_INSTAGRAM:%s:%s:%s", with version, timestamp and encrypted data
        return String.format("#PWD_INSTAGRAM:%s:%s:%s", versionNumber, time, Base64.getEncoder().encodeToString(out.toByteArray()));
    }
}
