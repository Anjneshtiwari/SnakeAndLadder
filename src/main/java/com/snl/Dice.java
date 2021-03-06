package com.snl;

import java.util.Random;

public class Dice {
	
	private int rollValue;


	public int rollDice() {
		 
		 rollValue = new Random().nextInt(6)+1;
		 return rollValue;
	}
	
	

}
