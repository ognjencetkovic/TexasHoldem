package ba.bitcamp.texas.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;

import ba.bitcamp.texas.run.Room;

public class PanelLobby extends JPanel {

	private JList<Room> lstRooms = new JList<Room>();
	private JButton btnJoinRoom = new JButton("Join room");
	private JPanel pnlEast = new JPanel();
	
	private JLabel lblRoomName = new JLabel("Room name: ");
	private JTextField txtRoomName = new JTextField();
	private JLabel lblNumberOfPlayers = new JLabel("Number of players: ");
	private JTextField txtNumberOfPlayers = new JTextField();
	private JButton btnCreateRoom = new JButton("Create room");
	private JPanel pnlWest = new JPanel();
	
	
	public PanelLobby() {
		setLayout(new GridLayout(1, 2));
		
		pnlEast.setLayout(new BorderLayout());
		pnlEast.add(lstRooms);
		pnlEast.add(btnJoinRoom, BorderLayout.SOUTH);
		
		pnlWest.setBorder(BorderFactory.createTitledBorder("West"));
		pnlEast.setBorder(BorderFactory.createTitledBorder("East"));
		
		add(pnlWest);
		add(pnlEast);
	}
	
	
}
