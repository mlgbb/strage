package com.example.strage.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.LinkedList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        //添加swagger中的请求头信息
//        ParameterBuilder parameterBuilder = new ParameterBuilder();
//        List<Parameter> headers = new LinkedList<>();
//        parameterBuilder.name("Authorization")
//                .description("token")
//                .modelRef(new ModelRef("string"))
//                .parameterType("header")
//                .required(false).build();
//        headers.add(parameterBuilder.build());

        com.google.common.base.Predicate<RequestHandler> selector1 = RequestHandlerSelectors.basePackage("com.example.strage.controller");
        com.google.common.base.Predicate<RequestHandler> selector2 = RequestHandlerSelectors.basePackage("com.example.strage.springbootdemo.controller");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(Predicates.or(selector1,selector2))
                //不显示错误的接口地址
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .paths(PathSelectors.any())
                .build();
//                .globalOperationParameters(headers);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("mlgbb测试平台")
                .version("1.0")
                .build();
    }
}