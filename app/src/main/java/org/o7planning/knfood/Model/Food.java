package org.o7planning.knfood.Model;

public class Food {
    private String title;
    private double original_price;
    private double price;
    private String img;

    public Food(String title, double original_price, double price, String img) {
        this.title = title;
        this.original_price = original_price;
        this.price = price;
        this.img = img;
    }
    public Food(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(double original_price) {
        this.original_price = original_price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
