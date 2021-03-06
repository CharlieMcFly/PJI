package Strategy;

import Serveur.FtpRequest;

public class RequestPASS implements Request {

	public void doRequest(FtpRequest ftp, String[] request){

			/* Test si le mot de pass correspond au client */
		if (ftp.getClient().isPassword(request[1])) {
			ftp.sendMessage(230 + " Password correct");
			ftp.getClient().setConnected(true);
			System.out.println(ftp.getClient() + " est connecté.");
		} else {
			ftp.sendMessage(430 + " Invalid Password");
		}
	}

}
