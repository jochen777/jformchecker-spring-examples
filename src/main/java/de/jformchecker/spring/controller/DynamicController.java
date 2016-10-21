package de.jformchecker.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import de.jformchecker.FormChecker;
import de.jformchecker.adapter.request.ServletRequestAdapter;
import de.jformchecker.elements.TextInput;
import de.jformchecker.spring.forms.ExampleForm;
import de.jformchecker.spring.service.ResultProcessor;

@Controller
public class DynamicController {
	
	@Autowired
	ResultProcessor resultProcessor;

	@RequestMapping("/dynamic")
	public ModelAndView bootstrap(HttpServletRequest request) {
		
		ExampleForm form = new ExampleForm();
		if (request.getSession().getAttribute("add1") != null) {
			form.add(TextInput.build("text").setDescription("Additional"));
		}
		FormChecker fc = FormChecker.build("id", ServletRequestAdapter.of(request), form).run();
		resultProcessor.processResult(fc);
			if ("add".equals(fc.getValue("btn"))) {
				request.getSession().setAttribute("add1", "add");
			}
		return new ModelAndView("bootstrap", "fc", fc);
	}
	
	
	
}
