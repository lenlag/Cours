package main;

public class Saisie {

	public static String getInputString() throws Exception {
		byte[] bs = new byte[255];
		System.in.read(bs);
		
		return new String(bs).trim();
	}
	public static int getInputInt() throws Exception {
		String s = getInputString();
		return Integer.parseInt(s);
	}
	public static void main(String[] args)  throws Exception {
		System.out.print("Entrez une chaine -> ");
		System.out.println(getInputString());
		System.out.print("Entrez un nombre -> ");
		int i = getInputInt();
		if (i < 18) {
			System.out.println("MINEUR");
		} else {
			System.out.println("MAJEUR");
		}
	}

}
