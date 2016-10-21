package de.jformchecker.spring.controller;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import de.jformchecker.FormChecker;
import de.jformchecker.FormCheckerConfig;
import de.jformchecker.adapter.message.ResourceBundleMessageSource;
import de.jformchecker.spring.forms.ExampleForm;
import de.jformchecker.spring.service.ResultProcessor;
import de.jformchecker.themes.TwoColumnBootstrapFormBuilder;

@Controller
public class BootstrapController {
	
	@Autowired
	ResultProcessor resultProcessor;
	
	
	@Autowired
	private MessageSource messageSource;

	@RequestMapping("/bootstrap")
	public ModelAndView bootstrap(HttpServletRequest request) {
		
		FormCheckerConfig config = new FormCheckerConfig(key -> messageSource.getMessage(key, null, LocaleContextHolder.getLocale()) , new TwoColumnBootstrapFormBuilder());

		FormChecker fc = FormChecker.build("id", key -> request.getParameter(key), new ExampleForm()).
				setProtectAgainstCSRF(
				key -> request.getSession().getAttribute(key), 
				(k,v)-> request.getSession().setAttribute(k, v)
				).setConfig(config)
				.run();
		resultProcessor.processResult(fc);
		return new ModelAndView("bootstrap", "fc", fc);
	}
	
	
	
}
