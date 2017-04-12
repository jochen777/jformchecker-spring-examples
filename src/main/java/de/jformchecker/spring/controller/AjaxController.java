package de.jformchecker.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import de.jformchecker.AjaxUtils;
import de.jformchecker.FormChecker;
import de.jformchecker.adapter.request.ServletRequestAdapter;
import de.jformchecker.spring.forms.ExampleForm;
import de.jformchecker.spring.forms.RadiosForm;
import de.jformchecker.spring.service.ResultProcessor;
import de.jformchecker.themes.TwoColumnBootstrapFormBuilder;

@Controller
public class AjaxController {
	
	@Autowired
	ResultProcessor resultProcessor;

	@GetMapping("/ajax")
	public ModelAndView  ajax(HttpServletRequest request) {
		FormChecker fc = FormChecker.build(ServletRequestAdapter.of(request), new ExampleForm())
				.setFormBuilder(new TwoColumnBootstrapFormBuilder());
		fc.run();
		return new ModelAndView("ajax", "fc", fc);
	}
	
	@RequestMapping("/ajax_receive")
	public @ResponseBody String  ajaxReceive(HttpServletRequest request) {
		FormChecker fc = FormChecker.build(ServletRequestAdapter.of(request), new RadiosForm());
		fc.run();
		resultProcessor.processResult(fc);
		return(AjaxUtils.getJsonOutput(fc));
	}
	
	
	
}
