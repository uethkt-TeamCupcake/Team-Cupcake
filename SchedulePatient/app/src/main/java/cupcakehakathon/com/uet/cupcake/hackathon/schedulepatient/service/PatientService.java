package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.AppController;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.object.ListHospital;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.data.SQLController;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.data.SQLHelper;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.data.SyncData;

/**
 * Created by NgocThai on 10/03/2017.
 */

public class PatientService extends Service {

    public static final String CONTROL_SERVICE = "CONTROL_SERVICE";
    public static final String VALUE_GET_LIST_HOSPITAL = "GET_LIST_HOSPITAL";
    public static final String VALUE_GET_FACULTY = "GET_LIST_FACULTY";
    public static final String VALUE_GET_RESPONSE_OF_DOCTOR = "GET_RESPONSE_DOCTOR";
    public static final String VALUE_ID_REQUEST = "ID_REQUEST";


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.getExtras() != null) {
            String action = intent.getStringExtra(PatientService.CONTROL_SERVICE);
            switch (action) {
                case VALUE_GET_LIST_HOSPITAL: {
                    reqListHospital(this);
                    break;
                }
            }
        }
        return START_STICKY;
    }


    public static final String TAG_REQ_HOSPITAL = "HOSPITAL";
    public static final String BROADCAST_EMPTY_LIST_HOSPITAL = "LIST_HOSPITAL_EMPTY";
    public static final String BROADCAST_UPDATE_HOSPITAL = "LIST_HOSPITAL_SHOW";
    public static final String BROADCAST_ERROR_REQ_HOSPITAL = "ERROR_REQ_HOSPITAL";
    public static final String URL_GET_ALL_HOSPITAL = "http://datuet.esy.es/cupcake/get_all_hospital.php";

    private void reqListHospital(final Context context) {
        StringRequest srtReq = new StringRequest(Request.Method.GET, URL_GET_ALL_HOSPITAL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String result = response.toString();
                Gson gson = new Gson();
                try {
                    ListHospital listHospital = gson.fromJson(result, ListHospital.class);
                    if (listHospital.getHospital().size() > 0) {
                        SQLController controller = new SQLController(context);
                        if (SyncData.checkHospitalChange(controller.queryListHospital(SQLHelper.SQL_SELECT_ALL_HOSPITAL), listHospital.getHospital())) {
                            // need update data. delete all and insert to sqlite
                            controller.deleteAllData(SQLHelper.TABLE_NAME_HOSPITAL);
                            for (int i = 0; i < listHospital.getHospital().size(); i++) {
                                boolean insert = controller.insertHospital(listHospital.getHospital().get(i));
                                insert = false;
                            }
                            Intent i = new Intent();
                            i.setAction(PatientService.BROADCAST_UPDATE_HOSPITAL);
                            context.sendBroadcast(i);
                        }
                    } else {
                        Intent i = new Intent();
                        i.setAction(PatientService.BROADCAST_EMPTY_LIST_HOSPITAL);
                        context.sendBroadcast(i);
                    }
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Intent i = new Intent();
                i.setAction(PatientService.BROADCAST_ERROR_REQ_HOSPITAL);
                context.sendBroadcast(i);
            }
        });
        AppController.getInstance().addToRequestQueue(srtReq, TAG_REQ_HOSPITAL);
    }


}
