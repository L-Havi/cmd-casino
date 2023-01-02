package slot;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SlotMachine {
	private static final String[] symbols = {"Cherry", "Lemon", "Plum", "Bell", "Bar"};
	private static final Random random = new Random();
	private static final Scanner scanner = new Scanner(System.in);

	public static double play(double totalAmount) {
		boolean run = true;
		
		double pot = 2;
		double winAmount = 0;
		
		List<Integer> numbers = new ArrayList<Integer>();
		
		while(run) {
			int choice = 0;
			System.out.println("\tSlots");
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
					winAmount = playRound(pot);
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
	
	public static double playRound(double bet) {
		String[] result = spinReels();
		System.out.println("Result: ");
		printResult(result);
		double winnings = getWinnings(result, bet);
		System.out.println("Winnings: " + winnings);
		System.out.println();
		return winnings;
	}

	private static String[] spinReels() {
		String[] result = new String[3];
		for (int i = 0; i < 3; i++) {
			result[i] = symbols[random.nextInt(symbols.length)];
		}
		return result;
	}

	private static void printResult(String[] result) {
		for (String symbol : result) {
			System.out.print(symbol + " ");
		}
		System.out.println();
	}

	private static double getWinnings(String[] result, double bet) {
		if (result[0].equals(result[1]) && result[1].equals(result[2])) {
			return bet * 3;
		} else if (result[0].equals(result[1]) || result[1].equals(result[2]) || result[0].equals(result[2])) {
			return bet * 2;
		} else {
			return 0;
		}
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
	
	private static void howToPlay() {
		
		boolean runInstructions = true;
		
		int pages = 1;
		
		while(runInstructions) {
			System.out.println("-----------------------------------");
			System.out.println("\tSlots");
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
		System.out.println("Get 2 symbols in a row to win bet * 2. Get 3 symbols in a row to win bet * 3");
	}
}