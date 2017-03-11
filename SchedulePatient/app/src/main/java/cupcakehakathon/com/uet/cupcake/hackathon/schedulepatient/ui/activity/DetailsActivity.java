package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.ui.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
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
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.R;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.Constants;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.DialogUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.PostDataUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.RecycleUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.ToastUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Utils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.adapter.FacultyAdapter;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.listener.Listener;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.map.MapUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.object.FacultyObject;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.object.HospitalObject;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.object.RequestObject;
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
               LocationListener,
               Listener.requestStatus {

    private String TAG = "DETAILS";
    public static final int MAX_LINES = 3;
    public static final int TWO_SPACES = 2;

    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ImageView imgDetails;
    private int idHospital;
    private HospitalObject hospitalObject;
    private ArrayList<FacultyObject> lsFacultySub, lsFaculty;
    private RecyclerView recyclerView;
    private FacultyAdapter adapter;
    private NestedScrollView nestedScrollView;
    private TextView txtAddress, txtPhone, txtRate, txtDescription;
    private RatingBar mRatingBar;

    private GoogleMap mMaps;
    private Marker mCurrLocationMarker, mPlaceLocation;
    private LocationRequest mLocationRequest;
    private GoogleApiClient mGoogleApiClient;
    private LatLng mCurrentLatLng, mPlaceLatLng;
    String targetTime = " ";

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
        txtAddress = (TextView) findViewById(R.id.txtAddress);
        txtPhone = (TextView) findViewById(R.id.txtPhone);
        txtDescription = (TextView) findViewById(R.id.txtDescription);
        mRatingBar = (RatingBar) findViewById(R.id.ratingBar);
    }

    @Override
    protected void initData(Bundle saveInstanceState) {
        receiveId();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
        RecycleUtils.showListRcv(recyclerView, adapter, new Listener.listenFaculty() {
            @Override
            public void onClick(int id) {
                //ToastUtils.quickToast(DetailsActivity.this, "ID = " + id);
                showDialog();
            }
        }, this);
        try {
            ImageLoader.getInstance().displayImage(hospitalObject.getImage(), imgDetails);
        } catch (Exception e) {
            e.printStackTrace();
        }

        collapsingToolbarLayout.setTitle(hospitalObject.getName());
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);

        txtAddress.setText(hospitalObject.getAddress());
        txtPhone.setText(hospitalObject.getPhone());
        //txtRate.setText(hospitalObject.getRate() + "");
        mRatingBar.setMax(5);
        txtDescription.setText(hospitalObject.getDesc());

        mRatingBar.setRating((float) hospitalObject.getRate());

        //seeMoreLine();

        //makeTextViewResizable(txtDescription, 3, hospitalObject.getDesc(), true);
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

    @Override
    public void requestSuccess(int id) {
        Log.i(TAG, "requestSuccess: success " + id);
        finish();
        ToastUtils.quickToast(getBaseContext(), "Send request success");
    }

    @Override
    public void requestError() {

    }

    @Override
    public void requestErrorResponse() {

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

    private void showDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.custom_dialog, null);
        final EditText edtDate = (EditText) alertLayout.findViewById(R.id.edtDate);
        final EditText edtSymptom = (EditText) alertLayout.findViewById(R.id.edtSymptom);

        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtils.dialogShowDate(DetailsActivity.this,
                                           "Choose time",
                                           new DatePickerDialog.OnDateSetListener() {
                                               @Override
                                               public void onDateSet(DatePickerDialog view,
                                                                     int year,
                                                                     int monthOfYear,
                                                                     int dayOfMonth) {
                                                   targetTime = year
                                                       + "-"
                                                       + (monthOfYear + 1)
                                                       + "-"
                                                       + dayOfMonth;
                                                   edtDate.setText(targetTime);
                                               }
                                           });
            }
        });

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Gửi yêu cầu");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        alert.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Button negativeButton =
                    ((AlertDialog) dialog).getButton(DialogInterface.BUTTON_NEGATIVE);
                final Drawable negativeButtonDrawable =
                    getResources().getDrawable(R.drawable.dialog_button_light_red);
                negativeButton.setBackground(negativeButtonDrawable);
                negativeButton.setTextColor(getResources().getColor(R.color.alert_dialog_button_red2));
                negativeButton.invalidate();
                Toast.makeText(getBaseContext(), "Thoát", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setPositiveButton("Gửi", new DialogInterface.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Button positiveButton =
                    ((AlertDialog) dialog).getButton(DialogInterface.BUTTON_POSITIVE);
                final Drawable negativeButtonDrawable =
                    getResources().getDrawable(R.drawable.dialog_button_light_green);
                positiveButton.setTextColor(getResources().getColor(R.color.alert_dialog_button_red2));
                positiveButton.invalidate();

                if (targetTime.equalsIgnoreCase("")) {
                    ToastUtils.quickToast(DetailsActivity.this, "Choose time first");
                } else {
                    String timeRequest = Utils.getCurrentTime(Utils.VALUES_DATE)
                        + " "
                        + Utils.getCurrentTime(Utils.VALUES_TIME);
                    String symptom = edtSymptom.getText().toString();
                    if (symptom.equalsIgnoreCase("")) {
                        ToastUtils.quickToast(DetailsActivity.this, "Choose time first");
                    } else {
                        PostDataUtils postDataUtils = new PostDataUtils();
                        postDataUtils.setRequestStatus(DetailsActivity.this);
                        String idPatient =
                            Utils.getValueFromPreferences(Constants.PREFERENCES_LOGIN_ID,
                                                          getBaseContext());
                        RequestObject requestObject = new RequestObject(Integer.parseInt(idPatient),
                                                                        symptom,
                                                                        timeRequest,
                                                                        1,
                                                                        0,
                                                                        targetTime);
                        postDataUtils.sendRequest(getBaseContext(),
                                                  new RequestObject(Integer.parseInt(idPatient),
                                                                    symptom,
                                                                    timeRequest,
                                                                    1,
                                                                    0,
                                                                    targetTime));
                        SQLController sqlController = new SQLController(getBaseContext());
                        boolean insert = sqlController.insertRequest(requestObject);
                        insert = false;
                    }
                }
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }
}


