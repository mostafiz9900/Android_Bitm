package com.beskilled.googlemapdemo;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
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
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
private GoogleMap map;
private FloatingActionButton button;
private Button lButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.custonCurrentLocationBtn);
        lButton=findViewById(R.id.locationBtn);

        getCurrentPermition();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCurrentLocation();
            }
        });

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(this);

    }

    private void getPickerLocation(final GoogleMap map) {
        map.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
            @Override
            public void onCameraIdle() {
                LatLng pickerlatlng=map.getCameraPosition().target;
                lButton.setText(getAddres(pickerlatlng.latitude,pickerlatlng.longitude));
            }
        });
    }

    private void getCurrentPermition() {
        String[] permition={Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION};
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED){
                requestPermissions(permition,0);
            }else {

            }
        }
    }

    @SuppressLint("MissingPermission")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onMapReady(GoogleMap googleMap) {

map=googleMap;
        // Add a marker in Sydney, Australia, and move the camera.
        LatLng bitm = new LatLng(23.00, 90.00);
        googleMap.addMarker(new MarkerOptions().position(bitm).title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bitm,10));

        /*if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }*/
        googleMap.setMyLocationEnabled(true);

        getPickerLocation(googleMap);

        map.getUiSettings().setMyLocationButtonEnabled(false);
        getCurrentLocation();

    }

    @SuppressLint("MissingPermission")
    private void getCurrentLocation() {
        FusedLocationProviderClient  fusedLocationProviderClient=new FusedLocationProviderClient(this);
       Task location= fusedLocationProviderClient.getLastLocation();
       location.addOnCompleteListener(new OnCompleteListener() {
           @Override
           public void onComplete(@NonNull Task task) {
               if (task.isSuccessful()){
                   Location currentLocation=(Location) task.getResult();
                   LatLng currentLantLng=new LatLng(currentLocation.getLatitude(),currentLocation.getLongitude());
                  String address= getAddres(currentLocation.getLatitude(),currentLocation.getLongitude());
                   map.addMarker(new MarkerOptions().position(currentLantLng).title(address));
                   map.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLantLng,10));
               }
           }
       });
    }
    public String getAddres(double lot, double log){
        String addres="";
        Geocoder geocoder=new Geocoder(this, Locale.getDefault());
        List<Address> addressList;
        try {
            addressList=geocoder.getFromLocation(lot,log,1);
            addres=addressList.get(0).getAddressLine(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return addres;
    }
}
