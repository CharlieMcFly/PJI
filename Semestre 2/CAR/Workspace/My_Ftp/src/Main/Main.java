package Main;
import Serveur.Serveur;


class Main {

	/**
	 * Créer et lance le serveur
	 * @param args
	 */
	public static void main(String[] args) {
		Serveur s = new Serveur();
		s.initServeur();
		s.start();
	}

}
