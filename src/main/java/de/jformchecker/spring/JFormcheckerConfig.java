package de.jformchecker.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;

import de.jformchecker.FormCheckerConfig;
import de.jformchecker.themes.BasicBootstrapFormBuilder;

@Configuration
public class JFormcheckerConfig {
	@Autowired
	private MessageSource messageSource;

	@Bean
	public FormCheckerConfig getConfig() {
		return new FormCheckerConfig(key -> messageSource.getMessage(key, null, LocaleContextHolder.getLocale()) 
				, new BasicBootstrapFormBuilder());
		
	}
	
	
}
