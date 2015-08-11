package ba.bitcamp.texas.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import ba.bitcamp.texas.run.Card;

public class PanelCardImage extends JPanel {
	
	private static final long serialVersionUID = 4063138341155485971L;
	
	BufferedImage cardImage;
	Card card;
	
	
	public PanelCardImage(Card card) {
		this.card = card;
		try {
			String filePath = card.getValue().toString().toLowerCase() + "_of_" + card.getSuit().toString().toLowerCase() + ".png";
			cardImage = ImageIO.read(new File("card1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(cardImage.getScaledInstance(150, 220, Image.SCALE_DEFAULT), 0, 0, null);
	}
	
}