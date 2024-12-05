package com.example.ManagementTool;

import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springdoc.core.providers.SpringWebProvider;
import org.springdoc.webmvc.ui.SwaggerWelcomeWebMvc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomSwaggerWelcomeWebMvc extends SwaggerWelcomeWebMvc{
	private String pathPrefix;
	private SpringWebProvider springWebProvider;

	public CustomSwaggerWelcomeWebMvc(SwaggerUiConfigProperties swaggerUiConfig,
			SpringDocConfigProperties springDocConfigProperties, SwaggerUiConfigParameters swaggerUiConfigParameters,
			SpringWebProvider springWebProvider) {
		super(swaggerUiConfig, springDocConfigProperties, swaggerUiConfigParameters, springWebProvider);
		
		this.springWebProvider=springWebProvider;
		
	}
	
	@Override
	protected String buildUrlWithContextPath(String swaggerUiUrl) {
		if(this.pathPrefix==null)
			this.pathPrefix= springWebProvider.findPathPrefix(springDocConfigProperties);
		
		return buildUrl("../"+pathPrefix,swaggerUiUrl);
	}

	protected String buildApiDocUrl() {
		return buildUrlWithContextPath(springDocConfigProperties.getApiDocs().getPath());
		
	}
}
