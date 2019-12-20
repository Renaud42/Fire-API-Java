package ga.firesoftwares.fireapi.utils.math;

/**
 * Computations algorithm are implemented in this class
 * @author Renaud
 * @since 1.1
 * @version 1.1
 */
public class Compute {	
	// -------------------------------------------
    // FUNCTIONS & METHODS
    // -------------------------------------------
	/** 
	 * Calculate Champernowne String with specified digits
	 * @param digits Number of digits to compute.
	 */
	public static String calculateChampernowneString(int digits) {
		String result = "";
		int x = 1;

		while (result.length() < digits)
			if (result.length() < digits) {
				int current = 0;
				
				while (current < (new Integer(x)).toString().length())
					if (result.length() == digits) current = (new Long(x)).toString().length();
					else {
						result += "" + (new Integer(x)).toString().substring(current, current + 1);
						current += 1;
					}

				x += 1;
			}

		return "0." + result;
	}
}
