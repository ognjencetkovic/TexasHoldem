package ba.bitcamp.texas.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ba.bitcamp.texas.run.Room;

public class PanelLobby extends JPanel {
	private static final long serialVersionUID = -4328719155136254368L;

	private JList<Room> lstRooms = new JList<Room>();
	private JButton btnJoinRoom = new JButton("Join room");
	private JPanel pnlEast = new JPanel();

	private JLabel lblRoomName = new JLabel("Room name: ");
	private JTextField txtRoomName = new JTextField();
	private JLabel lblNumberOfPlayers = new JLabel("Number of players: ");
	// private JTextField txtNumberOfPlayers = new JTextField();
	private JButton btnCreateRoom = new JButton("Create room");
	private JPanel pnlWest = new JPanel();

	private String[] nmbOfPlayers = { "2 Players", "3 Players", "4 Players",
			"5 Players", "6 Players" };
	private JComboBox<String> boxPlayers = new JComboBox<>(nmbOfPlayers);

	public PanelLobby() {

		setLayout(new GridLayout(1, 2));

		// pnlWest.setLayout(new GridLayout(5,1) );
		// pnlWest.add(lblRoomName);
		// pnlWest.add(txtRoomName);
		// pnlWest.add(lblNumberOfPlayers);
		// pnlWest.add(boxPlayers);
		// pnlWest.add(txtNumberOfPlayers);
		// pnlWest.add(btnCreateRoom);
		
		
		// Pokusao sam sa ovim Box layout i stavio sam da se broj igraca bira preko opadajuceg menija
		//pa ako ti se ne svidja slobodno izbrisi pa otkomentarisi ovo gore :D
		
		Box theBox = Box.createVerticalBox();
		
		theBox.add(lblRoomName);
		theBox.add(Box.createVerticalStrut(20));
		theBox.add(txtRoomName);
		theBox.add(Box.createVerticalStrut(100));
		theBox.add(lblNumberOfPlayers);
		theBox.add(Box.createVerticalStrut(20));
		theBox.add(boxPlayers);
		theBox.add(Box.createVerticalStrut(100));
		theBox.add(btnCreateRoom);
		pnlWest.add(theBox);

		pnlEast.setLayout(new BorderLayout());
		pnlEast.add(lstRooms);
		pnlEast.add(btnJoinRoom, BorderLayout.SOUTH);

		pnlWest.setBorder(BorderFactory.createTitledBorder("West"));
		pnlEast.setBorder(BorderFactory.createTitledBorder("East"));

		add(pnlWest);
		add(pnlEast);
	}

}
