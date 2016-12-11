package de.jformchecker.spring.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.jformchecker.FormCheckerConfig;
import de.jformchecker.FormCheckerForm;
import de.jformchecker.adapter.FC;

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

	
	public FC provideFormCheckerFromBean(Object bean, FormCheckerForm formCheckerForm) {
		return FC.simpleFromBean(config, bean, formCheckerForm);
	}

}
