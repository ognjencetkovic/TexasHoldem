package ba.bitcamp.texas.networking;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import ba.bitcamp.texas.run.Player;
import ba.bitcamp.texas.run.Room;

public class PlayersActiveList {
	
	private ArrayList<Player> players;
	private Socket socket;
	
	public PlayersActiveList(Room room) {
		players = new ArrayList<Player>();
		try {
			socket = new Socket(room.getIp(), room.getHost());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addPlayer(Player player){
		players.add(player);
	}

	public void removePlayer(Player player){
		players.remove(player);
	}
	
	public boolean isActive(Player player) {
		return players.contains(player);
	}
	
}
