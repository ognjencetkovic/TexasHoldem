package ba.bitcamp.texas.run;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

import ba.bitcamp.texas.run.Card.Suit;
import ba.bitcamp.texas.run.Card.Value;

public class Deck {

	private ArrayList<Card> deck = new ArrayList<Card>();
	
	public Deck() {
		for (int i = 0; i < Suit.values().length; i++) {
			for (int j = 0; j < Value.values().length; j++) {
				deck.add(new Card(Suit.values()[i], Value.values()[j]));
			}
		}
	}
	
	public void shuffle(){
		Collections.shuffle(deck);
	}
	
	public static void main(String[] args) {
		Deck d = new Deck();
		System.out.println(d.deck);
		d.shuffle();
		System.out.println(d.deck);
		
		for (int i = 0; i < 5; i++) {
			System.out.print(d.deck.remove(i) + ", ");
		}	
		System.out.println();
		for (int j = 0; j < 4; j++) {
			System.out.print("player " + (j + 1) + ": ");
			for (int i = 0; i < 2; i++) {
				System.out.print(d.deck.remove(i) + ", ");
			}			
			System.out.println();
		}
		System.out.println(d.deck);
		
	}
}
