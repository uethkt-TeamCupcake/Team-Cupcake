package cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.AppController;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.common.object.ResponseObject;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.utils.Constants;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.utils.Utils;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Luong Tran on 3/10/2017.
 */

public class DoctorService extends Service {

    private String TAG = "SERVICE";

    public static final String BROADCAST_UPDATE_REQUEST = "UPDATE_REQUEST";
    public static final String BROADCAST_EMPTY_LIST_REQUEST = "EMPTY_REQUEST";
    public static final String BROADCAST_ERROR_REQ_REQUEST = "ERROR_REQUEST";

    public static final String BROAD_CAST_UPDATE_ROOM = "UPDATE_ROOM";

    public static final String CONTROL_SERVICE = "CONTROL_SERVICE";
    public static final String VALUE_GET_ALL_REQUEST_BY_FACULTY = "GET_ALL_REQ_BY_FACULTY";
    public static final String VALUE_POST_RESPONSE = "POST_RESPONSE";
    public static final String VALUE_GET_ALL_ROOM = "GET_ALL_ROOM";

    public static final String PASS_DATA_ID_REQUEST = "ID_REQUEST";

    private static String URL_GET_ALL_REQUEST = "http://cupcake96uet.hol.es/get_all_request_folow_faculty.php?id=";
    private static String URL_CREATE_RESPONSE = "http://cupcake96uet.hol.es/api/api_create_response.php";

    // response
    public static final String RESPONSE_APPOINTMENT_TIME = "appointmentTime";
    public static final String RESPONSE_DESC = "description";
    public static final String RESPONSE_ID_DOCTOR = "idDoctor";
    public static final String RESPONSE_ID_ROOM = "idRoom";
    public static final String RESPONSE_ID_REQUEST = "idRequest";
    public static final String RESPONSE_APPOINTMENT_TIME_END="appointmentTimeEnd";
    public static final String RESPONSE_DATE = "dateResponse";

    // room
    public static final String ID_FACULTY = "idFaculty";

    private String TAG_REQ_REQUEST = "REQ_REQUEST", TAG_REQ_RESPONSE = "REQ_RESPONSE";

    private ResponseObject responseObject;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.getExtras() != null) {
            String action = intent.getStringExtra(DoctorService.CONTROL_SERVICE);
            ResponseObject responseObject= (ResponseObject) intent.getSerializableExtra(Constants.RESPONSE_OBJECT);
            switch (action) {
                case VALUE_GET_ALL_REQUEST_BY_FACULTY: {
                    //getAllReq(this);
                    int idFaculty = Integer.parseInt(Utils.getValueFromPreferences(Constants.PREFERENCES_ID_FACULTY, this));
                    //getAllRoomFacultyWithDay(this, idFaculty, Utils.getCurrentTime(Utils.VALUES_DATE));
                    break;
                }
                case VALUE_POST_RESPONSE: {
                    postResponse(getApplicationContext(),responseObject);
                    break;
                }
                case VALUE_GET_ALL_ROOM: {
                    break;
                }
            }
        }
        return START_STICKY;
    }

    private static String ID_ROOM_FACULTY = "idFaculty";
    private static String DATE_ROOM = "dateTarget";
    private static String TAG_REQ_ROOM = "REQ_ROOM";
    private static String URL_GET_ALL_ROOM_OF_FACULTY = "http://cupcake96uet.hol.es/api/api_get_room_with_day.php";

    private void postResponse(final Context context, final ResponseObject responseObject) {
        StringRequest strReq =
            new StringRequest(Request.Method.POST, URL_CREATE_RESPONSE, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    String result = response.toString();
                    //                        Log.i(TAG, "onResponse: result + " + result);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            }) {
                /**
                 * @return
                 */
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put(RESPONSE_APPOINTMENT_TIME, responseObject.getAppointmentTime());
                    params.put(RESPONSE_DESC, responseObject.getDescription());
                    params.put(RESPONSE_ID_DOCTOR, responseObject.getIdDoctor() + "");
                    params.put(RESPONSE_ID_REQUEST, responseObject.getIdRequest() + "");
                    params.put(RESPONSE_ID_ROOM, responseObject.getIdRoom() + "");
                    params.put(RESPONSE_DATE, responseObject.getResponseDate());
                    params.put(RESPONSE_APPOINTMENT_TIME_END,responseObject.getApppointmentTimeEnd());

                    return params;
                }

                @Override
                public Priority getPriority() {
                    return Priority.IMMEDIATE;
                }
            };
        AppController.getInstance().addToRequestQueue(strReq, TAG_REQ_RESPONSE);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
