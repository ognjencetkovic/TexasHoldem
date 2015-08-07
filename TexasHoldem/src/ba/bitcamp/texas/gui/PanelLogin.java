package ba.bitcamp.texas.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class PanelLogin extends JPanel {

	private JLabel lblUsername = new JLabel("Username: ");
	private JTextField txtUsername = new JTextField();
	private JButton btnSubmit = new JButton("Submit");
	private JButton btnGit = new JButton("Git");
	
	public PanelLogin(Dimension d) {
		
		btnSubmit.addActionListener(new Action());
		txtUsername.addKeyListener(new Action());
		
		
		setLayout(new FlowLayout());
		add(lblUsername);
		add(txtUsername);
		add(btnSubmit);
		add(btnGit);
		
		setSize(d);
	}
	
	private class Action extends KeyAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			action();
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER){
				action();
			}
			super.keyPressed(e);
		}
		
		private void action(){
			//TODO
			MainWindow.getInstance().getContentPane().removeAll();
			MainWindow.getInstance().getContentPane().add(new PanelLobby());
			MainWindow.getInstance().setVisible(true);
	
			
//			new Timer(1, new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					System.out.println("dsad");
//					MainWindow.getInstance().getContentPane().repaint();
//					MainWindow.getInstance().repaint();
//					pl.repaint();
//					
//				}
//			}).start();
			
		}
		
	}
}
