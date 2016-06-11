package models;

public class Cart {
    private int cart_id;
    private int user_id;
    private int item_id;

    public Cart( int user_id, int item_id) {
        this.user_id = user_id;
        this.item_id = item_id;
    }

    public int getCart_id() {
        return cart_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getItem_id() {
        return item_id;
    }


    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }
}
