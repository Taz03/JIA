package io.github.taz03.jia;

// Proxy Client
public final class TestClient {
    private static InstagramClient client;

    public static InstagramClient getClient() {
        return client;
    }

    public static void setClient(InstagramClient client) {
        TestClient.client = client;
    }
}
