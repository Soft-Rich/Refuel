package be.ehb.digx.refuel.login;

import android.app.Activity;
import android.util.Log;

import be.ehb.digx.refuel.authentication.AuthenticationException;
import be.ehb.digx.refuel.authentication.AuthenticationManager;
import be.ehb.digx.refuel.domain.model.User;
import be.ehb.digx.refuel.login.domain.model.Login;

/**
 * Created by richsoft on 13/11/2016.
 */

public class LoginPresenter implements LoginContract.Presenter, AuthenticationManager.Callback {

    private static final String TAG = "LoginPresenter";
    
    private AuthenticationManager authenticationManager;
    private Activity activity;
    private LoginContract.View view;

    public LoginPresenter(Activity activity, LoginContract.View view) {
        this.activity = activity;
        this.view = view;
    }

    @Override
    public void attemptLogin(Login login) {
        Log.d(TAG, "attemptLogin: user = "+login.getEmail());
        authenticationManager = new AuthenticationManager(activity, this);
        authenticationManager.signIn(login);
    }

    @Override
    public void start() {
        Log.d(TAG, "start()");

    }

    @Override
    public void onAuthenticationSuccessful(User user) {
        Log.d(TAG, "onAuthenticationSuccessful: user = "+user.getDisplayName());
        view.showLogInSuccessful(user);
    }

    @Override
    public void onAuthenticationFailed(AuthenticationException authenticationException) {
        Log.d(TAG, "onAuthenticationFailed: "+authenticationException.getMessage());
        view.showLoginFailed(authenticationException);
    }
}
