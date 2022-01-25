package ru.netology.jclo_homework1_1_1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JcloHomework111ApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    public static GenericContainer<?> devApp = new GenericContainer<>("devapp");
    public static GenericContainer<?> prodApp = new GenericContainer<>("prodapp");

    @BeforeAll
    public static void setUp() {
        devApp.start();
        prodApp.start();
    }

    @Test
    void profileDev() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity(
                "http://localhost:" + devApp.getMappedPort(8080) + "/profile", String.class
        );
        System.out.println(forEntity.getBody());
        assertEquals("Current profile is dev", forEntity.getBody());
    }

    @Test
    void profileProd() {
         ResponseEntity<String> forEntity = restTemplate.getForEntity(
                "http://localhost:" + prodApp.getMappedPort(8081) + "/profile", String.class
        );
        System.out.println(forEntity.getBody());
        assertEquals("Current profile is production", forEntity.getBody());
    }
}
