package com.snl;

import java.util.Map;

public class Player {
	
	private Token token;
	private String playerName;
	private Dice dice;
	
	public Player() {
		super();
	}

	public Player(Token token, String playerName) {
		super();
		this.token = token;
		this.playerName = playerName;
	}
	
	public int rollDice() throws Exception{
		dice = new Dice();
		return dice.rollDice();
	}
	
	public int moveTokenInSquare(Player player, int diceRollNumber, Board board) throws Exception{
		Map<String, Integer> playerPositions = board.getPlayerPositions();
		int position = playerPositions.get(player.getToken().getColor());
		System.out.println(player.getPlayerName()+" at position "+position+ " dice rolled number "+diceRollNumber);
		if(position+diceRollNumber<=100) {
			position += diceRollNumber;
		}
		if (position == 100){
			playerPositions.put(player.getToken().getColor(), 100);
			return position;
		} else {
			playerPositions.put(player.getToken().getColor(), position);
			return position;
		}

	}

	public String getPlayerName() {
		return playerName;
	}

	public Token getToken() {
		return token;
	}

	@Override
	public int hashCode() {
		return playerName.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (playerName == null) {
			if (other.playerName != null)
				return false;
		} else if (!playerName.equals(other.playerName))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}

	
	
	

}
