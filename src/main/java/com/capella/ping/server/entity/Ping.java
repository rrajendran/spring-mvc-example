package com.capella.ping.server.entity;

public class Ping {
	private String server;
	private int port;
	private boolean isConnected;

	public Ping(String server, int port) {
		super();
		this.server = server;
		this.port = port;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public boolean isConnected() {
		return isConnected;
	}
	public boolean setConnected(boolean isConnected) {
		return this.isConnected = isConnected;
	}
	@Override
	public String toString() {
		return "Ping [server=" + server + ", port=" + port + ", isConnected="
				+ isConnected + "]";
	}

}
