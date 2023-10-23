package com.example.app.SpringBootWebNaturix;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.logging.Logger;

@SpringBootApplication
public class NaturixApplication {

    private static final Logger LOGGER =
            Logger.getLogger(NaturixApplication.class.getName());

    public static void main(String[] args) {

        new SpringApplicationBuilder(NaturixApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);

        LOGGER.info("APP is running...");
    }

}
