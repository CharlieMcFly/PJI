package Stategy;

import static org.mockito.Mockito.mock;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.mockito.Mockito;

import Client.Client;
import Serveur.DataService;
import Serveur.FtpRequest;
import Strategy.RequestSTOR;

public class RequestSTORTest {

	@Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

	private FtpRequest ftp;
	private DataService ds;
	private InputStream is;
	private FileOutputStream out;
	private Socket socket;
	
	@Before
    public void setUp() throws IOException {
		ftp = mock(FtpRequest.class);
		ds = mock(DataService.class);
		out = mock(FileOutputStream.class);
		socket = mock(Socket.class);
		
		
		Mockito.when(ftp.getDataService()).thenReturn(ds);
		Mockito.when(ds.openDataStream()).thenReturn(socket);
		InputStream anyInputStream = new ByteArrayInputStream("test data".getBytes());
		Mockito.when(socket.getInputStream()).thenReturn(anyInputStream);
    }
	
	@Test()
	public void testFichierNonTrouve() throws IOException {

		File tempFolder = testFolder.newFolder("folder");
		File tempFile = testFolder.newFile("folder/file.txt");
		tempFile.setWritable(false);
		String [] request = {"STOR", "/file.txt"};
		Client c = mock(Client.class);
		
		Mockito.when(ftp.getClient()).thenReturn(c);
		
		Mockito.when(c.getPathname()).thenReturn(tempFolder.getAbsolutePath());
			
		RequestSTOR stor = new RequestSTOR();
		stor.doRequest(ftp, request);
		
		Mockito.verify(ftp).sendMessage("550 Requested action not taken; file unavailable");	
	}
	
	@Test
	public void testOK() throws IOException {

		File tempFolder = testFolder.newFolder("folder");
		File tempFile = testFolder.newFile("folder/file.txt");
		String [] request = {"STOR", "/file.txt"};
		Client c = mock(Client.class);
		
		Mockito.when(ftp.getClient()).thenReturn(c);
		Mockito.when(c.getPathname()).thenReturn(tempFolder.getAbsolutePath());
		
		RequestSTOR stor = new RequestSTOR();
		stor.doRequest(ftp, request);
		
		Mockito.verify(ftp).sendMessage("150 File status okay; about to open data connection");	
	}


}
