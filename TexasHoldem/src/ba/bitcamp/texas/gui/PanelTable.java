package ba.bitcamp.texas.gui;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private Action action = new Action();
	
	
	public PanelTable() {
		
		for (int i = 0; i < players.length; i++) {
			addPanelPlayer(new PanelPlayer(), i);
			players[i].getPlayerInfo().addMouseListener(action);
		}
		
	}
	
	private void addPanelPlayer(PanelPlayer pnlPlayer, int position) {
		if(getComponentCount() > position){
			remove(players[position]);			
		}
		players[position] = pnlPlayer;
		players[position].getPlayerInfo().setName(String.valueOf(position));
		players[position].setBounds((int)PLAYER_POSITIONS[position].getX(), (int)PLAYER_POSITIONS[position].getY(), 200, 170);
		add(players[position]);
		
	}
	
	private class Action extends MouseAdapter {
		
		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("dasd");
			for (int i = 0; i < players.length; i++) {
				players[i].getPlayerInfo().removeMouseListener(this);
			}
			updateTable(Integer.parseInt(e.getComponent().getName()));
		}
		
	}
	
	private void updateTable(int position) {
		System.out.println(PanelLogin.getPlayer().getName());
		addPanelPlayer(new PanelPlayer(PanelLogin.getPlayer()), position);
		repaint();
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
