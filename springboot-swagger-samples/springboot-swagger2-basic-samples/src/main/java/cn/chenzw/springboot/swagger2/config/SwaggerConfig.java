package cn.chenzw.springboot.swagger2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.chenzw.springboot.swagger2"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes()); // 开启basic认证
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger示例")
                .description("Swagger示例 API 1.0 操作文档")
                //服务条款网址
                .termsOfServiceUrl("https://github.com/otary/springboot-samples")
                .version("1.0")
                .contact(new Contact("夜之子", "https://github.com/otary/springboot-samples", "656469722@qq.com"))
                .build();
    }

    /**
     * 使用basic认证
     *
     * @return
     */
    private List<SecurityScheme> securitySchemes() {
        return Collections.singletonList(new BasicAuth("basicAuth"));
    }

}