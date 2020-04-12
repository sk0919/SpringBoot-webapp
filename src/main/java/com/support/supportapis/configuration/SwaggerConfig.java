/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.support.supportapis.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

/**
 *
 * @author <Sumit Mishra>
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer{
//    @Bean
//    public Docket postsApi() {
//            return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
//                            .apiInfo(apiInfo()).select().paths(postPaths()).build();
//    }
//
//    private Predicate<String> postPaths() {
//            return or(regex("/v1/test.*"),regex("/user/v1/.*"));
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().title("Support API")
//                        .description("Support API reference for developers")
//                        .termsOfServiceUrl("http://test.abc")
//                        .contact("test@test.com").license("test License")
//                        .licenseUrl("test@test.com").version("1.0").build();
//    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    
    @Bean(name = "swaggerApi")
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.support.supportapis.controller"))
                .paths(PathSelectors.any())
                .build()
                .groupName("support-service-API");
    }
    
    private ApiInfo getApiInfo() {

        return new ApiInfoBuilder()
                .title("Support Services APIs")
                .description("Rest APIs for web and mobile")
                .version("1.0.0")
                .build();
    }
}
