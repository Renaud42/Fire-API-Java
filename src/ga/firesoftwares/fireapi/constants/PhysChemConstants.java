package ga.firesoftwares.fireapi.constants;

/**
 * Physics and chemical related constants
 * @author Renaud
 * @since 1.1
 * @version 1.1
 */
public class PhysChemConstants {
	// Constants
	/** 
	 * Avogadro's constant (unit/mol)
	 */
	public static final double AVOGADRO = 6.022140857 * Math.pow(10, 23);
	/** 
	 * Boltzmann constant (J/K)
	 */
	public static final double BOLTZMANN = 1.38066 * Math.pow(10, -23), kB = 1.38066 * Math.pow(10, -23);
	/** 
	 * Light speed constant (m/s)
	 */
	public static final double C = 2.99792458 * Math.pow(10, 8), LIGHT_SPEED = 2.99792458 * Math.pow(10, 8);
	/** 
	 * Gravitational force on Earth
	 */
	public static final double EARTH_GRAVITATIONAL_FORCE = 9.80665;
	/** 
	 * Elementary charge constant
	 */
	public static final double ELEMENTARY_CHARGE = 1.60219 * Math.pow(10, -19);
	/** 
	 * Faraday's constant (C/mol)
	 */
	public static final int FARADAY = 96484;
	/** 
	 * Gravitational constant (N × m² × kg-²)
	 */
	public static final double G = 6.672 * Math.pow(10, -11), GRAVITATIONAL_CONSTANT = 6.672 * Math.pow(10, -11);
	/** 
	 * Perfect gasses constant (J/(K/mol))
	 */
	public static final double PERFECT_GASSES = 8.3144;
	/** 
	 * Planck's constant (J × s)
	 */
	public static final double PLANCK = 6.62617;

	// Masses
	/** 
	 * Mass of an electron (kg)
	 */
	public static final double electronMass = 9.10953 * Math.pow(10, -31);
	/** 
	 * Mass of a neutron (kg)
	 */
	public static final double neutronMass = 1.675 * Math.pow(10, -27);
	/** 
	 * Mass of a proton (kg)
	 */
	public static final double protonMass = 1.673 * Math.pow(10, -27);
}
