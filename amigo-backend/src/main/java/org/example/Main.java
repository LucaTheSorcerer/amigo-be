package org.example;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Amigo App", version="1.0", description = "Apis for Amigo Chat backend"))
@PropertySource("file:${user.dir}/.env")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}