package br.com.springMysql.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Lucas Duarte
 */

@EnableAutoConfiguration
@ComponentScan(basePackages = "br.com.springMysql.endpoint")
public class AplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(AplicationStart.class, args);
    }
}