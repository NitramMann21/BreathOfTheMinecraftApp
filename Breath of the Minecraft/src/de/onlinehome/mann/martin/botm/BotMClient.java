package de.onlinehome.mann.martin.botm;

import com.blogspot.debukkitsblog.net.Client;

public class BotMClient extends Client {

	public BotMClient(String hostname, int port) {
		super(hostname, port, 5000);
		
		start();
	}

}
