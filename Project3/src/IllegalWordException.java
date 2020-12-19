/**
 * Create IllegalWordException class to pass argument exceptions for invalid words
 * @author Alexandra Ali
 * @since 11.20. 2020
 * @version 1.0
 * @throws IllegalWordException
 * @returns IllegalWordException for words
 */

public class IllegalWordException extends IllegalArgumentException{
    /**
     * Passes message of invalid word
     * @param message
     */
    public IllegalWordException(String message) {
        super (message);
    }

}
