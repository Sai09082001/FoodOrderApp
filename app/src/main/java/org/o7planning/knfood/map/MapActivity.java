package org.o7planning.knfood.map;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import org.o7planning.knfood.OnActionCallBack;
import org.o7planning.knfood.R;

public class MapActivity extends AppCompatActivity implements OnActionCallBack {

    private static final int PERMISSION_REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        //MapFragment
        initViews();
    }

    private void initViews() {
//        if (!checkPermission()) {
//            requestPermission();
//        }

        if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            },101);
        }
        MapFragment mapFragment= (MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                MapManager.getInstance().setMap(googleMap);
                MapManager.getInstance().initMap();
                MapManager.getInstance().setCallBack(MapActivity.this);
            }
        });
    }

    @Override
    public void showAlert(String distance, LatLng start, LatLng end) {
        AlertDialog alert=new AlertDialog.Builder(this).create();
        alert.setTitle("Thông báo");
        alert.setMessage("Đến đó khoảng: "+distance);
        alert.setButton(DialogInterface.BUTTON_POSITIVE,
                "Chỉ đường", (dialog, which) -> showDirection(start,end));
        alert.show();
    }

    private void showDirection(LatLng start, LatLng end) {
        String text=String.format("http://maps.google.com/maps?saddr=%s,%s&daddr=%s,%s",start.latitude,start.longitude,end.latitude,end.longitude);
        Intent intent=new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(text));
        startActivity(intent);
    }

}