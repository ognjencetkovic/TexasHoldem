package ba.bitcamp.texas.gui;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class PanelTable extends JLayeredPane {
	
	private static final long serialVersionUID = 1604522399060949298L;

	public static final Point PLAYER_ONE = new Point(400, 400);
	public static final Point PLAYER_TWO = new Point(100, 300);
	public static final Point PLAYER_THREE = new Point(100, 100);
	public static final Point PLAYER_FOUR = new Point(400, 30);
	public static final Point PLAYER_FIVE = new Point(700, 100);
	public static final Point PLAYER_SIX = new Point(700, 300);
	public static final Point[] PLAYER_POSITIONS = {PLAYER_ONE, PLAYER_TWO, PLAYER_THREE, PLAYER_FOUR, PLAYER_FIVE, PLAYER_SIX};
	
	
	private PanelPlayer[] players = new PanelPlayer[6];
	
	public PanelTable() {
		
		for (int i = 0; i < players.length; i++) {
			players[i] = new PanelPlayer();
			players[i].setName(i + "");
			players[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					System.out.println(e.getComponent().getName());
				}
			});
			players[i].setBounds((int)PLAYER_POSITIONS[i].getX(), (int)PLAYER_POSITIONS[i].getY(), 200, 170);
			System.out.print((int)PLAYER_POSITIONS[i].getX() + ", ");
			System.out.println((int)PLAYER_POSITIONS[i].getY());
			add(players[i]);
		}
		
	}
	
	public static void main(String[] args) {
		
		
		JFrame f = new JFrame();
		f.add(new PanelTable());
		f.setSize(1000, 800);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
