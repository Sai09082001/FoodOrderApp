package org.o7planning.knfood.Model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties
public class Food implements Serializable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    private String fName;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String note;
    private String price;
    private String date;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Food(String fName, String note, String price) {
        this.fName = fName;
        this.note = note;
        this.price = price;
    }

    public Food(int id, String fName, String note, String price, String date,String status) {
        this.id = id;
        this.fName = fName;
        this.note = note;
        this.price = price;
        this.date = date;
        this.status = status;
    }

    public Food(String name, String note, String price,String date,String status) {
        this.fName = name;
        this.note = note;
        this.price = price;
        this.date = date;
        this.status = status;
    }

    public Food(){

    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", note='" + note + '\'' +
                ", price='" + price + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
