package io.github.alexanderheim.utility;

import java.util.HashMap;

public class CharMap {

	private HashMap<Character, Character> letterMap = new HashMap<Character, Character>();
	private HashMap<Character, Character> digitMap = new HashMap<Character, Character>();
	
	public void addMapping(Character letter, Character digit) {
		letterMap.put(letter, digit);
		digitMap.put(digit,  letter);
	}
	
	public Character getLetter(Character digit) {
		return digitMap.get(digit);
	}
	
	public Character getLetter(int digit) {
		if(digit >= 10 || digit < 0) 
			throw new IllegalArgumentException("DIGIT MUSS ZWISCHEN 0 UND 9 (BEIDE INKULDIERT) SEIN.");
		return digitMap.get(Integer.toString(digit).charAt(0));
	}
	
	public int getDigit(Character letter) {
		return Character.getNumericValue(letterMap.get(letter));
	}
	
	public boolean isLetterRegistered(Character letter) {
		return letterMap.containsKey(letter);
	}
}
