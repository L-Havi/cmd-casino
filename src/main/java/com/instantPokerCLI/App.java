package com.instantPokerCLI;

import java.util.InputMismatchException;
import java.util.Scanner;

import Lottery.Lottery;
import baccarat.Baccarat;
import blackjack.Blackjack;
import craps.Craps;
import instantPoker.InstantPoker;
import keno.Keno;
import roulette.Roulette;
import slot.SlotMachine;

public class App {
	
	private static InstantPoker instantPoker = new InstantPoker();
	
	private static Lottery lottery = new Lottery();
	
	private static Baccarat baccarat = new Baccarat();
	
	private static Keno keno = new Keno();
	
	private static SlotMachine slots = new SlotMachine();
	
	private static Craps craps = new Craps();
	
	private static Roulette roulette = new Roulette();
	
	private static Blackjack blackjack = new Blackjack();
	
    public static void main(String[] args ) {
    	
    	Scanner scanner = new Scanner(System.in);
    	double totalAmount = 1000;
    	boolean run = true;
    	
		while(run) {
			int choice = 0;
			for(int k = 0; k < 20; k++) {
				System.out.println();
			}
			System.out.println("------------------------------------------------------------");
			System.out.println("\tCommand Line Casino\t\tTotal: " + totalAmount);
			System.out.println("------------------------------------------------------------");
			System.out.println("1. Instant Poker");
			System.out.println("2. Lottery");
			System.out.println("3. Baccarat");
			System.out.println("4. Keno");
			System.out.println("5. Blackjack");
			System.out.println("6. Craps");
			System.out.println("7. Roulette");
			System.out.println("8. Slots");
			System.out.println("9. Exit");
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
				totalAmount = baccarat.playBaccarat(totalAmount);
			} else if(choice == 4) {
				totalAmount = keno.play(totalAmount);
			} else if(choice == 5) {
				totalAmount = blackjack.play(totalAmount);
			} else if(choice == 6) {
				totalAmount = craps.play(totalAmount);
			} else if(choice == 7) {
				totalAmount = roulette.play(totalAmount);
			} else if(choice == 8) {
				totalAmount = slots.play(totalAmount);
			} else if(choice == 9) {
				System.exit(0);
			} else {
	    		System.out.println("Choose valid action!");
			}
		}
    	
    }
}
