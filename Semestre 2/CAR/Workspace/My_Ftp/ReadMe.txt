Cours de CAR Groupe 4 - MA1 Informatique - Lille 1
2015/2016

@ Auteur : Charlie Quetstroey

Lancement du serveur :

	Pour lancer le serveur, il suffit de le lancer avec le main.java
	Il faut au préalable changer le répertoire du ftp : dans le constructeur de FtpRequest
	Le user : Charlie
	Le pass : 123
	
Remarque et Amélioration :

	J'ai utilisé des patterns comme Strategy et Factory
	J'aurai pu en utiliser d'autre mais j'ai pris ceux ci par simplicité.
	Je pourrais  :
		- faire en sorte que mon ftp marche avec plusieurs client en meme temps.
		- faire des logs pour récupérer les erreurs.
		- refactoriser mon code à certain endroit par facilité.
		- utiliser d'autres patterns pour que mon code soit optimal
		
Ne marche pas : 
	
	J'aurai du écrire les tests en TDD mais par manque de temps, je les ai fait après
	Pour ce qui est des tests, certains ne fonctionne pas, je n'ai donc pas pas trouvé pourquoi.
	Il y a toujours quelques petits bug. 
	