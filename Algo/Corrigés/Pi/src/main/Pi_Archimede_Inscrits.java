package main;

import java.util.Scanner;

/**
 * 
 * @author JCV
 * 
 * Calcule une approximation de PI en utilisant la méthode des polygones inscrits d'Archimède (à chercher sur internet)
 *
 */
public class Pi_Archimede_Inscrits {
	
	public static void main(String[] args) {
		int nbBoucles = 0;
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez le nombre de boucles -> ");
		nbBoucles = sc.nextInt();
		
		double corde = 1.0;
		double perim = 0.0;
		for (int i = 4; i <= nbBoucles ; i = i*2) {
			corde = (Math.sqrt(2.0)/2.0) * corde / (Math.sqrt(1+Math.sqrt(1-corde*corde)));
			perim = i*corde;
			System.out.println("i = "+i+" corde = "+corde+" perimetre = "+perim);
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Pi approx = "+perim+" Pi = "+Math.PI);
	}
}
