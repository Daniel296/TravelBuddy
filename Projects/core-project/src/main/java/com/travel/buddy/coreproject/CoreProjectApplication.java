package com.travel.buddy.coreproject;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.travel.buddy.coreproject.configuration.WebConfig;

@SpringBootApplication
public class CoreProjectApplication extends AbstractAnnotationConfigDispatcherServletInitializer {	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
	    return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}

