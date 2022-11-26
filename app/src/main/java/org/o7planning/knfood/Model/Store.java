package org.o7planning.knfood.Model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

public class Store {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;
    private String keypass;
    private String rating;
    private String time;
    private String content;

    public String getKeypass() {
        return keypass;
    }

    public void setKeypass(String keypass) {
        this.keypass = keypass;
    }


    public Store(int id, String name, String keyPass, String rating, String time, String content, String[] foods) {
        this.id = id;
        this.name = name;
        this.keypass = keyPass;
        this.rating = rating;
        this.time = time;
        this.content = content;
    }
    public Store() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", keypass='" + keypass + '\'' +
                ", rating='" + rating + '\'' +
                ", time='" + time + '\'' +
                ", content='" + content + '\''+
                '}';
    }

    public Map<String,Object> toMap(){
        HashMap<String,Object> result = new HashMap<>();
        result.put("name",name);
        result.put("keypass",keypass);
        result.put("rating",rating);
        result.put("time",time);
        result.put("content",content);
        return result;
    }
}
