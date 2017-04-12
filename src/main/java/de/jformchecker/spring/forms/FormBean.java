package de.jformchecker.spring.forms;

import java.util.LinkedHashMap;

import javax.validation.constraints.Min;

import de.jformchecker.FormCheckerForm;
import de.jformchecker.adapter.BeanAdapter;
import de.jformchecker.elements.CheckboxInput;
import de.jformchecker.elements.Label;
import de.jformchecker.elements.SelectInput;
import de.jformchecker.fieldmarkers.FieldType;
import de.jformchecker.fieldmarkers.LongText;
import de.jformchecker.utils.FormCheckerBean;
import de.jformchecker.utils.Utils;

/**
 * Classic Bean, that would be used in normal spring-apps for form handling
 * @author jochen
 *
 */
public class FormBean extends BeanAdapter implements FormCheckerBean{
	@Min(5)
	int height;
	
	@LongText
	int widht;
	
	@FieldType(type=CheckboxInput.class) 
	@Label(text="Dein Alter")
	int age;
	
	@FieldType(type=SelectInput.class) 
	@Label(text="Anrede")
	String gender;
	
	
	public int getWidht() {
		return widht;
	}
	public void setWidht(int widht) {
		this.widht = widht;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public void preRun(FormCheckerForm form) {
		System.err.println(Utils.getDebugOutput(form));
		((SelectInput)form.getElement("gender")).setPossibleValues(createSelectMap());
	}
	
	@Override
	public void postRun(FormCheckerForm form) {
		// TODO Auto-generated method stub
	}

	
	private LinkedHashMap<String, String> createSelectMap() {
		LinkedHashMap<String, String> selectEntries = new LinkedHashMap<>();
		selectEntries.put("male", "Herr");
		selectEntries.put("female", "Frau");
		return selectEntries;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}
