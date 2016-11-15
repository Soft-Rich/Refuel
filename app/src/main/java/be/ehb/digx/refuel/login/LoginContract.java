package be.ehb.digx.refuel.login;

import be.ehb.digx.refuel.BasePresenter;
import be.ehb.digx.refuel.BaseView;
import be.ehb.digx.refuel.authentication.AuthenticationException;
import be.ehb.digx.refuel.domain.model.User;
import be.ehb.digx.refuel.login.view.model.Login;


/**
 * Created by richsoft on 13/11/2016.
 * The contract between the LoginPresenter and the LoginView
 */

public interface LoginContract {


    /**
     * Created by richsoft on 13/11/2016.
     * Handles actions for user login
     */

    interface Presenter extends BasePresenter {
        void attemptLogin(Login login);
    }


    /**
     * Created by richsoft on 13/11/2016.
     * Displays the login information and triggers the LoginPresenter for actions
     */

    interface View extends BaseView<LoginPresenter> {
        void showLogInSuccessful(User user);
        void showLoginFailed(AuthenticationException authenticationException);
        void doResetInputError();
        void showEmailError(String message);
        void showPasswordError(String message);
        void showProgressBar();
        void hideProgressBar();
    }
}
