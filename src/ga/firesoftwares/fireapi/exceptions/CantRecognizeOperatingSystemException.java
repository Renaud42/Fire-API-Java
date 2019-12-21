package ga.firesoftwares.fireapi.exceptions;

import ga.firesoftwares.fireapi.constants.Messages;

/**
 * Represents an error when can't recognize OS
 * @author Renaud
 * @since 1.1
 * @version 1.1
 */
public class CantRecognizeOperatingSystemException extends Exception {
	/**
	 * Serial version Unique Identifier
	 */
	private static final long serialVersionUID = 6065328917575875052L;
	
	// Constructor
	public CantRecognizeOperatingSystemException() {
		super(Messages.CANT_RECOGNIZE_OPERATING_SYSTEM_EXCEPTION);
	}
}
