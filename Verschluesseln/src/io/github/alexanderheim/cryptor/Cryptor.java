package io.github.alexanderheim.cryptor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import io.github.alexanderheim.decryptor.Decryptor;
import io.github.alexanderheim.encryptor.Encryptor;

public class Cryptor {

	private File filePath;
	private Encryptor encryptor = new Encryptor("0");
	private Decryptor decryptor = new Decryptor();
	
	public Cryptor(File folder) {
		this.filePath = folder;
		filePath.mkdir();
		File encryptFile = new File(filePath, "encrypt.txt");
		File decryptFile = new File(filePath, "decrypt.txt");
		try {
			encryptFile.createNewFile();
			decryptFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void changeEncryptionKey(String key) {
		this.encryptor.changeKey(key);
	}
	
	public void writeEncryptedMessage(String message) {
		 try {
			FileWriter myWriter = new FileWriter(new File(filePath, "encrypt.txt"));
			myWriter.write(this.encryptor.encrypt(message));
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void decryptEncryptedMessageBruteForce() {
		try {
			FileReader myReader = new FileReader(new File(filePath, "encrypt.txt"));
			BufferedReader myBufferedReader = new BufferedReader(myReader);
			String encryptedMessage = myBufferedReader.readLine();
			ArrayList<ArrayList<String>> list = this.decryptor.bruteForce(encryptedMessage, 4);
			FileWriter myWriter = new FileWriter(new File(filePath, "decrypt.txt"));
			for(int i = 0; i < list.size(); i++) {
				myWriter.append("MESSAGE " + i + ": " + list.get(i).get(0) + "  -  " + "KEY: " + list.get(i).get(1) + "\n");
			}
			myWriter.close();
			myBufferedReader.close();
			myReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
			
}
