package de.jformchecker.spring.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import de.jformchecker.FormChecker;
import de.jformchecker.FormCheckerConfig;
import de.jformchecker.message.MessageSource;
import de.jformchecker.spring.forms.ExampleForm;
import de.jformchecker.spring.forms.RadiosForm;
import de.jformchecker.spring.service.FormCheckerService;

@Controller
public class BootstrapController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	FormCheckerService fcService;
	
	@Autowired
	FormCheckerConfig config;
	
	@RequestMapping("/bootstrap")
	public ModelAndView bootstrap(@RequestParam Map<String, String> params) {

		// FC fc = fcService.provideSimpleFormChecker(params, new
		// ExampleForm());
		// if (fc.isOk()) {
		// log.debug("Firstname: " + fc.getValueFor("firstname"));
		// }
		FormChecker fc1 = FormChecker.build((k) -> params.get(k), new ExampleForm());
		fc1.setConfig(config);
		fc1.run();

		return new ModelAndView("bootstrap", "fc", fc1.getView());

	}

	@RequestMapping("/bootstrap_generic")
	public ModelAndView bootstrapGeneric(@RequestParam Map<String, String> params) {

		// FC fc = fcService.provideSimpleFormChecker(params, new
		// ExampleForm());
		// if (fc.isOk()) {
		// log.debug("Firstname: " + fc.getValueFor("firstname"));
		// }
		FormChecker fc1 = FormChecker.build((k) -> params.get(k), new RadiosForm());
		fc1.setConfig(config);
		fc1.run();

		ModelAndView mv = new ModelAndView("bootstrap", "view", fc1.getView());
		return mv;
	}
}
