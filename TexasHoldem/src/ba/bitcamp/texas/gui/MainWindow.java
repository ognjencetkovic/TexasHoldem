package ba.bitcamp.texas.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainWindow extends JFrame {
	
	private Dimension dim = new Dimension(getContentPane().getWidth(), getContentPane().getHeight());
	
	private PanelLogin pnlLogin;
	
	private static MainWindow instance;
	
	private MainWindow() {
		
		
		
		pnlLogin = new PanelLogin(dim);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(pnlLogin);
		
		
		setTitle("Texas Holdem");
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		System.out.println(getContentPane().getHeight());
		System.out.println(getContentPane().getWidth());
		
		
	}
	
	public static MainWindow getInstance(){
		if(instance == null){
			instance = new MainWindow();
		}
		return instance;
	}

	
	public static void main(String[] args) {
		MainWindow.getInstance();
	}
}
