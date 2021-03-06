package com.snl;

import com.snl.enums.Color;

public class Test {

	
	public static void main(String[] args) {
		for(Color color: Color.values()){
			System.out.println(color.toString());
		}
	}
}
