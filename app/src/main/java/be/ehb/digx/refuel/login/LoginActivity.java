package be.ehb.digx.refuel.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import be.ehb.digx.refuel.R;
import be.ehb.digx.refuel.authentication.AuthenticationException;
import be.ehb.digx.refuel.databinding.ActivityLoginBinding;
import be.ehb.digx.refuel.dialog.ProgressDialogFragment;
import be.ehb.digx.refuel.domain.model.User;
import be.ehb.digx.refuel.login.view.model.Login;
import be.ehb.digx.refuel.vehicles.VehiclesActivity;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements LoginContract.View{

    private static final String TAG = "LoginActivity";


    private ProgressDialogFragment progressDialogFragment;
    private LoginPresenter loginPresenter;
    private Login login;
    private ActivityLoginBinding activityLoginBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialogFragment = new ProgressDialogFragment();
        progressDialogFragment.setContext(this);
        //Databinding
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginPresenter = new LoginPresenter(this, this);
        login = new Login();
        activityLoginBinding.lvEmail.addTextChangedListener(login.onEmailChanged);
        activityLoginBinding.lvPassword.addTextChangedListener(login.onPasswordChanged);
        activityLoginBinding.setPresenter(loginPresenter);
        activityLoginBinding.setLogin(login);
    }

    @Override
    public void showLogInSuccessful(User user) {
        Toast.makeText(this, getString(R.string.label_user)+ (user.getDisplayName() != null? user.getDisplayName() : "Unknown")+" "+getString(R.string.successful_login), Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, VehiclesActivity.class));
        this.finish();
    }

    @Override
    public void showLoginFailed(AuthenticationException authenticationException) {
        Toast.makeText(this, authenticationException.getMessage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void doResetInputError() {
        activityLoginBinding.lvEmail.setError(null);
        activityLoginBinding.lvPassword.setError(null);
    }

    @Override
    public void showEmailError(String message) {
        activityLoginBinding.lvEmail.requestFocus();
        activityLoginBinding.lvEmail.setError(message);
    }

    @Override
    public void showPasswordError(String message) {
        activityLoginBinding.lvPassword.requestFocus();
        activityLoginBinding.lvPassword.setError(message);
    }

    @Override
    public void showProgressBar() {
        progressDialogFragment.show(getFragmentManager(), TAG);
    }

    @Override
    public void hideProgressBar() {
        progressDialogFragment.dismiss();
    }

    @Override
    public void setPresenter(LoginPresenter presenter) {
        this.loginPresenter = presenter;
    }
}

