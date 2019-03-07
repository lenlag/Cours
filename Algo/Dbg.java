package main;

public class Dbg {

	public static int square(int i) {
		int sq = i*i;
		return sq;
	}
	public static void main(String[] args) {
		int i = 0;
		i++;
		i = i * 3;
		i = square(i);
		System.out.println(""+i);
	}

}
