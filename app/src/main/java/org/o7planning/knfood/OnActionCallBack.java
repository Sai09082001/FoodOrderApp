package org.o7planning.knfood;

import com.google.android.gms.maps.model.LatLng;

public interface OnActionCallBack {
    void showAlert(String distance, LatLng start, LatLng end);
}
