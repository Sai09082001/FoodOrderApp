package org.o7planning.knfood.Model;

public class FoodDesserts {
    private String img;

    public FoodDesserts(String img, String namefood) {
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
