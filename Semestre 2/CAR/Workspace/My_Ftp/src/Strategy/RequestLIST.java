package Strategy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import Serveur.FtpRequest;


public class RequestLIST implements Request {

	public void doRequest(FtpRequest ftp, String[] request){
		
	
		OutputStream output = null;
		try {
			// Opens connection
			ftp.sendMessage("150 File status okay; about to open data connection");

			output = ftp.getDataService().openDataStream().getOutputStream();
			
			InputStream is = Runtime
					.getRuntime()
					.exec(new String[] { "ls", "-l",
							ftp.getClient().getPathname()+ftp.getServerPath()})
					.getInputStream();
			
			// Sends response through data socket
			byte[] buffer = new byte[1024];
			int nbBytes = 0;
			while ((nbBytes = is.read(buffer)) != -1) {
				output.write(buffer, 0, nbBytes);
			}

			ftp.sendMessage("226 Closing data connection");
			ftp.getDataService().closeDataStream();

		} catch (IOException ignore) {
			ftp.sendMessage("426 Connection closed, transfer aborted");
			ftp.getDataService().closeDataStream();
		} finally {
			try {
				output.close();
			} catch (Exception ignore) {
			}
		}

	}

}
