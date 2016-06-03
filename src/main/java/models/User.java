package models;

/**
 * Created by Marichka on 28.05.2016.
 */

public class User {

    private String login;
    private String password;
    private String email;
    private long ph_number;


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public long getPh_number() {
        return ph_number;
    }

    public User(String login, String password, String email,long ph_number) {

        this.ph_number = ph_number;
        this.login = login;
        this.password = password;
        this.email = email;
    }
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
