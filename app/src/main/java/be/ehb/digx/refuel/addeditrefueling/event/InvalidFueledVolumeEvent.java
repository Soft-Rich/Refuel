package be.ehb.digx.refuel.addeditrefueling.event;

import org.jetbrains.annotations.NotNull;

import be.ehb.digx.refuel.event.BaseInvalidEvent;

/**
 * Created by richsoft on 23/11/2016.
 */

public class InvalidFueledVolumeEvent extends BaseInvalidEvent {
    public InvalidFueledVolumeEvent(@NotNull String message) {
        super(message);
    }
}
