package models;


public class Category {
    private int id_categ;
    private String name_categ;

    public int getId_categ() {
        return id_categ;
    }

    public String getName_categ() {
        return name_categ;
    }

    public Category(int id_categ, String name_categ) {

        this.id_categ = id_categ;
        this.name_categ = name_categ;
    }
}
