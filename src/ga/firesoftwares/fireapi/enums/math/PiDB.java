package ga.firesoftwares.fireapi.enums.math;

/**
 * π digits database enum
 * @author Renaud
 * @since 1.0
 * @version 1.1
 */
public enum PiDB {
	/**
	 * CableNewsNetwork ({@link https://edition.cnn.com/2017/03/13/health/pi-digits-trnd/index.html})
	 * <br>
	 * - Maximum : 10000 digits
	 * <br>
	 * - Protocol : HTTPS
	 */
    CableNewsNetwork,
	/**
	 * MIT ({@link https://stuff.mit.edu/afs/sipb/contrib/pi/pi-billion.txt})
	 * <br>
	 * - Maximum : 1000000000 digits
	 * <br>
	 * - Protocol : HTTPS
	 */
    MIT,
	/**
	 * Utah ({@link https://www.math.utah.edu/~pa/math/pi.html})
	 * <br>
	 * - Maximum : 9999 digits
	 * <br>
	 * - Protocol : HTTPS
	 */
    Utah;
}
