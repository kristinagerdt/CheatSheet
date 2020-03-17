package serialization.transientType;

import java.io.Serializable;

public class Login implements Serializable {
    private String login;
    private transient String password;

    public Login(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{login=" + login + ", password=" + password + '}';
    }
}