package io.github.taz03.jia.requests.rupload;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpRequest.BodyPublishers;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import io.github.taz03.jia.InstagramClient;
import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.rupload.RuploadIgphotoResponse;

public final class RuploadIgphotoRequest extends InstagramPostRequest<RuploadIgphotoResponse> {
    private final byte[] array;
    private final String imgType;

    public RuploadIgphotoRequest(File photo) throws IOException {
        this(Files.readAllBytes(photo.toPath()), photo.getName().split("\\.")[1]);
    }

	public RuploadIgphotoRequest(byte[] array, String imgType) {
		super(RuploadIgphotoResponse.class, "/rupload_igphoto/" + createName(), null, BodyPublishers.ofByteArray(array));
        this.array = array;
        this.imgType = imgType;
	}

    @Override
    protected Map<String, Object> getHeaders(InstagramClient client) {
        String[] url = this.getUrl().split("/");
        String name = url[url.length - 1];

        Map<String, Object> headers = new HashMap<>();
        headers.putAll(super.getHeaders(client));
        headers.put("X-Instagram-Rupload-Params", "{\"upload_id\":\"%s\",\"media_type\":\"1\"}".formatted(name.split("_0_")[0]));
        headers.put("X-Entity-Name", name);
        headers.put("X-Entity-Length", array.length);
        headers.put("X-Entity-Type", "image/" + imgType);
        headers.put("Offset", 0);

        return headers;
    }

    private static String createName() {
        return System.currentTimeMillis() + "_0_" + ThreadLocalRandom.current().nextLong(1_000_000_000L, 9_999_999_999L);
    }
}
