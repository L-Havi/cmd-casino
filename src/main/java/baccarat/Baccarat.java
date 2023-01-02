package baccarat;

import java.util.Scanner;

import AsciiArt.AllPlayingCards;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;

public class Baccarat {

	private static final Scanner scanner = new Scanner(System.in);
  	private static final Random random = new Random();

  	private static final AllPlayingCards playingCards = new AllPlayingCards(); 
  	
  	public static double playBaccarat(double balance) {
	  
		boolean run = true;
		double pot = 1;  
		
	    while (run) {
			int choice = 0;
			System.out.println("\tBaccarat");
			System.out.println("-----------------------------------");
			System.out.println("\tBet Size: " + pot + "\tTotal: " + balance);
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
				if((balance - pot) >= 0) {
					balance -= pot;
					double winnings = playHand(pot, balance);
					balance += winnings;
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
	    
	    return balance;
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
			System.out.println("\tBaccarat");
			System.out.println("-----------------------------------");
			if(pages == 1) {
				mainInstructions();
			} else if(pages == 2) {
				returnSizes();
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
	
	private static void mainInstructions() {
		System.out.println("\nHow to Play\n");
		
		System.out.println("Baccarat is a card game that is played with a deck of 52 cards. \nThe goal of the game is to get as close to a total of 9 as possible with the two or three cards that are dealt. \nThe game is played with two hands, the player hand and the banker hand.\n");

		System.out.println("Steps to play a game of baccarat:");

		System.out.println("1. Place your bet on the player, banker, or tie space on the table.");
		System.out.println("2. Two cards are dealt to the player and banker hands.");
		System.out.println("The hand with the highest total wins, with the exception that a \nhand with a total of 8 or 9 is called a \"natural\" and automatically wins, unless both hands are naturals, \nin which case the game is a tie.");
		System.out.println("If the player hand has a total of 0-5, a third card is drawn. \nIf the player hand has a total of 6 or 7, no additional cards are drawn.");
		System.out.println("If the banker hand has a total of 0-2, a third card is always drawn. \nIf the banker hand has a total of 3-6, whether or not a third card is drawn depends on the total of the player hand. \nIf the banker hand has a total of 7, no additional cards are drawn.");
		System.out.println("The hand with the highest total wins and is paid out according to the bet made. \nIf the game is a tie, the tie bet is paid out.");
	}
	
	private static void returnSizes() {
		System.out.println("\nWin Table\n");
		
		System.out.println("Bet on Player: 	Bet Size * 2");
		System.out.println("Bet on Banker: 	Bet Size * 2");
		System.out.println("Bet on Tie: 	Bet Size * 8");
	}
	
    private static double playHand(double bet, double balance) {
		int choice = 0;
		System.out.println("\tBaccarat");
		System.out.println("-----------------------------------");
		System.out.println("\tBet Size: " + bet + "\tTotal: " + balance);
		System.out.println("-----------------------------------");
    	System.out.println("Enter winner: ");
		System.out.println("1. Player");
		System.out.println("2. Banker");
		System.out.println("3. Tie");
    	int betType = scanner.nextInt();
    	scanner.nextLine();
    	
    	System.out.println("\n\n\n\n\n\n");
    	
    	List<Integer> playerCards = drawCards();
    	int playerTotal = playerCards.get(playerCards.size() - 1);
    	playerCards.remove(playerCards.size() - 1);
    	
		System.out.println("-----------------------------------");
    	
		String[][] playCards = new String[playerCards.size()][];
		
		for(int i = 0; i < playCards.length; i++) {
			playCards[i] = playingCards.returnCard(playerCards.get(i));
		}
		
		for(int j = 0; j < 6; j++) {
			for(int i = 0; i < playCards.length; i++) {
				System.out.print(playCards[i][j]);
			}
			System.out.println();
		}	
		
    	List<Integer> bankerCards = drawCards();
    	int bankerTotal = bankerCards.get(bankerCards.size() - 1);
    	bankerCards.remove(bankerCards.size() - 1);
    	
		String[][] bankCards = new String[bankerCards.size()][];
		
		for(int i = 0; i < bankCards.length; i++) {
			bankCards[i] = playingCards.returnCard(bankerCards.get(i));
		}
		
		for(int j = 0; j < 6; j++) {
			for(int i = 0; i < bankCards.length; i++) {
				System.out.print(bankCards[i][j]);
			}
			System.out.println();
		}	
    	
    	if (betType == 1) {
    		if (playerTotal > bankerTotal) {
    			System.out.println("You win $" + bet + "!");
    			System.out.println("-----------------------------------");
    			return (bet * 2);
    		} else if (playerTotal < bankerTotal) {
    			System.out.println("You lose $" + bet + ".");
    			System.out.println("-----------------------------------");
    			return 0;
    		} else {
    			System.out.println("It's a tie.");
    			System.out.println("-----------------------------------");
    			return 0;
    		}
    	} else if (betType == 2) {
    		if (bankerTotal > playerTotal) {
    			System.out.println("You win $" + bet + "!");
    			System.out.println("-----------------------------------");
    			return (bet * 2);
    		} else if (bankerTotal < playerTotal) {
    			System.out.println("You lose $" + bet + ".");
    			System.out.println("-----------------------------------");
    			return 0;
    		} else {
    			System.out.println("It's a tie.");
    			System.out.println("-----------------------------------");
    			return 0;
    		}
    	} else if (betType == 3) {
    	   	if (playerTotal == bankerTotal) {
                System.out.println("You win $" + (bet * 8) + "!");
        		System.out.println("-----------------------------------");
                return (bet * 8);
            } else {
                System.out.println("You lose $" + bet + ".");
        		System.out.println("-----------------------------------");
                return 0;
            }
    	} else {
       		System.out.println("Invalid bet type.");
    		System.out.println("-----------------------------------");
       		return bet;
        }
    }
  
  private static List<Integer> drawCards() {
	  int total = 0;
	  List<Integer> cards = new ArrayList<Integer>();
      boolean drawAgain = true;
      while (drawAgain) {
    	  int cardRank = random.nextInt(13) + 1;
    	  int cardSuite = random.nextInt(4) + 1;
    	  int card = cardRank * cardSuite;
    	  if(cards.size() == 0) {
        	  if (cardRank == 1) {
        		  total += 1;
              } else if (cardRank > 9) {
            	  total += 0;
              } else {
            	  total += cardRank;
              }
              if (total > 9) {
            	  total -= 10;
              }
              if (total >= 8) {
            	  drawAgain = false;
              }
              cards.add(card);
    	  } else if(!cards.contains(card)) {
        	  if (cardRank == 1) {
        		  total += 1;
              } else if (cardRank > 9) {
            	  total += 0;
              } else {
            	  total += cardRank;
              }
              if (total > 9) {
            	  total -= 10;
              }
              if (total >= 8) {
            	  drawAgain = false;
              }
              cards.add(card);
    	  }
      }
      
      cards.add(total);
      
      return cards;
  }
}

