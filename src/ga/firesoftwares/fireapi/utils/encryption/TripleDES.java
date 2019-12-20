package ga.firesoftwares.fireapi.utils.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import ga.firesoftwares.fireapi.enums.encryption.HashingAlgorithm;
import ga.firesoftwares.fireapi.exceptions.EncryptionException;

/**
 * Advanced custom integrated TripleDES class
 * @author Renaud
 * @since 1.1
 * @version 1.1
 */
public class TripleDES {
	/**
	 * Function to encrypt data
	 * @param plainText Text to encrypt
	 * @param key The password
	 * @param hashingAlgorithm The hashing algorithm
	 * @return Text encrypted
	 * @throws Exception Thrown when an error as occured while trying to encrypt specified data with specified key and specified encryption algorithm.
	 */
	public static String encryptData(String plainText, String key, HashingAlgorithm hashingAlgorithm) throws Exception {
		MessageDigest md = encryptionAlgorithmToMD(hashingAlgorithm);
		
		byte[] digestOfPassword = md.digest(key.getBytes("utf-8"));
		byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
		
		SecretKey secretKey = new SecretKeySpec(keyBytes, "DESede");
		
		Cipher cipher = Cipher.getInstance("DESede");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		
		byte[] plainTextBytes = plainText.getBytes("utf-8");
	    byte[] buf = cipher.doFinal(plainTextBytes);
	    byte[] base64Bytes = Base64.getEncoder().encode(buf);
	    
	    String base64EncryptedString = new String(base64Bytes);
	    
	    return base64EncryptedString;
	}

	/**
	 * Function to decrypt data
	 * @param encryptedText Hash to encrypt
	 * @param key The password
	 * @param hashingAlgorithm The hashing algorithm
	 * @return Text decrypted
	 * @throws Exception Thrown when an error as occured while trying to decrypt specified data with specified key and specified encryption algorithm.
	 */
	public static String decryptData(String encryptedText, String key, HashingAlgorithm hashingAlgorithm) throws Exception {
	    byte[] message = Base64.getDecoder().decode(encryptedText.getBytes("utf-8"));
	    
		MessageDigest md = encryptionAlgorithmToMD(hashingAlgorithm);
		
		byte[] digestOfPassword = md.digest(key.getBytes("utf-8"));
		byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
		
		SecretKey secretKey = new SecretKeySpec(keyBytes, "DESede");
		
		Cipher decipher = Cipher.getInstance("DESede");
		decipher.init(Cipher.DECRYPT_MODE, secretKey);
		
		byte[] plainText = decipher.doFinal(message);
		
		return new String(plainText, "UTF-8");
	}
	
	/**
	 * Turns an {@link HashingAlgorithm} to a MessageDigest object.
	 * @param hashingAlgorithm Hashing algorithm to turn HashingAlgorithm to
	 * @return MessageDigest Corresponding {@link MessageDigest} instance
	 * @throws NoSuchAlgorithmException Thrown when specified an invalid {@link HashingAlgorithm}
	 * @throws EncryptionException Thrown when specified an unknown {@link HashingAlgorithm}
	 */
	private static MessageDigest encryptionAlgorithmToMD(HashingAlgorithm hashingAlgorithm) throws NoSuchAlgorithmException, EncryptionException {
		// Return MessageDigest object corresponding to correct hashing algorithm
		switch (hashingAlgorithm) {
		case MD5:
			return MessageDigest.getInstance("MD5");
		case SHA1:
			return MessageDigest.getInstance("SHA-1");
		case SHA256:
			return MessageDigest.getInstance("SHA-256");
		case SHA384:
			return MessageDigest.getInstance("SHA-384");
		case SHA512:
			return MessageDigest.getInstance("SHA-512");
		default:
			throw new EncryptionException();
		}
	}
	
}
