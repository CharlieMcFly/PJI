package Serveur;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Client.Client;

public class ClientTest {

	@Test
	public void testConnexionOk() {
		Client c = new Client("a", "a");
		boolean result = c.isPassword("a");
		assertEquals(result, true);
		assertEquals(c.isConnected(), true);
	}

	@Test
	public void testConnectPassOk() {
		Client c = new Client("a", "a");
		boolean result = c.isPassword("e");
		assertEquals(result, false);
		assertEquals(c.isConnected(), false);
	}

	@Test
	public void testConnectCharlie() {
		Client c = new Client("Charlie", "123");
		boolean result = c.isPassword("123");
		assertEquals(result, true);
		assertEquals(c.isConnected(), true);
	}

}
