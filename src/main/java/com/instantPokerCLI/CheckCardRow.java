package com.instantPokerCLI;

import java.util.ArrayList;
import java.util.List;

public class CheckCardRow {

	public double checkRow(double pot, List<Integer> finalCards) {
		
		boolean win = false;
		
		List<Integer> ranks = getCardRanks(finalCards);
		List<Integer> suits = getCardSuits(finalCards);

		String cardsInput = "";
		
		for(int i = 0; i < ranks.size(); i++) {
			String rank = null;
			if(ranks.get(i) > 10 || ranks.get(i) == 1) {
				if(ranks.get(i) == 11) {
					rank = "J";
				} else if(ranks.get(i) == 12) {
					rank = "Q";
				} else if(ranks.get(i) == 13) {
					rank = "K";
				} else if(ranks.get(i) == 1) {
					rank = "A";
				}
			} else {
				rank = ranks.get(i).toString();
			}
			if(suits.get(i) == 1) {
				cardsInput += "\u2660" + rank + "\t";
			} else if(suits.get(i) == 2) {
				cardsInput += "\u2663" + rank + "\t";
			} else if(suits.get(i) == 3) {
				cardsInput += "\u2665" + rank + "\t";
			} else if(suits.get(i) == 4) {
				cardsInput += "\u2666" + rank + "\t";
			} else if(suits.get(i) == 5) {
				cardsInput += "Joker\t";
			}
		}
		
		System.out.println(cardsInput);
		System.out.println("-----------------------------------");
		
		win = hasFiveSameNumber(ranks);
		if(win) {
			return (pot * 125);
		}
		
		win = hasRoyalFlush(ranks, suits);
		if(win) {
			return (pot * 100);
		}
		
		win = hasStraightFlush(ranks, suits);
		if(win) {
			return (pot * 75);
		}
		
		win = hasFourSameNumber(ranks);
		if(win) {
			return (pot * 50);
		}
		
		win = hasFullHouse(ranks);
		if(win) {
			return (pot * 20);
		}
		
		win = hasFlush(suits);
		if(win) {
			return (pot * 15);
		}
		
		win = hasStraight(ranks);
		if(win) {
			return (pot * 11);
		}
		
		win = hasThreeSameNumber(ranks);
		if(win) {
			return (pot * 5);
		}
		
		win = hasTwoPairs(ranks);
		if(win) {
			return (pot * 3);
		}
		
		win = hasPair(ranks);
		if(win) {
			return (pot * 2);
		}
		
		return 0;
	}
	
	public List<Integer> getCardRanks(List<Integer> finalCards) {
		
		boolean isLargerThan13 = true;
		
		List<Integer> result = new ArrayList<Integer>();
		
		for(int finalCard : finalCards) {
			if(finalCard != 53) {
				int tempValue = finalCard;
				while(isLargerThan13) {
					if(tempValue > 13) {
						tempValue -= 13;
					} else {
						result.add(tempValue);
						isLargerThan13 = false;
					}
				}
				isLargerThan13 = true;
			} else {
				result.add(14);
			}
		}
		return result;
	}

	public List<Integer> getCardSuits(List<Integer> finalCards) {
		
		boolean isLargerThan13 = true;
		
		List<Integer> suitsValues = new ArrayList<Integer>();
		
		for(int finalCard : finalCards) {
			int tempValue = 1;
			if(finalCard != 53) {
				while(isLargerThan13) {
					if(finalCard > 13) {
						finalCard -= 13;
						tempValue++;
					} else {
						isLargerThan13 = false;
						suitsValues.add(tempValue);
					}
				}
				isLargerThan13 = true;
			} else {
				tempValue = 5;
				suitsValues.add(tempValue);
			}
		}
		
		return suitsValues;
	}

	private boolean hasPair(List<Integer> finalCards) {

		int firstValue = 0;
		int secondValue = 0;
		int thirdValue = 0;
		int fourthValue = 0;
		
		for(int card : finalCards) {
			if(firstValue == 0 && ((card < 14 && card > 9) || card == 1)) {
				firstValue = card;
			} else if (firstValue == card || (card == 14 && firstValue != 0)) {
				return true;
			} else if(secondValue == 0 && ((card < 14 && card > 9) || card == 1)) {
				secondValue = card;
			} else if (secondValue == card || (card == 14 && secondValue != 0)) {
				return true;
			} else if(thirdValue == 0 && ((card < 14 && card > 9) || card == 1)) {
				thirdValue = card;
			} else if (thirdValue == card || (card == 14 && thirdValue != 0)) {
				return true;
			} else if(fourthValue == 0 && ((card < 14 && card > 9) || card == 1)) {
				fourthValue = card;
			} else if (fourthValue == card || (card == 14 && fourthValue != 0)) {
				return true;
			}
		}
		
		return false;
		
	}

	private boolean hasTwoPairs(List<Integer> ranks) {
		
		int firstValue = 0;
		int secondValue = 0;
		int otherValueCount = 0;
		
		for(int card : ranks) {
			if(firstValue == 0 && card != 14) {
				firstValue = card;
			} else if(secondValue == 0 && card != 14) {
				secondValue = card;
			} else if (secondValue != card && firstValue != card && card != 14) {
				otherValueCount++;
			}
			if(otherValueCount > 1) {
				return false;
			}
		}

		return true;
		
	}

	private boolean hasThreeSameNumber(List<Integer> ranks) {
		
		int notSameCount = 0;
		int temp = 0;
		
		for(int finalCard : ranks) {
			if(temp == 0 && finalCard != 14) {
				temp = finalCard;
			} else if(finalCard != 14) {
				if(temp != finalCard) {
					notSameCount++;
				}
			}
			if(notSameCount > 2){
				return false;
			}
		}
		return true;
		
	}

	private boolean hasStraight(List<Integer> ranks) {

		int usedJokers = 0;
		int smallestValue = 1;
		
		boolean loop = true;
		
		while(loop) {
			if(ranks.contains(smallestValue)) {
				loop = false;
			} else {
				smallestValue++;
			}
		}
		
		if(!ranks.contains(smallestValue + 1) && usedJokers == 0) {
			if(!ranks.contains(14)) {
				return false;
			}
			usedJokers++;
		} else if(!ranks.contains(smallestValue + 1) && usedJokers > 0) {
			return false;
		}

		if(!ranks.contains(smallestValue + 2) && usedJokers == 0) {
			if(!ranks.contains(14)) {
				return false;
			}
			usedJokers++;
		} else if(!ranks.contains(smallestValue + 2) && usedJokers > 0) {
			return false;
		}
		
		if(!ranks.contains(smallestValue + 3) && usedJokers == 0) {
			if(!ranks.contains(14)) {
				return false;
			}
			usedJokers++;
		} else if(!ranks.contains(smallestValue + 3) && usedJokers > 0) {
			return false;
		}
		
		if(!ranks.contains(smallestValue + 4) && usedJokers == 0) {
			if(!ranks.contains(14)) {
				return false;
			}
			usedJokers++;
		} else if(!ranks.contains(smallestValue + 4) && usedJokers > 0) {
			return false;
		}
		
		return true;

	}

	private boolean hasFlush(List<Integer> suits) {

		int temp = 0;
		
		for(int suite : suits) {
			if(temp == 0 && suite != 5) {
				temp = suite;
			} else if(suite != 5 && temp != 0) {
				if(suite != temp) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean hasFullHouse(List<Integer> finalCards) {

		int firstValue = 0;
		int secondValue = 0;
		
		for(int card : finalCards) {
			if(firstValue == 0 && card != 14) {
				firstValue = card;
			} else if(secondValue == 0 && card != 14) {
				secondValue = card;
			} else if (secondValue != card && firstValue != card && card != 14) {
				return false;
			}
		}

		return true;
	}

	private boolean hasStraightFlush(List<Integer> ranks, List<Integer> suits) {

		int temp = 0;
		
		for(int suite : suits) {
			if(temp == 0 && suite != 5) {
				temp = suite;
			} else if(suite != 5) {
				if(temp != suite) {
					return false;
				}
			}
		}
		
		int usedJokers = 0;
		int smallestValue = 1;
		
		boolean loop = true;
		
		while(loop) {
			if(ranks.contains(smallestValue)) {
				loop = false;
			} else {
				smallestValue++;
			}
		}
		
		if(!ranks.contains(smallestValue + 1) && usedJokers == 0) {
			if(!ranks.contains(14)) {
				return false;
			}
			usedJokers++;
		} else if(!ranks.contains(smallestValue + 1) && usedJokers > 0) {
			return false;
		}

		if(!ranks.contains(smallestValue + 2) && usedJokers == 0) {
			if(!ranks.contains(14)) {
				return false;
			}
			usedJokers++;
		} else if(!ranks.contains(smallestValue + 2) && usedJokers > 0) {
			return false;
		}
		
		if(!ranks.contains(smallestValue + 3) && usedJokers == 0) {
			if(!ranks.contains(14)) {
				return false;
			}
			usedJokers++;
		} else if(!ranks.contains(smallestValue + 3) && usedJokers > 0) {
			return false;
		}
		
		if(!ranks.contains(smallestValue + 4) && usedJokers == 0) {
			if(!ranks.contains(14)) {
				return false;
			}
			usedJokers++;
		} else if(!ranks.contains(smallestValue + 4) && usedJokers > 0) {
			return false;
		}
		
		return true;
	}

	private boolean hasFourSameNumber(List<Integer> finalCards) {
		
		int notSameCount = 0;
		int temp = 0;
		
		for(int finalCard : finalCards) {
			if(temp == 0 && finalCard != 14) {
				temp = finalCard;
			} else if(finalCard != 14) {
				if(temp != finalCard) {
					notSameCount++;
				}
			}
			if(notSameCount > 1){
				return false;
			}
		}
		return true;
	}

	private boolean hasFiveSameNumber(List<Integer> finalCards) {

		int temp = 0;
		
		for(int finalCard : finalCards) {
			if(temp == 0 && finalCard != 14) {
				temp = finalCard;
			} else if(finalCard != 14) {
				if(temp != finalCard) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean hasRoyalFlush(List<Integer> ranks, List<Integer> suites) {

		int temp = 0;
		
		for(int suite : suites) {
			if(temp == 0 && suite != 5) {
				temp = suite;
			} else if(suite != 5) {
				if(temp != suite) {
					return false;
				}
			}
		}
		
		int usedJokers = 0;
		
		if(!ranks.contains(1) && usedJokers == 0) {
			if(!ranks.contains(14)) {
				return false;
			}
			usedJokers++;
		} else if(!ranks.contains(1) && usedJokers > 0) {
			return false;
		}

		if(!ranks.contains(10) && usedJokers == 0) {
			if(!ranks.contains(14)) {
				return false;
			}
			usedJokers++;
		} else if(!ranks.contains(10) && usedJokers > 0) {
			return false;
		}
		
		if(!ranks.contains(11) && usedJokers == 0) {
			if(!ranks.contains(14)) {
				return false;
			}
			usedJokers++;
		} else if(!ranks.contains(11) && usedJokers > 0) {
			return false;
		}
		
		if(!ranks.contains(12) && usedJokers == 0) {
			if(!ranks.contains(14)) {
				return false;
			}
			usedJokers++;
		} else if(!ranks.contains(12) && usedJokers > 0) {
			return false;
		}
		
		if(!ranks.contains(13) && usedJokers == 0) {
			if(!ranks.contains(14)) {
				return false;
			}
			usedJokers++;
		} else if(!ranks.contains(13) && usedJokers > 0) {
			return false;
		}
		
		return true;
	}

}
