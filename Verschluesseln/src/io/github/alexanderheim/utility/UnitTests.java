package io.github.alexanderheim.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.github.alexanderheim.decryptor.Decryptor;
import io.github.alexanderheim.encryptor.Encryptor;

public class UnitTests {

	@Test
	public void testAddEncrypt0() {
		String input = "ABCDEFGHIJ";
		String key = "9876543210";
		String output = "JJJJJJJJJJ";
		
		Encryptor testEncryptor = new Encryptor(key);
		assertEquals(output, testEncryptor.encrypt(input));
		
	}
	
	@Test
	public void testAddEncrypt1() {
		String input = "AAABBBCCCDDDEFG";
		String key = "432";
		String output = "EDCFEDGFEHGFIII";
		
		Encryptor testEncryptor = new Encryptor(key);
		assertEquals(output, testEncryptor.encrypt(input));
		
	}
	
	@Test
	public void testAddEncrypt2() {
		String input = "A";
		String key = "98764234214";
		String output = "J";
		
		Encryptor testEncryptor = new Encryptor(key);
		assertEquals(output, testEncryptor.encrypt(input));
		
	}
	
	@Test
	public void testAddEncrypt3() {
		String input = "JJFG";
		String key = "9746";
		String output = "IGJC";
		
		Encryptor testEncryptor = new Encryptor(key);
		assertEquals(output, testEncryptor.encrypt(input));
		
	}
	
	@Test
	public void testAddEncrypt4() {
		String input = "AHFG";
		String key = "0";
		String output = "AHFG";
		
		Encryptor testEncryptor = new Encryptor(key);
		assertEquals(output, testEncryptor.encrypt(input));
		
	}
	
	@Test
	public void testAddEncrypt5() {
		String input = "/AbcdeXßß421G";
		String key = "562891";
		String output = "FHEBDH";
		
		Encryptor testEncryptor = new Encryptor(key);
		assertEquals(output, testEncryptor.encrypt(input));
		
	}
	
	@Test
	public void testAddDecrypt0() {
		String input = "BDF";
		String key = "123";
		String output = "ABC";
		
		Decryptor d = new Decryptor();
		assertEquals(output, d.decryptWithKey(input, key));
	}
	
	@Test
	public void testAddDecrypt1() {
		String input = "FJCCIBBBGBJCGHIH";
		String key = "5921378";
		String output = "AAABFEDGHJIJJJDI";
		
		Decryptor d = new Decryptor();
		assertEquals(output, d.decryptWithKey(input, key));
	}
	
	@Test
	public void testAddDecrypt2() {
		String input = "JJJJJJJJJJ";
		String key = "9876543210";
		String output = "ABCDEFGHIJ";
		
		Decryptor d = new Decryptor();
		assertEquals(output, d.decryptWithKey(input, key));
	}
	
	@Test
	public void testAddDecrypt3() {
		String input = "AFGHFGHFGHFG";
		String key = "0000000";
		String output = "AFGHFGHFGHFG";
		
		Decryptor d = new Decryptor();
		assertEquals(output, d.decryptWithKey(input, key));
	}
	
	@Test
	public void testAddDecrypt4() {
		String input = "FGHIJABCDE";
		String key = "555";
		String output = "ABCDEFGHIJ";
		
		Decryptor d = new Decryptor();
		assertEquals(output, d.decryptWithKey(input, key));
	}
}
