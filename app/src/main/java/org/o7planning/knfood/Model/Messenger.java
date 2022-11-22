package org.o7planning.knfood.Model;

public class Messenger {
    private String avarta;
    private String username;
    private String content;
    private String status;

    public String getAvarta() {
        return avarta;
    }

    public void setAvarta(String avarta) {
        this.avarta = avarta;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Messenger(String avarta, String username, String content, String status) {
        this.avarta = avarta;
        this.username = username;
        this.content = content;
        this.status = status;
    }
}
