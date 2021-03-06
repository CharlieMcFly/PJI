package Serveur;

import static org.mockito.Mockito.mock;
import org.junit.Test;
import Serveur.FtpRequest;
import Exceptions.FTPConnexionException;

public class DataServiceTest {

	@Test(expected = FTPConnexionException.class)
	public void initActiveTestPort() {
		FtpRequest ftp = mock(FtpRequest.class);
		DataService dcs = new DataService(ftp);
		dcs.initActive("127.0.0.1", 545);
	}

	@Test(expected = FTPConnexionException.class)
	public void initiActiveTestAdresse() {
		FtpRequest ftp = mock(FtpRequest.class);
		DataService dcs = new DataService(ftp);
		dcs.initActive("127.0.0.1", 545);

	}

}
