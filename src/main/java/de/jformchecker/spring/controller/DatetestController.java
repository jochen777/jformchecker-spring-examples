package de.jformchecker.spring.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import de.jformchecker.adapter.FC;
import de.jformchecker.spring.forms.ExampleForm;
import de.jformchecker.spring.forms.ExampleFormDate;
import de.jformchecker.spring.service.FormCheckerService;

@Controller
public class DatetestController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	FormCheckerService fcService;
	
	@RequestMapping("/datetest")
	public ModelAndView bootstrap(@RequestParam Map<String, String> params) {
		
		FC fc = fcService.provideSimpleFormChecker(params, new ExampleFormDate()); 
		if (fc.isOk()) {
			log.debug("Birthdate: " + fc.getValueFor("birthdate"));
		}
		return new ModelAndView("bootstrap", "fc", fc.getFcInstance());
	}
	
	
	
}
