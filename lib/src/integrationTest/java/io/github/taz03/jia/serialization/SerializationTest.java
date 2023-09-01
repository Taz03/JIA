package io.github.taz03.jia.serialization;

import static io.github.taz03.jia.TestProxy.client;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import io.github.taz03.jia.InstagramClient;
import org.junit.jupiter.api.Test;

public class SerializationTest {
    @Test
    public void serializationTest() throws Exception{
        File dir = new File("src/integrationTest/resources");
        client.serialize(dir);

        assertTrue(dir.exists());
    }

    @Test
    public void deserializationTest() throws Exception {
        InstagramClient deserialized = InstagramClient.deserialize(new File("src/integrationTest/resources"));

        assertNotNull(deserialized);
    }
}
