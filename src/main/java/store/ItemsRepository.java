package store;


import models.Cart;
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
    //-------------------------------------------------------------
    public void addItem(Item i) throws SQLException {

        final PreparedStatement uStatement = this.connection.prepareStatement("insert into items (name, price, image)"+
                "values ('"+ i.getName()+ "',"+i.getPrice()+",'"+i.getImage()+"')");
        uStatement.executeUpdate();
        uStatement.close();

    }
    //--------------------------------------------------------------
    public void deleteItem(Item i) throws SQLException {
        CartRepository storage = new CartRepository();
        Cart c = storage.searchCartByItemId(i.getId_item());
        if (!c.equals(null)){
            storage.deleteCart(c);
        }
        final PreparedStatement uStatement = this.connection.prepareStatement("delete from items "+
                "where id_item = "+i.getId_item());
        uStatement.executeUpdate();
        uStatement.close();

    }
    //------------------------------------------------------------------
    public void updateItem(Item i) throws SQLException {

        final PreparedStatement uStatement = this.connection.prepareStatement("update items " +
                "set image = '" + i.getImage() + "' where id_item = " + i.getId_item()

        );
        uStatement.executeUpdate();
        uStatement.close();

    }

    public static void main(String []args) throws SQLException  {
//        Item item = new Item("Acer Black 11.6",500,"http://ll-us-i5.wal" +
//                ".co/dfw/dce07b8c-9c98/k2-_2aa9e9ba-fc33-4f69-9281-afafffbce6b1.v1.jpg-552c7fa07eb9816749ce41796bded6f701099107-webp-450x450.webp");
//        ItemsRepository storage = new ItemsRepository();
//        storage.addItem(item);

        Item item= new Item(6);
        ItemsRepository storage = new ItemsRepository();
        storage.deleteItem(item);

//
//        Item item= new Item(10,"http://ll-us-i5.wal.co/dfw/dce07b8c-4cce/k2-_f724bd61-ccb4-4be0-8517-13b07290b18e.v1" +
//                ".jpg-bb492b1ce62d60d5e3cfea9e1092de422f88af26-webp-450x450.webp");
//        ItemsRepository storage = new ItemsRepository();
//        storage.updateItem(item);

    }
}
