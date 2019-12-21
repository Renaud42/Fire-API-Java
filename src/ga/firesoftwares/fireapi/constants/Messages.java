package ga.firesoftwares.fireapi.constants;

/**
 * All Fire-API messages
 * @author Renaud
 * @since 1.1
 * @version 1.1
 */
public class Messages {
    // -------------------------------------------
    // EXCEPTIONS
    // -------------------------------------------
	/**
	 * Message returned by an {@link ga.firesoftwares.fireapi.exceptions.CantRecognizeOperatingSystemException}
	 */
	public static final String CANT_RECOGNIZE_OPERATING_SYSTEM_EXCEPTION = "Can't recognize operating system !";
	/**
	 * Message returned by an {@link ga.firesoftwares.fireapi.exceptions.EncryptionException}
	 */
	public static final String ENCRYPTION_EXCEPTION = "Can't use Triple DES with this encryption algorithm.";
	/**
	 * Messare returned by a {@link ga.firesoftwares.fireapi.utils.serialization.json.JsonDeserializer} custom {@link java.text.ParseException} (function {@link ga.firesoftwares.fireapi.utils.serialization.json.JsonDeserializer.expected(String expected)})
	 */
	public static final String JSON_EXPECTED = "Expected ";
	/**
	 * Messare returned by a {@link ga.firesoftwares.fireapi.utils.serialization.json.JsonDeserializer} custom {@link java.text.ParseException} (function {@link ga.firesoftwares.fireapi.utils.serialization.json.JsonDeserializer.expected(String expected)})
	 */
	public static final String JSON_UNEXPECTED_CHARACTER = "Unexpected character";
	/**
	 * Messare returned by a {@link ga.firesoftwares.fireapi.utils.serialization.json.JsonDeserializer} custom {@link java.text.ParseException} (function {@link ga.firesoftwares.fireapi.utils.serialization.json.JsonDeserializer.expected(String expected)})
	 */
	public static final String JSON_UNEXPECTED_EOI = "Unexpected end of input";
	/**
	 * Message returned by an {@link ga.firesoftwares.fireapi.exceptions.NetworkUnavailableException}
	 */
	public static final String NETWORK_UNAVAILABLE_EXCEPTION = "Network unavailable";
	/**
	 * Message returned by an {@link ga.firesoftwares.fireapi.exceptions.UnknownServerException}
	 */
	public static final String UNKNOWN_SERVER_EXCEPTION = "Unknown server name.";
    /**
     * Message returned when can't check for updates
     */
	public static final String UPDATE_CHECK_EXCEPTION = "Can't check for updates :";
	/**
	 * Message returned by an {@link ga.firesoftwares.fireapi.exceptions.WrongServerInfoTypeException}
	 */
	public static final String WRONG_SERVER_INFO_TYPE_EXCEPTION = "Wrong server info type \"%info-type%\" specified for \"%name%\" server.";
	
    // -------------------------------------------
    // PREFIXES
    // -------------------------------------------
    /**
     * Fire-API logs regular prefix
     */
	public static final String API_PREFIX = "[Fire-API]";
    /**
     * Fire-API logs error prefix
     */
	public static final String API_ERROR_PREFIX = "[Fire-API Error]";
    /**
     * Fire-API logs warning prefix
     */
	public static final String API_WARNING_PREFIX = "[Fire-API Warning]";
	
	// -------------------------------------------
    // SUCCESS
    // -------------------------------------------
	/**
	 * Message shown when Fire-API is successfully loaded with main class initilization
	 */
	public static final String API_HELLO = "Fire-API version %api-version% by Fire-Softwares successfully loaded !";
    /**
     * Message shown when your Fire-API version is the lastest stable
     */
	public static final String API_UP_TO_DATE = "You're running the lastest version of Fire-API (%api-version%), nice !";
	
	// -------------------------------------------
    // WARNINGS
    // -------------------------------------------
    /**
     * Message shown when a Fire-API Beta is used
     */
	public static final String API_BETA = "Warning : you are using a beta / unstable build of Fire-API (%api-version%). If you don't know why you see this warning, go back to lastest stable version (%lastest-stable%) on %api-update-page%. Or else you're in the future of Fire-API 8)";
    /**
     * Message shown when a Fire-API update is available
     */
	public static final String API_UPDATE_AVAILABLE = "New update available : Fire-API version %new-version%. You can get the update here : %api-update-page%";
}
