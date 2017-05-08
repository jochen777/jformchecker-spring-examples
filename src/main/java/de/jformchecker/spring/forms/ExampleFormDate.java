package de.jformchecker.spring.forms;


import java.time.LocalDate;

import de.jformchecker.FormCheckerForm;
import de.jformchecker.criteria.Criteria;
import de.jformchecker.elements.CheckboxInput;
import de.jformchecker.elements.DateInputSelectCompound;
import de.jformchecker.elements.DateInputSelectCompound.YearRange;
import de.jformchecker.elements.LongTextInput;
import de.jformchecker.elements.RadioInput;
import de.jformchecker.elements.TextInput;
import de.jformchecker.message.MessageSource;

public class ExampleFormDate extends FormCheckerForm {
	
	MessageSource messageSource;
	DateInputSelectCompound birthday;
	
	public ExampleFormDate(MessageSource ms){
		messageSource = ms;
		birthday = DateInputSelectCompound.build("birthdate", 2000, 2019, messageSource).setDescription("Birthdate");
	}

	
	public void init() {

		birthday.setPresetValue(LocalDate.now());
		
		add(birthday);

		add(TextInput.build("email").setDescription("Your Email")
				.setCriterias(Criteria.emailAddress()));

		add(LongTextInput.build("description").setRequired().setDescription("Your Description!"));

		add(CheckboxInput.build("agb").setDescription("AGB"));
		
		add(RadioInput.build ("anrede", new String[]{"a","b"}, new String[]{"peter", "pater"}));
		add(DateInputSelectCompound.build("horst", YearRange.birthday(), messageSource));

		this.disableHtml5Validation();
	}

}
