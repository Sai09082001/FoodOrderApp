package org.o7planning.knfood.Model;

public class Bill {
    private String billcode;
    private String title;
    private String time;
    private String price;
    private String status;
    private double rating;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Bill(String billcode, String title, String time, String price, String status, double rating) {
        this.billcode = billcode;
        this.title = title;
        this.time = time;
        this.price = price;
        this.status = status;
        this.rating = rating;
    }

    public String getBillcode() {
        return billcode;
    }

    public void setBillcode(String billcode) {
        this.billcode = billcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }



    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
