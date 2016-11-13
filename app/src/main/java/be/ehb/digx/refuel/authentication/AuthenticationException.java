package be.ehb.digx.refuel.authentication;

/**
 * Created by richsoft on 13/11/2016.
 */

public class AuthenticationException extends Exception {

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
