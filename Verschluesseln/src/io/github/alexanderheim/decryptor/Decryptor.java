package io.github.alexanderheim.decryptor;

import java.util.ArrayList;

import io.github.alexanderheim.utility.CharMap;

public class Decryptor {

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
	
	public void bruteForce(String input) {
		bruteForce(input, input.length());
	}
	
	@SuppressWarnings("unused")
	public ArrayList<ArrayList<String>> bruteForce(String input, int maxKeyLength) {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		int count = 0;
		ForceKey forceKey = new ForceKey(maxKeyLength);
		String s = forceKey.getForceKey();
		boolean isEndKey = false;
		while(!isEndKey) {
			isEndKey = true;
			for(int i = 0; i < forceKey.maxKeyLength; i++) {
				if(forceKey.getArray()[i].getValue() != 9) isEndKey = false;
			}
			if(validate(decryptWithKey(input, forceKey.getForceKey()))) {
				count++;
				ArrayList<String> pair = new ArrayList<String>();
				pair.add(decryptWithKey(input, forceKey.getForceKey()));
				pair.add(forceKey.getForceKey());
				list.add(pair);
			}
			if(isEndKey == true) {
				break;
			}
			forceKey.nextKey();
			s = forceKey.getForceKey();
		}
		return list;
	}
	
	public String decryptWithKey(String message, String key) {
		int[] key_ = new int[key.length()];
		for(int i = 0; i < key_.length; i++) {
			key_[i] = Integer.parseInt(String.valueOf(key.charAt(i)));
		}
		StringBuilder messageDigit = mapLettersToDigits(message);
		StringBuilder output = new StringBuilder("");
		for(int i = 0; i < messageDigit.length(); i++) {
			int encrypted = Byte.parseByte((String.valueOf(messageDigit.charAt(i))));
			encrypted -= key_[i % key_.length];
			if(encrypted < 0) encrypted += 10;
			output.append(encrypted);
		}
		return mapDigitsToLetters(output).toString();
	}
	
	private StringBuilder mapLettersToDigits(String input_) {
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
	
	private boolean validate(String input) {
		return input.contains("AAA");
	}
}
