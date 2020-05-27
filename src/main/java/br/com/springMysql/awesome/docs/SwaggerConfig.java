package br.com.springMysql.awesome.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket apiDoc() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("br.com.springMysql.Awesome.Controller"))
                    .paths(PathSelectors.regex("/v1.*"))
                    .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder().title("Persistence FIAP - Spring / MySql / Redis")
                .description("Trabalho para avaliação da diciplina de Persistence na FIAP MBA")
                .version("1.0.0")
                .contact(new Contact("Lucas", "http://lucaswebs.com", "l.duarte.mk@gmail.com"))
                .license("Apacha Licence version 2.0")
                .licenseUrl("https://apache.org/LICENSE-2.0")
                .build();
    }
}
