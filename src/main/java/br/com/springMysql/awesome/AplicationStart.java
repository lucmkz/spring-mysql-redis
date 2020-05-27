package br.com.springMysql.awesome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Created by Lucas Duarte
 */

@SpringBootApplication
@EnableCaching
//@EnableAutoConfiguration
//@Configuration
public class AplicationStart {
    public static void main(String[] args) {

        SpringApplication.run(AplicationStart.class, args);
    }
}