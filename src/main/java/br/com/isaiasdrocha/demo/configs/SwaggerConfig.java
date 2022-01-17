package br.com.isaiasdrocha.demo.configs;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.isaiasdrocha.demo.forum.model.Usuario;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
   
	@Value("${info.app.version}")
	private String appVersion;// = "0.0.1-SNAPSHOT";
	
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.select()
        		.apis(RequestHandlerSelectors.basePackage("br.com.isaiasdrocha"))
        		.paths(PathSelectors.ant("/**")) //PathSelectors.any()
        		.build()
        		.ignoredParameterTypes(Usuario.class)
        		.globalOperationParameters(Arrays.asList(
        				new ParameterBuilder()
        				.name("Authorization")
        				.description("Header para token JWT")
        				.modelRef(new ModelRef("string"))
        				.parameterType("header")
        				.required(false)
        				.build()
        		));
        		//.groupName("public-api")
        		//.apiInfo(metaInfo())
                //.useDefaultResponseMessages(false)
    }

	/*
    private ApiInfo metaInfo() {
        return new ApiInfoBuilder()
                .title("JavaInUse API")
                .description("API - Exemplos de java e rest.")
                .version(appVersion)
                .termsOfServiceUrl("http://javainuse.com")
                .license("Apache 2.0")
                .licenseUrl("http://javainuse.com")
                .build();
    }
*/
}