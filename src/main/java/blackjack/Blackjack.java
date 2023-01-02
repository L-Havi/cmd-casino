package blackjack;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import AsciiArt.AllPlayingCards;

public class Blackjack {
	private static final int BLACKJACK = 21;

	private static Random random = new Random();
	private static Scanner scanner = new Scanner(System.in);
	
	private static AllPlayingCards playingCards = new AllPlayingCards();
	
	private static int playerTotal;
	private static int dealerTotal;
	private static List<Integer> dealedValues;
	private static List<Integer> playerCards;
	private static List<Integer> dealerCards;
	private static boolean playerTurn;
	private static boolean gameOver;

	public static double play(double totalAmount) {
		boolean run = true;
		
		double pot = 2;
		double winAmount = 0;
		
		List<Integer> numbers = new ArrayList<Integer>();
		
		while(run) {
			int choice = 0;
			dealerTotal = 0;
			playerTotal = 0;
			dealedValues = new ArrayList<Integer>();
			playerCards = new ArrayList<Integer>();
			dealerCards = new ArrayList<Integer>();
			playerTurn = true;
			gameOver = false;
			System.out.println("\tBlackjack");
			System.out.println("-----------------------------------");
			System.out.println("\tBet Size: " + pot + "\tTotal: " + totalAmount);
			System.out.println("-----------------------------------");
			System.out.println("1. Play");
			System.out.println("2. Bet Size");
			System.out.println("3. How to Play");
			System.out.println("4. Exit");
			try {
				choice = scanner.nextInt();
			} catch(InputMismatchException ex) {
				System.out.println("Please type valid input");
			}
			scanner.nextLine();
			if(choice == 1) {
				if((totalAmount - pot) >= 0) {
					totalAmount -= pot;
					winAmount = playHand(pot);
					totalAmount += winAmount;
				} else {
					System.out.println("You don't have enough money!");
				}
			} else if(choice == 2) {
				pot = changeBetSize();
			} else if(choice == 3) {
				howToPlay();
			} else if(choice == 4) {
				run = false;
			} else {
	    		System.out.println("Choose valid action!");
			}
		}
		
		return totalAmount;
	}
	
	private static void howToPlay() {
		
		boolean runInstructions = true;
		
		int pages = 1;
		
		while(runInstructions) {
			System.out.println("-----------------------------------");
			System.out.println("\tBlackjack");
			System.out.println("-----------------------------------");
			if(pages == 1) {
				mainInstructions();
			} else if(pages == 2) {
				runInstructions = false;
			} 
			System.out.println("1. How to Play\t2. Exit");
			if(runInstructions) {
				try {
					pages = scanner.nextInt();
				} catch(InputMismatchException ex) {
					System.out.println("Please type valid input");
				}
			}
		}
		
	}

	private static void mainInstructions() {
		System.out.println("\nHow to Play\n");
		System.out.println("In blackjack, players receive two cards at the beginning of the deal, and the croupier receives one card. \nPlayers can draw additional cards until they think they are close enough to the total score of 21. \nWhen all players have received the desired number of cards, the croupier deals himself additional cards if necessary until his score reaches 17 or more. \nDepending on the player's choice, the value of an ace is either 1 or 11, the value of a picture card is 10, \nand the same as the number of points indicated by the card. The player can play several slots, as well as additional games at the same time. \nThe game uses a deck of 52 cards without jokers.");
		
	}

	private static double changeBetSize() {
		for(int k = 0; k < 20; k++) {
			System.out.println();
		}
		System.out.println("Type a bet size (e.g. 2.5)");
		double choice = 0;
		boolean run = true;
		while(run) {
			try {
				choice = scanner.nextDouble();
			} catch(InputMismatchException ex) {
				System.out.println("Please type valid input");
			}
			if(choice != 0) {
				run = false;
			}
		}

		return choice;
	}
	
	private static double playHand(double bet) {
		
		dealInitialCards();

		while (!gameOver) {
			if (playerTurn) {
				playerTurn();
			} else {
				dealerTurn();
			}
		}

		double winnings = announceWinner(bet);
		return winnings;
	}

	private static void playerTurn() {
		System.out.println("Your total is: " + playerTotal);
		System.out.println("Hit or stand (h/s)?");
		char choice = readPlayerChoice();
		if (choice == 'h') {
			int card = drawCard();
			playerCards.add(card);
			
			while(card > 13) {
				card -= 13;
			}
			
			if(card >= 2 && card <= 10) {
				playerTotal += card;
			} else if(card > 10) {
				playerTotal += 10;
			} else if(card == 1 && (playerTotal + 11 > 21)) {
				playerTotal += 1;
			} else if(card == 1 && (playerTotal + 11 <= 21)) {
				playerTotal += 11;
			}
			
			String[][] playerAsciiCards = new String[playerCards.size()][];
			
			for(int i = 0; i < playerAsciiCards.length ; i++) {
				playerAsciiCards[i] = playingCards.returnCard(playerCards.get(i));
			}
			
			System.out.println("Player's Hand");
			for(int j = 0; j < 6; j++) {
				for(int i = 0; i < playerAsciiCards.length; i++) {
					System.out.print(playerAsciiCards[i][j]);
				}
				System.out.println();
			}
			System.out.println("You drew a " + card);
			if (playerTotal > BLACKJACK) {
				System.out.println("You bust!");
				gameOver = true;
			}
		} else {
			playerTurn = false;
		}
	}

	private static void dealerTurn() {
		System.out.println("Dealer total is: " + dealerTotal);
		if (dealerTotal < 17) {
			int card = drawCard();
			dealerCards.add(card);
			
			while(card > 13) {
				card -= 13;
			}
			
			if(card >= 2 && card <= 10) {
				dealerTotal += card;
			} else if(card > 10) {
				dealerTotal += 10;
			} else if(card == 1 && (dealerTotal + 11 > 21)) {
				dealerTotal += 1;
			} else if(card == 1 && (dealerTotal + 11 <= 21)) {
				dealerTotal += 11;
			}
			System.out.println("Dealer drew a " + card);
			if (dealerTotal > BLACKJACK) {
				System.out.println("Dealer busts!");
				gameOver = true;
			}
		} else {
			gameOver = true;
		}
	}

	private static double announceWinner(double bet) {
		if (gameOver) {
			if(playerTotal <= 21 && dealerTotal <= 21) {
				if (playerTotal > dealerTotal) {
					if(playerTotal == 21 && playerCards.size() == 2) {
						System.out.println("You win, Blackjack!");
						return (bet * 2.5);
					} else {
						System.out.println("You win!");
						return (bet * 2);
					}

				} else if (dealerTotal > playerTotal) {
					System.out.println("Dealer wins!");
					return 0;
				} else {
					System.out.println("It's a tie!");
					return bet;
				}
			} else if(playerTotal > 21) {
				return 0;
			} else {
				return (bet * 2);
			}

		}
		return bet;
	}

	private static void dealInitialCards() {
		
		int tempCard;
		
		for(int i = 0; i < 2; i++) {
			tempCard = drawCard();
			playerCards.add(tempCard);
			while(tempCard > 13) {
				tempCard -= 13;
			}
			if(tempCard >= 2 && tempCard <= 10) {
				playerTotal += tempCard;
			} else if(tempCard > 10) {
				playerTotal += 10;
			} else if(tempCard == 1) {
				playerTotal += 11;
			}
		}
		
		tempCard = drawCard();
		dealerCards.add(tempCard);
		
		while(tempCard > 13) {
			tempCard -= 13;
		}
		if(tempCard >= 2 && tempCard <= 10) {
			dealerTotal += tempCard;
		} else if(tempCard > 10) {
			dealerTotal += 10;
		} else if(tempCard == 1) {
			dealerTotal += 11;
		}
		
		dealerCards.add(54);
		String[][] dealerAsciiCards = new String[dealerCards.size()][];
		
		for(int i = 0; i < dealerAsciiCards.length; i++) {
			dealerAsciiCards[i] = playingCards.returnCard(dealerCards.get(i));
		}
		
		System.out.println("Dealer's Hand");
		for(int j = 0; j < 6; j++) {
			for(int i = 0; i < dealerAsciiCards.length; i++) {
				System.out.print(dealerAsciiCards[i][j]);
			}
			System.out.println();
		}	
		dealerCards.remove(1);
		
		String[][] playerAsciiCards = new String[playerCards.size()][];
		
		for(int i = 0; i < dealerAsciiCards.length; i++) {
			playerAsciiCards[i] = playingCards.returnCard(playerCards.get(i));
		}
		System.out.println("\n");
		System.out.println("Player's Hand");
		for(int j = 0; j < 6; j++) {
			for(int i = 0; i < playerAsciiCards.length; i++) {
				System.out.print(playerAsciiCards[i][j]);
			}
			System.out.println();
		}	
		
	}

	private static int drawCard() {

		boolean run = true;
		int card = 0;
		
		while(run) {
			card = random.nextInt(52) + 1;
		  	if(!dealedValues.contains(card)) {
		  		run = false;
		  		dealedValues.add(card);
		  	}
		}
		
		return card;
	}

	private static char readPlayerChoice() {
		while (true) {
			String input = scanner.nextLine().trim();
		    if (input.equalsIgnoreCase("h")) {
		    	return 'h';
		    } else if (input.equalsIgnoreCase("s")) {
		    	return 's';
		    } else {
		    	System.out.println("Please enter 'h' to hit or 's' to stand:");
		    }
		}
	}

}
