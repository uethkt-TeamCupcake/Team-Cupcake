package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient;

<<<<<<< HEAD
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

=======
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
>>>>>>> 69fb475edeee2417a6efef30cd58c8a3ae67ac89
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

<<<<<<< HEAD
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
=======
/**
 * Created by Luong Tran on 3/11/2017.
 */

public class MapsActivity
    extends FragmentActivity
    implements OnMapReadyCallback {
>>>>>>> 69fb475edeee2417a6efef30cd58c8a3ae67ac89

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
<<<<<<< HEAD
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


=======
        SupportMapFragment
            mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

>>>>>>> 69fb475edeee2417a6efef30cd58c8a3ae67ac89
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 69fb475edeee2417a6efef30cd58c8a3ae67ac89
