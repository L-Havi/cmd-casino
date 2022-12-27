package com.instantPokerCLI;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
	
	private static Card cards = new Card();
	
	private static CheckCardRow checkCardRow = new CheckCardRow();
	
	private static Scanner scanner = new Scanner(System.in);
	
    public static void main(String[] args ) {
    	
    	boolean jokerRounds = false;
    	boolean run = true;
    	
    	double pot = 1;
    	
    	while(run) {
    		int choice = 0;
    		System.out.println("1. Play");
			try {
    			choice = scanner.nextInt();
			} catch(InputMismatchException ex) {
				System.out.println("Please type valid input");
			}
			scanner.nextLine();
    		if(choice == 1) {
    			List<Integer> finalCards = null;
        		List<Integer> choiceRowCards = cards.createChoiceRow(jokerRounds);   
        		System.out.println("1. Row 1");
        		System.out.println("2. Row 2");
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
        		} else if (choice == 2) {
        			int removedItem = choiceRowCards.get(2);
        			choiceRowCards.remove(2);
        			finalCards = cards.createFinalRow(choiceRowCards, removedItem, jokerRounds);
        		}
        		
        		double winnings = checkCardRow.checkRow(pot, finalCards);
        				
        		if(winnings > 0) {
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
        		} else {
        			System.out.println("No win");
        		}

    		} else {
        		System.out.println("Choose valid action!");
    		}
    	}
    	
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
