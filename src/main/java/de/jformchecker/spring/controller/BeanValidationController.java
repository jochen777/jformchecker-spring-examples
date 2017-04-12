package de.jformchecker.spring.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import de.jformchecker.FormCheckerForm;
import de.jformchecker.adapter.FC;
import de.jformchecker.spring.forms.ExampleBean;
import de.jformchecker.spring.service.FormCheckerService;
import de.jformchecker.utils.BeanUtils;

/**
 * Testing Bean-Validation struff
 * 
 * @author jochen
 *
 */
@Controller
public class BeanValidationController {

	@Autowired
	FormCheckerService fcService;

	@RequestMapping("/beanelegant")
	public ModelAndView bootstrapElegant(@RequestParam Map<String, String> params) {
		Form1 e = new Form1();
//		e.setHeight(11);
//		e.setLenght(55);
 
		 FC fc = fcService.buildAndProcess(params, e);
		 if (fc.isOk()) {
			   System.err.println("L:"+ e.getLenght());
			   System.err.println("H:"+ e.getHeight());
		 }
		return new ModelAndView("bootstrap", "fc", fc.getFcInstance());
	}
	
	

	@RequestMapping("/beanelegant2")
	public ModelAndView bootstrapElegant2(@RequestParam Map<String, String> params) {
		ExampleBean e = new ExampleBean("", "");
 
		 FC fc = fcService.buildAndProcess(params, e);
		 if (fc.isOk()) {
			   System.err.println(e.getFirstname());
		 }
		return new ModelAndView("bootstrap", "fc", fc.getFcInstance());
	}
	
	
	
	@RequestMapping("/bean")
	public ModelAndView bootstrap(HttpServletRequest request) {

		ExampleBean e = new ExampleBean("Jochen", "Pier");

		// ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		// Validator validator = factory.getValidator();
		// Set<ConstraintViolation<ExampleBean>> constraintViolations =
		// validator.validate( e );

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

	@RequestMapping("/beanclean")
	public ModelAndView bootstrapClean(@RequestParam Map<String, String> allRequestParams) {
		/*
		 * 
		 * FC fc = fcService.get(params, Bean.class);
		 * if (fc.isOk()) {
		 *    Bean bean = fc.getBean();
		 * }
		 * 
		 * FC fc = fcService.get(params, bean);
		 * if (fc.isOk()) {
		 *    bean.getTest();
		 * }
		 * 
		 */
		
		FC fc = fcService.provideSimpleFormChecker(allRequestParams, 
				BeanUtils.fromBean(
				new ExampleBean("Jochen!", "Pier"))
				);
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


