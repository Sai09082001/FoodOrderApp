package org.o7planning.knfood.Model;

public class Ticket {
    private String img;
    private String title;
    private String time;
    private boolean status;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Ticket(String img, String title, String time, boolean status) {
        this.img = img;
        this.title = title;
        this.time = time;
        this.status = status;
    }
}
