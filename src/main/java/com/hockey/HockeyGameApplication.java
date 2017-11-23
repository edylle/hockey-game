package com.hockey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class HockeyGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(HockeyGameApplication.class, args);
	}

	@Configuration
	public static class MvcConfig extends WebMvcConfigurerAdapter {

		@Autowired
		private MessageSource messageSource;

		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addRedirectViewController("/", "/home");
		}

		@Override
		public Validator getValidator() {
			LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
			validator.setValidationMessageSource(messageSource);

			return validator;
		}

	}

}
