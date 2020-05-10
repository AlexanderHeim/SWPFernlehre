package io.github.alexanderheim.decryptor;

public class ForceDigit {

	private int digit = 0;
	
	public int getValue() {
		return this.digit;
	}
	public boolean addOne() {
		this.digit++;
		if(this.digit >= 10) {
			this.digit = 0;
			return true;
		}
		return false;
	}
}
