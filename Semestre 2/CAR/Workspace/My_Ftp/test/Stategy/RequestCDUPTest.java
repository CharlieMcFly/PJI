package Stategy;


import static org.mockito.Mockito.mock;

import java.io.File;

import org.junit.Test;
import org.mockito.Mockito;

import Serveur.FtpRequest;
import Strategy.RequestCDUP;

public class RequestCDUPTest {

	@Test
	public void testCDUPko() {
		
		FtpRequest ftp = mock(FtpRequest.class);
		String [] request = {"CDUP", ".."};
		File file = mock(File.class);
		
		Mockito.when(file.getParent()).thenReturn("dossier");
		Mockito.when(ftp.getServerPath()).thenReturn("fichier");		

		RequestCDUP cdup = new RequestCDUP();
		
		cdup.doRequest(ftp, request);
		
		Mockito.verify(ftp).sendMessage("550 No access to parent folder");
		
	}
	
	/*
	@Test
	public void testCDUPok() {
		
		FtpRequest ftp = mock(FtpRequest.class);
		String [] request = {"CDUP", "racine"};
		File file = mock(File.class);
		
		Mockito.when(file.getParent()).thenReturn("racine");
		Mockito.when(ftp.getServerPath()).thenReturn("dossier");
		Mockito.when(ftp.getServerPath()).thenReturn("");
		

		RequestCDUP cdup = new RequestCDUP();
		
		cdup.doRequest(ftp, request);
		
		//Mockito.verify(ftp).setServerPath("racine");
		Mockito.verify(ftp).sendMessage("200 CDUP successfull");
		
	}
	*/
}
