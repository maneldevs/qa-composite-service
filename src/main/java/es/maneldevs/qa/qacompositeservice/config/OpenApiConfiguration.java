package es.maneldevs.qa.qacompositeservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfiguration {
    private static final String TITLE = "QA Application";
    private static final String DESCRIPTION = "Programming Question and Answers application";
    private static final String VERSION = "1.0.0";

    @Bean
    OpenAPI getOpenAPI() {
        Info info = new Info().title(TITLE).description(DESCRIPTION).version(VERSION);
        return new OpenAPI().info(info);
    }
    
}
