package store;

import models.Cart;
import models.User;
import service.Settings;

import java.sql.*;


public class CartRepository {
    private final Connection connection;

    public CartRepository() {
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
    public void addCart(Cart c) throws SQLException {

            final PreparedStatement uStatement = this.connection.prepareStatement("insert into carts (user_id,item_id) " +
                    "values (" + c.getUser_id() + ","+c.getItem_id()+")");
            uStatement.executeUpdate();
            uStatement.close();

    }
    public Cart searchCartByItemId(int id) {
        Cart item = new Cart();
        try {
            final Statement statement = this.connection.createStatement();
            final ResultSet rs = statement.executeQuery("select * from carts where item_id = " + id);
            if (rs.next()) {
                item.setCart_id(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }
    public void deleteCart(Cart c) throws SQLException {
        final PreparedStatement uStatement = this.connection.prepareStatement("delete from carts "+
                "where cart_id = "+c.getCart_id());
        uStatement.executeUpdate();
        uStatement.close();

    }
}