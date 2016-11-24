package be.ehb.digx.refuel.addeditrefueling.event;

import org.jetbrains.annotations.NotNull;

import be.ehb.digx.refuel.event.BaseInvalidEvent;

/**
 * Created by richsoft on 23/11/2016.
 */

public class InvalidMileAgeEvent extends BaseInvalidEvent {
    public InvalidMileAgeEvent(@NotNull String message) {
        super(message);
    }
}
