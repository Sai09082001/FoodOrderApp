package org.o7planning.knfood.Model;

public class Store {
    private String img;
    private String title;
    private double rating;
    private String time;
    private String content;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Store(String img, String title, double rating, String time, String content) {
        this.img = img;
        this.title = title;
        this.rating = rating;
        this.time = time;
        this.content = content;
    }
}
