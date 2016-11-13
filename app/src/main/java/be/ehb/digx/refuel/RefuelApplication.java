package be.ehb.digx.refuel;

import android.app.Application;
import android.content.Context;

import com.firebase.client.Firebase;
import com.squareup.leakcanary.LeakCanary;
/**
 * Created by richsoft on 13/11/2016.
 *
 * In this class it is possible to de specific actions during the lifecycle of the Refuel Application
 */

public class RefuelApplication extends Application {

    private static final String TAG = "RefuelApplication";
    public static RefuelApplication instance;
    private static Firebase firebase;

    public RefuelApplication() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        /*Log.i(TAG, "Initiating Firebase");
        FirebaseApp.initializeApp(this);
        Firebase.setAndroidContext(this);
        firebase = new Firebase("https://tankingapp.firebaseio.com");*/

        LeakCanary.install(this);
    }

    public static Firebase getFirebase() {
        return firebase;
    }

    /**
     * http://stackoverflow.com/questions/987072/using-application-context-everywhere
     * Return the context of the application
     * @return Context
     */
    public static Context getContext(){
        return instance;
    }
}
