package ba.bitcamp.texas.run;

import java.util.ArrayList;
import java.util.Arrays;
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
		//System.out.println(d.deck);
		d.shuffle();
		System.out.println(d.deck + "\n");
		
		ArrayList<Card> table = new ArrayList<Card>();
		for (int i = 0; i < 5; i++) {
			table.add(d.deck.remove(i));
		}
		System.out.println("table: " + table + "\n");
		
		ArrayList<Card> p1 = new ArrayList<Card>(table);
		for (int i = 0; i < 2; i++) {
			p1.add(d.deck.remove(i));
		}
		System.out.println("p1: " + p1 + "\n");
		ArrayList<Card> p2 = new ArrayList<Card>(table);
		for (int i = 0; i < 2; i++) {
			p2.add(d.deck.remove(i));
		}
		System.out.println("p2: " + p2 + "\n");
		ArrayList<Card> p3 = new ArrayList<Card>(table);
		for (int i = 0; i < 2; i++) {
			p3.add(d.deck.remove(i));
		}
		System.out.println("p3: " + p3 + "\n");
		ArrayList<Card> p4 = new ArrayList<Card>(table);
		for (int i = 0; i < 2; i++) {
			p4.add(d.deck.remove(i));
		}
		System.out.println("p4: " + p4 + "\n");
		
		HandEvaluator2 h1 = new HandEvaluator2(p1);
		HandEvaluator2 h2 = new HandEvaluator2(p2);
		HandEvaluator2 h3 = new HandEvaluator2(p3);
		HandEvaluator2 h4 = new HandEvaluator2(p4);
		
		HandEvaluator2[] h = new HandEvaluator2[4];
		h[0] = h1;
		h[1] = h2;
		h[2] = h3;
		h[3] = h4;
		Arrays.sort(h);
		for (HandEvaluator2 handEvaluator2 : h) {
			System.out.println(handEvaluator2.hand);
		}
		
		
		
//		for (int i = 0; i < 5; i++) {
//			System.out.print(d.deck.remove(i) + ", ");
//		}	
//		System.out.println();
//		for (int j = 0; j < 4; j++) {
//			System.out.print("player " + (j + 1) + ": ");
//			for (int i = 0; i < 2; i++) {
//				System.out.print(d.deck.remove(i) + ", ");
//			}			
//			System.out.println();
//		}
//		System.out.println(d.deck);
		
	}
}
