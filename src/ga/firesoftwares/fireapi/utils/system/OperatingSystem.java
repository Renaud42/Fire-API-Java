package ga.firesoftwares.fireapi.utils.system;

import ga.firesoftwares.fireapi.enums.system.OS;

/**
 * Operating System utils
 * @author Renaud
 * @since 1.0
 * @version 1.1
 */
public class OperatingSystem {
	/**
	 * Detect operating system
	 * @param os OS String
	 * @return OS The OS
	 * @throws Exception Thrown when can't recognize operating system.
	 */
	public static OS detectOS(String os) throws Exception {
		String lcOS = os.toLowerCase();
		// Return the operating system based on the String who is given in parameters.
		if (lcOS.contains("win"))
			return OS.WINDOWS;
		else if (lcOS.contains("mac"))
			return OS.MACINTOSH;
		else if (lcOS.contains("sun") || lcOS.contains("sola"))
			return OS.SOLARIS;
		else if (lcOS.contains("ix") || lcOS.contains("nux") || lcOS.contains("hp-"))
			return OS.UNIX;
		else
			throw new Exception("Can't recognize operating system !");
	}
}
