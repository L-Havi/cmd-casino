package com.instantPokerCLI;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Card {

	static Scanner scanner = new Scanner(System.in);
	
	private static AllPlayingCards allPlayingCards = new AllPlayingCards();
	
	private static CheckCardRow checkCardRow = new CheckCardRow();
	
	private static String[] addCard(int value) {
		
		String[] card = allPlayingCards.returnCard(value);
		
	    return card;
	}
	
	public static List<Integer> createChoiceRow(boolean jokerRounds) {
		
		String[][] cards = new String[4][];
		List<Integer> usedCards = new ArrayList<Integer>();
		
		for(int i = 0; i < cards.length; i++) {
			
			int[] tempValues = generateValues(jokerRounds);
			
			int value = tempValues[0] * tempValues[1];
			
			if(!usedCards.contains(value)) {
				cards[i] = addCard(value);
				usedCards.add(value);
			} else {
				i--;
			}

		}
		
		for(int k = 0; k < 20; k++) {
			System.out.println();
		}
		
		System.out.println("-----------------------------------");
		System.out.println("               _____  _____ ");
		System.out.println("              |\\ ~ /||\\ ~ /|");
		System.out.println("               _____  _____ ");
		System.out.println("              |\\ ~ /||\\ ~ /|");
		
		for(int j = 0; j < 6; j++) {
			for(int i = 0; i < cards.length; i++) {
				System.out.print(cards[i][j]);
			}
			System.out.println();
		}	
		List<Integer> ranks = checkCardRow.getCardRanks(usedCards);
		List<Integer> suits = checkCardRow.getCardSuits(usedCards);

		String cardsInput = "";
		
		for(int i = 0; i < ranks.size(); i++) {
			String rank = null;
			if(ranks.get(i) > 10 || ranks.get(i) == 1) {
				if(ranks.get(i) == 11) {
					rank = "J";
				} else if(ranks.get(i) == 12) {
					rank = "Q";
				} else if(ranks.get(i) == 13) {
					rank = "K";
				} else if(ranks.get(i) == 1) {
					rank = "A";
				}
			} else {
				rank = ranks.get(i).toString();
			}
			if(suits.get(i) == 1) {
				cardsInput += "\u2660" + rank + "\t";
			} else if(suits.get(i) == 2) {
				cardsInput += "\u2663" + rank + "\t";
			} else if(suits.get(i) == 3) {
				cardsInput += "\u2665" + rank + "\t";
			} else if(suits.get(i) == 4) {
				cardsInput += "\u2666" + rank + "\t";
			} else if(suits.get(i) == 5) {
				cardsInput += "Joker\t";
			}
		}
		
		System.out.println(cardsInput);
		System.out.println("-----------------------------------");
		return usedCards;
	}
	
	private static int[] generateValues(boolean jokerRounds){
		
		Random rn = new Random();
		
		int[] values = new int[2];
		
		
		if(jokerRounds) {
			int randomNum = rn.nextInt((53 - 1) + 1) + 1;
			if(randomNum == 53) {
				values[0] = 1;
				values[1] = 53;
				return values;
			}
		}
		
		values[0] = rn.nextInt((4 - 1) + 1) + 1;
		values[1] = rn.nextInt((13 - 1) + 1) + 1;
		
		return values;
	}
	
	public static List<Integer> createFinalRow(List<Integer> oldRow, int removedItem ,boolean jokerRounds) {
		
		String[][] cards = new String[5][];
		
		int index = 0;
		
		for(int item : oldRow) {
			cards[index] = addCard(item);
			index++;
		}
		
		for(int i = 3; i < cards.length; i++) {
			
			int[] tempValues = generateValues(jokerRounds);
			
			int value = tempValues[0] * tempValues[1];
			
			if(!(oldRow.contains(value) || value == removedItem)) {
				cards[i] = addCard(value);
				oldRow.add(value);
			} else {
				i--;
			}

		}
		for(int k = 0; k < 20; k++) {
			System.out.println();
		}
		System.out.println("-----------------------------------");
		for(int j = 0; j < 6; j++) {
			for(int i = 0; i < cards.length; i++) {
				System.out.print(cards[i][j]);
			}
			System.out.println();
		}	
		
		return oldRow;
	}
	
	public static boolean doubleWin() {
		
		boolean runInput = true;
		
		String[][] cards = new String[5][];
		
		List<Integer> possibleValues = new ArrayList<Integer>();
		
		int[] doubleValue = generateValues(false);
		int value = doubleValue[0] * doubleValue[1];
		possibleValues.add(value);
		cards[0] = addCard(value);
		
		for(int i = 1; i < cards.length; i++) {
			cards[i] = addCard(54);
		}
		for(int k = 0; k < 20; k++) {
			System.out.println();
		}
		System.out.println("-----------------------------------");
		for(int j = 0; j < 6; j++) {
			for(int i = 0; i < cards.length; i++) {
				System.out.print(cards[i][j]);
			}
			System.out.println();
		}	
		System.out.println("-----------------------------------");
		for(int i = 1; i < cards.length; i++) {
			
			int[] tempValues = generateValues(false);
			
			int tempValue = tempValues[0] * tempValues[1];
			
			if(!possibleValues.contains(tempValue)) {
				cards[i] = addCard(tempValue);
				possibleValues.add(tempValue);
			} else {
				i--;
			}
		}
		
		int decision = 0;
		
		while(runInput) {
			System.out.println("Choose a card. (1-4)");
			int choice = 0;
			try {
    			choice = scanner.nextInt();
			} catch(InputMismatchException ex) {
				System.out.println("Please type valid input (1-4)");
			}
			scanner.nextLine();
			if(choice > 0 && choice < 5) {
				decision = possibleValues.get(choice);
				runInput = false;
			} else {
				System.out.println("Choose a card. (1-4)");
			}
		}
		
		boolean result = compareTwoCardSizes(possibleValues.get(0), decision);
		for(int k = 0; k < 20; k++) {
			System.out.println();
		}
		System.out.println("-----------------------------------");
		for(int j = 0; j < 6; j++) {
			for(int i = 0; i < cards.length; i++) {
				System.out.print(cards[i][j]);
			}
			System.out.println();
		}	
		System.out.println("-----------------------------------");
		
		return result;
	}

	private static boolean compareTwoCardSizes(int doubleValue, int decision) {
		
		boolean largerThan13 = true;
		
		while(largerThan13) {
			if(decision > 13) {
				decision -= 13;
			} else {
				largerThan13 = false;
			}
		}
		
		if(decision > doubleValue) {
			return true;
		}
		
		return false;
	}
}
