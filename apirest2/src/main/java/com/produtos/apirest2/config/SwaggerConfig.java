package com.produtos.apirest2.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket ProductApi() {
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.produtos.apirest"))
		.build()
		.apiInfo(metaInfo());
	}
	
	public ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Produtos API REST",
				"API REST de cadastros de produtos.",
				"1.0",
				"Terms of Service",
				new Contact("Victor", "https://github.com/victorstati", "victorstti@outlook.com"),
				"Apache License Version 2.0",
				"http://www.apache.org/license.html", new ArrayList<VendorExtension>()
				);
		return apiInfo;
	}
}
