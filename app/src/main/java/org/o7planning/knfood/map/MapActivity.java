package org.o7planning.knfood.map;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import org.o7planning.knfood.MainActivity;
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
//    private boolean checkPermission() {
//        int result = ContextCompat.checkSelfPermission(getApplicationContext(), ACCESS_FINE_LOCATION);
//        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), ACCESS_COARSE_LOCATION);
//
//        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
//    }
//    private void requestPermission() {
//
//        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION}, PERMISSION_REQUEST_CODE);
//
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode) {
//            case PERMISSION_REQUEST_CODE:
//                if (grantResults.length > 0) {
//
//                    boolean fineLocationAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
//                    boolean coarseLocationAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;
//
//                    if (!(fineLocationAccepted && coarseLocationAccepted)) {
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                            if (shouldShowRequestPermissionRationale(ACCESS_FINE_LOCATION)) {
//                                showMessageOKCancel("You need to allow access to both the permissions",
//                                        new DialogInterface.OnClickListener() {
//                                            @Override
//                                            public void onClick(DialogInterface dialog, int which) {
//                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                                                    requestPermissions(new String[]{ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION},
//                                                            PERMISSION_REQUEST_CODE);
//                                                }
//                                            }
//                                        });
//                                return;
//                            }
//                        }
//                    }
//                }
//
//                break;
//        }
//    }
//    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
//        new AlertDialog.Builder(MapActivity.this)
//                .setMessage(message)
//                .setPositiveButton("OK", okListener)
//                .setNegativeButton("Cancel", null)
//                .create()
//                .show();
//    }
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