package ga.firesoftwares.api.enums;

/** 
 TempTypes enum.
*/
public enum TempTypes {
	// Enumerate TempObject types
	
	/**
	 * Folder TempType.
	 */
	FOLDER,
	/**
	 * File TempType.
	 */
	FILE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static TempTypes forValue(int value)
	{
		return values()[value];
	}
}
