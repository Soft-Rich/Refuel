package be.ehb.digx.refuel.data.source.remote;

import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import be.ehb.digx.refuel.RefuelApplicationConstants;
import be.ehb.digx.refuel.data.source.RefuelDataSourceException;
import be.ehb.digx.refuel.data.source.RefuelingDataSource;
import be.ehb.digx.refuel.domain.model.Refueling;

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
    public static RefuelingRemoteDataSource getInstance(){
        if (instance == null){
            instance = new RefuelingRemoteDataSource();
        }
        return instance;
    }
    @Override
    public void add(Refueling refueling, final RefuelingDataSource.RefuelingAddedCallback refuelingAddedCallback) {
        Log.i(TAG, "add()");
        databaseReference = FirebaseDatabase.getInstance().getReference().child(RefuelApplicationConstants.FIREBASE_DATABASE_CHILD_REFUELS).child(refueling.getVehicleId()).child(String.valueOf(refueling.getTimestamp()));
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.v(TAG, "add() - onChildAdded():"+s);
                refuelingAddedCallback.onRefuelAddedSuccesfull();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.v(TAG, "add() - onChildChanged():"+s);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.v(TAG, "add() - onChildRemoved()");
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                Log.v(TAG, "add() - onCancelled(): "+s);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "add() - onChildMoved(): "+databaseError.getMessage());
                refuelingAddedCallback.onRefuelAddedFailed(new RefuelDataSourceException(databaseError.getMessage()));
            }
        });
        databaseReference.setValue(refueling);
    }
}
