package de.jformchecker.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import de.jformchecker.adapter.FC;
import de.jformchecker.spring.forms.FormBean;
import de.jformchecker.spring.service.FormCheckerService;
import de.jformchecker.utils.BeanUtils;

@Controller
public class BeanInputController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	FormCheckerService fcService;
	
	// Warning: This does not work at the moment!
	@RequestMapping("/fromBean")
	public ModelAndView bootstrap(FormBean formBean, BindingResult result, String submittedValue) {
		
		log.debug("Height: " + formBean.getHeight());
		
		FC fc = fcService.provideFormCheckerFromBean(formBean, BeanUtils.fromBean(formBean), submittedValue); 
		if (fc.isOk()) {
			log.debug("Firstname: " + fc.getValueFor("height"));
		}
		return new ModelAndView("bootstrap", "fc", fc.getFcInstance());
	}
	
	
	
}
