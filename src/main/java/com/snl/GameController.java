package com.snl;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import com.snl.enums.Color;
/**
 * @author atiwari
 * 
 * This class is controller for virtual SnakeAndLadder Game.
 * 
 *
 */
public class GameController {

	/**
	*
	* This method is used to give turn to play next. 
	* The current player will roll the dice and then move the token. 
	*
	* @param  noOfPlayer  this parameter defines Number of Player 
	* @param  playerLinkedList this parameter have the details of player like name, which colour they have been assigned
	* 
	* @throws Exception          
	*/
	public boolean giveTurnToNextPlayer(int noOfPlayer,LinkedList<Player> playerLinkedList) throws Exception{
		boolean isWinner = false;
		int playerNumber = 0;
		Board board = new Board(playerLinkedList);
		while(!isWinner) {
			Player currentPlayer = playerLinkedList.remove();
			int diceRollNumber = currentPlayer.rollDice();
			int positionOfToken = currentPlayer.moveTokenInSquare(currentPlayer, diceRollNumber, board);
			if(positionOfToken==100) {
				System.out.println(currentPlayer.getPlayerName()+" "+currentPlayer.getToken().getColor()+" Won.");
				isWinner =true;
				return isWinner;
			}
			playerLinkedList.add(currentPlayer);
			playerNumber++;
			if (playerNumber == noOfPlayer){
				playerNumber = 0;
			}
		}
		return isWinner;
	}
	
	
	public static void main(String[] args) {
	    LinkedList<Player> playerLinkedList = new LinkedList<>();
	    Scanner scanner = null;
	    GameController gameController=null;
	    try {
	    	int index = 1;
			gameController = new GameController();
			scanner = new Scanner(System.in);
			System.out.println("Please Enter the Number of players:\t");
			int noOfPlayers = scanner.nextInt();
			Set<String> colorSet = new HashSet<String>(noOfPlayers);
			for(Color color: Color.values()){
				if(colorSet.size()!=noOfPlayers)
					colorSet.add(color.getColor().toUpperCase());
			}
			for(String str :colorSet){
				System.out.println("Player " + index +" Please Enter the Your Name:\t");
				Token token = new Token();
	        	token.setColor(str);
	        	playerLinkedList.add(new Player(token,scanner.next()));
	        	index++;
			}
	        gameController.giveTurnToNextPlayer(noOfPlayers,playerLinkedList);
	    }catch(Exception exception) {
	    	System.out.println(exception.getMessage());
	    	//Handle Exception
	    }finally {
			if(null!=scanner) {
				scanner.close();
			}
		}
	}

}
