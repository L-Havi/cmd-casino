package com.instantPokerCLI;

import java.util.InputMismatchException;
import java.util.Scanner;

import Lottery.Lottery;
import instantPoker.InstantPoker;

public class App {
	
	private static InstantPoker instantPoker = new InstantPoker();
	
	private static Lottery lottery = new Lottery();
	
    public static void main(String[] args ) {
    	
    	Scanner scanner = new Scanner(System.in);
    	double totalAmount = 1000;
    	boolean run = true;
    	
		while(run) {
			int choice = 0;
			for(int k = 0; k < 20; k++) {
				System.out.println();
			}
			System.out.println("-----------------------------------");
			System.out.println("\tCMD Casino\tTotal: " + totalAmount);
			System.out.println("-----------------------------------");
			System.out.println("1. Play Instant Poker");
			System.out.println("2. Play Lottery");
			System.out.println("3. Exit");
			try {
				choice = scanner.nextInt();
			} catch(InputMismatchException ex) {
				System.out.println("Please type valid input");
			}
			scanner.nextLine();
			if(choice == 1) {
				totalAmount = instantPoker.runInstantPoker(totalAmount);
			} else if(choice == 2) {
				totalAmount = lottery.runLottery(totalAmount);
			} else if(choice == 3) {
				System.exit(0);
			} else {
	    		System.out.println("Choose valid action!");
			}
		}
    	
    }
}
