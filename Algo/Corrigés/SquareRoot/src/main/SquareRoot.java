package main;

import java.util.Scanner;

/**
 * 
 * @author JCV
 * 
 * Calcule la racine carrée d'un nombre donné par améliorations successives et par récursion. 
 *
 */
public class SquareRoot {
	
	/**
	 * Calcule la racine carrée par approximation
	 * 
	 * @param floor = valeur inférieure à la valeur recherchée
	 * @param ceil = valeur supérieure à la valeur recherchée
	 * @param precision = précision
	 * @param value = valeur dont on cherche la racine carrée
	 * @return la racine carrée de value
	 */
	public static double approch(double floor, double ceil, double precision,double value) {
		// on prend comme valeur de test celle qui est "au milieu" de floor et ceil
		double val = floor+(ceil-floor)/2;
		System.out.println(floor+" "+ceil+" "+val);
		// on calcule le carré de val
		double sq = square(val);
		// ensuite on regarde l'ordre des 2 carrés
		if (sq == value) {
			// valeur OK direct -> on retourne
			return val;
		} else {
			// si la valeur absolue de la différence est inférieure à la précision, on admet que la valeur trouvée est la bonne et on retourne
			if (Math.abs(value-sq) <= precision) {
				// regarder quand même si un nombre "rond" ne marche pas
				if ((int)square(Math.ceil(val)) == value) {
					return Math.ceil(val);
				} else if ((int)square(Math.floor(val)) == value) {
					return Math.floor(val);
				} else {
					return val;
				}
			}
			// selon que sq est supérieur ou inférieur à result, on utilise val comme floor ou ceil et on continue par récusion
			if (sq > value) {
				return approch(floor,val,precision,value);
			} else {
				return approch(val,ceil,precision,value);
			}
		}
	}
	/**
	 * Calcul le carré d'un nombre
	 * 
	 * @param d : valeur dont on veut le carré
	 * @return le carré de d
	 */
	public static double square (double d) {
		return d*d;
	}
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez la valeur -> ");
		int val = sc.nextInt();
		
		double result = 0.0;

		// précision en dessous de laquelle on arrête la recherche
		final double precision = 0.0001;
		
		result = approch(0,val,precision,val);
		System.out.println("Racine carrée -> "+result+" Carré -> "+square(result));
		System.out.println("Racine carrée réelle -> "+Math.sqrt(val));
	}

}
