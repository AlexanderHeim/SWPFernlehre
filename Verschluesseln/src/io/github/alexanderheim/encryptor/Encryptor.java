package io.github.alexanderheim.encryptor;

import io.github.alexanderheim.utility.CharMap;

public class Encryptor {

	private int[] key;
	private static CharMap charMap = new CharMap();
	static {
		charMap.addMapping('A', '0');
		charMap.addMapping('B', '1');
		charMap.addMapping('C', '2');
		charMap.addMapping('D', '3');
		charMap.addMapping('E', '4');
		charMap.addMapping('F', '5');
		charMap.addMapping('G', '6');
		charMap.addMapping('H', '7');
		charMap.addMapping('I', '8');
		charMap.addMapping('J', '9');
	}
	
	public Encryptor(String key) {
		changeKey(key);
	}
	
	public void changeKey(String key) {
		this.key = new int[key.length()];
		for(int i = 0; i < this.key.length; i++) {
			this.key[i] = Integer.parseInt(String.valueOf(key.charAt(i)));
		}
	}
	
	private StringBuilder mapLettersToDigits(String input_) {
		// TODO IS STRINGUILBER FASTER
		StringBuilder input = new StringBuilder(input_.toUpperCase());
		StringBuilder output = new StringBuilder("");
		for(int i = 0; i < input.length(); i++) {
			if(charMap.isLetterRegistered((input.charAt(i)))) {
				output.append(charMap.getDigit((input.charAt(i))));
			}
		}
		return output;
	}
	
	private StringBuilder mapDigitsToLetters(StringBuilder input) {
		StringBuilder output = new StringBuilder("");
		for(int i = 0; i < input.length(); i++) {
			output.append(charMap.getLetter((Character.getNumericValue((input.charAt(i))))));
		}
		return output;
	}
	
	public String encrypt(String input_) {
		StringBuilder input = mapLettersToDigits(input_);
		StringBuilder output = new StringBuilder("");
		for(int i = 0; i < input.length(); i++) {
			int encrypted = Byte.parseByte((String.valueOf(input.charAt(i))));
			encrypted += this.key[i % key.length];
			if(encrypted >= 10) encrypted -= 10;
			output.append(encrypted);
		}
		return  mapDigitsToLetters(output).toString();
	}
	
}
