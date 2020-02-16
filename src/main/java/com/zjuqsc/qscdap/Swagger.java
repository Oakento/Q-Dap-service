package com.zjuqsc.qscdap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


@Configuration //标记配置类
@EnableSwagger2 //开启在线接口文档
public class Swagger {
    /**
     * 添加摘要信息(Docket)
     */
    @Bean
    public Docket controllerApi() {
//        ParameterBuilder pb = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<>();
//        pb.name("uid").description("uid").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
//        pars.add(pb.build());
//        pb.name("token").description("token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
//        pars.add(pb.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("标题：")
                        .description("描述：")
                        .version("版本号:1.0")
                        .build())
                .groupName("/")
                .select()
                //  .paths(PathSelectors.regex("^(?!login).*$ | ^(?!error).*$"))
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
        //.globalOperationParameters(pars);
    }


    private List<ApiKey> securitySchemes() {
        List<ApiKey> apiKeyList = new ArrayList();
        apiKeyList.add(new ApiKey("uid", "uid", "header"));
        apiKeyList.add(new ApiKey("token", "token", "header"));
        return apiKeyList;
    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        //        .forPaths(PathSelectors.regex("^(?!login).*$ | ^(?!error).*$"))
                        .build());
        return securityContexts;
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("uid", authorizationScopes));
        securityReferences.add(new SecurityReference("token", authorizationScopes));
        return securityReferences;
    }


}

