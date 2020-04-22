package io.github.alexanderheim.uebung3;

public class Uebung3 {
	
	final static int AMOUNT = 100000;
	public static void main(String[] args) {
		String a1 = "X";
		StringBuffer sb = new StringBuffer();
		long startTime = System.currentTimeMillis();
		for(int i = 0; i <= AMOUNT; i++) {
			a1 += "X";
		}
		System.out.println("Normal String Time: " + (System.currentTimeMillis() - startTime) + " Millis");
		
		startTime = System.currentTimeMillis();
		for(int i = 0; i <= AMOUNT; i++) {
			sb.append("X");
		}
		System.out.println("Stringbuilder Time: " + (System.currentTimeMillis() - startTime) + " Millis");
	}

}
