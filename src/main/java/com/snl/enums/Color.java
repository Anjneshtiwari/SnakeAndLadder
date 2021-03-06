package com.snl.enums;

public enum Color {
    RED("red"), YELLOW("yellow"), BLUE("blue"), GREEN("green"); 
	
	private String color;
	
	Color(String color) {
	    this.color = color;
	}
	 
    public String getColor() {
        return color;
    }
}
