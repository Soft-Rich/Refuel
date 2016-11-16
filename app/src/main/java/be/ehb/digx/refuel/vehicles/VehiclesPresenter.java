package be.ehb.digx.refuel.vehicles;

import java.util.List;

import be.ehb.digx.refuel.data.source.RefuelDataSourceException;
import be.ehb.digx.refuel.data.source.VehiclesDataSource;
import be.ehb.digx.refuel.data.source.remote.VehiclesRemoteDataSource;
import be.ehb.digx.refuel.domain.model.Vehicle;

/**
 * Created by richsoft on 15/11/2016.
 */

public class VehiclesPresenter implements VehiclesContract.Presenter, VehiclesDataSource.VehilesCallback{

    private VehiclesContract.View view;

    public VehiclesPresenter(VehiclesContract.View view) {
        this.view = view;
    }

    @Override
    public void getVehicles() {
        VehiclesRemoteDataSource.getInstance().getAllVehicles(this);
    }

    @Override
    public void start() {
        getVehicles();
    }

    @Override
    public void onVehiclesLoaded(List<Vehicle> vehiclesList) {
        view.showVehicles(vehiclesList);

    }

    @Override
    public void onDataNotAvailable(RefuelDataSourceException refuelDataSourceException) {

    }
}
