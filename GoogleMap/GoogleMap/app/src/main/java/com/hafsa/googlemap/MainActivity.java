package com.hafsa.googlemap;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap map;
    private Button button;
    private Button lbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCurrentPermition();


        button=findViewById(R.id.currentbtn);
        lbutton=findViewById(R.id.lbtn);

button.setOnClickListener(new View.OnClickListener() {
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View view) {
        getCurrentLocation();
    }
});
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }




    private void getPickerLocation(final GoogleMap map) {
        map.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
            @Override
            public void onCameraIdle() {
                LatLng pickerlatlng=map.getCameraPosition().target;
                lbutton.setText(getAddress(pickerlatlng.latitude, pickerlatlng.longitude));

            }
        });
    }


    private void getCurrentPermition() {

        String [] permition={Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED);
            requestPermissions(permition, 0);



            }else{

        }
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onMapReady(GoogleMap googleMap) {
        getPickerLocation(googleMap);
        map = googleMap;

        LatLng bitm = new LatLng(23.35, 90.75);
        googleMap.addMarker(new MarkerOptions().position(bitm).title("Marker in BITM"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bitm, 15));


        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        googleMap.setMyLocationEnabled(true);

        map.getUiSettings().setMyLocationButtonEnabled(false);
        getCurrentLocation();

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void getCurrentLocation() {
        FusedLocationProviderClient fusedLocationProviderClient = new FusedLocationProviderClient(this);
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        Task location = fusedLocationProviderClient.getLastLocation();
        location.addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if(task.isSuccessful()){
                    Location currentLocation=(Location)task.getResult();
                    LatLng currentLatLng=new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());

                 String addres= getAddress(currentLocation.getLatitude(), currentLocation.getLongitude());
                    map.addMarker(new MarkerOptions().position(currentLatLng).title(addres));


                    //map.addMarker(new MarkerOptions().position(currentLatLng));
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 15));

                }
            }
        });

    }



    public String getAddress(double lat, double lon){
        String address="";

        Geocoder geocoder=new Geocoder(this, Locale.getDefault());
        List<Address> addresses;

        try {
            addresses =geocoder.getFromLocation(lat, lon, 1);
            if(addresses.size()>0){
                address=addresses.get(0).getAddressLine(0);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return address;

    }

}
