package ba.bitcamp.texas.networking;

import java.net.Socket;

public class RoomClient implements Runnable {

	private Socket client;
	
	public RoomClient(Socket client) {
		
		this.client = client;
		
		new Thread(this).start();
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
