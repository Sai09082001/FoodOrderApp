package org.o7planning.knfood.Model;

import com.google.android.gms.maps.model.LatLng;

public class PlaceEntity {
    private final String name,address,content;
    private final int photoBG;
    private LatLng location;

    public PlaceEntity(LatLng location,String name, String address, String content, int photoBG) {
        this.location=location;
        this.name = name;
        this.address = address;
        this.content = content;
        this.photoBG = photoBG;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }


    public String getContent() {
        return content;
    }


    public int getPhotoBG() {
        return photoBG;
    }

    public LatLng getLocation() {
        return location;
    }
}