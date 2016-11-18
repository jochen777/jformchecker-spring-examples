package de.jformchecker.spring.forms;

import de.jformchecker.adapter.BeanAdapter;

/**
 * Classic Bean, that would be used in normal spring-apps for form handling
 * @author jochen
 *
 */
public class FormBean extends BeanAdapter{
	int height;
	int widht;
	
	
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

}
