package ba.bitcamp.texas.run;

import java.util.ArrayList;

import ba.bitcamp.texas.run.Card.Suit;
import ba.bitcamp.texas.run.Card.Value;

public class HandEvaluator2 {
	
	private ArrayList<Card> hand;
	private int[] distibutionOfValues = new int[Value.values().length];
	private int[] distibutionOfSuits = new int[Suit.values().length];

	public HandEvaluator2(ArrayList<Card> hand) {
        this.hand = hand;
        
        // Find patterns.
        calculateDistributions();
        //findStraight();
//        findFlush();
//        findDuplicates();
//        
//        // Find special values.
//        boolean isSpecialValue =
//                (isStraightFlush() ||
//                 isFourOfAKind()   ||
//                 isFullHouse()     ||
//                 isFlush()         ||
//                 isStraight()      ||
//                 isThreeOfAKind()  ||
//                 isTwoPairs()      ||
//                 isOnePair());
//        if (!isSpecialValue) {
//            calculateHighCard();
//        }
//        
//        // Calculate value.
//        for (int i = 0; i < NO_OF_RANKINGS; i++) {
//            value += rankings[i] * RANKING_FACTORS[i];
//        }
    }

	private void calculateDistributions() {
		  for (Card card : hand) {
	            distibutionOfValues[card.getValue().ordinal()]++;
	            distibutionOfSuits[card.getSuit().ordinal()]++;
	        }
	}

	private boolean hasStraight() {
		int counter = 0;
		for (int i = 0; i < distibutionOfValues.length; i++) {
			if (distibutionOfValues[i] != 0){
				counter++;
				if(counter >= 5)
					return true;
			} else {
				counter = 0;
			}
		}
		if(counter == 4){
			if(distibutionOfValues[0] != 0)
				return true;
		}
		return false;
	}
	
	private boolean hasFlush(){
		for (int i = 0; i < distibutionOfSuits.length; i++) {
			if(distibutionOfSuits[i] >= 5){
				return true;
			}
		}
		return false;
	}
	
}
