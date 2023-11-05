package io.github.taz03.jia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@Configuration
public class TestConfiguration {
    @Bean
    public User user() {
        try {
            return new ObjectMapper().readValue(Files.readString(Path.of("src/integrationTest/resources/user.json")), User.class);
        } catch (IOException e) {
            return new User("", "", "", "");
        }
    }

    @Bean
    public InstagramClient client(@Autowired User user) {
        return new InstagramClient(user.username(), user.password());
    }

    @Bean
    public long instagramPk() {
        // pk of official instagram account - https://www.instagram.com/instagram/
        return 25025320;
    }
}
