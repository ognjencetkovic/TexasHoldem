package ba.bitcamp.texas.run;

import java.util.ArrayList;

public class Player {

	private static String name;
	private int positionAtTable;
	private ArrayList<Card> hand;
	private int chips;
	private boolean active;
	private boolean folded;
	
	public Player(String name) {
		super();
		this.name = name;
	}
	public static String getName() {
		return name;
	}
	
	
	
}
