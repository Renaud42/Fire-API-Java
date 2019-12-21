package ga.firesoftwares.fireapi.exceptions;

import ga.firesoftwares.fireapi.constants.Messages;

/**
 * Represents an error which throws when trying to use network when unavailable
 * @author Renaud
 * @since 1.1
 * @version 1.1
 */
public class NetworkUnavailableException extends Exception {
	/**
	 * Serial version Unique Identifier
	 */
	private static final long serialVersionUID = 1008882962097715773L;

	// Constructor
	public NetworkUnavailableException() {
		super(Messages.NETWORK_UNAVAILABLE_EXCEPTION);
	}
}
