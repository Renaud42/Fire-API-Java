package ga.firesoftwares.fireapi.exceptions;

import ga.firesoftwares.fireapi.constants.Messages;

/**
 * Represents an error which throws when the encryption algorithm is not supported
 * @author Renaud
 * @since 1.1
 * @version 1.1
 */
public class EncryptionException extends Exception {
	/**
	 * Serial version Unique Identifier
	 */
	private static final long serialVersionUID = 2260836082749051182L;
	
	// Constructor
	public EncryptionException() {
		super(Messages.ENCRYPTION_EXCEPTION);
	}
}
