package com.snl;

public class Token {
	
	private String color;
	
	public Token() {
		super();
	}
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Token [color=" + color + "]";
	}

}
