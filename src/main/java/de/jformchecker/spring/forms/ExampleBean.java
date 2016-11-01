package de.jformchecker.spring.forms;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import de.jformchecker.FormCheckerForm;
import de.jformchecker.elements.HTMLSnippet;
import de.jformchecker.elements.IgnoreFormElement;
import de.jformchecker.elements.Label;
import de.jformchecker.utils.FormCheckerBean;

public class ExampleBean implements FormCheckerBean{

	@NotNull
	@Label(text="Der Vorname")
	String firstname;
	
	@NotNull
	@Label(text="Die Checkbox")
	boolean optin;
	
	@Min(18)
	@Label(text="Dein Alter")
	int age;
	
	LocalDate birthday = LocalDate.of(1978, 6, 17);

	
	@Size(min = 2, max = 3)
	String lastname;

	@IgnoreFormElement
	String checksum;
	

	public ExampleBean(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public boolean isOptin() {
		return optin;
	}


	public void setOptin(boolean optin) {
		this.optin = optin;
	}


	public LocalDate getBirthday() {
		return birthday;
	}


	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getChecksum() {
		return checksum;
	}


	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}


	@Override
	public void preRun(FormCheckerForm form) {
		form.
		add(HTMLSnippet.build("headline").setHTML("<h1>Headline</h1>"));
	}


	@Override
	public void postRun(FormCheckerForm form) {
		// TODO Auto-generated method stub
		
	}
	
	
}
