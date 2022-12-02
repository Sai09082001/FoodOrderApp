package org.o7planning.knfood.Model;

import java.io.Serializable;

public class Voucher implements Serializable {
    private int id;
    private String title;
    private String time;
    private String status;

    public Voucher(String title, String time, String status) {
        this.title = title;
        this.time = time;
        this.status = status;
    }

    public Voucher(int id, String title, String time, String status) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.status = status;
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
    public Voucher(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", status=" + status +
                '}';
    }
}
