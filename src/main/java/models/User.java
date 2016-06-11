package models;

/**
 * Created by Marichka on 28.05.2016.
 */

public class User {
    private int id_user;
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

    public int getId_user() {
        return id_user;
    }


    public User(String login, String password, String email, long ph_number) {
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
