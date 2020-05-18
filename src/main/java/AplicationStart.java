import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Lucas Duarte
 */

//@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "br.com.springMysql.endpoint")
@Configuration
public class AplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(AplicationStart.class, args);
    }
}