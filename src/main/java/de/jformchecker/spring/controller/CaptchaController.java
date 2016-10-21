package de.jformchecker.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import de.jformchecker.FormChecker;
import de.jformchecker.adapter.request.ServletRequestAdapter;
import de.jformchecker.spring.forms.ExampleFormCaptcha;
import de.jformchecker.spring.service.ResultProcessor;

@Controller
public class CaptchaController {
	
	@Autowired
	ResultProcessor resultProcessor;

	@RequestMapping("/captcha")
	public ModelAndView bootstrap(HttpServletRequest request) {
		
		// TODO: Make recaptcha working!
		FormChecker fc = FormChecker.build("id", ServletRequestAdapter.of(request), new ExampleFormCaptcha()).run();

		resultProcessor.processResult(fc);
		return new ModelAndView("bootstrap", "fc", fc);
	}
	
	
	
}
