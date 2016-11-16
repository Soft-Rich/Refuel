package be.ehb.digx.refuel.login.view.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;

import be.ehb.digx.refuel.BR;


/**
 * Created by richsoft on 15/11/2016.
 */

public class Login extends BaseObservable{

    private String email;
    private String password;

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public TextWatcher onEmailChanged = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            setEmail(charSequence.toString());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    @Bindable
    public TextWatcher onPasswordChanged = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            setPassword(charSequence.toString());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public boolean isEmailValid() {
        if (email == null){
            return false;
        }
        return email.contains("@");
    }

    public boolean isPasswordValid() {
        if (password == null){
            return false;
        }
        return password.length() > 4;
    }
}
