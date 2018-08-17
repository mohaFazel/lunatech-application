package org.lunatech.assessment.lunatechapplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class LunatechApplication {

    private static final Logger logger = LoggerFactory.getLogger(LunatechApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LunatechApplication.class, args);
        logger.info("Application Started Successfully");
        System.out.println("Let's enjoy the Lunatech test CSV");
    }
}
