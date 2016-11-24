package be.ehb.digx.refuel.addeditrefueling;

/**
 * Created by richsoft on 20/11/2016.
 */

public class AddEditRefuelException extends Exception {

    public AddEditRefuelException(String message) {
        super(message);
    }

    public AddEditRefuelException(Throwable cause) {
        super(cause);
    }
    public AddEditRefuelException(String message, Throwable cause) {
        super(message, cause);
    }
}
