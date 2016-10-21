package de.jformchecker.spring.service;

import java.lang.reflect.InvocationTargetException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import de.jformchecker.FormChecker;
import de.jformchecker.utils.Utils;

@Service
public class ResultProcessor {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public void processResult(FormChecker fc) {
		if (fc.isValid()) {
			ExampleBean bean = new ExampleBean();
			try {
				Utils.fillBean(fc.getForm().getElements(), bean);
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
				e.printStackTrace();
			}
			log.debug("bean:" + bean);
			log.debug("--------------");
			log.debug(Utils.getDebugOutput(fc.getForm().getElementsAsMap()));
		}
	}
}
