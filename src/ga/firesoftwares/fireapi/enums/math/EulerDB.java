package ga.firesoftwares.fireapi.enums.math;

/**
 * e digits database enum
 * @author Renaud
 * @since 1.0
 * @version 1.1
 */
public enum EulerDB {
	/**
	 * MacTutorHistory ({@link http://www-history.mcs.st-and.ac.uk/HistTopics/e_10000.html})
	 * <br>
	 * - Maximum : 9999 digits
	 * <br>
	 * - Protocol : HTTP
	 */
	MacTutorHistory,
	/**
	 * NASA ({@link https://apod.nasa.gov/htmltest/gifcity/e.5mil})
	 * <br>
	 * - Maximum : 5000157 digits
	 * <br>
	 * - Protocol : HTTPS
	 */
	NASA,
	/**
	 * Utah ({@link https://www.math.utah.edu/~pa/math/e.html})
	 * <br>
	 * - Maximum : 9999 digits
	 * <br>
	 * - Protocol : HTTPS
	 */
	Utah;
}
