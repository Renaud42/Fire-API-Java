package ga.firesoftwares.fireapi.objects;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import ga.firesoftwares.fireapi.enums.encryption.EncryptionType;
import ga.firesoftwares.fireapi.enums.encryption.HashingAlgorithm;
import ga.firesoftwares.fireapi.utils.encryption.TripleDES;

/**
 * {@link ExtraFile} class defines extra-functions for files/directorys
 * @author Renaud
 * @since 1.1
 * @version 1.1
 */
public class ExtraFile {
	/**
	 * Encrypt a file
	 * <br><br>
	 *  WARNING : The encryption works with {@link TripleDES} combined with the {@link HashingAlgorithm} that you choose.
     * <br>
     *  When encrypt a file name with this method, the "/" characters of the hash will be automatically replaced with ",", and "\" with ";" because Windows doesn't accept file names with "/".
	 * @param filePath Path to the file
	 * @param hashingAlgorithm Hashing algorithm used to encrypt file
	 * @param encType Encryption type used (file content, file name, both)
	 * @param password TripleDES encryption password
	 * @throws Exception Thrown when file isn't found
	 */
	public static void encryptFileWithTripleDES(String filePath, HashingAlgorithm hashingAlgorithm, EncryptionType encType, String password) throws Exception {
		if (Files.exists(Paths.get(filePath)))
			if (encType == EncryptionType.FILE_CONTENT) {
				String listToString = "";
				
				// Getting file lines
				List<String> lines = Files.readAllLines(Paths.get(filePath));
				
				// Converting List<String> to formatted String
				for (String line : lines)
					listToString.concat(System.lineSeparator() + line);
				
				// Encrypting file content
				String encryptedText = TripleDES.encryptData(listToString, password, hashingAlgorithm);
				
				// We edit the file with the encrypted text of the wrapper of the selected algorithm
				BufferedWriter out = new BufferedWriter(new FileWriter(filePath), encryptedText.length() + 8);
				out.write(encryptedText);
				out.close();
			} else if (encType == EncryptionType.FILE_NAME) {
				// Encrypting file content
				String encryptedText = TripleDES.encryptData(Paths.get(filePath).getFileName().toString(), password, hashingAlgorithm).replace("/", ",").replace("\\", ";");
				
				// Renaming file
				Files.move(Paths.get(filePath), Paths.get(filePath).resolveSibling(encryptedText));
			} else {
				encryptFileWithTripleDES(filePath, hashingAlgorithm, EncryptionType.FILE_CONTENT, password);
				encryptFileWithTripleDES(filePath, hashingAlgorithm, EncryptionType.FILE_NAME, password);
			}
		else throw new FileNotFoundException();
	}
	
	/**
	 * Decrypt a file
	 * <br><br>
	 *  WARNING : The encryption works with {@link TripleDES} combined with the {@link HashingAlgorithm} that you choose.
     * <br>
     *  When decrypt a file name with this method, the "," characters of the hash will be automatically restored with "/", and ";" with "\" because Windows doesn't accept file names with "/".
	 * @param filePath Path to the file
	 * @param hashingAlgorithm Hashing algorithm used to encrypt file
	 * @param encType Encryption type used (file content, file name, both)
	 * @param password TripleDES encryption password
	 * @throws Exception Thrown when file isn't found
	 */
	public static void decryptFileWithTripleDES(String filePath, HashingAlgorithm hashingAlgorithm, EncryptionType encType, String password) throws Exception {
		if (Files.exists(Paths.get(filePath)))
			if (encType == EncryptionType.FILE_CONTENT) {
				String listToString = "";
				
				// Getting file lines
				List<String> lines = Files.readAllLines(Paths.get(filePath));
				
				// Converting List<String> to formatted String
				for (String line : lines)
					listToString.concat(System.lineSeparator() + line);
				
				// Decrypting file content
				String decryptedText = TripleDES.decryptData(listToString, password, hashingAlgorithm);
				
				// We edit the file with the encrypted text of the wrapper of the selected algorithm
				BufferedWriter out = new BufferedWriter(new FileWriter(filePath), decryptedText.length() + 8);
				out.write(decryptedText);
				out.close();
			} else if (encType == EncryptionType.FILE_NAME) {
				// Encrypting file content
				String decryptedText = TripleDES.decryptData(Paths.get(filePath).getFileName().toString().replace(",", "/").replace(";", "\\"), password, hashingAlgorithm);
				
				// Renaming file
				Files.move(Paths.get(filePath), Paths.get(filePath).resolveSibling(decryptedText));
			} else {
				decryptFileWithTripleDES(filePath, hashingAlgorithm, EncryptionType.FILE_CONTENT, password);
				decryptFileWithTripleDES(filePath, hashingAlgorithm, EncryptionType.FILE_NAME, password);
			}
		else throw new FileNotFoundException();
	}
}
