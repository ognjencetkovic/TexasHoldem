package ba.bitcamp.texas.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class PanelPlayer extends JLayeredPane {
	
	private static final long serialVersionUID = -4366640253233963633L;

	JLabel lblCard1 = new JLabel("Card 1");
	JLabel lblCard2 = new JLabel("Card 2");
	JLabel lblPlayerInfo = new JLabel("Player Info");
	
	
	public PanelPlayer() {
		
		setPreferredSize(new Dimension(400, 400));
		setBorder(BorderFactory.createTitledBorder("pane"));
		
		lblCard1.setBounds(30, 30, 70, 100);
		//lblCard1.setLocation(30, 30);
		lblCard2.setBounds(80, 30, 70, 100);
		lblPlayerInfo.setBounds(10, 80, 160, 70);
		
		ImageIcon c1 = new ImageIcon("card1.png");
		//c1.get
		
		lblCard1.setBackground(Color.BLUE);
		lblCard1.setOpaque(true);
		lblCard2.setBackground(Color.RED);
		lblCard2.setOpaque(true);
		//lblCard1.setIcon(c1);
		
		lblCard1.setBorder(BorderFactory.createTitledBorder("card1"));
		lblCard2.setBorder(BorderFactory.createTitledBorder("card2"));
		lblPlayerInfo.setBorder(BorderFactory.createTitledBorder("player info"));
		
		
		add(lblCard1, 2);
		add(lblCard2, 3);
		add(lblPlayerInfo, 0);
		
	}
	
	
	public static void main(String[] args) {
		
		
		JFrame f = new JFrame();
		f.add(new PanelPlayer());
		f.setSize(400, 400);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
