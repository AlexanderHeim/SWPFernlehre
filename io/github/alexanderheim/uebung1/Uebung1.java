package io.github.alexanderheim.uebung1;

import java.util.Random;

public class Uebung1 {

	
	public static void main(String[] args) {
		Random random = new Random();
		int[][] temperatures = new int[14][10];
		
		for(int d = 0; d < temperatures.length; d++) {
			for(int t = 0; t < temperatures[d].length; t++) {
				temperatures[d][t] = random.nextInt(16) + 20;
			}
		}
		
		int[] averages = new int[temperatures.length];
		int sumsum = 0;
		for(int i = 0; i < temperatures.length; i++) {
			int sum = 0;
			for(int j = 0; j < temperatures[i].length; j++) {
				sum+= temperatures[i][j];
				System.out.print(temperatures[i][j] + " ");
			}
			sumsum += sum/temperatures[i].length;
			System.out.println("Durchschnittstemperatur: " + sum/temperatures[i].length);
		}
		System.out.println("Total average: " + sumsum/temperatures.length);
	}
}
