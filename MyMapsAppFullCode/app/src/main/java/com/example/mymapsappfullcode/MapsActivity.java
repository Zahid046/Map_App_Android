package com.example.mymapsappfullcode;

//All of these imports were put in by the system when we selected File > New > Google > Google Maps Activity
//For a deeper understanding of these imports and when to use them go to developer.android.com
//START
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
//FINISH

//While in our MainActivity.java we had 'implements View.OnClickListener' to facilitate the fact
//that we had a button that required an onClick, in this class we have 'implements OnMapReadyCallback'
//to facilitate the fact that we need to use a callback onMapReady which contains instructions that
//will be used when the map in this activity is ready to use.
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    //Creating a GoogleMap java object that will be connected to our Map fragment in activity_maps.xml
    //in our onMapReady method when the map fragment in ready.
    //START
    private GoogleMap mMap;
    //FINISH

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        //Obtain the SupportMapFragment and get notified when the map is ready to be used.
        //The mapFragement is connected to the fragment in activity_maps.xml using findFragmentByID
        //with R.id.'name' inside the brackets. Most of you are probably familiar with this type of
        //structure from findViewByID that we have used in the MainActivity and in previous projects.
        //START
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        //FINISH
        //We instruct the system that the instructions of what to do when the map fragment is ready
        //can be found in the onMapReady method - we do this by putting 'this' inside the brackets.
        //START
        mapFragment.getMapAsync(this);
        //FINISH
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near the Coursera office, in Mountain View, California.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        //Connect the map that has been launched to the GoogleMap object that was created above our
        //onCreate.
        //START
        mMap = googleMap;
        //FINISH

        //Create a LatLng (Latitude, Longitude) object and give it the coordinates value near the
        //Coursera office in Mountain View, California
        //START
        LatLng coursera = new LatLng(37.3868, -122.0608);
        //FINISH
        //Create and new marker, set it with the location of the LatLng object we created and give
        //it the title "Marker Near Coursera"
        //START
        mMap.addMarker(new MarkerOptions().position(coursera).title("Marker Near Coursera"));
        //FINISH
        //We instruct our mapFragment that we want the part of the world with our marker called
        //'coursera' to be visible when our user sees the map.
        //START
        mMap.moveCamera(CameraUpdateFactory.newLatLng(coursera));
        //FINISH
    }
}