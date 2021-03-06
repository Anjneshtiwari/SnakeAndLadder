package com.snl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	
	private Board board;
	
	@Before
	public void setup() {
		LinkedList<Player> playerLinkedList = new LinkedList<>();
		Player player1 = new Player(new Token(),"Player 1");
		Player player2 = new Player(new Token(),"Player 2");
		playerLinkedList.add(player1);
		playerLinkedList.add(player2);
		board = new Board(playerLinkedList);
	}
	
	@Test
	public void testIsGameStarted() {
		int playerPosition = 1;
		Player player1 = new Player(new Token(),"Player 1");
		assertTrue(playerPosition == board.getPlayerPositions().get(player1.getPlayerName()));
	}
	
	@Test
	public void testPlayerPositionAfterDiceRollOutThreePositiveScenario() throws Exception {
		int expectedPlayerPosition = 4;
		int diceRollOutValue = 3;
		Player player1 = new Player(new Token(),"Player 1");
		assertTrue(expectedPlayerPosition == player1.moveTokenInSquare(player1, diceRollOutValue,board));
	}
	
	@Test
	public void testPlayerPositionAfterDiceRollOutThreeNegativeScenario() throws Exception {
		int expectedPlayerPosition = 3;
		int diceRollOutValue = 3;
		Player player1 = new Player(new Token(),"Player 1");
		assertFalse(expectedPlayerPosition == player1.moveTokenInSquare(player1, diceRollOutValue,board));
	}
	@Test
	public void testPlayerPositionAfterDiceRollOutThreeAndFourPositiveScenario() throws Exception  {
		int diceRollOutValueIsThree = 3;
		int expectedPlayerPositionAfterRollThree = 4; 
		int diceRollOutValueIsFour = 4;
		int expectedPlayerPositionAfterRollFour = 8;
		Player player1 = new Player(new Token(),"Player 1");
		assertEquals(expectedPlayerPositionAfterRollThree, player1.moveTokenInSquare(player1, diceRollOutValueIsThree,board));
		assertEquals(expectedPlayerPositionAfterRollFour, player1.moveTokenInSquare(player1, diceRollOutValueIsFour,board));
	}

	@Test
	public void testPlayerPositionAfterDiceRollOutThreeAndFourNegativeScenario() throws Exception {
		int diceRollOutValueIsThree = 3;
		int expectedPlayerPositionAfterRollThree = 3; 
		int diceRollOutValueIsFour = 4;
		int expectedPlayerPositionAfterRollFour = 7;
		Player player1 = new Player(new Token(),"Player 1");
		assertNotEquals(expectedPlayerPositionAfterRollThree, player1.moveTokenInSquare(player1, diceRollOutValueIsThree,board));
		assertNotEquals(expectedPlayerPositionAfterRollFour, player1.moveTokenInSquare(player1, diceRollOutValueIsFour, board));
	}
	
	@Test
	public void testPlayerSpaceOnGameBoardAfterDiceRollOutNumberIsFour() throws Exception {
		int diceRollValue = 4;
		int expectedPlayerSpaceNumber = 5;
		Player player1 = new Player(new Token(),"Player 1");
		assertEquals(expectedPlayerSpaceNumber, player1.moveTokenInSquare(player1, diceRollValue, board));
	}
	
	@Test
	public void testDiceRollNumberShouldBetweenOneToSix() throws Exception {
		Player testPlayer = new Player();
		assertTrue(testPlayer.rollDice()>=1 && testPlayer.rollDice()<=6);
	}
	
	@Test
	public void testPlayerWonAfterTokenReachedAtHundred() throws Exception {
		Player player1 = new Player(new Token(),"Player 1");
		board.getPlayerPositions().put("Player 1", 97);
		int diceRollValue = 3;
		int expectedTokenOnSquare = 100;
		assertEquals(expectedTokenOnSquare, player1.moveTokenInSquare(player1, diceRollValue, board));
	}
	
	@Test
	public void testPlayerWonAfterTokenReachedAtHundredNegative() throws Exception {
		Player player1 = new Player(new Token(),"Player 1");
		board.getPlayerPositions().put("Player 1", 97);
		int diceRollValue = 4;
		int expectedTokenOnSquare = 100;
		assertNotEquals(expectedTokenOnSquare, player1.moveTokenInSquare(player1, diceRollValue, board));
	}

}
