package be.ehb.digx.refuel.data.source;

/**
 * Created by richsoft on 08/11/2016.
 */

public class RefuelDataSourceException extends Exception {

    public RefuelDataSourceException(String message) {
        super(message);
    }

    public RefuelDataSourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public RefuelDataSourceException(Throwable cause) {
        super(cause);
    }

    public RefuelDataSourceException() {
    }
}
