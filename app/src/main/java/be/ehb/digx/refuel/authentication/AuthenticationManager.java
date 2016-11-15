package be.ehb.digx.refuel.authentication;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import be.ehb.digx.refuel.authentication.model.adapter.UserAdapter;
import be.ehb.digx.refuel.domain.model.User;
import be.ehb.digx.refuel.login.view.model.Login;


/**
 * Created by richsoft on 13/11/2016.
 *
 * Manage the actions for authentication in the Refuel application
 */

public class AuthenticationManager {

    /**
     * Callback interface for the AuthenticationManager
     */

    public interface Callback{

        void onAuthenticationSuccessful(User user);

        void onAuthenticationFailed(AuthenticationException authenticationException);
    }


    private static final String TAG = "AuthenticationManager";
    private Activity activity;
    private Callback authenticationCallback;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    public AuthenticationManager(Activity activity, Callback authenticationCallback) {
        this.activity = activity;
        this.authenticationCallback = authenticationCallback;
        FirebaseApp.initializeApp(activity.getApplicationContext());
        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            //TODO Eventbus implementeren
            //Wanneer gebruiker uitgelogd is moet een event gegooid worden
            //zodat gebruiker terug op inlogscherm komt
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };
    }

    /**
     * Attempt to login the user with email and password
     * @param login
     */
    public void signIn(Login login){
        Log.i(TAG, "signIn("+login.getEmail()+",********)");
        FirebaseAuth auth = FirebaseAuth.getInstance();
        login.setEmail("info4rs@test.local");
        login.setPassword("info4rs123!");
        auth.signInWithEmailAndPassword(login.getEmail(), login.getPassword())
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            authenticationCallback.onAuthenticationSuccessful(UserAdapter.adapt(FirebaseAuth.getInstance().getCurrentUser()));
                        }else{
                            authenticationCallback.onAuthenticationFailed(new AuthenticationException(task.getException().getMessage(), task.getException()));
                        }
                    }
                });

    }

    /**
     * Start observing authentication state changes
     */
    public void start(){
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    /**
     * Stop observing authentication state changes
     */
    public void stop(){
        firebaseAuth.removeAuthStateListener(authStateListener);
    }
}
