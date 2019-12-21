package ga.firesoftwares.fireapi.utils.serialization.json.interfaces;

import java.io.IOException;
import java.text.ParseException;

/**
 * Interface for JSON decoding operation
 * @author Renaud
 */
public interface IJsonDecodingOperation {
	/**
	 * Parse function
	 * @return Parsed JSON as Object
	 * @throws IOException Thrown when file not found
	 * @throws ParseException Thrown when there's an error when parsing file
	 */
	public Object parse() throws IOException, ParseException;
}
