package ba.bitcamp.texas.gui;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import ba.bitcamp.texas.run.Card;
import ba.bitcamp.texas.run.Card.Suit;
import ba.bitcamp.texas.run.Card.Value;

public class PanelPlayer extends JLayeredPane {

	private static final long serialVersionUID = -4366640253233963633L;

	JLabel lblCard1 = new JLabel("Card 1");
	JLabel lblCard2 = new JLabel("Card 2");


	PanelCardImage card1 = new PanelCardImage(new Card(Suit.CLUBS, Value.EIGHT));
	PanelCardImage card2 = new PanelCardImage(
			new Card(Suit.SPADES, Value.QUEEN));
	PanelPlayerInfo playerInfo = new PanelPlayerInfo("Edvin",
			PanelPlayerInfo.Played.ALL_IN);

	
	public PanelPlayer() {

		card1.setBounds(30, 10, 70, 100);
		card2.setBounds(90, 10, 70, 100);
		playerInfo.setBounds(10, 80, 180, 60);

		add(card1, 0);
		add(card2, 0);
		add(playerInfo);

	}

	public static void main(String[] args) {

		JFrame f = new JFrame();
		f.add(new PanelPlayer());
		f.setSize(200, 170);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}
}
