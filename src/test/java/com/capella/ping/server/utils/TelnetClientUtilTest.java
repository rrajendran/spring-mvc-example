package com.capella.ping.server.utils;

import org.junit.Test;

import com.capella.ping.server.entity.Ping;

public class TelnetClientUtilTest {

	@Test
	public void testTelnet() throws Exception {
		Ping ping = new Ping("localhost", 389);
		System.out.println(TelnetClientUtil.telnet(ping ));
	}

}
