package ga.firesoftwares.api.enums;

/** 
 * PiDB object.
 */
public enum PiDB {
	/**
	 * CableNewsNetwork (https://edition.cnn.com/2017/03/13/health/pi-digits-trnd/index.html), max = 10000 digits, protocol = HTTPS
	 */
	CABLE_NEWS_NETWORK,
	/**
	 * MIT (https://stuff.mit.edu/afs/sipb/contrib/pi/pi-billion.txt), max = 1000000000 digits, protocol = HTTPS
	 */
	MIT,
	/**
	 * Utah (https://www.math.utah.edu/~pa/math/pi.html), max = 9999 digits, protocol = HTTPS
	 */
	UTAH;
}
