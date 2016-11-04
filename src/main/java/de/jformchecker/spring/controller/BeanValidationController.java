package de.jformchecker.spring.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import de.jformchecker.FormCheckerForm;
import de.jformchecker.adapter.FC;
import de.jformchecker.spring.forms.ExampleBean;
import de.jformchecker.spring.service.FormCheckerService;
import de.jformchecker.utils.BeanUtils;

/**
 * Testing Bean-Validation struff
 * @author jochen
 *
 */
@Controller
public class BeanValidationController {
	
	@Autowired
	FormCheckerService fcService;
	
	@RequestMapping("/bean")
	public ModelAndView bootstrap(HttpServletRequest request) {
		
		ExampleBean e = new ExampleBean("Jochen", "Pier");
		
//		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//		Validator validator = factory.getValidator();
//		Set<ConstraintViolation<ExampleBean>> constraintViolations =
//                validator.validate( e );
		
		
		FormCheckerForm f = BeanUtils.fromBean(e);
		
		FC fc = fcService.provideFormChecker(request, f); 
		if (fc.isOk()) {
			ExampleBean resultBean = new ExampleBean("", "");
			try {
				BeanUtils.fillBean(fc.getFcInstance().getForm(), resultBean);
				System.err.println("Resulted Bean: " + resultBean.getBirthday());
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		return new ModelAndView("bootstrap", "fc", fc.getFcInstance());
	}
	
}
