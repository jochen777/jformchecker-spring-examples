package de.jformchecker.spring.controller;

import org.hibernate.validator.constraints.Range;

import de.jformchecker.elements.Label;

public class Form1 {
	@Label(text="Höhe")
	Integer height;
	
	
	@Label(text="Länge")
	@Range(min=10, max=100)
	int lenght=0;
	
	public Form1() {
		
	}
	public int getLenght() {
		return lenght;
	}
	public void setLenght(int lenght) {
		this.lenght = lenght;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	
	
}
