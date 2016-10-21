package de.jformchecker.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import de.jformchecker.adapter.FC;
import de.jformchecker.spring.forms.ExampleForm;
import de.jformchecker.spring.service.FormCheckerService;

@Controller
public class BootstrapController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	FormCheckerService fcService;
	
	@RequestMapping("/bootstrap")
	public ModelAndView bootstrap(HttpServletRequest request) {
		
		FC fc = fcService.provideFormChecker(request, new ExampleForm()); 
		if (fc.isOk()) {
			log.debug("Firstname: " + fc.getValueFor("firstname"));
		}
		return new ModelAndView("bootstrap", "fc", fc.getFcInstance());
	}
	
	
	
}
