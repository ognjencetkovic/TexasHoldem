package ba.bitcamp.texas.run;

import java.util.ArrayList;

import ba.bitcamp.texas.run.Card.Suit;
import ba.bitcamp.texas.run.Card.Value;

public class HandEvaluator2 implements Comparable<HandEvaluator2> {

	private static final int MAX_NUM_OF_PAIRS = 2;
	private ArrayList<Card> hand;
	private int[] distibutionOfValues = new int[Value.values().length];
	private int[] distibutionOfSuits = new int[Suit.values().length];
	private int fourOfAKind;
	private int threeOfAKind;
	private int numOfPairs;
	private int[] pairs;

	public HandEvaluator2(ArrayList<Card> hand) {
		this.hand = hand;

		// Find patterns.
		calculateDistributions();
		// findStraight();
		// findFlush();
		// findDuplicates();
		//
		// // Find special values.
		// boolean isSpecialValue =
		// (isStraightFlush() ||
		// isFourOfAKind() ||
		// isFullHouse() ||
		// isFlush() ||
		// isStraight() ||
		// isThreeOfAKind() ||
		// isTwoPairs() ||
		// isOnePair());
		// if (!isSpecialValue) {
		// calculateHighCard();
		// }
		//
		// // Calculate value.
		// for (int i = 0; i < NO_OF_RANKINGS; i++) {
		// value += rankings[i] * RANKING_FACTORS[i];
		// }
	}

	private void calculateDistributions() {
		for (Card card : hand) {
			distibutionOfValues[card.getValue().ordinal()]++;
			distibutionOfSuits[card.getSuit().ordinal()]++;
		}
	}

	private boolean hasStraight() {
		int counter = 0;
		for (int i = distibutionOfValues.length - 1; i >= 0; i++) {
			if (distibutionOfValues[i] != 0) {
				counter++;
				if (counter >= 5)
					return true;
			} else {
				counter = 0;
			}
		}
		if (counter == 4) {
			if (distibutionOfValues[distibutionOfValues.length - 1] != 0)
				return true;
		}
		return false;
	}

	private boolean hasFlush() {
		for (int i = 0; i < distibutionOfSuits.length; i++) {
			if (distibutionOfSuits[i] >= 5) {
				return true;
			}
		}
		return false;
	}

	private void findDuplicates() {
		for (int i = Value.values().length - 1; i >= 0; i--) {
			if (distibutionOfValues[i] == 4) {
				fourOfAKind = i;
			} else if (distibutionOfValues[i] == 3) {
				threeOfAKind = i;
			} else if (distibutionOfValues[i] == 2) {
				if (numOfPairs < MAX_NUM_OF_PAIRS) {
					pairs[numOfPairs++] = i;
				}
			}
		}
	}

	@Override
	public int compareTo(HandEvaluator2 o) {
		
		
		
		
		
		
		return 0;
	}
	
}
