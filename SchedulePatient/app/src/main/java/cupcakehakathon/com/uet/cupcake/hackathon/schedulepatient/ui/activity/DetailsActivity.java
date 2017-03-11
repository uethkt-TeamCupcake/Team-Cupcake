package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.R;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.Constants;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.RecycleUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.ToastUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.adapter.FacultyAdapter;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.listener.Listener;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.map.MapUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.map.WorkaroundMapFragment;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.object.FacultyObject;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.object.HospitalObject;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.data.SQLController;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.data.SQLHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/**
 * Created by Luong Tran on 3/11/2017.
 */

public class DetailsActivity
    extends BaseActivity
    implements OnMapReadyCallback,
               GoogleApiClient.ConnectionCallbacks,
               GoogleApiClient.OnConnectionFailedListener,
               LocationListener {

    private String TAG = "DETAILS";

    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ImageView imgDetails;
    private int idHospital;
    private HospitalObject hospitalObject;
    private ArrayList<FacultyObject> lsFacultySub, lsFaculty;
    private RecyclerView recyclerView;
    private FacultyAdapter adapter;
    private NestedScrollView nestedScrollView;
    private TextView txtSend;

    private GoogleMap mMaps;
    private Marker mCurrLocationMarker, mPlaceLocation;
    private LocationRequest mLocationRequest;
    private GoogleApiClient mGoogleApiClient;
    private LatLng mCurrentLatLng, mPlaceLatLng;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_details;
    }

    @Override
    protected void initVariables(Bundle saveInstanceState) {
        toolbar = (Toolbar) findViewById(R.id.toolbarDetails);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        imgDetails = (ImageView) findViewById(R.id.imgDetailHospital);
        recyclerView = (RecyclerView) findViewById(R.id.rcvFaculty);
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScroll);
        txtSend = (TextView) findViewById(R.id.txtSend);
    }

    @Override
    protected void initData(Bundle saveInstanceState) {
        receiveId();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        createMaps();

        SQLController controller = new SQLController(this);
        ArrayList<HospitalObject> ls =
            controller.queryListHospital(SQLHelper.SQL_SELECT_HOSPITAL_BY_ID + idHospital);
        hospitalObject = ls.get(0);
        lsFaculty = controller.queryFaculty(SQLHelper.SQL_SELECT_FACULTY_BY_HOSPITAL
                                                + idHospital
                                                + " AND "
                                                + SQLHelper.FAC_KIND
                                                + " = "
                                                + Constants.ID_FACULTY_KIND);
        lsFacultySub = controller.queryFaculty(SQLHelper.SQL_SELECT_FACULTY_BY_HOSPITAL
                                                   + idHospital
                                                   + " AND "
                                                   + SQLHelper.FAC_KIND
                                                   + " = "
                                                   + Constants.ID_SUB_FACULTY_KIND);

        mPlaceLatLng = new LatLng(Double.valueOf(hospitalObject.getLatitude()),
                                  Double.valueOf(hospitalObject.getLongitude()));

        adapter = new FacultyAdapter(lsFaculty, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                                                              LinearLayoutManager.VERTICAL,
                                                              false));

        RecycleUtils.showListRcv(recyclerView, adapter, new Listener.listenFaculty() {
            @Override
            public void onClick(int id) {
                ToastUtils.quickToast(DetailsActivity.this, "ID = " + id);
            }
        }, this);
        try {
            ImageLoader.getInstance().displayImage(hospitalObject.getImage(), imgDetails);
        } catch (Exception e) {
            e.printStackTrace();
        }

        txtSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this, SendRequestActivity.class);
                startActivity(intent);
            }
        });

        collapsingToolbarLayout.setTitle(hospitalObject.getName());
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
    }

    private void createMaps() {
        SupportMapFragment mapFragment =
            (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fmMaps);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                onBackPressed();
                break;
            }
        }
        return true;
    }

    private void receiveId() {
        idHospital = getIntent().getIntExtra(Constants.PASS_ID_HOSPITAL, 0);
    }

    private class FetchUrl
        extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... url) {
            try {
                return MapUtils.downloadUrl(url[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            new ParserTask().execute(result);
            //            try {
            //                txtDistanceDetails.setText(MapUtils.DataParser.getDistance(result));
            //                txtTimeDetails.setText(MapUtils.DataParser.getTime(result));
            //                lsInstruction = MapUtils.DataParser.getAllInstruction(result);
            //                if (lsInstruction.size() != 0) {
            //
            //                }
            //            } catch (JSONException e) {
            //                e.printStackTrace();
            //            }
        }
    }

    private class ParserTask
        extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {
            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;
            try {
                jObject = new JSONObject(jsonData[0]);
                routes = MapUtils.DataParser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points;
            PolylineOptions lineOptions = null;

            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList<>();
                lineOptions = new PolylineOptions();
                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);
                // Fetching all the points in i-th route
                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);
                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);
                    points.add(position);
                }
                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(10);
                lineOptions.color(Color.RED);
            }
            // Drawing polyline in the Google Map for the i-th route
            if (lineOptions != null) {
                mMaps.addPolyline(lineOptions);
            } else {
                Log.d("onPostExecute", "without Polylines drawn");
            }
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient,
                                                                     mLocationRequest,
                                                                     this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }

        //Place current location marker
        mCurrentLatLng = new LatLng(location.getLatitude(), location.getLongitude());

        MarkerOptions mCurrentMarker = new MarkerOptions();
        MarkerOptions mPlaceMarker = new MarkerOptions();
        mCurrentMarker.position(mCurrentLatLng);
        mCurrentMarker.title("Your Location");
        mCurrentMarker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));

        mPlaceMarker.position(mPlaceLatLng);
        mPlaceMarker.title(hospitalObject.getName());
        mPlaceMarker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));

        mCurrLocationMarker = mMaps.addMarker(mCurrentMarker);
        mPlaceLocation = mMaps.addMarker(mPlaceMarker);

        // Load json from API
        new FetchUrl().execute(MapUtils.getUrlDistance(mCurrentLatLng, mPlaceLatLng));

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(mCurrentLatLng);
        builder.include(mPlaceLatLng);
        LatLngBounds bounds = builder.build();

        int padding = 0; // offset from edges of the map in pixels
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
        mMaps.animateCamera(cu);

        //stop location updates
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMaps = googleMap;

        //        mMaps = ((WorkaroundMapFragment) getChildFragmentManager().findFragmentById(R.id.fmMaps)).getMap();
        mMaps.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMaps.getUiSettings().setZoomControlsEnabled(true);

        ((WorkaroundMapFragment) getSupportFragmentManager().findFragmentById(R.id.fmMaps)).setListener(
            new WorkaroundMapFragment.OnTouchListener() {
                @Override
                public void onTouch() {
                    nestedScrollView.requestDisallowInterceptTouchEvent(true);
                }
            });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMaps.setMyLocationEnabled(true);
            }
        } else {
            buildGoogleApiClient();
            mMaps.setMyLocationEnabled(true);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[],
                                           int[] grantResults) {
        switch (requestCode) {
            case Constants.MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted. Do the
                    // contacts-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                                                          Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {
                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mMaps.setMyLocationEnabled(true);
                    }
                } else {
                    // Permission denied, Disable the functionality that depends on this permission.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }
            // other 'case' lines to check for other permissions this app might request.
            // You can add here other case statements according to your requirement.
        }
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this).addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .addApi(LocationServices.API)
            .build();
        mGoogleApiClient.connect();
    }
}