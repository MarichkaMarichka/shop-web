package store;

import models.User;
import org.postgresql.util.PSQLException;
import service.Settings;

import java.sql.*;



public class UsersRepository {
    private final Connection connection;

    public UsersRepository() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        final Settings settings = Settings.getInstanse();
        try {
            this.connection = DriverManager.getConnection(settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    //-------------------------------------------------------------
    public void addUser(User u) throws SQLException {

            final PreparedStatement uStatement = this.connection.prepareStatement("insert into s_users (login,password,email,ph_number) " +
                    "values ('" + u.getLogin() + "','"+u.getPassword()+"','"+u.getEmail()+"','"+u.getPh_number()+"')");
            uStatement.executeUpdate();
            uStatement.close();

    }
    //-------------------------------------------------------------
    public boolean searchUserByLogPass(User u){
        boolean exist = false;
        try{
            final Statement statement = this.connection.createStatement();
            final ResultSet rs = statement.executeQuery("select * from s_users where login = '"+u.getLogin()+"' and password = '"+u.getPassword()+"'");
            if (rs.next()){
                exist = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return exist;
    }


    public static void main(String []args)  {
        User user = new User("1","2","3",4);

        UsersRepository storage = new UsersRepository();




    }
}