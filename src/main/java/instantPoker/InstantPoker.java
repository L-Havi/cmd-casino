package instantPoker;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InstantPoker {

	private static Card cards = new Card();
	
	private static CheckCardRow checkCardRow = new CheckCardRow();
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static double runInstantPoker(double totalAmount) {
		
		boolean jokerRounds = false;
		boolean run = true;
		
		double jokerRoundCounter = 0;
		double pot = 1;
		double winAmount = 0;
		double results[] = new double[2];
		
		while(run) {
			int choice = 0;
			System.out.println("\tInstant Poker");
			System.out.println("-----------------------------------");
			if(jokerRoundCounter > 0) {
				System.out.println("\tJoker Rounds: " + jokerRoundCounter);
			}
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
					results = playHand(jokerRounds, pot, totalAmount);
					totalAmount += results[0];
					if(results[1] == 2) {
						jokerRounds = true;
						jokerRoundCounter = 11;
					}
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
			if(jokerRoundCounter >= 1) {
				jokerRoundCounter--;
				if(jokerRoundCounter == 1) {
					jokerRounds = false;
				}
			}
		}
		
		return totalAmount;
	}

	private static void howToPlay() {
		
		boolean runInstructions = true;
		
		int pages = 1;
		
		while(runInstructions) {
			System.out.println("-----------------------------------");
			System.out.println("\tInstant Poker");
			System.out.println("-----------------------------------");
			if(pages == 1) {
				mainInstructions();
			} else if(pages == 2) {
				jokerRoundInstructions();
			} else if(pages == 3) {
				doublingInstructions();
			} else if(pages == 4) {
				runInstructions = false;
			} 
			System.out.println("1. How to Play\t2. Joker Rounds");
			System.out.println("3. Doubling   \t4. Exit");
			if(runInstructions) {
				try {
					pages = scanner.nextInt();
				} catch(InputMismatchException ex) {
					System.out.println("Please type valid input");
				}
			}
		}
		
	}

	private static void doublingInstructions() {
		System.out.println("\tDoubling\n");
		System.out.println("In doubling, the player is dealt five cards, \nof which the first card on the left is face up.");
		System.out.println("The player must guess which of the other four cards has a higher value \nthan the card shown. Doubling does not include jokers.\n");
		System.out.println("If the chosen card is bigger than the shown card, \nthe player wins twice his bet and can continue doubling or return to the basic game.");
		System.out.println("If the selected card is smaller than the displayed card, \nthe doubling ends and the player loses the amount he bet on the doubling.");
		System.out.println("In doubling, the ace (A) is worth one.");
		System.out.println("-----------------------------------");	
	}

	private static void jokerRoundInstructions() {
		System.out.println("\tJoker Rounds\n");
		System.out.println("If the player gets a straight or better hand in the game round, \nin the next ten rounds there is one Joker card in the deck. \nA joker card replaces any other card. Joker rounds have one more \nwinning category, Five of a Kind.\n");
		System.out.println("The number of rounds is shown in a separate joker round counter. \nWild rounds can be won at all bet levels and are valid for the \nbet selected at the time of winning or for smaller bets.");
		System.out.println("-----------------------------------");	
	}

	private static void mainInstructions() {
		System.out.println("\tHow to Play\n");
		System.out.println("The purpose of the game is to get the best possible poker hand. \nThe hand is ready when its five cards are visible.\n");
		System.out.println("The game uses a deck of 52 cards. In joker rounds, one joker card\n is added to the deck. In the basic game, the ace (A)\nis 1 or 14, depending on which is more favorable for the hand.");
		System.out.println("The game round starts with the Play input. The machine deals the \nplayer two cards face up and two stacks of three cards, \nof which the top cards are face up and the other cards are face down.");
		System.out.println("The player selects the stack of three cards he wants by clicking on it.\nThe game turns the other two cards of the pile chosen \nby the player face up and these form the player's card hand.");
		System.out.println("-----------------------------------");	
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

	private static double[] playHand(boolean jokerRounds, double pot, double totalAmount) {
		
		List<Integer> finalCards = null;
		boolean runHand = true;
		double winnings = 0;
		double jokerRoundsDouble = 0;
		
		if(jokerRounds) {
			jokerRoundsDouble = 1;
		}
		
		while(runHand) {
			for(int k = 0; k < 20; k++) {
				System.out.println();
			}
			System.out.println("\tBet Size: " + pot + "\tTotal: " + totalAmount);
			List<Integer> choiceRowCards = cards.createChoiceRow(jokerRounds);   
			System.out.println("\tRow 1\tRow 2");
			System.out.println("\t 1\t 2");
			int choice = 0;
			try {
				choice = scanner.nextInt();
			} catch(InputMismatchException ex) {
				System.out.println("Please type valid input (1 or 2)");
			}
			scanner.nextLine();
			if(choice == 1) {
				int removedItem = choiceRowCards.get(3);
				choiceRowCards.remove(3);
				finalCards = cards.createFinalRow(choiceRowCards, removedItem, jokerRounds);
				winnings = checkCardRow.checkRow(pot, finalCards);
				if(winnings > 0) {
					if(winnings >= (pot * 11)) {
						jokerRoundsDouble = 2;
					}
					winnings = doubleWinnings(winnings, pot);
				} else {
					System.out.println("No win");
				}
				runHand = false;
			} else if (choice == 2) {
				int removedItem = choiceRowCards.get(2);
				choiceRowCards.remove(2);
				finalCards = cards.createFinalRow(choiceRowCards, removedItem, jokerRounds);
				winnings = checkCardRow.checkRow(pot, finalCards);
				if(winnings > 0) {
					winnings = doubleWinnings(winnings, pot);
				} else {
					System.out.println("No win");
				}
				runHand = false;
			} else {
				System.out.println("Please choose row 1 or 2!");
			}
		}
		
		double[] statistics = { winnings, jokerRoundsDouble };
		
		return statistics;
	}
	
	private static double doubleWinnings(double winnings, double pot) {
		boolean runDoubling = true;
		String winningHand = getWinningHand(winnings, pot);
		int doubleCounter = 0;
		while(runDoubling) {
			if(doubleCounter == 0) {
    			System.out.println("You've got " + winningHand);
    			System.out.println("Won: " + winnings);
    			System.out.println("-----------------");
    			System.out.println("1. Double");
    			System.out.println("2. Take winnings");
			} else {
    			System.out.println("Won: " + winnings);
    			System.out.println("-----------------");
    			System.out.println("1. Double");
    			System.out.println("2. Take winnings");
			}
			int choice = 0;
			try {
    			choice = scanner.nextInt();
			} catch(InputMismatchException ex) {
				System.out.println("Please type valid input (1 or 2)");
			}
			scanner.nextLine();
			if(choice > 0 && choice < 3) {
				if(choice == 1) {
            		boolean dbl = cards.doubleWin();
            		if(dbl) {
            			winnings *= 2; 
            		} else {
    					winnings = 0;
    					runDoubling = false;
            		}
				} else {
					runDoubling = false;
				}
			} else {
    			System.out.println("Choose 1 or 2!");
			}
		}
		return winnings;
	}
	
	private static String getWinningHand(double winnings, double pot) {
		if(winnings / pot == 125) {
			return "Five of a Kind";
		} else if(winnings / pot == 100) {
			return "Royal Flush";
		} else if(winnings / pot == 75) {
			return "Straight Flush";
		} else if(winnings / pot == 50) {
			return "Four of a Kind";
		} else if(winnings / pot == 20) {
			return "Full House";
		} else if(winnings / pot == 15) {
			return "Flush";
		} else if(winnings / pot == 11) {
			return "Straight";
		} else if(winnings / pot == 5) {
			return "Three of a Kind";
		} else if(winnings / pot == 3) {
			return "Two Pairs";
		} else if(winnings / pot == 2) {
			return "Pair (10-A)";
		}
		return null;
	}
	
}
