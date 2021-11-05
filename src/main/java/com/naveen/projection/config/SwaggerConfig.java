package com.naveen.projection.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("public-api")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.naveen.projection"))
				.paths(PathSelectors.any()).build();
	}

	

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Spring _data-Redis API")
				.description("Redis API reference for developers")
				.termsOfServiceUrl("http://ashokit.in")
				.contact("AshokIt@gmail.com").license("AshokIt License")
				.licenseUrl("AshokIt@gmail.com").version("1.0").build();
	}
}
