package ga.firesoftwares.fireapi.exceptions;

import ga.firesoftwares.fireapi.constants.Messages;
import ga.firesoftwares.fireapi.enums.server.ServerInfoType;
import ga.firesoftwares.fireapi.enums.server.ServerName;

/**
 * Represents an error which throws when a wrong {@link ga.firesoftwares.fireapi.enums.server.ServerInfoType} is specified
 * @author Renaud
 * @since 1.1
 * @version 1.1
 */
public class WrongServerInfoTypeException extends Exception {
	/**
	 * Serial version Unique Identifier
	 */
	private static final long serialVersionUID = 8261668106647873189L;

	// Constructor
	public WrongServerInfoTypeException(ServerName name, ServerInfoType infotype) {
		super(Messages.WRONG_SERVER_INFO_TYPE_EXCEPTION.replace("%name%", name.toString()).replace("%info-type%", infotype.toString()));
	}
}
