package io.github.alexanderheim.decryptor;

public class ForceKey {
	
	private ForceDigit[] forceKey;
	public int maxKeyLength;
	
	public ForceKey(int maxKeyLength) {
		this.maxKeyLength = maxKeyLength;
		this.forceKey  = new ForceDigit[maxKeyLength];
		for(int i = 0; i < maxKeyLength; i++) {
			this.forceKey[i] = new ForceDigit();
		}
	}
	
	public ForceDigit[] getArray() {
		return this.forceKey;
	}
	
	public void nextKey() {
		int currentDigit = 0;
		while(forceKey[currentDigit].addOne()) {
			currentDigit++;
		}
	}
	
	public String getForceKey() {
		StringBuilder sb = new StringBuilder("");
		for(int i = 0; i < forceKey.length; i++) {
			sb.append(forceKey[i].getValue());
		}
		return sb.toString();
	}

}
