package ga.firesoftwares.api.objects;

import ga.firesoftwares.api.enums.TempTypes;

/**
 * This object is for define properties for a temp file/folder.
 * @author Renaud
 *
 */
public class TempObject {
	
	// Variables
	private TempTypes tt;
	private String tn;
	private String td;


	// TempObject constructor.
	/**
	 * This object is for define properties for a temp file/folder.
	 * @param TempType
	 * @param TempName
	 * @param TempDir
	 * @author Renaud
	 */
	public TempObject(TempTypes tempType, String tempName, String tempDir) {
		tt = tempType;
		tn = tempName;
		td = tempDir;
	}

	// Getters and setters
	public final TempTypes getTempType() {
		return tt;
	}
	public final void setTempType(TempTypes value) {
		tt = value;
	}
	public final String getTempName() {
		return tn;
	}
	public final void setTempName(String value) {
		tn = value;
	}
	public final String getTempDir() {
		return td;
	}
	public final void setTempDir(String value) {
		td = value;
	}
	public final TempObject getTempObj() {
		return this;
	}
	public final void setTempObj(TempObject value) {
		tt = value.getTempType();
		tn = value.getTempName();
		td = value.getTempDir();
	}

}
