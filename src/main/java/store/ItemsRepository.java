package store;


import models.Item;
import service.Settings;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemsRepository {
    private final Connection connection;
    List<Item> items = new ArrayList<Item>();

    public ItemsRepository() {
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
    public List<Item> selectItems(int start,int count){
        try{
            final Statement statement = this.connection.createStatement();
            final ResultSet rs = statement.executeQuery("select * from items limit "+count+" offset "+start+"");
            while (rs.next()){
                Item item = new Item();
                item.setName(rs.getString(2));
                item.setPrice(rs.getInt(3));
                item.setImage(rs.getString(4));
                items.add(item);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return items;
    }
}
