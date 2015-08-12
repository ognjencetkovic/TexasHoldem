package ba.bitcamp.texas.networking;

import java.io.IOException;
import java.net.ServerSocket;

public class RoomServer {

	public static final int ROOM_SERVER_PORT = 35721;
	
	private String roomName;
	private ServerSocket roomServer;
	private PlayersActiveList playersActiveList;
	
	public RoomServer(String roomName) {
		
		this.roomName = roomName;
		
		try {
			roomServer = new ServerSocket(ROOM_SERVER_PORT);
			
			while (true) {
				
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//playersActiveList = new PlayersActiveList();
		
	}
	
}
