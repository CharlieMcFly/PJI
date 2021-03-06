package Stategy;



import static org.mockito.Mockito.mock;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.mockito.Mockito;

import Client.Client;
import Serveur.DataService;
import Serveur.FtpRequest;
import Strategy.RequestLIST;



public class RequestLISTTest {

	@Rule
    public TemporaryFolder tmpFolder= new TemporaryFolder();

	
	@Test
	public void test() throws IOException {

		FtpRequest ftp = mock(FtpRequest.class);
		String [] request = {"LIST"};
		DataService ds = mock(DataService.class);
		OutputStream out = mock(OutputStream.class);
		Socket socket = mock(Socket.class);
		Client c = mock(Client.class);
		
		Mockito.when(ftp.getClient()).thenReturn(c);
		Mockito.when(ftp.getDataService()).thenReturn(ds);
		Mockito.when(ds.openDataStream()).thenReturn(socket);
		Mockito.when(socket.getOutputStream()).thenReturn(out);
		
		File folder = tmpFolder.newFolder("dossier");
		File file = tmpFolder.newFile("dossier/fichier");
		
		Mockito.when(ftp.getClient().getPathname()).thenReturn(folder.getAbsolutePath());
		Mockito.when(ftp.getServerPath()).thenReturn(folder.getAbsolutePath());
		
		RequestLIST list = new RequestLIST();
		
		list.doRequest(ftp, request);
		
		Mockito.verify(ftp).sendMessage("226 Closing data connection");	
	}

}

