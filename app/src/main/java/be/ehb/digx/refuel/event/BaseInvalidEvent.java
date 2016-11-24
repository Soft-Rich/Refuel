package be.ehb.digx.refuel.event;

import org.jetbrains.annotations.NotNull;

/**
 * Created by richsoft on 23/11/2016.
 */

public abstract class BaseInvalidEvent {

    private String message;

    public BaseInvalidEvent(@NotNull String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
