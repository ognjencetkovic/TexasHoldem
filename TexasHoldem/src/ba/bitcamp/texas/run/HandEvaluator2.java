package ba.bitcamp.texas.run;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import java.util.TreeSet;

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
	private int[] pairs = new int[MAX_NUM_OF_PAIRS];

	private int straightRank;

	public HandEvaluator2(ArrayList<Card> hand) {
		this.hand = hand;

		
	}

	private void calculateDistributions() {
		for (Card card : hand) {
			distibutionOfValues[card.getValue().ordinal()]++;
			distibutionOfSuits[card.getSuit().ordinal()]++;
		}
	}

	private boolean hasStraight() {
		int counter = 0;
		for (int i = distibutionOfValues.length - 1; i >= 0; i--) {
			if (distibutionOfValues[i] != 0) {
				counter++;
				if (counter >= 5){
					return true;
				}
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
	
	private boolean hasStraightFlush() {
        if (hasStraight() && hasFlush()) {
            // Flush and Straight (possibly separate); check for Straight Flush.
        	TreeMap<Suit, ArrayList<Value>> set = new TreeMap<>();
        	for (Suit s : Suit.values()){
        		set.put(s, new ArrayList<Card.Value>());
        	}
        	for (Card card : hand) {
        		set.get(card.getSuit()).add(card.getValue());
        	}
        	
        	for (Suit s : Suit.values()){
        		if (set.get(s).size() >= 5){
        			int counter = 0;
        			ArrayList<Value> tmp = set.get(s);
        			Collections.sort(tmp);
        			for (int i = 0; i < tmp.size() - 1; i++) {
        				if (tmp.get(i).ordinal() + 1 == tmp.get(i + 1).ordinal()) {
        					counter++;
        					if (counter >= 4){
        						return true;
        					}
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
        	}
         	
        }
	}
	

	@Override
	public int compareTo(HandEvaluator2 o) {
		
		
		
		
		
		
		return 0;
	}
	
}
