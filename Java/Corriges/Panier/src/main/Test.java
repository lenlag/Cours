package main;

public class Test {

	public static void main(String[] args) {
		ISellableItem item1 = new SellableItem(5, "Stylo", 3.0, 0.2);
		Log.log(item1.toString());
		ISellableItem item2 = new SellableItem(10, "Marteau", 15.0, 0.1);
		Log.log(item2.toString());
		ISellableItem itemx = new SellableItem(12, "Seau", 33.0, 0.1);
		Cart cart = new Cart();
		cart.add(item1);
		cart.add(item2);
		cart.add(itemx);
		Log.log(cart.toString());
		ISellableItem si = cart.getItemById(10);
		if (si != null) {
			Log.log("Valeur du SellableItem de id=10 "+si.toString());
		}
		// Erreur volontaire
		ISellableItem si2 = cart.getItemById(45);
		if (si2 == null) {
			Log.log("Ok, c'est bien null");
		}
		// modif de si
		si.setNom("Lapin");
		Log.log(cart.toString());
		// on met un item à la place d'un autre
		ISellableItem item3 = new SellableItem(20, "Banane", 1.5, 0.1);
		cart.setItemById(10, item3);
		Log.log(cart.toString());
		// on rajoute un 4eme item
		item3 = new SellableItem(22, "Roue", 20.6, 0.2);
		cart.add(item3);
		Log.log(cart.toString());
		Log.log("------------ Debut de destruction ---------");
		// on détruit l'item du milieu (id == 20)
		cart.deleteItemById(20);
		Log.log(cart.toString());

		cart.deleteItemById(12);
		Log.log(cart.toString());
		
		// cas aux limites
		cart.deleteItemById(22);
		Log.log(cart.toString());
		// le panier sera vide après
		cart.deleteItemById(5);
		Log.log(cart.toString());
	}

}
