package AsciiArt;

public class AllDice {

	
	public String[] returnDice(int diceNumber) {
		
		String[] chosenDice = new String[7];
		
		if(diceNumber == 1) {
		
			//1
			
			chosenDice[0] = "  .-------.";
			chosenDice[1] = " /   o   /|";
			chosenDice[2] = "/_______/o|";
			chosenDice[3] = "| o     | |";
			chosenDice[4] = "|   o   |o/";
			chosenDice[5] = "|     o |/ ";
			chosenDice[6] = "'-------'  ";
			
		} else if(diceNumber == 2) {
		
			//2
			
			chosenDice[0] = "  .-------.";
			chosenDice[1] = " / o   o /|";
			chosenDice[2] = "/_______/ |";
			chosenDice[3] = "| o     |o|";
			chosenDice[4] = "|   o   | /";
			chosenDice[5] = "|     o |/ ";
			chosenDice[6] = "'-------'  ";
			
		} else if(diceNumber == 3) {
		
			//3
			
			chosenDice[0] = "  .-------.";
			chosenDice[1] = " / o o o /|";
			chosenDice[2] = "/______ /o|";
			chosenDice[3] = "|       | |";
			chosenDice[4] = "|   o   |o/";
			chosenDice[5] = "|       |/ ";
			chosenDice[6] = "'-------'  ";
			
		} else if(diceNumber == 4) {
		
			//4
			
			chosenDice[0] = "  .-------.";
			chosenDice[1] = " / o   o /|";
			chosenDice[2] = "/_o___o_/ |";
			chosenDice[3] = "| o     |o|";
			chosenDice[4] = "|       | /";
			chosenDice[5] = "|     o |/ ";
			chosenDice[6] = "'-------'  ";
			
		} else if(diceNumber == 5) {
		
			//5
			
			chosenDice[0] = "  .-------.";
			chosenDice[1] = " / o o o /|";
			chosenDice[2] = "/_o___o_/ |";
			chosenDice[3] = "| o     |o|";
			chosenDice[4] = "|   o   | /";
			chosenDice[5] = "|     o |/ ";
			chosenDice[6] = "'-------'  ";
			
		} else if(diceNumber == 6) {
		
			//6
			
			chosenDice[0] = "  .-------.";
			chosenDice[1] = " / o o o /|";
			chosenDice[2] = "/_o_o_o_/o|";
			chosenDice[3] = "| o     | |";
			chosenDice[4] = "|   o   |o/";
			chosenDice[5] = "|     o |/ ";
			chosenDice[6] = "'-------'  ";
			
		}
		
		return chosenDice;
	}	
	
}
