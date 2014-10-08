package com.capella.ping.server.utils;

import java.net.ConnectException;

import org.apache.commons.net.telnet.TelnetClient;

import com.capella.ping.server.entity.Ping;

/***
 * This is a simple example of use of TelnetClient. An external option handler
 * (SimpleTelnetOptionHandler) is used. Initial configuration requested by
 * TelnetClient will be: WILL ECHO, WILL SUPPRESS-GA, DO SUPPRESS-GA. VT100
 * terminal type will be subnegotiated.
 * <p>
 * Also, use of the sendAYT(), getLocalOptionState(), getRemoteOptionState() is
 * demonstrated. When connected, type AYT to send an AYT command to the server
 * and see the result. Type OPT to see a report of the state of the first 25
 * options.
 * <p>
 *
 * @author Bruno D'Avanzo
 ***/
public class TelnetClientUtil {
	static TelnetClient tc = new TelnetClient();;

	/***
	 * Main for the TelnetClientExample.
	 * @return
	 ***/
	public static Ping telnet(Ping ping) throws Exception {
		try {
			tc.connect(ping.getServer(), ping.getPort());
			ping.setConnected(tc.isConnected());
		} catch (ConnectException e) {
		}
		return ping;
	}


}