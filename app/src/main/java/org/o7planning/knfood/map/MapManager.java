package org.o7planning.knfood.map;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.o7planning.knfood.KNFoodApp;
import org.o7planning.knfood.Model.PlaceEntity;
import org.o7planning.knfood.OnActionCallBack;
import org.o7planning.knfood.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MapManager implements GoogleMap.OnInfoWindowClickListener {
    private static final long TIME_DURATION = 2000;
    private static MapManager instance;
    private GoogleMap mMap;
    private Marker myPos;
    private OnActionCallBack mCallBack;

    private List<PlaceEntity> listPlace;

    private MapManager() {

    }

    public static MapManager getInstance() {
        if (instance == null) {
            instance = new MapManager();
        }
        return instance;
    }

    public void setCallBack(OnActionCallBack mCallBack) {
        this.mCallBack = mCallBack;
    }

    public void setMap(GoogleMap mMap) {
        this.mMap = mMap;
    }

    public void initMap() {
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setInfoWindowAdapter(initWindow());
        mMap.setOnInfoWindowClickListener(this);

        if (ActivityCompat.checkSelfPermission(KNFoodApp.getInstance(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(KNFoodApp.getInstance(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        mMap.setMyLocationEnabled(true);
        findMyLocation();
        // for dummy data
        initPlaces();
        addPlaceToMap();
       // getLocalAddress();
    }

    private GoogleMap.InfoWindowAdapter initWindow() {
        return new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return initViewAdapter(marker);
            }

            @Override
            public View getInfoContents(Marker marker) {
                return initViewAdapter(marker);
            }
        };
    }

    private View initViewAdapter(Marker marker) {
        if (marker.getTag() == null) return null;
        PlaceEntity place = (PlaceEntity) marker.getTag();
        View view = LayoutInflater.from(KNFoodApp.getInstance()).inflate(R.layout.item_view_info, null);
        ImageView ivPlace = view.findViewById(R.id.iv_place);
        TextView tvName = view.findViewById(R.id.tv_name);
        TextView tvAddress = view.findViewById(R.id.tv_address);
        TextView tvContent = view.findViewById(R.id.tv_content);

        ivPlace.setImageResource(place.getPhotoBG());
        tvName.setText(place.getName());
        tvAddress.setText(place.getAddress());
        tvContent.setText(place.getContent());
        return view;
    }

    private void initPlaces() {
        listPlace = new ArrayList<>();
        listPlace.add(new PlaceEntity(new LatLng(10.761372975756645, 106.66877881241845), KNFoodApp.getInstance().getString(R.string.txt_tra_sua_rb), KNFoodApp.getInstance().getString(R.string.txt_tra_sua_rb_address), KNFoodApp.getInstance().getString(R.string.txt_tra_sua_rb_content), R.drawable.ic_tra_sua_rb));
        listPlace.add(new PlaceEntity(new LatLng(10.76698793165913, 106.69642092591313), KNFoodApp.getInstance().getString(R.string.txt_tra_sua_alley), KNFoodApp.getInstance().getString(R.string.txt_tra_sua_alley_address), KNFoodApp.getInstance().getString(R.string.txt_tra_sua_alley_content), R.drawable.ic_tra_sua_alley));
        listPlace.add(new PlaceEntity(new LatLng(10.801210838856722, 106.65493528173803), KNFoodApp.getInstance().getString(R.string.txt_tra_sua_heekcaa), KNFoodApp.getInstance().getString(R.string.txt_tra_sua_heekcaa_address), KNFoodApp.getInstance().getString(R.string.txt_tra_sua_heekcaa_content), R.drawable.ic_tra_sua_heekcaa));

        listPlace.add(new PlaceEntity(new LatLng(10.801476277362038, 106.71509495474858), KNFoodApp.getInstance().getString(R.string.txt_ga_ran_donchicken), KNFoodApp.getInstance().getString(R.string.txt_ga_ran_donchicken_address), KNFoodApp.getInstance().getString(R.string.txt_ga_ran_donchicken_content), R.drawable.ic_don_chicken));
        listPlace.add(new PlaceEntity(new LatLng(10.727250919284192, 106.70878589707775), KNFoodApp.getInstance().getString(R.string.txt_ga_ran_popeyes), KNFoodApp.getInstance().getString(R.string.txt_ga_ran_popeyes_address), KNFoodApp.getInstance().getString(R.string.txt_ga_ran_popeyes_content), R.drawable.ic_ga_popeyes));
        listPlace.add(new PlaceEntity(new LatLng(10.762089094936652, 106.68282052591319), KNFoodApp.getInstance().getString(R.string.txt_ga_ran_texas), KNFoodApp.getInstance().getString(R.string.txt_ga_ran_texas_address), KNFoodApp.getInstance().getString(R.string.txt_ga_ran_texas_content), R.drawable.ic_texas_chicken));
        listPlace.add(new PlaceEntity(new LatLng(10.77592008524883, 106.67190878358345), KNFoodApp.getInstance().getString(R.string.txt_healthy_eatmoresalad), KNFoodApp.getInstance().getString(R.string.txt_healthy_eatmoresalad_address), KNFoodApp.getInstance().getString(R.string.txt_healthy_eatmoresalad_content), R.drawable.ic_eat_more_salad));
        listPlace.add(new PlaceEntity(new LatLng(10.786822856140521, 106.67638172775908), KNFoodApp.getInstance().getString(R.string.txt_healthy_gateauhealthy), KNFoodApp.getInstance().getString(R.string.txt_healthy_gateauhealthy_address), KNFoodApp.getInstance().getString(R.string.txt_healthy_eatmoresalad_content), R.drawable.ic_gateau_healthy));
        listPlace.add(new PlaceEntity(new LatLng(10.807776608759118, 106.68880971057322), KNFoodApp.getInstance().getString(R.string.txt_com_congamai), KNFoodApp.getInstance().getString(R.string.txt_com_congamai_address), KNFoodApp.getInstance().getString(R.string.txt_com_congamai_content), R.drawable.ic_com_ga_phu_yen));
        listPlace.add(new PlaceEntity(new LatLng(10.780615024017976, 106.69547169707818), KNFoodApp.getInstance().getString(R.string.txt_com_wagashiart), KNFoodApp.getInstance().getString(R.string.txt_com_wagashiart_address), KNFoodApp.getInstance().getString(R.string.txt_com_wagashiart_content), R.drawable.ic_wagashi_art));
        listPlace.add(new PlaceEntity(new LatLng(10.771320647718927, 106.68603119707814), KNFoodApp.getInstance().getString(R.string.txt_an_vat_banhtrangtronchuvien), KNFoodApp.getInstance().getString(R.string.txt_an_vat_banhtrangtronchuvien_address), KNFoodApp.getInstance().getString(R.string.txt_an_vat_banhtrangtronchuvien_content), R.drawable.ic_banh_trang_tron_cv));

    }

    private void updateMyLocation(LocationResult locationResult) {
        double lat = locationResult.getLastLocation().getLatitude();
        double lgn = locationResult.getLastLocation().getLongitude();
        if (myPos == null) {
            MarkerOptions marker = new MarkerOptions();
            marker.title("I'm here");
            marker.icon(BitmapDescriptorFactory.defaultMarker());
            marker.position(new LatLng(lat, lgn));
            String address = getAddress(lat, lgn);

            marker.snippet(address);

            myPos = mMap.addMarker(marker);
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myPos.getPosition(), 16));
        }
        if (myPos.getPosition().latitude != lat || myPos.getPosition().longitude != lgn) {
            String address = getAddress(lat, lgn);
            myPos.setSnippet(address);
            myPos.setPosition(new LatLng(lat, lgn));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myPos.getPosition(), 16));
        }
        //   mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myPos.getPosition(),16));
        // Toast.makeText(App.getInstance(),"My pos"+lat+" - "+lgn,Toast.LENGTH_SHORT).show();
    }

    private String getAddress(double lat, double lgn) {
        try {
            Geocoder geocoder = new Geocoder(KNFoodApp.getInstance(), Locale.getDefault());
            List<Address> rs = geocoder.getFromLocation(lat, lgn, 1);
            if (rs != null && !rs.isEmpty()) {
                return rs.get(0).getAddressLine(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Không xác định";
    }

    @SuppressLint("VisibleForTests")
    private void findMyLocation() {
        FusedLocationProviderClient client
                = new FusedLocationProviderClient(KNFoodApp.getInstance());

        if (ActivityCompat.checkSelfPermission(KNFoodApp.getInstance(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(KNFoodApp.getInstance(),
                        Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationRequest req = new LocationRequest();
        req.setInterval(TIME_DURATION);
        req.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        client.requestLocationUpdates(req,
                new LocationCallback() {
                    @Override
                    public void onLocationResult(@NonNull LocationResult locationResult) {
                        updateMyLocation(locationResult);
                    }
                }, Looper.getMainLooper());
    }

    private void addPlaceToMap() {
        BitmapDescriptor iconPlace = BitmapDescriptorFactory.fromResource(R.drawable.ic_place);
        for (PlaceEntity place : listPlace) {
            MarkerOptions op = new MarkerOptions();
            op.title(place.getName());
            op.snippet(place.getAddress());
            op.icon(iconPlace);
            op.position(place.getLocation());
            Marker marker = mMap.addMarker(op);
            marker.setTag(place);
        }

    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        PlaceEntity place = (PlaceEntity) marker.getTag();
        LatLng end = place.getLocation();
        LatLng start = myPos.getPosition();
        String distance = calcDistance(start, end);
        mCallBack.showAlert(distance, start, end);
    }

    private String calcDistance(LatLng start, LatLng end) {
        double lat1 = start.latitude;
        double lat2 = end.latitude;
        double lgn1 = start.longitude;
        double lgn2 = end.longitude;
        double R = 6371; // Radius of the earth in km
        double dLat = deg2rad(lat2 - lat1);  // deg2rad below
        double dLon = deg2rad(lgn2 - lgn1);
        double a =
                Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                        Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
                                Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = R * c; // Distance in km
        return new DecimalFormat("#.#").format(d) + " km";
    }

    double deg2rad(double deg) {
        return deg * (Math.PI / 180);

    }
}