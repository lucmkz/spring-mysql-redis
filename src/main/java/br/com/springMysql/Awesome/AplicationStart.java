package br.com.springMysql.Awesome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

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