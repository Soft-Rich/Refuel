package be.ehb.digx.refuel.login;

import android.app.Activity;
import android.util.Log;

import be.ehb.digx.refuel.R;
import be.ehb.digx.refuel.authentication.AuthenticationException;
import be.ehb.digx.refuel.authentication.AuthenticationManager;
import be.ehb.digx.refuel.domain.model.User;
import be.ehb.digx.refuel.login.view.model.Login;

/**
 * Created by richsoft on 13/11/2016.
 * Implementation for the handling of login actions
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

    /**
     * Attempt to login the user based on email and password
     * @param login
     */
    @Override
    public void attemptLogin(Login login) {
        Log.d(TAG, "attemptLogin: user = "+login.getEmail());
        view.showProgressBar();
        if (loginValid(login)) {
            Log.d(TAG, "attemptLogin: user = isValid");
            authenticationManager = new AuthenticationManager(activity, this);
            authenticationManager.signIn(login);
            return;
        }
        Log.w(TAG, "attemptLogin: user = isInvalid");
        view.hideProgressBar();
    }

    private boolean loginValid(Login login){
        view.doResetInputError();
        if (login.getEmail() == null || login.getEmail().length() == 0){
            view.showEmailError(activity.getResources().getString(R.string.error_field_required));
            return false;
        }

        if (login.getPassword() == null || login.getPassword().length() == 0){
            view.showPasswordError(activity.getResources().getString(R.string.error_field_required));
            return false;
        }

        if (!login.isEmailValid()){
            view.showEmailError(activity.getResources().getString(R.string.error_invalid_email));
            return false;
        }

        if (!login.isPasswordValid()){
            view.showPasswordError(activity.getResources().getString(R.string.error_invalid_password));
            return false;
        }
        return true;
    }

    /**
     * Start the use of the presenter
     */
    @Override
    public void start() {
        Log.d(TAG, "start()");

    }

    /**
     * Handles a successful login
     * @param user
     */
    @Override
    public void onAuthenticationSuccessful(User user) {
        Log.d(TAG, "onAuthenticationSuccessful: user = "+user.getDisplayName());
        view.hideProgressBar();
        view.showLogInSuccessful(user);
    }

    /**
     * Handles a failed login
     * @param authenticationException
     */
    @Override
    public void onAuthenticationFailed(AuthenticationException authenticationException) {
        Log.d(TAG, "onAuthenticationFailed: "+authenticationException.getMessage());
        view.hideProgressBar();
        view.showLoginFailed(authenticationException);
    }
}
