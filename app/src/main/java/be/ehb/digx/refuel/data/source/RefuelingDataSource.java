package be.ehb.digx.refuel.data.source;

import java.util.List;

import be.ehb.digx.refuel.domain.model.Refueling;

/**
 * Created by richsoft on 06/11/2016.
 */

public interface RefuelingDataSource {

    public interface RefuelingAddedCallback {

        void onRefuelAddedSuccesfull();

        void onRefuelAddedFailed(RefuelDataSourceException refuelDataSourceException);
    }

    public interface RefuelingsForVehicleCallback {

        void onReceivedSuccesfull(List<Refueling> refuelings);

        void onReceivedFailed(RefuelDataSourceException refuelDataSourceException);
    }


    public void add(Refueling refueling, final RefuelingDataSource.RefuelingAddedCallback refuelingAddedCallback);
    public void getRefuelingsForVehicle(String vehicledId, final RefuelingDataSource.RefuelingsForVehicleCallback refuelingsForVehicleCallback);

}
