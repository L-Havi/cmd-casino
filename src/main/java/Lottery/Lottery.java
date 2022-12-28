package Lottery;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Lottery {

	private static Scanner scanner = new Scanner(System.in);
	private static Random rn = new Random();
	
	public static double runLottery(double totalAmount) {
		boolean run = true;
		
		double pot = 2;
		double winAmount = 0;
		double results[] = new double[2];
		
		int[] numbers = new int[8];
		
		while(run) {
			int choice = 0;
			System.out.println("\tLottery");
			System.out.println("-----------------------------------");
			if(numbers[0] != 0) {
				System.out.println("\tNumbers: " + numbers[0] + ", " + numbers[1] + ", " + numbers[2] + ", " + numbers[3] + ", " + numbers[4] + ", " + numbers[5] + ", " + numbers[6] + "\tExtra Number: " + numbers[7]);
			}
			System.out.println("\tBet Size: " + pot + "\tTotal: " + totalAmount);
			System.out.println("-----------------------------------");
			System.out.println("1. Choose Numbers");
			System.out.println("2. Generate Random Numbers");
			System.out.println("3. Play");
			System.out.println("4. How to Play");
			System.out.println("5. Exit");
			try {
				choice = scanner.nextInt();
			} catch(InputMismatchException ex) {
				System.out.println("Please type valid input");
			}
			scanner.nextLine();
			if(choice == 1) {
				numbers = chooseNumbers();
			} else if(choice == 2) {
				numbers = generateRandomNumbers();
			} else if(choice == 3) {
				if(numbers[0] != 0) {
					if((totalAmount - pot) >= 0) {
						totalAmount -= pot;
						winAmount = playLotteryRow(numbers);
						totalAmount += winAmount;
					} else {
						System.out.println("You don't have enough money!");
					}
				} else {
					System.out.println("You havent chosen numbers!\nChoose or generate numbers to play!");
				}
			} else if(choice == 4) {
				howToPlay();
			} else if(choice == 5) {
				run = false;
			} else {
	    		System.out.println("Choose valid action!");
			}
		}
		
		return totalAmount;
	}

	private static double playLotteryRow(int[] numbers) {
		
		int[] computerNumbers = generateRandomNumbers();
		
		int[] correctNumbers = checkNumbers(numbers, computerNumbers);
		
		double winnings = getWinAmount(correctNumbers);
		
		System.out.println("\tLottery Results");
		System.out.println("-----------------------------------");
		System.out.println("Player Numbers: "+ numbers[0] + ", " + numbers[1] + ", " + numbers[2] + ", " + numbers[3] + ", " + numbers[4] + ", " + numbers[5] + ", " + numbers[6] + "\tPlayer Extra Number: " + numbers[7]);
		System.out.println("Computer Numbers: "+ computerNumbers[0] + ", " + computerNumbers[1] + ", " + computerNumbers[2] + ", " + computerNumbers[3] + ", " + computerNumbers[4] + ", " + computerNumbers[5] + ", " + computerNumbers[6] + "\tComputer Extra Number: " + computerNumbers[7]);
		System.out.println("Correct Numbers: " + correctNumbers[0]);
		System.out.println("Correct Extra Numbers: " + correctNumbers[1]);
		System.out.println("Win amount: " + winnings);
		System.out.println("-----------------------------------");
		
		return winnings;
	}

	private static double getWinAmount(int[] correctNumbers) {

		if (correctNumbers[0] == 7) {
			return 1000000;
		} else if (correctNumbers[0] == 6 && correctNumbers[1] == 1) {
			return 100000;
		} else if (correctNumbers[0] == 6) {
			return 2000;
		} else if (correctNumbers[0] == 5) {
			return 50;
		} else if (correctNumbers[0] == 4) {
			return 10;
		} else if (correctNumbers[0] == 3 && correctNumbers[1] == 1) {
			return 2;
		}
		
		return 0;
	}

	private static int[] checkNumbers(int[] numbers, int[] computerNumbers) {
		int winMain = 0;
	    for (int i = 0; i < (numbers.length - 1); i++) {
	        for (int j = 0; j < (computerNumbers.length - 1); j++) {
	            if (numbers[i] == computerNumbers[j]) {
	            	winMain++;
	                break;
	            }
	        }
	    }
	    int winExtra = 0;
	    if(numbers[7] == computerNumbers[7]) {
	    	winExtra++;
	    }
	    
	    int[] results = { winMain, winExtra };
	    
		return results;
	}

	private static int[] generateRandomNumbers() {
		int[] numbers = new int[8];
		
		int tempValue = 0;
		
		for(int i = 0; i < numbers.length; i++) {
			if(i == 7) {
				numbers[i] = rn.nextInt((12 - 1) + 1) + 1;
			} else {
				tempValue = rn.nextInt((40 - 1) + 1) + 1;
				if(i != 0) {
					for(int k = 0; k < i; k++) {
						if(numbers[k] == tempValue) {
							i--;
							break;
						} else {
							numbers[i] = tempValue;
						}
					}	
				} else {
					numbers[i] = tempValue;
				}
			}
		}
		
		return numbers;
	}

	private static int[] chooseNumbers() {

		int[] numbers = new int[8];
		
		int tempValue = 0;
		
		for(int i = 0; i < numbers.length; i++) {
			if(i == 7) {
				System.out.println("Input extra number: ");
				tempValue = scanner.nextInt();
				
				if(tempValue > 0 && tempValue < 13) {
					numbers[i] = tempValue;
				} else {
					System.out.println("Input valid number! (1-12)");
					i--;
				}
			} else {
				System.out.println("Input number " + (i + 1) + ": ");
				tempValue = scanner.nextInt();
				
				if(tempValue > 0 && tempValue < 41) {
					if(i > 0) {
						for(int k = 0; k < i; k++) {
							if(numbers[k] == tempValue) {
								System.out.println("Number (" + tempValue + ") already included!");
								i--;
							} else {
								numbers[i] = tempValue;
							}
						}
					} else {
						numbers[i] = tempValue;
					}
				} else {
					System.out.println("Input valid number! (1-40)");
					i--;
				}
			}
		}
		
		return numbers;
	}

	private static void howToPlay() {
		// TODO Auto-generated method stub
		
	}
}
