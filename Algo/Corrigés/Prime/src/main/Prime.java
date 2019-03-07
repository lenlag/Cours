package main;

import java.util.Scanner;

/**
 * 
 * @author JCV
 * 
 * Calcule les N premiers nombre premiers
 *
 */
public class Prime {

	public static void main(String[] args) {
		System.out.println("Entrez le nombre de nombre premiers à afficher -> ");
		@SuppressWarnings("resource")
		int nb = new Scanner(System.in).nextInt();
		int[] primes = new int[nb];
		
		int index = 0;
		int value = 0;
		while (index < nb) {
			if (value > 2) {
				boolean good = true;
				for (int i = 2 ; i < index ; i++) {
					/*
					 * Le nombre est divisible par un des nombres premiers déjà calculés ? Ce n'est pas un nombre premier
					 */
					if ((value % primes[i]) == 0) {
						good = false;
						// il est divisible ? Pas la peine de continuer à tester
						break;
					}
				}
				if (good) {
					primes[index++] = value;
				}
			} else {
				primes[index++] = value;
			}
			value++;
		}
		
		for (int i = 0; i < nb ; i++) {
			System.out.println(""+primes[i]);
		}
	}

}
