package de.jformchecker.spring.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.jformchecker.FormCheckerConfig;
import de.jformchecker.FormCheckerForm;
import de.jformchecker.adapter.FC;
import de.jformchecker.utils.BeanUtils;

@Service
public class FormCheckerService {

	@Autowired
	FormCheckerConfig config;
	
	public FC provideFormChecker(HttpServletRequest request, FormCheckerForm formCheckerForm) {
		return FC.secure(config, request, formCheckerForm);
	}

	public FC provideSimpleFormChecker(Map<String, String> params, FormCheckerForm formCheckerForm) {
		return FC.simple(config, params, formCheckerForm);
	}

	
	public FC provideFormCheckerFromBean(Object bean, FormCheckerForm formCheckerForm, String submitted) {
		return FC.simpleFromBean(config, bean, formCheckerForm, submitted);
	}

	// create a formchecker-instance out of an object and fill this object
	public FC buildAndProcess(Map<String, String> params, Object e) {
		FC fc = provideSimpleFormChecker(params, 
				BeanUtils.fromBean(e));
		
		try {
			BeanUtils.fillBean(fc.getFcInstance().getForm(), e);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		return fc;
	}

}
