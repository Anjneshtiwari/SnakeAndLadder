package com.snl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Board {

	private Map<String, Integer> playerPositions;
	
	public Board(LinkedList<Player> players){
		this.playerPositions = new HashMap<String, Integer>();
		for (Player player : players){
			this.playerPositions.put(player.getToken().getColor(), 1);
		}
	}

	public Map<String, Integer> getPlayerPositions() {
		return playerPositions;
	}

}
