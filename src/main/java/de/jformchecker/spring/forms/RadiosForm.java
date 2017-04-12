package de.jformchecker.spring.forms;

import java.util.LinkedHashMap;

import de.jformchecker.FormCheckerForm;
import de.jformchecker.criteria.Criteria;
import de.jformchecker.elements.RadioInput;
import de.jformchecker.elements.TextInput;

public class RadiosForm extends FormCheckerForm {

	public void init() {
		
		add(TextInput.build("firstname").setDescription("Your Firstname").setPreSetValue("Peter").setRequired()
				.setCriterias(Criteria.accept("Peter", "Max"), Criteria.maxLength(10)));


		// RFE: simple map-builder
		LinkedHashMap<String, String> radioEntries = createRadioMap();

		add(RadioInput.build("rdio").setPossibleValues(radioEntries).setDescription("Your Choice"));

		LinkedHashMap<String, String> radioEntries2= createRadioMap2();

		add(RadioInput.build("rdio2").setPossibleValues(radioEntries2).setDescription("Radio2"));


		this.setId("example");
		
		this.disableHtml5Validation();

	}



	private LinkedHashMap<String, String> createRadioMap() {
		LinkedHashMap<String, String> radioEntries = new LinkedHashMap<>();
		radioEntries.put("one", "One $");
		radioEntries.put("two", "Two $");
		radioEntries.put("three", "Three $");
		return radioEntries;
	}

	private LinkedHashMap<String, String> createRadioMap2() {
		LinkedHashMap<String, String> radioEntries = new LinkedHashMap<>();
		radioEntries.put("one", "One $");
		radioEntries.put("two", "Two $");
		radioEntries.put("three", "Three $");
		return radioEntries;
	}

}
