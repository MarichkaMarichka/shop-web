package models;


import javax.xml.soap.Text;

public class Item {
    private int id_item;

    public void setName(String name) {
        this.name = name;
    }


    public void setPrice(int price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDiscription(Text discription) {
        this.discription = discription;
    }


    private String name;
    private int price;
    private String image;
    private Text discription;
    private int id_categ;

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

    public Text getDiscription() {
        return discription;
    }

    public int getId_categ() {
        return id_categ;
    }

    public Item() {

    }

    public Item(int id_item, String name, int price, String image, Text discription, int id_categ) {

        this.id_item = id_item;
        this.name = name;
        this.price = price;
        this.image = image;
        this.discription = discription;
        this.id_categ = id_categ;
    }
}

