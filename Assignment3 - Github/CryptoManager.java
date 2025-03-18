/*
 * Class: CMSC203
 * Instructor: Prof. Monshi
 * Description: This class has methods that are used for encryption and decryption
 * Due: 3/14/2025
 * Platform/compiler: IntelliJ IDEA
 * I pledge that I have completed the programming  assignment independently.
 *  I have not copied the code from a student or any source.
 *  I have not given my code to any student.
 *  Print your Name here: Christopher Andrews
 */
/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 *
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
@SuppressWarnings("LossyEncoding")
public class CryptoManager {

	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText){

		boolean inBounds = false;
		//if the characters in the plainText are within the Lower and Upper ranger it will return true
		for(int i=0; i < plainText.length(); i++){
			if(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE){
				inBounds = true;
			}else{
				inBounds= false;
				break;
			}
		}
		return inBounds;
	}
	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption (String plainText, int key){

		//Checks if string is inRange
		if(!isStringInBounds(plainText)){
			return ("The selected string is not in bounds, Try again.");
		}

		//Empty string for offset characters
		String encryption = "";

		//Offsets plainText
		for(int i=0; i < plainText.length(); i++) {
			char character = plainText.charAt(i);
			int ascii = character;

			ascii += key;

			//Wraps ascii value if it is out of range
			if(ascii > UPPER_RANGE){
				while (ascii > UPPER_RANGE) {
					ascii -= RANGE;
				}
			}else if(ascii < LOWER_RANGE) {
				while (ascii < LOWER_RANGE) {
					ascii += RANGE;
				}
			}
			//Adds char that coresponds to ascii value, to the string
			encryption += (char)ascii;
		}

		return encryption;
	}
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr){
		//Checks that plainText is in range
		if(!isStringInBounds(plainText)){
			return ("The selected string is not in bounds, Try again.");
		}

		//Empty string for offset characters
		String encryption = "";

		//This will extend the length of the key to match the length of the string
		for(int i = 0; bellasoStr.length() < plainText.length();i++){
			bellasoStr += bellasoStr.charAt(i);
		}

		//Offsets plainText by string
		for(int i=0; i < plainText.length(); i++) {

			int ascii = plainText.charAt(i);
			int offset = bellasoStr.charAt(i);

			int encryptedChar = ascii + offset;

			//Wraps ascii value if it is out of range
			if (encryptedChar > UPPER_RANGE) {
				while (encryptedChar > UPPER_RANGE) {
					encryptedChar -= RANGE;
				}
			}else if (encryptedChar < LOWER_RANGE) {
				while (encryptedChar < LOWER_RANGE) {
					encryptedChar += RANGE;
				}
			}

			encryption += (char) encryptedChar;
		}
		return encryption;
	}
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {

		//Empty string that Decrypted chars will be added to
		String decryption = "";

		//Decrypts plainText
		for (int c = 0; c < encryptedText.length(); c++) {
			char character = encryptedText.charAt(c);
			int ascii = character;

			ascii -= key;

			//Wraps ascii value if it is out of range
			if (ascii > UPPER_RANGE) {
				while (ascii > UPPER_RANGE) {
					ascii -= RANGE;
				}
			} else if (ascii < LOWER_RANGE) {
				while (ascii < LOWER_RANGE) {
					ascii += RANGE;
				}
			}

			decryption += (char) ascii;
		}

		//Adds char that corresponds to ascii value, to the string
		return decryption;
	}

	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {

		//Empty string for offset characters
		String decryption = "";

		//This will extend the length of the key to match the length of the string
		for(int i = 0; bellasoStr.length() < encryptedText.length(); i++ ){
			bellasoStr += bellasoStr.charAt(i);
		}

		//Decrypts text using String
		for(int i=0; i < encryptedText.length(); i++) {

			int ascii = encryptedText.charAt(i);
			int offset = bellasoStr.charAt(i);

			int decryptedChar = ascii - offset;

			//Wraps ascii value if it is out of range
			if (decryptedChar > UPPER_RANGE) {
				while (decryptedChar > UPPER_RANGE) {
					decryptedChar -= RANGE;
				}
			}else if (decryptedChar < LOWER_RANGE) {
				while (decryptedChar < LOWER_RANGE) {
					decryptedChar += RANGE;
				}
			}

			decryption += (char) decryptedChar;

		}

		return decryption;
	}
}