package org.example.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 *
 * @author maza261109
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories("org.example.spring")
public class H2SampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(H2SampleApplication.class, args);
    }
}

