package org.o7planning.knfood.Model;

public class Cart {
    private String img;
    private double price;
    private String title;
    private int count;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Cart(String img, double price, String title, int count) {
        this.img = img;
        this.price = price;
        this.title = title;
        this.count = count;
    }
}
