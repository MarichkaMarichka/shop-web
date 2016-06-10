package store;


import models.Item;
import service.Settings;

import javax.xml.soap.Text;
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
    public List<Item> selectItems(int start,int take){
        try{
            final Statement statement = this.connection.createStatement();
            final ResultSet rs = statement.executeQuery("select * from items limit "+take+" offset "+start);
            while (rs.next()){
                Item item = new Item();
                item.setId_item(rs.getInt(1));
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
    public int countRecords(){
        int size = 0;
        try{
            final Statement statement = this.connection.createStatement();
            final ResultSet rs = statement.executeQuery("select * from items ");
            int i = 0;
            while (rs.next()){
              i++;
            }
            size = i;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return size;
    }
    public Item searchItemById(int id){
        Item item = new Item();
        try{
            final Statement statement = this.connection.createStatement();
            final ResultSet rs = statement.executeQuery("select * from items where id_item = "+id);
            if (rs.next()){
                item.setId_item(rs.getInt(1));
                item.setName(rs.getString(2));
                item.setPrice(rs.getInt(3));
                item.setImage(rs.getString(4));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return item;
    }
    public static void main(String []args)  {
        Object obj = 10;
        int a = (Integer) obj;
        if(10==a){
            System.out.println("true");
        }
    }
}
