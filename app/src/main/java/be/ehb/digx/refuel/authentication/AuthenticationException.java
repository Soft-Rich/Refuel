package be.ehb.digx.refuel.authentication;

/**
 * Created by richsoft on 13/11/2016.
 */

/**
 * User defined exception class for exceptions during authentication
 */
public class AuthenticationException extends Exception {

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
