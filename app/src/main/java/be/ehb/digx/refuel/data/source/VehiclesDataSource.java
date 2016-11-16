package be.ehb.digx.refuel.data.source;

import com.firebase.client.annotations.NotNull;

import java.util.List;

import be.ehb.digx.refuel.domain.model.Vehicle;


/**
 * Created by richsoft on 06/11/2016.
 */

public interface VehiclesDataSource {

    public interface VehilesCallback {

        void onVehiclesLoaded(List<Vehicle> vehiclesList);

        void onDataNotAvailable(RefuelDataSourceException refuelDataSourceException);
    }

    public interface VehiclesForUserCallback{

        void onVehiclesLoaded(List<Vehicle> vehicle);

        void onDataNotAvailable(RefuelDataSourceException refuelDataSourceException);
    }

    public interface VehiclesByTypeOfUseCallback{

        void onVehiclesLoaded(List<Vehicle> vehicle);

        void onDataNotAvailable(RefuelDataSourceException refuelDataSourceException);
    }

    public interface VehicleDetailCallback{

        void onVehiclesLoaded(Vehicle vehicle);

        void onDataNotAvailable(RefuelDataSourceException refuelDataSourceException);
    }

    public void getAllVehicles(@NotNull VehilesCallback vehilesCallback);

    public void getVehiclesForUserId(String userid, VehiclesForUserCallback vehiclesForUserCallback);

    public void getVehiclesByTypeOfUse(String typeOfUSe, VehiclesByTypeOfUseCallback vehiclesByTypeOfUseCallback);

    public void getVehicleDetail(String vehicleId, VehicleDetailCallback vehicleDetailCallback);

    public void updateVehicleDetail(Vehicle vehicle);

    public void removeVehicleDetail(Vehicle vehicle);

    public void addVehicle(Vehicle vehicle);
}
