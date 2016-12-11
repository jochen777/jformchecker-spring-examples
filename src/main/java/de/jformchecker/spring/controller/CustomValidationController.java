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
import de.jformchecker.criteria.ValidationResult;
import de.jformchecker.elements.TextInput;
import de.jformchecker.spring.forms.ExampleForm;
import de.jformchecker.spring.service.FormCheckerService;

@Controller
public class CustomValidationController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	FormCheckerService fcService;
	
	@RequestMapping("/customval")
	public ModelAndView customVal(@RequestParam Map<String, String> params) {
		
		ExampleForm form = new ExampleForm();
		TextInput ti = (TextInput) form.getElement("textInput");
		ti.addCriteria(elem -> {
			if (!elem.getValue().equals("horst")) {
				return ValidationResult.failWithTranslated("This can not be ");
			} else {
				return ValidationResult.ok();
			}
			
		});
		
		
		FC fc = fcService.provideSimpleFormChecker(params, form); 
		if (fc.isOk()) {
			log.debug("Firstname: " + fc.getValueFor("firstname"));
		}
		return new ModelAndView("bootstrap", "fc", fc.getFcInstance());
	}
	
	
	
}
