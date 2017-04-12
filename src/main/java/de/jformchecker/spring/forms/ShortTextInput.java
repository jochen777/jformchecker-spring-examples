package de.jformchecker.spring.forms;

import de.jformchecker.TagAttributes;
import de.jformchecker.elements.TextInput;

public class ShortTextInput extends TextInput{
	public static ShortTextInput build(String name) {
		ShortTextInput i = new ShortTextInput();
		i.name = name;
		i.inputAttributes = new TagAttributes("class", " short");
		return i;
	}

} 
