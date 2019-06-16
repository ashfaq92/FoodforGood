package com.jaystiqs.jaydahstudios.feedme;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.andreilisun.swipedismissdialog.SwipeDismissDialog;
import com.microsoft.maps.MapAnimationKind;
import com.microsoft.maps.MapRenderMode;
import com.microsoft.maps.MapScene;
import com.microsoft.maps.MapView;
import com.microsoft.maps.Geolocation;
import com.microsoft.maps.MapElementLayer;
import com.microsoft.maps.MapIcon;
import com.microsoft.maps.MapImage;

public class BenefactorActivity extends AppCompatActivity  implements LocationListener {
    private MapView mMapView;
    LocationManager locationManager;
    private MapElementLayer mPinLayer;
    public static String longitudeC;
    public static String latitudeC;
    private static Geolocation HERE = new Geolocation(31.2508, 121.4506);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benefactor);
        mMapView = new MapView(this, MapRenderMode.VECTOR);
        mMapView.setCredentialsKey(BuildConfig.CREDENTIALS_KEY);
        ((FrameLayout)findViewById(R.id.map_view)).addView(mMapView);
        CheckPermission();

        mPinLayer = new MapElementLayer();
        mMapView.getLayers().add(mPinLayer);

        Geolocation location = new Geolocation(31.2508, 121.4506);

        String title = "You";      // title to be shown next to the pin
        Bitmap pinBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.map_pin);

        MapIcon pushpin = new MapIcon();

        pushpin.setLocation(location);

        pushpin.setTitle(title);
        pushpin.setImage(new MapImage(pinBitmap));

        mPinLayer.getElements().add(pushpin);

    }

    public void showStoreDetails(View view){
        View dialog = LayoutInflater.from(this).inflate(R.layout.location_popup, null);
        final SwipeDismissDialog swipeDismissDialog = new SwipeDismissDialog.Builder(this)
                .setView(dialog)
                .build()
                .show();
        Button dismissButton = dialog.findViewById(R.id.dissmissPDialog);
        Button navigateButton = dialog.findViewById(R.id.navigatetoPLocation);



        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeDismissDialog.dismiss();
            }
        });

        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double latitude = 31.2333;
                double longitude = 121.4814;
                String label = "ABC Label";
                String uriBegin = "geo:" + latitude + "," + longitude;
                String query = latitude + "," + longitude + "(" + label + ")";
                String encodedQuery = Uri.encode(query);
                String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                Uri uri = Uri.parse(uriString);
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                startActivity(intent);
                swipeDismissDialog.dismiss();
            }
        });
    }

    public void getLocation(){
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, this);
        }catch(SecurityException e){
            e.printStackTrace();
        }
    }

    public void CheckPermission(){
        if(ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions( this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        getLocation();
        mMapView.setScene(
                MapScene.createFromLocationAndZoomLevel(HERE, 10),
                MapAnimationKind.NONE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.resume();
        getLocation();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.suspend();
        locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {
//        longitudeC = String.valueOf(location.getLongitude());
//        latitudeC = String.valueOf(location.getLatitude());
//
//        HERE = new Geolocation(location.getLongitude(), location.getLatitude());
//        mMapView.setScene(
//                MapScene.createFromLocationAndZoomLevel(HERE, 10),
//                MapAnimationKind.NONE);
//        Toast.makeText(this,longitudeC+" - "+ latitudeC, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
