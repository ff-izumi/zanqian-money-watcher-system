package com.zanqian.framework.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author GanQuan
 * @date 2025-05-20 15:18
 */
@EnableKnife4j
@Configuration
public class Knife4jConfiguration {

    @Bean
    public GroupedOpenApi appApi() {
        return getOpenApi("APP端", "com.zanqian.modules.controller.app");
    }


    @Bean
    public OpenAPI springDocOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("zanqian-接口文档")
                        .version("1.0")
                        .description("amigo")
                        .termsOfService("服务条款")
                        .contact(new Contact().name("zanqian").url("http://www.zanqian.com"))
                        .license(new License().name("zanqian").url("http://www.zanqian.com"))

                );
    }

    private static GroupedOpenApi getOpenApi(String name, String packageName) {
        return GroupedOpenApi.builder()
                .group(name)
                .packagesToScan(packageName)
                .build();
    }
}
