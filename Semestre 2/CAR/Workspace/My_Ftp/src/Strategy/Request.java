package Strategy;

import Serveur.FtpRequest;

public interface Request {
	
	void doRequest(FtpRequest ftp, String [] request);

}
