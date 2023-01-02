package roulette;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;

public class Roulette {

	private static final Scanner scanner = new Scanner(System.in);
	private static final Random random = new Random();

	 public static double play(double totalAmount) {
			boolean run = true;
			
			double pot = 2;
			double winAmount = 0;
			
			List<Integer> numbers = new ArrayList<Integer>();
			
			while(run) {
				int choice = 0;
				System.out.println("\tRoulette");
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
		while (true) {
			System.out.print("Enter bet type (1 = single number, 2 = odd/even, 3 = red/black): ");
			int betType = scanner.nextInt();
			if (betType == 1) {
				System.out.print("Enter number to bet on (0-36): ");
				int number = scanner.nextInt();
				int winningNumber = spinWheel();
				if (winningNumber == number) {
					System.out.println("Winning number is: " + winningNumber);
					System.out.println("You win $" + (bet * 35) + "!");
					return (bet * 35);
				} else {
					System.out.println("Winning number is: " + winningNumber);
					System.out.println("You lose $" + bet + ".");
					return 0;
				}
			} else if (betType == 2) {
				System.out.print("Enter odd or even: ");
				String oddEven = scanner.next();
				int winningNumber = spinWheel();
				if ((winningNumber % 2 == 0 && oddEven.equalsIgnoreCase("even")) || (winningNumber % 2 != 0 && oddEven.equalsIgnoreCase("odd"))) {
					System.out.println("Winning number is: " + winningNumber);
					System.out.println("You win $" + bet + "!");
					return (bet * 2);
				} else {
					System.out.println("Winning number is: " + winningNumber);
					System.out.println("You lose $" + bet + ".");
					return 0;
				}
			} else if (betType == 3) {
				System.out.print("Enter red or black: ");
       
				String redBlack = scanner.next();
				int winningNumber = spinWheel();
				if ((winningNumber == 0 || winningNumber == 37) && !redBlack.equalsIgnoreCase("green")) {
					System.out.println("Winning number is: " + winningNumber + "(Green)");
					System.out.println("You lose $" + bet + ".");
					return 0;
				} else if ((winningNumber == 1 || winningNumber == 3 || winningNumber == 5 || winningNumber == 7 || winningNumber == 9 || winningNumber == 12 || winningNumber == 14 || winningNumber == 16 || winningNumber == 18 || winningNumber == 19 || winningNumber == 21 || winningNumber == 23 || winningNumber == 25 || winningNumber == 27 || winningNumber == 30 || winningNumber == 32 || winningNumber == 34 || winningNumber == 36) && redBlack.equalsIgnoreCase("red")) {
					System.out.println("Winning number is: " + winningNumber + "(Red)");
					System.out.println("You win $" + bet + "!");
					return (bet * 2);
				} else if ((winningNumber == 2 || winningNumber == 4 || winningNumber == 6 || winningNumber == 8 || winningNumber == 10 || winningNumber == 11 || winningNumber == 13 || winningNumber == 15 || winningNumber == 17 || winningNumber == 20 || winningNumber == 22 || winningNumber == 24 || winningNumber == 26 || winningNumber == 28 || winningNumber == 29 || winningNumber == 31 || winningNumber == 33 || winningNumber == 35) && redBlack.equalsIgnoreCase("black")) {
					System.out.println("Winning number is: " + winningNumber + "(Black)");
					System.out.println("You win $" + bet + "!");
					return (bet * 2);
				} else {
					System.out.println("Winning number is: " + winningNumber);
					System.out.println("You lose $" + bet + ".");
					return 0;
				}
			} else {
				System.out.println("Invalid bet type.");
			}
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
	
	private static int spinWheel() {
		return random.nextInt(38);
	}
	
	private static void howToPlay() {
		
		boolean runInstructions = true;
		
		int pages = 1;
		
		while(runInstructions) {
			System.out.println("-----------------------------------");
			System.out.println("\tRoulette");
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
		System.out.println("In Roulette, a player may choose to place a bet on a single number, the color red or black, whether the number is odd or even");
		System.out.println("The winnings are then paid to anyone who has placed a successful bet");
	}
}
