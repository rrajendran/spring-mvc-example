package com.capella.ping.server.utils;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class PseudoPing {
	public static String ping(String host, int port) throws IOException {
		Socket t = null;
		try {
			t = new Socket(host, port);
			DataInputStream dis = new DataInputStream(t.getInputStream());
			PrintStream ps = new PrintStream(t.getOutputStream());
			String str = dis.readLine();
			if (str != null)
				return ("Alive!");
			else
				return ("Dead or echo port not responding");

		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			t.close();
		}
		return "Empty";
	}

}