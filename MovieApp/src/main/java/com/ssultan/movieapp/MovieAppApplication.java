package com.ssultan.movieapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
@OpenAPIDefinition(
        info = @Info(
                title = "Movie App",
                description = "Movie App Using OMDB API ",
                version = "v1.0",
                contact = @Contact(
                        name = "saif sultan",
                        email = "saifsoltan18@gmail.com",
                        url ="https://github.com/Ssaif-9/Spring_Movies_App"
                )
        )
)
public class MovieAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieAppApplication.class, args);
    }

}
