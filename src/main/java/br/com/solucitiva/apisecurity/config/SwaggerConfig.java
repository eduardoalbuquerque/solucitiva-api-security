package br.com.solucitiva.apisecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket userApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.solucitiva.apisecurity"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo(){
        ApiInfo apiInfo = new ApiInfo(
                "Users API REST",
                "API REST para cadastro de Usuários",
                "1.0",
                "Terms of service",
                new Contact("Eduardo Albuquerque","https://www.solucitiva.com.br",
                        "eduardo.albuquerue@Hotmail.com.br"),
                "Apache license Version 2.0",
                "https://www.apache.org/licesen,html", new ArrayList<VendorExtension>()
        );
        return apiInfo;
    };

}
