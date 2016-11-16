package be.ehb.digx.refuel.data.source.remote;

import android.util.Log;

import com.firebase.client.annotations.NotNull;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import be.ehb.digx.refuel.RefuelApplicationConstants;
import be.ehb.digx.refuel.data.source.RefuelDataSourceException;
import be.ehb.digx.refuel.data.source.VehiclesDataSource;
import be.ehb.digx.refuel.domain.model.Vehicle;


/**
 * Created by richsoft on 06/11/2016.
 */

public class VehiclesRemoteDataSource implements VehiclesDataSource{

    private static VehiclesRemoteDataSource instance;
    private static ValueEventListener valueEventListener;
    private static final String TAG = "VehiclesRemoteDS";

    private VehiclesRemoteDataSource() {

    }
    //TODO make singleinstance threadsafe
    public static VehiclesRemoteDataSource getInstance(){
        if (instance == null){
            instance = new VehiclesRemoteDataSource();
        }
        return instance;
    }

    @Override
    public void getAllVehicles(@NotNull final VehiclesDataSource.VehilesCallback vehilesCallback) {
        Log.i(TAG, "getAllVehicles()");
        DatabaseReference vehicleReference = FirebaseDatabase.getInstance().getReference().child(RefuelApplicationConstants.FIREBASE_DATABASE_CHILD_VEHICLES);
        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Vehicle> vehiclesList = new ArrayList<>();
                Log.i(TAG, "getAllVehicles() - onDataChange()");
                for (DataSnapshot vehicleSnapshot:dataSnapshot.getChildren()){
                    Vehicle vehicle = vehicleSnapshot.getValue(Vehicle.class);
                    vehiclesList.add(vehicle);
                }
                vehilesCallback.onVehiclesLoaded(vehiclesList);
                vehiclesList.clear();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i(TAG, "getAllVehicles() - onCancelled() : "+databaseError.getMessage());
                RefuelDataSourceException refuelDataSourceException = new RefuelDataSourceException(databaseError.getMessage());
                vehilesCallback.onDataNotAvailable(refuelDataSourceException);
            }
        };
        vehicleReference.addValueEventListener (valueEventListener);
    }

    @Override
    public void getVehiclesForUserId(String userid, VehiclesForUserCallback vehiclesForUserCallback) {
        Log.i(TAG, "getVehiclesForUserId()");

    }

    @Override
    public void getVehiclesByTypeOfUse(String typeOfUSe, VehiclesByTypeOfUseCallback vehiclesByTypeOfUseCallback) {
        Log.i(TAG, "getVehiclesByTypeOfUse()");

    }

    @Override
    public void getVehicleDetail(String vehicleId, VehicleDetailCallback vehicleDetailCallback) {
        Log.i(TAG, "getVehicleDetail()");

    }


    @Override
    public void updateVehicleDetail(Vehicle vehicle) {
        Log.i(TAG, "updateVehicleDetail()");

    }

    @Override
    public void removeVehicleDetail(Vehicle vehicle) {
        Log.i(TAG, "removeVehicleDetail()");

    }

    public void removeVehicles() {
        Log.i(TAG, "removeVehicles()");

        DatabaseReference vehicleReference = FirebaseDatabase.getInstance().getReference().child(RefuelApplicationConstants.FIREBASE_DATABASE_CHILD_VEHICLES).child("JRG080");
        vehicleReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.v(TAG, "removeVehicles() - onChildAdded():"+s);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.v(TAG, "removeVehicles() - onChildChanged():"+s);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.v(TAG, "removeVehicles() - onChildRemoved()");
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                Log.v(TAG, "removeVehicles() - onCancelled(): "+s);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.v(TAG, "removeVehicles() - onChildMoved(): "+databaseError.getMessage());
            }
        });
        vehicleReference.removeValue();
    }


    @Override
    public void addVehicle(Vehicle vehicle) {
        Log.i(TAG, "addVehicle()");
        DatabaseReference vehicleReference = FirebaseDatabase.getInstance().getReference().child(RefuelApplicationConstants.FIREBASE_DATABASE_CHILD_VEHICLES).child(vehicle.getCarId());
        vehicleReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.v(TAG, "addVehicle() - onChildAdded():"+s);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.v(TAG, "addVehicle() - onChildChanged():"+s);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.v(TAG, "addVehicle() - onChildRemoved()");
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                Log.v(TAG, "addVehicle() - onCancelled(): "+s);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.v(TAG, "addVehicle() - onChildMoved(): "+databaseError.getMessage());
            }
        });
        vehicleReference.setValue(vehicle);
    }
}
