package be.ehb.digx.refuel.login.domain.model;

/**
 * Created by richsoft on 13/11/2016.
 * Keeps login data
 */

public class Login {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
