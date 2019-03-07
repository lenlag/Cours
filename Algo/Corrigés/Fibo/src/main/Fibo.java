package main;

import java.util.Scanner;

/**
 * 
 * @author JCV
 * 
 * Affichage d'une suite de Fibonacci jusqu'à ce que le dernier nombre soit supérieur à une valeur donnée (le seuil)
 *
 */
public class Fibo {

	public static void main(String[] args) {
		
		int prev = 0;
		int current = 1;
		System.out.println("Entrez la valeur du seuil (exemple : 1000) -> ");
		@SuppressWarnings("resource")
		int seuil = new Scanner(System.in).nextInt();
		while (true) {
			int tmp = current;
			current = current+prev;
			prev = tmp;
			System.out.println(current);
			if (current >= seuil) {
				break;
			}
		}
	}

}
