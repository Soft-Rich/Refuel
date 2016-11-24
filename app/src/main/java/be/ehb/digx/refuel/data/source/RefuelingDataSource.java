package be.ehb.digx.refuel.data.source;

import be.ehb.digx.refuel.domain.model.Refueling;

/**
 * Created by richsoft on 06/11/2016.
 */

public interface RefuelingDataSource {

    public interface RefuelingAddedCallback {

        void onRefuelAddedSuccesfull();

        void onRefuelAddedFailed(RefuelDataSourceException refuelDataSourceException);
    }

    public void add(Refueling refueling, final RefuelingDataSource.RefuelingAddedCallback refuelingAddedCallback);

}
