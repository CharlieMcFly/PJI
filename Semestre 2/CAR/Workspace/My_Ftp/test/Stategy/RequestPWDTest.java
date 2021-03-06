package Stategy;

import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.Mockito;

import Serveur.FtpRequest;
import Strategy.RequestPWD;

public class RequestPWDTest {

	@Test
	public void testPwd() {
		FtpRequest ftp = mock(FtpRequest.class);
		String [] request = {"PWD"};
		Mockito.when(ftp.getServerPath()).thenReturn("/");
		
		RequestPWD pwd = new RequestPWD();
		
		pwd.doRequest(ftp, request);
		
		Mockito.verify(ftp).sendMessage("257 "+ "\"" +"/"+ "\"" + " is the current directory.");
		
		
	}

}
