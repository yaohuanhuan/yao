package com.yao.admin.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by 姚焕焕 on 2018/08/09 14:28
 * desc
 * qq 1107129170@qq.com
 */

@Configuration
@EnableSwagger2
@EnableWebMvc
@ComponentScan(basePackages = {"com.yao.admin.controller"})
public class Swagger2 {

//访问地址http://localhost:8080/swagger-ui.html

    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2).
                useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("^(?!auth).*$"))
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(securitySchemes());
//                //全局限制接口登录权限验证
//                .securityContexts(securityContexts());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API Doc")
                .description("API Doc")
                .version("1.0.0")
                .build();
    }

    private List<ApiKey> securitySchemes() {
        ApiKey ak = new ApiKey("Authorization", "Authorization", "header");
        List<ApiKey> akList = new ArrayList();
        akList.add(ak);
        return akList;
    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> akList = new ArrayList();
        akList.add(SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("^(?!auth).*$"))
                .build());
        return akList;
    }
    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return newArrayList(new SecurityReference("Authorization", authorizationScopes));
    }

}