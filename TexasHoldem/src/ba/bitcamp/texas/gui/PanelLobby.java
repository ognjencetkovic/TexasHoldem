package ba.bitcamp.texas.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	private JLabel lblRoomName = new JLabel("Room name:", JLabel.CENTER);
	private JTextField txtRoomName = new JTextField();
	private JLabel lblNumberOfPlayers = new JLabel("Number of players:", JLabel.CENTER);
	// private JTextField txtNumberOfPlayers = new JTextField();
	private JButton btnCreateRoom = new JButton("Create room");
	private JPanel pnlWest = new JPanel();

	private String[] nmbOfPlayers = { "2 Players", "3 Players", "4 Players",
			"5 Players", "6 Players" };
	private JComboBox<String> boxPlayers = new JComboBox<>(nmbOfPlayers);

	public PanelLobby() {

		setLayout(new GridLayout(1, 2));

		btnCreateRoom.addActionListener(new Action());
		
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
		
		lblRoomName.setPreferredSize(new Dimension(300,50));
		lblNumberOfPlayers.setPreferredSize(new Dimension(300,50));
		
		lblRoomName.setBorder(BorderFactory.createTitledBorder("dsadasd"));
		lblNumberOfPlayers.setBorder(BorderFactory.createTitledBorder("dsadasd"));
		
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



	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MainWindow.getInstance().getContentPane().removeAll();
			MainWindow.getInstance().getContentPane().add(new PanelRoom());
			MainWindow.getInstance().setVisible(true);
			
		}
		
	}
	
}
