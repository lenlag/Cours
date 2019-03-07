package main;

public class Utilisateur {
	public void ecrire(Marker marker) {
		marker.enleverCapuchon();
		marker.utiliserEncre();
		Log.log("j'écris en tant qu'utilisateur");
	}
}
