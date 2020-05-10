package io.github.alexanderheim;

import java.io.File;

import io.github.alexanderheim.cryptor.Cryptor;
import io.github.alexanderheim.encryptor.Encryptor;

public class Main {

	public static void main(String args[]) {
		Encryptor e = new Encryptor("12345");
		System.out.println(e.encrypt("ABCDEFGHIJ"));
		
		Cryptor cryptor = new Cryptor(new File("C:\\Users\\Alex\\Desktop\\cryptor"));
		cryptor.changeEncryptionKey("1234");
		cryptor.writeEncryptedMessage("AAADEFGHIJ");
		cryptor.decryptEncryptedMessageBruteForce();
	}
}
