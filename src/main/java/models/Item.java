package models;


import javax.xml.soap.Text;

public class Item {

    private int id_item;
    private String name;
    private int price;
    private String image;


    public int getId_item() {
        return id_item;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public String getImage() {
        return image;
    }


    public void setId_item(int id_item) {
        this.id_item = id_item;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setImage(String image) {
        this.image = image;
    }




    public Item() {

    }
    public Item(int id_item) {
        this.id_item = id_item;

    }

    public Item(int id_item, String image) {
        this.id_item = id_item;
        this.image = image;
    }

    public Item(int id_item, String name, int price, String image) {

        this.id_item = id_item;
        this.name = name;
        this.price = price;
        this.image = image;

    }

    public Item( String name, int price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;

    }
}

