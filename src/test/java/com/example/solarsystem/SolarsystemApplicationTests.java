package com.example.solarsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
    "spring.datasource.url=jdbc:mysql://localhost:3306/spring_project",
    "spring.datasource.username=root",
    "spring.datasource.password=he2ma2nt2" 
})
public class SolarsystemApplicationTests {

    @Test
    void contextLoads() {
    }
}