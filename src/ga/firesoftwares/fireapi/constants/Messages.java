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
	public final static String  CANT_RECOGNIZE_OPERATING_SYSTEM_EXCEPTION = "Can't recognize operating system !";
	/**
	 * Message returned by an {@link ga.firesoftwares.fireapi.exceptions.EncryptionException}
	 */
	public final static String ENCRYPTION_EXCEPTION = "Can't use Triple DES with this encryption algorithm.";
	/**
	 * Message returned by an {@link ga.firesoftwares.fireapi.exceptions.UnknownServerException}
	 */
	public static final String UNKNOWN_SERVER_EXCEPTION = "Unknown server name.";
}
