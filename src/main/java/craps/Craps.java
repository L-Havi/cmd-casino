package craps;

import java.util.Scanner;

import AsciiArt.AllDice;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;

public class Craps {

  private static final Scanner scanner = new Scanner(System.in);
  private static final Random random = new Random();
  private static AllDice allDice = new AllDice();
  
  
  public static double play(double totalAmount) {
		boolean run = true;
		
		double pot = 2;
		double winAmount = 0;
		
		List<Integer> numbers = new ArrayList<Integer>();
		
		while(run) {
			int choice = 0;
			System.out.println("\tCraps");
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
  
  	private static double playRound(double bet) {
  		
  		String[][] dice = new String[2][];
  		
  		while (true) {
  			int dice1 = rollDice();
  			int dice2 = rollDice();
  			
  			dice[0] = allDice.returnDice(dice1);
  			dice[1] = allDice.returnDice(dice2);
  			
			for(int j = 0; j < 7; j++) {
				for(int i = 0; i < dice.length; i++) {
					System.out.print(dice[i][j]);
				}
				System.out.println();
			}
  			
  			int roll = dice1 + dice2;
  			System.out.println("You rolled a " + dice1 + " and a " + dice2 + " for a total of " + roll);
  			if (roll == 7 || roll == 11) {
  				System.out.println("You win $" + bet + "!");
  				return (bet * 2);
  			} else if (roll == 2 || roll == 3 || roll == 12) {
  				System.out.println("You lose $" + bet + ".");
  				return 0;
  			} else {
  				int point = roll;
  				System.out.println("Your point is " + point);
  				while (true) {
  					dice1 = rollDice();
  					dice2 = rollDice();
  					
  		  			dice[0] = allDice.returnDice(dice1);
  		  			dice[1] = allDice.returnDice(dice2);
  		  			
  					for(int j = 0; j < 7; j++) {
  						for(int i = 0; i < dice.length; i++) {
  							System.out.print(dice[i][j]);
  						}
  						System.out.println();
  					}
  					
  					roll = dice1 + dice2;
  					System.out.println("You rolled a " + dice1 + " and a " + dice2 + " for a total of " + roll);
  					if (roll == point) {
  						System.out.println("You win $" + bet + "!");
  						return (bet * 2);
  					} else if (roll == 7) {
  						System.out.println("You lose $" + bet + ".");
  						return 0;
  					}
  				}
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
  
 	private static int rollDice() {
 		return random.nextInt(6) + 1;
 	}
 	
 	private static void howToPlay() {
		
		boolean runInstructions = true;
		
		int pages = 1;
		
		while(runInstructions) {
			System.out.println("-----------------------------------");
			System.out.println("\tCraps");
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
		System.out.println("Craps is a dice game in which players place bets on the outcome of the roll, or a series of rolls, of a pair of dice.");
		System.out.println("The game starts with the \"come out\" roll, which is the first roll of the dice. If the come out roll is a 7 or an 11, \nthe player who rolled the dice wins. If the come out roll is a 2, 3, or 12, the player who rolled the dice loses (this is called \"craps\"). \nIf the come out roll is any other number, that number becomes the \"point.\"\n");
		System.out.println("If the come out roll establishes a point, the player continues rolling the dice until either the point is rolled again \n(in which case the player wins), or a 7 is rolled (in which case the player loses). This is called the \"point\" phase of the game.");
	}
 	
}
