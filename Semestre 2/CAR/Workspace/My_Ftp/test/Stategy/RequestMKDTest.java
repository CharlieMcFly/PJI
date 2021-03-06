package Stategy;

import static org.mockito.Mockito.mock;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.mockito.Mockito;

import Client.Client;
import Serveur.FtpRequest;
import Strategy.RequestMKD;

public class RequestMKDTest {

	@Rule
	public TemporaryFolder tmpFolder = new TemporaryFolder();

	@Test
	public void testOK() throws IOException {
		File folder = tmpFolder.newFolder("dossier");

		FtpRequest ftp = mock(FtpRequest.class);
		String [] request = {"MKD", "/dossier5"};
		Client c = mock(Client.class);
		Mockito.when(ftp.getClient()).thenReturn(c);
		
		Mockito.when(ftp.getServerPath()).thenReturn(folder.getAbsolutePath());

		RequestMKD mkd = new RequestMKD();
		mkd.doRequest(ftp, request);

		Mockito.verify(ftp).sendMessage("257 MKD command successfull");
	}
	
	@Test
	public void testAlreadyExists() throws IOException {
		File tempFolder = tmpFolder.newFolder("dossier");
		(new File(tempFolder.getAbsolutePath() + "/dossier2")).mkdirs();

		String [] request = {"MKD", "/dossier2"};
		FtpRequest ftp = mock(FtpRequest.class);
		Client c = mock(Client.class);
		Mockito.when(ftp.getClient()).thenReturn(c);
		
		Mockito.when(ftp.getServerPath()).thenReturn(tempFolder.getAbsolutePath());

		RequestMKD mkd = new RequestMKD();
		mkd.doRequest(ftp, request);

		Mockito.verify(ftp).sendMessage("553 Directory already exists");
	}
	
	
	@Test
	public void testNoRights() throws IOException {
		File tempFolder = tmpFolder.newFolder("file");
		tempFolder.setExecutable(false);
		
		String [] request = {"MKD", "/file2"};
		FtpRequest ftp = mock(FtpRequest.class);
		Client c = mock(Client.class);
		Mockito.when(ftp.getClient()).thenReturn(c);
		

		Mockito.when(ftp.getServerPath()).thenReturn(tempFolder.getAbsolutePath());

		RequestMKD mkd = new RequestMKD();
		mkd.doRequest(ftp, request);

		Mockito.verify(ftp).sendMessage("550 Unable to make directory");
	}
	
}
