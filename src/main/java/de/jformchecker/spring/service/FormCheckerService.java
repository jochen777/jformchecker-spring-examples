package de.jformchecker.spring.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.jformchecker.FormCheckerConfig;
import de.jformchecker.FormCheckerForm;
import de.jformchecker.adapter.FC;
import de.jformchecker.spring.forms.ExampleForm;

@Service
public class FormCheckerService {

	@Autowired
	FormCheckerConfig config;
	
	public FC provideFormChecker(HttpServletRequest request, FormCheckerForm formCheckerForm) {
		return FC.secure(config, request, formCheckerForm);
	}
}
