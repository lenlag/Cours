package starter;

import service.Worker;

/**
 * <b>CLASSE D'ENTREE DE L'APPLICATION</b><br/>
 * @author 1603599
 *
 */
public class Main {

	/**
	 * <b>METHODE D'ENTREE DE L'APPLICATION</b><br/>
	 * @author 1603599
	 *
	 */
	public static void main(String[] args) {
		
		///////////////////////////////////////////////////////////////////////////////
		// (01.)EFFECTUER LES 2 TACHES CI-DESSOUS :
		//      (01.01.)CREER UNE CLASSE ANONYME, QUI IMPLEMENTE L'INTERFACE 'Worker'.
		//      (01.02.)INSTANCIER UN OBJET DE LA CLASSE ANONYME.
		///////////////////////////////////////////////////////////////////////////////
		Worker worker = new Worker() {
			
			@Override
			public void work() {
				System.out.println("I am working !");
			}
		};
		
		///////////////////////////////////////////////////////////////////////////////
		// (02.)EFFECTUER LA TACHE CI-DESSOUS :
		//      ->SUR L'OBJET 'Worker', DECLENCHER LA METHODE 'work'.
		///////////////////////////////////////////////////////////////////////////////
		worker.work();
	}
}
