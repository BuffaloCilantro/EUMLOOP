/**
 * EField.java
 * Assignment: Final Project
 * Purpose: field class for my class class(EClass). this practices string concatenation. 
 * 
 * @version 06/27/19 
 * 
 */

public class EField {
	String type;
	String name;
	
	public EField(String type, String name) {
		this.type = type;
		this.name = name;
	}
	
	public String toString() {
		return type + " " + name;
	}
}
