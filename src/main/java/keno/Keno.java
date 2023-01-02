package keno;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Keno {
	
	private static final int MIN_DRAWN_NUMBERS = 2;
	private static final int MAX_DRAWN_NUMBERS = 10;
	private static final int MIN_NUMBER = 1;
 	private static final int MAX_NUMBER = 80;

    private static Random random = new Random();
	
	private static final int[][] KENO_11_PAYOUTS = {{11, 1000000}, {10, 25000}, {9, 500}, {8, 50}, {7, 6}, {6, 2}, {5, 1}, {0, 1}};
	
	private static final int[][] KENO_10_PAYOUTS = {{10, 200000}, {9, 5000}, {8, 200}, {7, 20}, {6, 4}, {5, 1}, {0, 1}};
	
	private static final int[][] KENO_9_PAYOUTS = {{9, 50000}, {8, 1200}, {7, 50}, {6, 10}, {5, 2}};
	
	private static final int[][] KENO_8_PAYOUTS = {{8, 10000}, {7, 240}, {6, 20}, {5, 3}, {4, 1}};
	
	private static final int[][] KENO_7_PAYOUTS = {{7, 2400}, {6, 100}, {5, 10}, {4, 1}};
	
	private static final int[][] KENO_6_PAYOUTS = {{6, 420}, {5, 20}, {4, 3}, {3, 1}};
	
	private static final int[][] KENO_5_PAYOUTS = {{5, 200}, {4, 9}, {3, 1}};
	
	private static final int[][] KENO_4_PAYOUTS = {{4, 32}, {3, 2}, {2, 1}};
	
	private static final int[][] KENO_3_PAYOUTS = {{3, 18}, {2, 1}};
	
	private static final int[][] KENO_2_PAYOUTS = {{2, 7}};

    private static Scanner scanner = new Scanner(System.in);

  	public static double play(double totalAmount) {
  		boolean run = true;
		
		double pot = 2;
		double winAmount = 0;
		
		List<Integer> numbers = new ArrayList<Integer>();
		
		while(run) {
			int choice = 0;
			System.out.println("\tKeno");
			System.out.println("-----------------------------------");
			if(numbers.size() > 0) {
				System.out.print("\tNumbers: ");
				for(int i = 0 ; i < numbers.size(); i++) {
					if(i == 0) {
						System.out.print(numbers.get(i));
					}else {
						System.out.print(", " + numbers.get(i));
					}
				}
				System.out.println();
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
				System.out.println("How many numbers? (2-10)");
				int generatedNumbersAmount = scanner.nextInt();
				scanner.nextLine();
				if(generatedNumbersAmount >= MIN_DRAWN_NUMBERS && generatedNumbersAmount <= MAX_DRAWN_NUMBERS) {
					numbers = generateRandomNumbers(generatedNumbersAmount);
				} else {
					System.out.println("Please type valid input");
				}
			} else if(choice == 3) {
				if(numbers.size() > 1) {
					if((totalAmount - pot) >= 0) {
						totalAmount -= pot;
						winAmount = playRound(numbers, pot);
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
  
  	private static void howToPlay() {
		
		boolean runInstructions = true;
		
		int pages = 1;
		
		while(runInstructions) {
			System.out.println("-----------------------------------");
			System.out.println("\tKeno");
			System.out.println("-----------------------------------");
			if(pages == 1) {
				mainInstructions();
			} else if(pages == 2) {
				winTable();
			} else if(pages == 3) {
				runInstructions = false;
			} 
			System.out.println("1. How to Play\t2. Win Table");
			System.out.println("3. Exit");
			if(runInstructions) {
				try {
					pages = scanner.nextInt();
				} catch(InputMismatchException ex) {
					System.out.println("Please type valid input");
				}
			}
		}
	}

	private static void winTable() {
		System.out.println("\tWin Table\n");
		System.out.println("Level 10");
		System.out.println("Result\tWin");
		System.out.println("10  \t200 000 * Bet");
		System.out.println("9   \t5 000 * Bet");
		System.out.println("8   \t200 * Bet");
		System.out.println("7   \t20 * Bet");
		System.out.println("6   \t4 * Bet");
		System.out.println("5   \t1 * Bet");
		System.out.println("0   \t1 * Bet");
		System.out.println("Level 9");
		System.out.println("Result\tWin");
		System.out.println("9   \t50 000 * Bet");
		System.out.println("8   \t1 200 * Bet");
		System.out.println("7   \t50 * Bet");
		System.out.println("6   \t10 * Bet");
		System.out.println("5   \t2 * Bet");
		System.out.println("Level 8");
		System.out.println("Result\tWin");
		System.out.println("8   \t10 000 * Bet");
		System.out.println("7   \t240 * Bet");
		System.out.println("6   \t20 * Bet");
		System.out.println("5   \t3 * Bet");
		System.out.println("4   \t1 * Bet");
		System.out.println("Level 7");
		System.out.println("Result\tWin");
		System.out.println("7   \t2 400 * Bet");
		System.out.println("6   \t100 * Bet");
		System.out.println("5   \t10 * Bet");
		System.out.println("4   \t1 * Bet");
		System.out.println("Level 6");
		System.out.println("Result\tWin");
		System.out.println("6   \t420 * Bet");
		System.out.println("5   \t20 * Bet");
		System.out.println("4   \t3 * Bet");
		System.out.println("3   \t1 * Bet");
		System.out.println("Level 5");
		System.out.println("Result\tWin");
		System.out.println("5   \t200 * Bet");
		System.out.println("4   \t9 * Bet");
		System.out.println("3   \t1 * Bet");
		System.out.println("Level 4");
		System.out.println("Result\tWin");
		System.out.println("4   \t32 * Bet");
		System.out.println("3   \t2 * Bet");
		System.out.println("2   \t1 * Bet");
		System.out.println("Level 3");
		System.out.println("Result\tWin");
		System.out.println("3   \t18 * Bet");
		System.out.println("2   \t1 * Bet");
		System.out.println("Level 2");
		System.out.println("Result\tWin");
		System.out.println("2   \t7 * Bet");
	}

	private static void mainInstructions() {
		System.out.println("\tHow to Play\n");
		System.out.println("In Keno, you choose between 2 and 10 game numbers from 80 numbers, \nor let the game system draw the numbers as a quick play for the number of rows you want. \nThe number of game numbers selected in a row indicates the level of keno.");
	}

	private static double playRound(List<Integer> playerNumbers, double bet) {
  		List<Integer> computerNumbers = drawNumbers();
  		int hits = calculateHits(playerNumbers, computerNumbers);
  		int playedNumbersAmount = playerNumbers.size();
  		double winnings = announceResult(hits, playedNumbersAmount, bet, playerNumbers, computerNumbers);
		return winnings;
  	}

	private static List<Integer> generateRandomNumbers(int drawnNumbers) {
		List<Integer> numbers = new ArrayList<Integer>();
		
		for(int i = 0; i < drawnNumbers; i++) {
		    int number = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
		    if (!numbers.contains(number)) {
		    	numbers.add(number);
		    }
		}
		
		return numbers;
	}
  	
	private static List<Integer> chooseNumbers() {

		List<Integer> numbers = new ArrayList<Integer>();
		
		int tempValue = 0;
		
		for(int i = 0; i < 10; i++) {
			if(i < MIN_DRAWN_NUMBERS) {
				System.out.println("Input number between 1-80: ");
				tempValue = scanner.nextInt();
				
				if(tempValue >= MIN_NUMBER && tempValue <= MAX_NUMBER) {
					if(!numbers.contains(tempValue)) {
						numbers.add(tempValue);
					} else {
						System.out.println("Number (" + tempValue + ") already included!");
						i--;
					}
				} else {
					System.out.println("Input valid number! (1-80)");
					i--;
				}
			} else if(i < MAX_DRAWN_NUMBERS) {
				System.out.println("Input number between 1-80 or number 0 to exit: ");
				tempValue = scanner.nextInt();
				
				if(tempValue >= MIN_NUMBER && tempValue <= MAX_NUMBER) {
					if(!numbers.contains(tempValue)) {
						numbers.add(tempValue);
					} else {
						System.out.println("Number (" + tempValue + ") already included!");
						i--;
					}
				} else if (tempValue == 0){
					return numbers;
				}else {
					System.out.println("Input valid number! (1-80, or 0 to quit inputting numbers)");
					i--;
				}
			} else {
				return numbers;
			}
		}
		return numbers;
	}

  private static List<Integer> drawNumbers() {
	  List<Integer> drawnNumbers = new ArrayList<Integer>();
    while (drawnNumbers.size() < 21) {
      int number = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
      if (!drawnNumbers.contains(number)) {
    	  drawnNumbers.add(number);
      }
    }
    return drawnNumbers;
  }

  private static int calculateHits(List<Integer> playerNumbers, List<Integer> computerNumbers) {
	  int hits = 0;
    for (int number : playerNumbers) {
      if (computerNumbers.contains(number)) {
        hits++;
      }
    }
    return hits;
  }

  private static double announceResult(int hits, int numDrawnNumbers, double bet, List<Integer> playerNumbers, List<Integer> computerNumbers) {
    double payout = 0;
    switch (numDrawnNumbers) {
      case 11:
        for (int[] payouts : KENO_11_PAYOUTS) {
          if (payouts[0] == hits) {
            payout = payouts[1] * bet;
            break;
          }
        }
        break;
      case 10:
        for (int[] payouts : KENO_10_PAYOUTS) {
          if (payouts[0] == hits) {
            payout = payouts[1] * bet;
            break;
          }
        }
        break;
      case 9:
        for (int[] payouts : KENO_9_PAYOUTS) {
          if (payouts[0] == hits) {
            payout = payouts[1] * bet;
            break;
          }
        }
        break;
      case 8:
        for (int[] payouts : KENO_8_PAYOUTS) {
          if (payouts[0] == hits) {
            payout = payouts[1] * bet;
            break;
          }
        }
        break;
      case 7:
        for (int[] payouts : KENO_7_PAYOUTS) {
          if (payouts[0] == hits) {
            payout = payouts[1] * bet;
            break;
          }
        }
        break;
      case 6:
        for (int[] payouts : KENO_6_PAYOUTS) {
          if (payouts[0] == hits) {
            payout = payouts[1] * bet;
            break;
          }
        }
        break;
      case 5:
        for (int[] payouts : KENO_5_PAYOUTS) {
          if (payouts[0] == hits) {
            payout = payouts[1] * bet;
            break;
          }
        }
        break;
      case 4:
        for (int[] payouts : KENO_4_PAYOUTS) {
          if (payouts[0] == hits) {
            payout = payouts[1] * bet;
            break;
          }
        }
        break;
      case 3:
        for (int[] payouts : KENO_3_PAYOUTS) {
          if (payouts[0] == hits) {
            payout = payouts[1] * bet;
            break;
          }
        }
        break;
      case 2:
        for (int[] payouts : KENO_2_PAYOUTS) {
          if (payouts[0] == hits) {
            payout = payouts[1] * bet;
            break;
          }
        }
        break;
    }
    System.out.println("Player numbers: " + playerNumbers);
    System.out.println("Numbers drawn: " + computerNumbers);
    System.out.println("Hits: " + hits);
    System.out.println("Payout: " + payout);
    return payout;
  }

}

