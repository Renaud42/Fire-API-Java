package ga.firesoftwares.fireapi.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.List;

import ga.firesoftwares.fireapi.constants.Server;
import ga.firesoftwares.fireapi.enums.server.ServerInfoType;
import ga.firesoftwares.fireapi.enums.server.ServerName;
import ga.firesoftwares.fireapi.exceptions.NetworkUnavailableException;
import ga.firesoftwares.fireapi.exceptions.UnknownServerException;
import ga.firesoftwares.fireapi.exceptions.WrongServerInfoTypeException;
import ga.firesoftwares.fireapi.utils.serialization.json.JsonDeserializer;
import ga.firesoftwares.fireapi.utils.web.Requests;

/**
 * Make requests to Fire-API and get response with this class.
 * @author Renaud
 * @since 1.0
 * @version 1.1
 */
public class API {
	// Variables
	private String cachedcontent;
	
	// Constructor
	public API() {
		this("");
	}
	public API(String cachedcontent) {
		this.cachedcontent = cachedcontent;
	}
	
	// Functions and methods
	/**
	 * 
	 * @param name
	 * @param infotype
	 * @return
	 * @throws WrongServerInfoTypeException 
	 * @throws ParseException 
	 * @throws UnknownServerException 
	 * @throws NetworkUnavailableException 
	 * @throws IOException 
	 * @throws UnknownHostException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public Object getServerInformation(ServerName name, ServerInfoType infotype) throws UnknownHostException, IOException, NetworkUnavailableException, UnknownServerException, ParseException, WrongServerInfoTypeException, NoSuchFieldException, SecurityException {
		return getServerInformation(name, infotype, true);
	}
	/**
	 * 
	 * @param name
	 * @param infotype
	 * @param refreshfile
	 * @return
	 * @throws IOException 
	 * @throws UnknownHostException 
	 * @throws NetworkUnavailableException 
	 * @throws UnknownServerException 
	 * @throws ParseException 
	 * @throws WrongServerInfoTypeException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object getServerInformation(ServerName name, ServerInfoType infotype, boolean refreshfile) throws UnknownHostException, IOException, NetworkUnavailableException, UnknownServerException, ParseException, WrongServerInfoTypeException, NoSuchFieldException, SecurityException {
		// Pinging CloudFlare DNS server with 5 seconds of timeout to check if
		// network is available
		boolean ping = Requests.netIsAvailable(InetAddress.getByName("1.1.1.1"), 5000);
		
		// Getting required content on corresponding URL
		if (ping || (!ping && !refreshfile && cachedcontent != "")) {
			if ((!refreshfile && cachedcontent == "") || refreshfile) cachedcontent = Requests.getWebFileContent(getServerStatusURL(name));
						
			// JavaScript Object Notation Deserialization
			JsonDeserializer jd = new JsonDeserializer(cachedcontent);
			Object parsedJson = jd.parse();
			
			// Returning corresponding information as a Java JSON-equivalent type
			switch (name) {
			case FIRE_SOFTWARES:
			case FIRE_NETWORK:
				switch (infotype) {
				case CPU_LOAD_0:
					return ((List<String>)((LinkedHashMap)((LinkedHashMap) parsedJson).get("status")).get("cpu")).get(0);
				case CPU_LOAD_1:
					return ((List<String>)((LinkedHashMap)((LinkedHashMap) parsedJson).get("status")).get("cpu")).get(1);
				case CPU_LOAD_2:
					return ((List<String>)((LinkedHashMap)((LinkedHashMap) parsedJson).get("status")).get("cpu")).get(2);
				case DISK_MAX:
					return ((LinkedHashMap)((LinkedHashMap)((LinkedHashMap) parsedJson).get("status")).get("disk")).get("total");
				case DISK_PERCENT:
					return ((LinkedHashMap)((LinkedHashMap)((LinkedHashMap) parsedJson).get("status")).get("disk")).get("percent");
				case DISK_UNIT:
					return ((LinkedHashMap)((LinkedHashMap)((LinkedHashMap) parsedJson).get("status")).get("units")).get("disk");
				case DISK_USED:
					return ((LinkedHashMap)((LinkedHashMap)((LinkedHashMap) parsedJson).get("status")).get("disk")).get("used");
				case HOSTNAME:
					return (((LinkedHashMap)((LinkedHashMap) parsedJson).get("status")).get("hostname"));
				case ONLINE:
					return (((LinkedHashMap)((LinkedHashMap) parsedJson).get("status")).get("online"));
				case RAM_MAX:
					return ((LinkedHashMap)((LinkedHashMap)((LinkedHashMap) parsedJson).get("status")).get("ram")).get("total");
				case RAM_PERCENT:
					return ((LinkedHashMap)((LinkedHashMap)((LinkedHashMap) parsedJson).get("status")).get("ram")).get("percent");
				case RAM_UNIT:
					return ((LinkedHashMap)((LinkedHashMap)((LinkedHashMap) parsedJson).get("status")).get("units")).get("ram");
				case RAM_USED:
					return ((LinkedHashMap)((LinkedHashMap)((LinkedHashMap) parsedJson).get("status")).get("ram")).get("used");
				default:
					throw new WrongServerInfoTypeException(name, infotype);
				}
			case MUMBLE:
				switch (infotype) {
				case ONLINE:
					return ((LinkedHashMap)((LinkedHashMap) parsedJson).get("status")).get("online");
				case PLAYER_COUNT:
					return ((LinkedHashMap)((LinkedHashMap)((LinkedHashMap) parsedJson).get("status")).get("players")).get("online");
				default:
					throw new WrongServerInfoTypeException(name, infotype);
				}
			case MUMBLE_CVP:
				switch (infotype) {
				case CHANNELS:
					return ((LinkedHashMap)((LinkedHashMap) parsedJson).get("root")).get("channels");
				case MEMBERS_ONLINE:
					return ((LinkedHashMap) parsedJson).get("users");
				case MUMBLE_X_CONNECT_URL:
					return ((LinkedHashMap) parsedJson).get("x_connecturl");
				case SERVER_NAME:
					return ((LinkedHashMap) parsedJson).get("name");
				case UPTIME:
					return ((LinkedHashMap) parsedJson).get("uptime");
				default:
					throw new WrongServerInfoTypeException(name, infotype);
				}
			case DISCORD:
				switch(infotype) {
				case CHANNELS:
					return ((LinkedHashMap) parsedJson).get("channels");
				case DISCORD_ID:
					return ((LinkedHashMap) parsedJson).get("id");
				case MEMBERS:
					return ((LinkedHashMap) parsedJson).get("members");
				case SERVER_NAME:
					return ((LinkedHashMap) parsedJson).get("name");
				default:
					throw new WrongServerInfoTypeException(name, infotype);
				}
			case FRAMEWORK_STATUS:
			case API_STATUS:
				switch(infotype) {
				case ONLINE:
					return ((LinkedHashMap)((LinkedHashMap) parsedJson).get("informations")).get("online");
				case VERSION:
					return ((LinkedHashMap)((LinkedHashMap) parsedJson).get("informations")).get("version");
				default:
					throw new WrongServerInfoTypeException(name, infotype);
				}
			default:
				throw new UnknownServerException();
			}
		} // If there is no network available, there's a network unavailable exception
		else throw new NetworkUnavailableException();
	}
	
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
