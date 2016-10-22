package de.jformchecker.spring.forms;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import de.jformchecker.elements.Label;

public class ExampleBean {

	@NotNull
	@Label(text="Der Vorname")
	String firstname;
	
	@NotNull
	@Label(text="Die Checkbox")
	boolean optin;
	
	
	LocalDate birthday = LocalDate.of(1978, 6, 17);

	
	@Size(min = 2, max = 3)
	String lastname;


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
	
	
}
