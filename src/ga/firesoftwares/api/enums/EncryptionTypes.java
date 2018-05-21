package ga.firesoftwares.api.enums;

/**
 * Types of File TempObject encryption.
 * @author Renaud
 *
 */
public enum EncryptionTypes {
	/**
	 * Encrypts only file content.
	 */
	FILE_CONTENT,
	/**
	 * Encrypts only file name.
	 */
	FILE_NAME,
	/**
	 * Encrypts complete file (name + content).
	 */
	BOTH;
}
