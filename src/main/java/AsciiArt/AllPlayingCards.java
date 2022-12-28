package AsciiArt;

public class AllPlayingCards {

	public String[] returnCard(int cardNumber) {
		
		String[] chosenCard = new String[6];
		
		if(cardNumber == 1) {
			
			//Ace of spades
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|A .  |";
			chosenCard[2] = "| /.\\ |";
			chosenCard[3] = "|(_._)|";
			chosenCard[4] = "|  |  |";
			chosenCard[5] = "|____V|";
			
		} else if(cardNumber == 2) {
			
			//2 of spades
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|2    |";
			chosenCard[2] = "|  ^  |";
			chosenCard[3] = "|     |";
			chosenCard[4] = "|  ^  |";
			chosenCard[5] = "|____Z|";
			
		} else if(cardNumber == 3) {
			
			//3 of spades
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|3    |";
			chosenCard[2] = "| ^ ^ |";
			chosenCard[3] = "|     |";
			chosenCard[4] = "|  ^  |";
			chosenCard[5] = "|____E|";
			
		} else if(cardNumber == 4) {
			
			//4 of spades
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|4    |";
			chosenCard[2] = "| ^ ^ |";
			chosenCard[3] = "|     |";
			chosenCard[4] = "| ^ ^ |";
			chosenCard[5] = "|____h|";
			
		} else if(cardNumber == 5) {

			//5 of spades
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|5    |";
			chosenCard[2] = "| ^ ^ |";
			chosenCard[3] = "|  ^  |";
			chosenCard[4] = "| ^ ^ |";
			chosenCard[5] = "|____S|";
			
		} else if(cardNumber == 6) {
			
			//6 of spades
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|6    |";
			chosenCard[2] = "| ^ ^ |";
			chosenCard[3] = "| ^ ^ |";
			chosenCard[4] = "| ^ ^ |";
			chosenCard[5] = "|____9|";
			
		} else if(cardNumber == 7) {
			
			//7 of spades
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|7    |";
			chosenCard[2] = "| ^ ^ |";
			chosenCard[3] = "|^ ^ ^|";
			chosenCard[4] = "| ^ ^ |";
			chosenCard[5] = "|____L|";
			
		} else if(cardNumber == 8) {
			
			//8 of spades
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|8    |";
			chosenCard[2] = "|^ ^ ^|";
			chosenCard[3] = "| ^ ^ |";
			chosenCard[4] = "|^ ^ ^|";
			chosenCard[5] = "|____8|";
			
		} else if(cardNumber == 9) {
			
			//9 of spades
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|9    |";
			chosenCard[2] = "|^ ^ ^|";
			chosenCard[3] = "|^ ^ ^|";
			chosenCard[4] = "|^ ^ ^|";
			chosenCard[5] = "|____6|";
			
		} else if(cardNumber == 10) {
			
			//10 of spades
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|10 ^ |";
			chosenCard[2] = "|^ ^ ^|";
			chosenCard[3] = "|^ ^ ^|";
			chosenCard[4] = "|^ ^ ^|";
			chosenCard[5] = "|___0I|";
			
		} else if(cardNumber == 11) {
			
			//Jack of spades
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|J  ww|";
			chosenCard[2] = "| ^ {)|";
			chosenCard[3] = "|(.)% |";
			chosenCard[4] = "| | % |";
			chosenCard[5] = "|__%%[|";
			
		} else if(cardNumber == 12) {
			
			//Queen of spades
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|Q  ww|";
			chosenCard[2] = "| ^ {(|";
			chosenCard[3] = "|(.)%%|";
			chosenCard[4] = "| |%%%|";
			chosenCard[5] = "|_%%%O|";
			
		} else if(cardNumber == 13) {
			
			//King of spades
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|K  WW|";
			chosenCard[2] = "| ^ {)|";
			chosenCard[3] = "|(.)%%|";
			chosenCard[4] = "| |%%%|";
			chosenCard[5] = "|_%%%>|";
			
		} else if(cardNumber == 14) {
			
			//Ace of clubs
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|A _  |";
			chosenCard[2] = "| ( ) |";
			chosenCard[3] = "|(_'_)|";
			chosenCard[4] = "|  |  |";
			chosenCard[5] = "|____V|";
			
		} else if(cardNumber == 15) {
			
			//2 of clubs
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|2    |";
			chosenCard[2] = "|  &  |";
			chosenCard[3] = "|     |";
			chosenCard[4] = "|  &  |";
			chosenCard[5] = "|____Z|";
			
		} else if(cardNumber == 16) {
			
			//3 of clubs
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|3    |";
			chosenCard[2] = "| & & |";
			chosenCard[3] = "|     |";
			chosenCard[4] = "|  &  |";
			chosenCard[5] = "|____E|";
			
		} else if(cardNumber == 17) {
			
			//4 of clubs
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|4    |";
			chosenCard[2] = "| & & |";
			chosenCard[3] = "|     |";
			chosenCard[4] = "| & & |";
			chosenCard[5] = "|____h|";
			
		} else if(cardNumber == 18) {

			//5 of clubs
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|5    |";
			chosenCard[2] = "| & & |";
			chosenCard[3] = "|  &  |";
			chosenCard[4] = "| & & |";
			chosenCard[5] = "|____S|";
			
		} else if(cardNumber == 19) {
			
			//6 of clubs
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|6    |";
			chosenCard[2] = "| & & |";
			chosenCard[3] = "| & & |";
			chosenCard[4] = "| & & |";
			chosenCard[5] = "|____9|";
			
		} else if(cardNumber == 20) {
			
			//7 of clubs
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|7    |";
			chosenCard[2] = "| & & |";
			chosenCard[3] = "|& & &|";
			chosenCard[4] = "| & & |";
			chosenCard[5] = "|____L|";
			
		} else if(cardNumber == 21) {
			
			//8 of clubs
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|8    |";
			chosenCard[2] = "|& & &|";
			chosenCard[3] = "| & & |";
			chosenCard[4] = "|& & &|";
			chosenCard[5] = "|____8|";
			
		} else if(cardNumber == 22) {
			
			//9 of clubs
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|9    |";
			chosenCard[2] = "|& & &|";
			chosenCard[3] = "|& & &|";
			chosenCard[4] = "|& & &|";
			chosenCard[5] = "|____6|";
			
		} else if(cardNumber == 23) {
			
			//10 of clubs
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|10 & |";
			chosenCard[2] = "|& & &|";
			chosenCard[3] = "|& & &|";
			chosenCard[4] = "|& & &|";
			chosenCard[5] = "|___0I|";
			
		} else if(cardNumber == 24) {
			
			//Jack of clubs
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|J  ww|";
			chosenCard[2] = "| o {)|";
			chosenCard[3] = "|o o% |";
			chosenCard[4] = "| | % |";
			chosenCard[5] = "|__%%[|";
			
		} else if(cardNumber == 25) {
			
			//Queen of clubs
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|Q  ww|";
			chosenCard[2] = "| o {(|";
			chosenCard[3] = "|o o%%|";
			chosenCard[4] = "| |%%%|";
			chosenCard[5] = "|_%%%O|";
			
		} else if(cardNumber == 26) {
			
			//King of clubs
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|K  WW|";
			chosenCard[2] = "| o {)|";
			chosenCard[3] = "|o o%%|";
			chosenCard[4] = "| |%%%|";
			chosenCard[5] = "|_%%%>|";
			
		} else if(cardNumber == 27) {
			
			//Ace of hearts
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|A_ _ |";
			chosenCard[2] = "|( v )|";
			chosenCard[3] = "| \\ / |";
			chosenCard[4] = "|  .  |";
			chosenCard[5] = "|____V|";
			
		} else if(cardNumber == 28) {
			
			//2 of hearts
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|2    |";
			chosenCard[2] = "|  v  |";
			chosenCard[3] = "|     |";
			chosenCard[4] = "|  v  |";
			chosenCard[5] = "|____Z|";
			
		} else if(cardNumber == 29) {
			
			//3 of hearts
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|3    |";
			chosenCard[2] = "| v v |";
			chosenCard[3] = "|     |";
			chosenCard[4] = "|  v  |";
			chosenCard[5] = "|____E|";
			
		} else if(cardNumber == 30) {
			
			//4 of hearts
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|4    |";
			chosenCard[2] = "| v v |";
			chosenCard[3] = "|     |";
			chosenCard[4] = "| v v |";
			chosenCard[5] = "|____h|";
			
		} else if(cardNumber == 31) {

			//5 of hearts
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|5    |";
			chosenCard[2] = "| v v |";
			chosenCard[3] = "|  v  |";
			chosenCard[4] = "| v v |";
			chosenCard[5] = "|____S|";
			
		} else if(cardNumber == 32) {
			
			//6 of hearts
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|6    |";
			chosenCard[2] = "| v v |";
			chosenCard[3] = "| v v |";
			chosenCard[4] = "| v v |";
			chosenCard[5] = "|____9|";
			
		} else if(cardNumber == 33) {
			
			//7 of hearts
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|7    |";
			chosenCard[2] = "| v v |";
			chosenCard[3] = "|v v v|";
			chosenCard[4] = "| v v |";
			chosenCard[5] = "|____L|";
			
		} else if(cardNumber == 34) {
			
			//8 of hearts
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|8    |";
			chosenCard[2] = "|v v v|";
			chosenCard[3] = "| v v |";
			chosenCard[4] = "|v v v|";
			chosenCard[5] = "|____8|";
			
		} else if(cardNumber == 35) {
			
			//9 of hearts
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|9    |";
			chosenCard[2] = "|v v v|";
			chosenCard[3] = "|v v v|";
			chosenCard[4] = "|v v v|";
			chosenCard[5] = "|____6|";
			
		} else if(cardNumber == 36) {
			
			//10 of hearts
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|10 v |";
			chosenCard[2] = "|v v v|";
			chosenCard[3] = "|v v v|";
			chosenCard[4] = "|v v v|";
			chosenCard[5] = "|___0I|";
			
		} else if(cardNumber == 37) {
			
			//Jack of hearts
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|J  ww|";
			chosenCard[2] = "|   {)|";
			chosenCard[3] = "|(v)% |";
			chosenCard[4] = "| v % |";
			chosenCard[5] = "|__%%[|";
			
		} else if(cardNumber == 38) {
			
			//Queen of hearts
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|Q  ww|";
			chosenCard[2] = "|   {(|";
			chosenCard[3] = "|(v)%%|";
			chosenCard[4] = "| v%%%|";
			chosenCard[5] = "|_%%%O|";
			
		} else if(cardNumber == 39) {
			
			//King of hearts
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|K  WW|";
			chosenCard[2] = "|   {)|";
			chosenCard[3] = "|(v)%%|";
			chosenCard[4] = "| v%%%|";
			chosenCard[5] = "|_%%%>|";
			
		} else if(cardNumber == 40) {
			
			//Ace of diamonds
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|A ^  |";
			chosenCard[2] = "| / \\ |";
			chosenCard[3] = "| \\ / |";
			chosenCard[4] = "|  .  |";
			chosenCard[5] = "|____V|";
			
		} else if(cardNumber == 41) {
			
			//2 of diamonds
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|2    |";
			chosenCard[2] = "|  o  |";
			chosenCard[3] = "|     |";
			chosenCard[4] = "|  o  |";
			chosenCard[5] = "|____Z|";
			
		} else if(cardNumber == 42) {
			
			//3 of diamonds
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|3    |";
			chosenCard[2] = "| o o |";
			chosenCard[3] = "|     |";
			chosenCard[4] = "|  o  |";
			chosenCard[5] = "|____E|";
			
		} else if(cardNumber == 43) {
			
			//4 of diamonds
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|4    |";
			chosenCard[2] = "| o o |";
			chosenCard[3] = "|     |";
			chosenCard[4] = "| o o |";
			chosenCard[5] = "|____h|";
			
		} else if(cardNumber == 44) {

			//5 of diamonds
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|5    |";
			chosenCard[2] = "| o o |";
			chosenCard[3] = "|  o  |";
			chosenCard[4] = "| o o |";
			chosenCard[5] = "|____S|";
			
		} else if(cardNumber == 45) {
			
			//6 of diamonds
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|6    |";
			chosenCard[2] = "| o o |";
			chosenCard[3] = "| o o |";
			chosenCard[4] = "| o o |";
			chosenCard[5] = "|____9|";
			
		} else if(cardNumber == 46) {
			
			//7 of diamonds
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|7    |";
			chosenCard[2] = "| o o |";
			chosenCard[3] = "|o o o|";
			chosenCard[4] = "| o o |";
			chosenCard[5] = "|____L|";
			
		} else if(cardNumber == 47) {
			
			//8 of diamonds
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|8    |";
			chosenCard[2] = "|o o o|";
			chosenCard[3] = "| o o |";
			chosenCard[4] = "|o o o|";
			chosenCard[5] = "|____8|";
			
		} else if(cardNumber == 48) {
			
			//9 of diamonds
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|9    |";
			chosenCard[2] = "|o o o|";
			chosenCard[3] = "|o o o|";
			chosenCard[4] = "|o o o|";
			chosenCard[5] = "|____6|";
			
		} else if(cardNumber == 49) {
			
			//10 of diamonds
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|10 o |";
			chosenCard[2] = "|o o o|";
			chosenCard[3] = "|o o o|";
			chosenCard[4] = "|o o o|";
			chosenCard[5] = "|___0I|";
			
		} else if(cardNumber == 50) {
			
			//Jack of diamonds
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|J  ww|";
			chosenCard[2] = "| /\\{)|";
			chosenCard[3] = "| \\/% |";
			chosenCard[4] = "|   % |";
			chosenCard[5] = "|__%%[|";
			
		} else if(cardNumber == 51) {
			
			//Queen of diamonds
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|Q  ww|";
			chosenCard[2] = "| /\\{(|";
			chosenCard[3] = "| \\/%%|";
			chosenCard[4] = "|  %%%|";
			chosenCard[5] = "|_%%%O|";
			
		} else if(cardNumber == 52) {
			
			//King of diamonds
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|K  ww|";
			chosenCard[2] = "| /\\{)|";
			chosenCard[3] = "| \\/%%|";
			chosenCard[4] = "|  %%%|";
			chosenCard[5] = "|_%%%>|";
			
		} else if(cardNumber == 53) {
			
			//Joker
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|Joker|";
			chosenCard[2] = "|==%, |";
			chosenCard[3] = "| \\/>\\|";
			chosenCard[4] = "| _>^^|";
			chosenCard[5] = "|/_\\/_|";
			
		} else if(cardNumber == 54) {
			
			//Backside of a card
			
			chosenCard[0] = " _____ ";
			chosenCard[1] = "|\\ ~ /|";
			chosenCard[2] = "|}}:{{|";
			chosenCard[3] = "|}}:{{|";
			chosenCard[4] = "|}}:{{|";
			chosenCard[5] = "|/_~_\\|";
			
		}
	
		return chosenCard;
		
	}

}
