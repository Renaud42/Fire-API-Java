package ga.firesoftwares.api.math;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import ga.firesoftwares.api.Fire_API_ref;
import ga.firesoftwares.api.enums.EulerDB;
import ga.firesoftwares.api.enums.PiDB;

public class Constants {

    /***************************************************
    **                     BINARY                     **
    ***************************************************/
	
	// Constants
	/**
	 * Bit false, zero, no, low state
	 */
	public static final int BIT_False = 0, BIT_No = 0, BIT_Low = 0;
	/**
	 * Bit true, one, yes, high state
	 */
	public static final int BIT_True = 1, BIT_Yes = 1, BIT_High = 1;
	

    /***************************************************
    **                    FIRE-API                    **
    ***************************************************/

	// Constants
	/** 
	 * Link of the JavaScript Object Notation web file with the informations of the latest version of the Fire-API.
	 */
	public static final String API_InformationsFile = "https://api.fire-softwares.ga/api.json";
	/** 
	 * Current version of your API.
	 */
	public static final String API_Version = "1.0";

	/** 
	 * Name of the application.
	 */
	public static String API_ApplicationName = "";
	/** 
	 * Path of the application.
	 */
	public static String API_ApplicationPath = "";
	/** 
	 * Folder where API data are saved.
	 */
	public static String API_Folder;
	
	/** 
	 * JavaScript Object Notation file URL of the current status of the asked server.
	 */	
	public static final String JSON_MUMBLE = "https://panel.omgserv.com/json/180774/status", JSON_VPS = "https://panel.omgserv.com/json/180278/status";
	
	
    /***************************************************
    **                      HTTP                      **
    ***************************************************/
	
	// Constants
	// Informatives messages (1xx)
	/** 
	 * (1xx) Messages with a status line or an header followed by a CRLF line.
	 */
	public static final int HTTP_Continue = 100, HTTP_SwitchingProtocols = 101;
	
	// Success messages (2xx)
	/** 
	 * (2xx) Messages of successful request.
	 */
	public static final int HTTP_OK = 200, HTTP_Created = 201, HTTP_Accepted = 202, HTTP_NonAuthoritativeInformation = 203, HTTP_NoContent = 204, HTTP_ResetContent = 205, HTTP_PartialContent = 206;
	
	// Redirect messages (3xx)
	/** 
	 * (3xx) Messages with a message who say that we need to do something for finish the request.
	 */
	public static final int HTTP_MultipleChoices = 300, HTTP_MovedPermanently = 301, HTTP_MovedTemporarily = 302, HTTP_SeeOther = 303, HTTP_NotModified = 304, HTTP_UseProxy = 305;
	
	// Client errors messages (4xx)
	/** 
	 * (4xx) Error message (if you see this kind of message, run away from here).
	 */
	public static final int HTTP_BadRequest = 400, HTTP_Unauthorized = 401, HTTP_PaymentRequired = 402, HTTP_Forbidden = 403, HTTP_NotFound = 404, HTTP_MethodNotAllowed = 405, HTTP_NotAcceptable = 406, HTTP_ProxyAuthenticationRequired = 407, HTTP_RequestTimeOut = 408, HTTP_Conflict = 409, HTTP_Gone = 410, HTTP_LengthRequired = 411, HTTP_PreconditionFailed = 412, HTTP_RequestEntityTooLarge = 413, HTTP_RequestURITooLong = 414, HTTP_UnsupportedMediaType = 415, HTTP_RequestedRangeUnsatifiable = 416, HTTP_ExpectationFailed = 417, HTTP_TooManyRequests = 425, HTTP_TooManyRequests2 = 429;
	
	// Server errors messages (5xx)
	/** 
	 * (5xx) Server error messages.
	 */
	public static final int HTTP_InternalServerError = 500, HTTP_NotImplemented = 501, HTTP_BadGateway = 502, HTTP_ServiceUnavailable = 503, HTTP_GatewayTimeOut = 504, HTTP_HTTPVersionNotSupported = 505;
	
	// 1000 error messages (10xx)
	/** 
	 * (10xx) Error 1000 message.
	 */
	public static final int HTTP_1000Error = 1000;
	
	
	/***************************************************
    **                      MATH                      **
    ***************************************************/
	
	// Constants
	/** 
	 * Champernowne's constant.
	 */
	public static final BigDecimal champernowne = new BigDecimal(0.1234567891011121314151617182), C10 = new BigDecimal(0.1234567891011121314151617182);
	/** 
	 * Gold number constant.
	 */
	public static final double goldNumber = (1 + Math.sqrt(5)) / 2, godNumber = (1 + Math.sqrt(5)), goldSection = (1 + Math.sqrt(5));
	/** 
	 * π constant.
	 */
	public static final BigDecimal PI = new BigDecimal(3.1415926535897932384626433833);
	/** 
	 * Euler constant.
	 */
	public static final BigDecimal e = new BigDecimal(2.7182818284590452353602874714), euler = new BigDecimal(2.7182818284590452353602874714);
	
	// Stored PiDB
	private static String TempPiDB1, TempPiDB2, TempPiDB3;
	private static String PiDB1, PiDB2, PiDB3;

	// Stored EulerDB
	private static String TempEulerDB1, TempEulerDB2, TempEulerDB3;
	private static String EulerDB1, EulerDB2, EulerDB3;

	// Methods and functions
	
	/** 
	 * Initialize one of the π databases of the class before getting its numbers.
	 * 
	 * @param database Database to get numbers to
	 */
	public static void initialize(PiDB database) {
		initialize(database, false);
	}

	/** 
	 * Initialize one of the π databases of the class before getting its numbers.
	 * 
	 * @param database Database to get numbers to*
	 * @param networkCheck Check if an network connection is available else returns an {@link Exception} with message "Can't connect to the network."
	 * @throws Exception 
	 */
	public static void initialize(PiDB database, boolean networkCheck) {
		try {
			if(networkCheck) {
				InetAddress inetAddr = InetAddress.getByName("www.fire-softwares.ga");
				
				if(!Fire_API_ref.netIsAvailable(inetAddr, 5000)) {
					throw new Exception("Can't connect to the network.");
				}
			}
			
			Fire_API_ref.destroyTempJSON();
			
			String jsonPath = Constants.API_ApplicationPath + "temp.json";
			
			if(database == PiDB.CABLE_NEWS_NETWORK) {
				Fire_API_ref.downloadFile("https://edition.cnn.com/2017/03/13/health/pi-digits-trnd/index.html", jsonPath);
				
				TempPiDB1 = new String(Files.readAllBytes(Paths.get(jsonPath)), Charset.defaultCharset());
				PiDB1 = TempPiDB1;
				TempPiDB1 = "";
			}
			else if(database == PiDB.MIT) {
				Fire_API_ref.downloadFile("https://stuff.mit.edu/afs/sipb/contrib/pi/pi-billion.txt", jsonPath);
				
				TempPiDB2 = new String(Files.readAllBytes(Paths.get(jsonPath)), Charset.defaultCharset());
				PiDB2 = TempPiDB2;
				TempPiDB2 = "";
			}
			else if(database == PiDB.UTAH)	{
				Fire_API_ref.downloadFile("https://www.math.utah.edu/~pa/math/pi.html", jsonPath);
				
				TempPiDB3 = new String(Files.readAllBytes(Paths.get(jsonPath)), Charset.defaultCharset());
				PiDB3 = TempPiDB3;
				TempPiDB3 = "";
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/** 
	 * Initialize one of the Euler databases of the class before getting its numbers.
	 * 
	 * @param database Database to get numbers to
	 */
	public static void initialize(EulerDB database) {
		initialize(database, false);
	}

	/** 
	 * Initialize one of the Euler databases of the class before getting its numbers.
	 * 
	 * @param database Database to get numbers to
	 * @param networkCheck Check if an network connection is available else returns an {@link Exception} with message "Can't connect to the network."
	 */
	public static void initialize(EulerDB database, boolean networkCheck) {
		try {
			if(networkCheck) {
				InetAddress inetAddr = InetAddress.getByName("www.fire-softwares.ga");
				
				if(!Fire_API_ref.netIsAvailable(inetAddr, 5000)) {
					throw new Exception("Can't connect to the network.");
				}
			}
			
			Fire_API_ref.destroyTempJSON();
			
			String jsonPath = Constants.API_ApplicationPath + "temp.json";

			if(database == EulerDB.MAC_TUTOR_HISTORY) {
				Fire_API_ref.downloadFile("http://www-history.mcs.st-and.ac.uk/HistTopics/e_10000.html", jsonPath);
				
				TempEulerDB1 = new String(Files.readAllBytes(Paths.get(jsonPath)), Charset.defaultCharset());
				EulerDB1 = TempEulerDB1;
				TempEulerDB1 = "";
			}
			else if(database == EulerDB.NASA) {
				Fire_API_ref.downloadFile("https://apod.nasa.gov/htmltest/gifcity/e.5mil", jsonPath);
				
				TempEulerDB3 = new String(Files.readAllBytes(Paths.get(jsonPath)), Charset.defaultCharset());
				EulerDB3 = TempEulerDB3;
				TempEulerDB3 = "";
			}
			else if(database == EulerDB.UTAH) {
				Fire_API_ref.downloadFile("https://www.math.utah.edu/~pa/math/e.html", jsonPath);
				
				TempEulerDB2 = new String(Files.readAllBytes(Paths.get(jsonPath)), Charset.defaultCharset());
				EulerDB2 = TempEulerDB2;
				TempEulerDB2 = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 
	 * Initialize the class before getting numbers from database.
	 */
	public static void initializeAll() {
		initializeAll(false);
	}

	/** 
	 * Initialize the class before getting numbers from database.
	 * 
	 * @param networkCheck Check if an network connection is available else returns an {@link Exception} with message "Can't connect to the network."
	 */
	public static void initializeAll(boolean networkCheck) {
		if(networkCheck) {
			InetAddress inetAddr = null;
			
			try {
				inetAddr = InetAddress.getByName("www.fire-softwares.ga");
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			}
			
			if(!Fire_API_ref.netIsAvailable(inetAddr, 5000)) {
				try {
					throw new Exception("Can't connect to the network.");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				initializationWorker();
			}
		}
		else {
			initializationWorker();
		}
	}

	private static void initializationWorker() {
		try {
			// Euler's number databases initialisation
			initialize(EulerDB.MAC_TUTOR_HISTORY);
			initialize(EulerDB.NASA);
			initialize(EulerDB.UTAH);
			// π databases initialization
			initialize(PiDB.CABLE_NEWS_NETWORK);
			initialize(PiDB.MIT);
			initialize(PiDB.UTAH);
		} catch (Exception e) {
			throw e;
		}
	}
	
	/** 
	 * Calculate Champernowne String with specified digits.
	 *
	 * @param Digits Number of digits to compute.
	 */
	public static String calculateChampernowneString(long digits) {
		String result = "";
		long x = 1;

		while(result.length() < (int)digits) {
			if(result.length() < (int)digits) {
				int current = 0;
				
				while(current < (new Long(x)).toString().length()) {
					if(result.length() == (int)digits) {
						current = (new Long(x)).toString().length();
					} else {
						result += "" + (new Long(x)).toString().substring(current, current + 1);
						current += 1;
					}
				}

				x += 1;
			}
		}

		return "0." + result;
	}
	
	/** 
	 * Calculate π.
	 */
	public static double getPi() {
		return 4.0 * Math.atan(1.0); // Calculate the value of pi.
	}
	
	/** 
	 * Calculate Euler.
	 * 
	 * @param iterations Number of iterations
	 */
	public static double calculateEuler(long iterations) {
		double result = 1, f = 1;
        
        for(int i = 1; i <= iterations; i++) {
            f *= (1.0 / i);
            
            if(f == 0)
            	break;
            
            result += f;
        }

		// Example :  2 + 1/(1*2) + 1/(1*2*3) + 1/(1*2*3*4) etc..
		return result;
	}
	
	/** 
	 * Get Euler String from a database specified.
	 * WARNING : You need to do {@link Constants}{@code .Initialize()} before using this.
	 * @param digits
	 * @param database
	 */
	public static String getEulerFromDatabase(long digits, EulerDB database) {
		String data = "";

		if (digits == 0) {
			data = "2";
		}
		else if (digits < 0) {
			data = "" + (2 * Math.pow(10, digits));
		}
		else if (database == EulerDB.MAC_TUTOR_HISTORY) {
			data = parseUrl(EulerDB1, digits, 219);
		}
		else if (database == EulerDB.NASA) {
			data = parseUrl(EulerDB3, digits, 811);
		}
		else if (database == EulerDB.UTAH) {
			data = parseUrl(EulerDB2, digits, 594);
		}

		return data;
	}

	/** 
	 * Get π String from a database specified.
	 * WARNING : You need to do {@link Constants}{@code .Initialize()} before using this.
	 * @param digits
	 * @param database
	 */
	public static String getPiFromDatabase(long digits, PiDB database) {
		String data = "";

		if (digits == 0) {
			data = "2";
		}
		else if (digits < 0) {
			data = "" + (2 * Math.pow(10, digits));
		}
		else if (database == PiDB.CABLE_NEWS_NETWORK) {
			data = parseUrl(PiDB1, digits, 119308);
		}
		else if (database == PiDB.MIT) {
			data = parseUrl(PiDB2, digits, 0);
		}
		else if (database == PiDB.UTAH) {
			data = parseUrl(PiDB3, digits, 572);
		}

		return data;
	}

	/** 
	 * Internal method for parsing URLs for getting constants.
	 * 
	 * @param database {@link EulerDB} or {@link PiDB} {@link String} variable to initialize
	 * @param digits Length of the decimals of the number.
	 * @param index Index for the substring of the result.
	 */
	private static String parseUrl(String database, long digits, int index) {
		return database.replace(" ", "").replace(System.lineSeparator(), "").substring((int)index, (int)(2 + digits)); // Substring 2 because of the 2 first characters "2." of the String Euler10000 + the number of digits precised in this function.
	}

	/** 
	 * Get the X coordinate of the vertex of a second degree polynomial graphical parabola representation (-b divided by 2a with a ≠ 0).
	 * 
	 * @param a x² coefficient of the second degree polynomial
	 * @param b x coefficient of the second degree polynomial
	 */
	public static double secondDegreePolynomialParabolaVertexGetX(double a, double b) {
		return -b / (2 * a);
	}

	/** 
	 * Get the forbidden value of an homographic function (-d divided by c with c ≠ 0).
	 * This value will define the set of definitions of the homographic function on R \ {{@link HomographicForbiddenValue(Decimal, Decimal)} }.
	 * 
	 * @param c
	 * @param d
	 */
	public static double homographicForbiddenValue(double c, double d) {
		return -d / c;
	}
	
	
	/***************************************************
    **               PHYSICS & CHEMISTRY              **
    ***************************************************/
	
	// Constants
	/** 
	 * Avogadro's constant (unit/mol).
	 */
	public static final double Avogadro = 6.022140857 * Math.pow(10, 23);
	/** 
	 * Boltzmann constant (J/K).
	 */
	public static final double Boltzmann = 1.38066 * Math.pow(10, -23), kB = 1.38066 * Math.pow(10, -23);
	/** 
	 * Light speed constant (m/s).
	 */
	public static final double C = 2.99792458 * Math.pow(10, 8), lightSpeed = 2.99792458 * Math.pow(10, 8);
	/** 
	 * Gravitational force on Earth.
	 */
	public static final double earthGravitationalForce = 9.80665;
	/** 
	 * Elementary charge constant.
	 */
	public static final double elementaryCharge = 1.60219 * Math.pow(10, -19);
	/** 
	 * Faraday's constant (C/mol).
	 */
	public static final int Faraday = 96484;
	/** 
	 * Gravitational constant (N × m² × kg-²).
	 */
	public static final double G = 6.672 * Math.pow(10, -11), gravitationalConstant = 6.672 * Math.pow(10, -11);
	/** 
	 * Perfect gasses constant (J/(K/mol)).
	 */
	public static final double perfectGasses = 8.3144;
	/** 
	 * Planck's constant (J × s)
	 */
	public static final double Planck = 6.62617;

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
