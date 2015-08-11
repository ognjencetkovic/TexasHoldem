package ba.bitcamp.texas.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	
	PanelCardImage card1 = new PanelCardImage();
	PanelCardImage card2 = new PanelCardImage();
	
	public PanelPlayer() {
		
		
		
		setPreferredSize(new Dimension(400, 400));
		setBorder(BorderFactory.createTitledBorder("pane"));
		
		lblPlayerInfo.setBounds(10, 80, 160, 70);
		card1.setBounds(30, 30, 150, 220);
		card2.setBounds(150, 30, 150, 220);
		ImageIcon c1 = new ImageIcon("card1.png");
		
		lblCard1.setBorder(BorderFactory.createTitledBorder("card1"));
		lblCard2.setBorder(BorderFactory.createTitledBorder("card2"));
		lblPlayerInfo.setBorder(BorderFactory.createTitledBorder("player info"));
		
		
		add(card1, 3);
		add(card2, 2);
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
