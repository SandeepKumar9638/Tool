
package com.example.ManagementTool;

import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springdoc.core.providers.SpringWebProvider;
import org.springdoc.webmvc.ui.SwaggerWelcomeWebMvc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwagerConfig {

	@Bean
	public GroupedOpenApi internalApi() {
		return GroupedOpenApi.builder().group("internal").pathsToMatch("/**").build();
	}

	@Bean
	public GroupedOpenApi externalApi() {
		return GroupedOpenApi.builder().group("Entities").pathsToMatch("/dba-names").build();
	}

	public SwaggerWelcomeWebMvc customSwaggerWelcomeWebMvc(SwaggerUiConfigProperties swaggerUiConfigProperties,
														SpringDocConfigProperties configProperties,
														SwaggerUiConfigParameters configParameters,
														SpringWebProvider springWebProvider) {
		return new CustomSwaggerWelcomeWebMvc(swaggerUiConfigProperties, configProperties, configParameters, springWebProvider);
	}
	
}
