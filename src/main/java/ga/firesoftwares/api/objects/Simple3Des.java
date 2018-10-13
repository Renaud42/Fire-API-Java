package ga.firesoftwares.api.objects;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import ga.firesoftwares.api.enums.EncryptionAlgorithms;

/**
 * Advanced custom integrated Simple TripleDES class.
 * @author Renaud
 *
 */
public class Simple3Des {
	
	/**
	 * Function to encrypt data.
	 * @param plainText
	 * @param key
	 * @param enc
	 * @return String
	 * @throws Exception Throwed when an error as occured while trying to encrypt specified data with specified key and specified encryption algorithm.
	 */
	public static String encryptData(String plainText, String key, EncryptionAlgorithms enc) throws Exception {
		MessageDigest md = encryptionAlgorithmToMD(enc);
		
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
	 * Function to decrypt data.
	 * @param encryptedText
	 * @param key
	 * @param enc
	 * @return String
	 * @throws Exception Throwed when an error as occured while trying to decrypt specified data with specified key and specified encryption algorithm.
	 */
	public static String decryptData(String encryptedText, String key, EncryptionAlgorithms enc) throws Exception {
	    byte[] message = Base64.getDecoder().decode(encryptedText.getBytes("utf-8"));
	    
		MessageDigest md = encryptionAlgorithmToMD(enc);
		
		byte[] digestOfPassword = md.digest(key.getBytes("utf-8"));
		byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
		
		SecretKey secretKey = new SecretKeySpec(keyBytes, "DESede");
		
		Cipher decipher = Cipher.getInstance("DESede");
		decipher.init(Cipher.DECRYPT_MODE, secretKey);
		
		byte[] plainText = decipher.doFinal(message);
		
		return new String(plainText, "UTF-8");
	}
	
	/**
	 * Turns an EncryptionAlgorithm to a MessageDigest object.
	 * @param enc
	 * @return MessageDigest
	 * @throws NoSuchAlgorithmException Throwed when specified an unknown EncryptionAlgorithm.
	 */
	private static MessageDigest encryptionAlgorithmToMD(EncryptionAlgorithms enc) throws NoSuchAlgorithmException {
		// Return MessageDigest object corresponding to the specified EncryptionAlgorithm.
		switch (enc) {
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
			throw new NoSuchAlgorithmException();
		}
	}
	
}
