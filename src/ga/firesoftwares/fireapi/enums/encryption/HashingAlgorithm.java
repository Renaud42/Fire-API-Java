package ga.firesoftwares.fireapi.enums.encryption;

/**
 * Cryptographic hash algorithms
 * @author Renaud
 * @since 1.1
 * @version 1.1
 */
public enum HashingAlgorithm {	
	/**
	 * Message Digest 5
	 * <br><br>
	 * - 128-bit output
	 * <br>
	 * - 64 rounds
	 */
	MD5,
	/**
	 * Secure Hash Algorithm
	 * <br><br>
	 * - 160-bit output
	 * <br>
	 * - 80 rounds
	 */
	SHA1,
	/**
	 * Secure Hash Algorithm 256-bit
	 * <br><br>
	 * - 256-bit output
	 * <br>
	 * - 64 rounds
	 */
	SHA256,
	/**
	 * SHA384 : Secure Hash Algorithm 384-bit
	 * <br><br>
	 * - 384-bit output
	 * <br>
	 * - 80 rounds
	 */
	SHA384,
	/**
	 * SHA512 : Secure Hash Algorithm 512-bit
	 * <br><br>
	 * - 512-bit output
	 * <br>
	 * - 80 rounds
	 */
	SHA512;
}
