package org.o7planning.knfood.Model;

public class MonTrangMieng {
    private String img;

    public MonTrangMieng(String img, String namefood) {
        this.img = img;
        this.namefood = namefood;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNamefood() {
        return namefood;
    }

    public void setNamefood(String namefood) {
        this.namefood = namefood;
    }

    private String namefood;
}
