package ga.firesoftwares.fireapi.exceptions;

import ga.firesoftwares.fireapi.constants.Messages;

/**
 * Represents an error which throws when trying to use a wrong {@link ga.firesoftwares.fireapi.enums.server.ServerName}
 * @author Renaud
 * @since 1.1
 * @version 1.1
 */
public class UnknownServerException extends Exception {
	/**
	 * Serial version Unique Identifier
	 */
	private static final long serialVersionUID = -6602368729787125586L;

	// Constructor
	public UnknownServerException() {
		super(Messages.UNKNOWN_SERVER_EXCEPTION);
	}
}
