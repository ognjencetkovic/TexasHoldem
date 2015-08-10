package ba.bitcamp.texas.run;

public class Card {

	public enum Suit {
		HEARTS, CLUBS, DIAMONDS, SPADES
	}
	
	public enum Value {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}
	
	private Suit suit;
	private Value value;
	
	/**
	 * @param suit
	 * @param value
	 */
	public Card(Suit suit, Value value) {
		super();
		this.suit = suit;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value.toString() + " of " + suit.toString();
	}
}
