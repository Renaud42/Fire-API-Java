package ga.firesoftwares.fireapi.server;

import ga.firesoftwares.fireapi.constants.Server;
import ga.firesoftwares.fireapi.enums.server.ServerName;
import ga.firesoftwares.fireapi.exceptions.UnknownServerException;

/**
 * Make requests to Fire-API and get response with this class.
 * @author Renaud
 * @since 1.0
 * @version 1.1
 */
public class API {
	// Variables
	private String cachedcontent;
	
	// Functions and methods
	/**
	 * Get status URL corresponding to a server name
	 * @param name {@link name} to get status URL
	 * @return Status server URL
	 * @throws UnknownServerException Thrown when an unknown server is specified
	 */
	private String getServerStatusURL(ServerName name) throws UnknownServerException {
		switch (name) {
		case FIRE_SOFTWARES:
			return Server.STATUS_0;
		case FIRE_NETWORK:
			return Server.STATUS_1;
		case MUMBLE:
			return Server.STATUS_2;
		case MUMBLE_CVP:
			return Server.STATUS_MUMBLE_CVP;
		case API_STATUS:
			return Server.STATUS_API;
		case DISCORD:
			return Server.STATUS_DISCORD;
		case FRAMEWORK_STATUS:
			return Server.STATUS_FRAMEWORK;
		default:
			throw new UnknownServerException();
		}
	}
}
