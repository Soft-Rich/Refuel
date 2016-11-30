package be.ehb.digx.refuel.data.source.remote;

import android.util.Log;

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
import be.ehb.digx.refuel.data.source.RefuelingDataSource;
import be.ehb.digx.refuel.domain.model.Refueling;
import be.ehb.digx.refuel.util.DateTime;

/**
 * Created by richsoft on 20/11/2016.
 */

public class RefuelingRemoteDataSource implements RefuelingDataSource {


    private static RefuelingRemoteDataSource instance;
    private static ValueEventListener valueEventListener;
    private static final String TAG = "RefuelingRemoteDS";
    private DatabaseReference databaseReference;

    private RefuelingRemoteDataSource() {

    }

    //TODO make singleinstance threadsafe
    public static RefuelingRemoteDataSource getInstance() {
        if (instance == null) {
            instance = new RefuelingRemoteDataSource();
        }
        return instance;
    }

    @Override
    public void add(Refueling refueling, final RefuelingDataSource.RefuelingAddedCallback refuelingAddedCallback) {
        Log.i(TAG, "add()");
        databaseReference = FirebaseDatabase.getInstance().getReference().child(RefuelApplicationConstants.FIREBASE_DATABASE_CHILD_REFUELS).child(refueling.getVehicleId()).child(String.valueOf(DateTime.getCurrentTimestamp()));
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.v(TAG, "add() - onChildAdded():" + s);
                refuelingAddedCallback.onRefuelAddedSuccesfull();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.v(TAG, "add() - onChildChanged():" + s);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.v(TAG, "add() - onChildRemoved()");
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                Log.v(TAG, "add() - onCancelled(): " + s);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "add() - onChildMoved(): " + databaseError.getMessage());
                refuelingAddedCallback.onRefuelAddedFailed(new RefuelDataSourceException(databaseError.getMessage()));
            }
        });
        databaseReference.setValue(refueling);
    }

    @Override
    public void getRefuelingsForVehicle(String vehicledId, final RefuelingsForVehicleCallback refuelingsForVehicleCallback) {
        Log.i(TAG, "getRefuelingsForVehicle(VehicleID " + vehicledId + ")");
        DatabaseReference vehicleReference = FirebaseDatabase.getInstance().getReference().child(RefuelApplicationConstants.FIREBASE_DATABASE_CHILD_REFUELS).child(vehicledId);
        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Refueling> refuelingList = new ArrayList<>();
                Log.i(TAG, "getRefuelingsForVehicle() - onDataChange()");
                Log.i(TAG, "dataSnapshot: " + dataSnapshot.toString());

                for (DataSnapshot refuelingSnapshot : dataSnapshot.getChildren()) {
                    Long id = 1L;
                    if (refuelingSnapshot != null && refuelingSnapshot.getKey() != null) {
                        id = Long.parseLong(refuelingSnapshot.getKey());
                    }
                    Refueling refueling = refuelingSnapshot.getValue(Refueling.class);
                    refueling.setId(id);
                    refuelingList.add(refueling);
                }
                refuelingsForVehicleCallback.onReceivedSuccesfull(refuelingList);
                refuelingList.clear();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i(TAG, "getRefuelingsForVehicle() - onCancelled() : " + databaseError.getMessage());
                RefuelDataSourceException refuelDataSourceException = new RefuelDataSourceException(databaseError.getMessage());
                refuelingsForVehicleCallback.onReceivedFailed(refuelDataSourceException);
            }
        };
        vehicleReference.addValueEventListener(valueEventListener);
    }
}
