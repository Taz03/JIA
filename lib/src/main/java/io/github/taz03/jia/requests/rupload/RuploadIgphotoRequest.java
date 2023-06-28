package io.github.taz03.jia.requests.rupload;

import java.io.IOException;
import java.net.http.HttpRequest.BodyPublishers;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import io.github.taz03.jia.InstagramClient;
import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.rupload.RuploadIgphotoResponse;

/**
 * Represents an Instagram rupload igphoto request, used to get details about an Instagram user.
 */
public final class RuploadIgphotoRequest extends InstagramPostRequest<RuploadIgphotoResponse> {
    private final byte[] array;

    /**
     * Creates an Instagram rupload igphoto request.
     *
     * @param path path to the photo to upload
     */
    public RuploadIgphotoRequest(Path path) throws IOException {
        this(Files.readAllBytes(path));
    }

	/**
     * Creates an Instagram rupload igphoto request.
     *
	 * @param array byte array created from the photo to upload
	 */
	public RuploadIgphotoRequest(byte[] array) {
		super(RuploadIgphotoResponse.class, "/rupload_igphoto/" + createName(), null, BodyPublishers.ofByteArray(array));
        this.array = array;
	}

    @Override
    protected Map<String, Object> getHeaders(InstagramClient client) {
        String[] url = this.getUrl().split("/");
        String name = url[url.length - 1];

        Map<String, Object> headers = new HashMap<>(super.getHeaders(client));
        headers.put("X-Instagram-Rupload-Params", "{\"upload_id\":\"%s\",\"media_type\":\"1\"}".formatted(name));
        headers.put("X-Entity-Name", name);
        headers.put("X-Entity-Length", array.length);
        headers.put("Offset", 0);

        return headers;
    }

    private static String createName() {
        return String.valueOf(System.currentTimeMillis());
    }
}
