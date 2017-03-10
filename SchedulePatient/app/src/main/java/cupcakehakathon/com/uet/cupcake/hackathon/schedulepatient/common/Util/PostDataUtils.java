package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.listener.Listener;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.object.PatientObject;

/**
 * Created by NgocThai on 10/03/2017.
 */

public class PostDataUtils {

    private String TAG = "POST DATA";

    private static String RESPONSE_SUCCESS = "success";
    private static String RESPONSE_LOGIN_ERROR = "ERROR";
    private static String RESPONSE_FAIL = "fail";

    private static String USERNAME = "userName";
    private static String PASSWORD = "passWord";
    private Listener.loginStatus loginStatus;
    public static final String URL_LOGIN = "http://datuet.esy.es/api/api_check_login_patient.php";

    public void login(final Context context, final String username, final String password) {
        StringRequest stringRequest =
                new StringRequest(Request.Method.POST, URL_LOGIN, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String result = response.toString();
                        Log.i(TAG, "onResponse: result " + result);
                        try {
                            JSONArray arr = new JSONArray(result);
                            JSONObject js = arr.getJSONObject(0);
                            String status = js.getString("message");
                            int id = js.getInt("id");
                            if (status.equalsIgnoreCase(RESPONSE_SUCCESS)) {
                                loginStatus.loginSuccess(id);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            loginStatus.loginFail();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loginStatus.loginRequestError();
                    }
                }) {
                    /**
                     * @return
                     */
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put(USERNAME, username);
                        params.put(PASSWORD, password);
                        return params;
                    }

                    @Override
                    public Priority getPriority() {
                        return Priority.IMMEDIATE;
                    }
                };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }


    private Listener.registerStatus registerStatus;
    public static final String URL_REGISTER = "http://datuet.esy.es/api/api_create_patient.php";
    private static String BIRTHDAY = "birthday";
    private static String GENDER = "gender";
    private static String IDENTITY_NUMBER = "identityNumber";
    private static String INSURANCE_CODE = "insuranceCode";
    private static String ADDRESS = "address";
    private static String NAME = "name";

    public void register(final Context context, final PatientObject patientObject) {
        StringRequest stringRequest =
                new StringRequest(Request.Method.POST, URL_REGISTER, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String result = response.toString();
                        Log.i(TAG, "onResponse: " + result);
                        try {
                            JSONArray arr = new JSONArray(result);
                            JSONObject js = arr.getJSONObject(0);
                            String status = js.getString("message");
                            int id = js.getInt("id");
                            if (status.equalsIgnoreCase(RESPONSE_SUCCESS)) {
                                registerStatus.registerSuccess(id);
                            } else if (status.equalsIgnoreCase(RESPONSE_FAIL)) {
                                registerStatus.registerExist();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i(TAG, "onErrorResponse: error " + error.toString());
                        registerStatus.registerFail();
                    }
                }) {
                    /**
                     * @return
                     */
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        params.put(USERNAME, patientObject.getUserName());
                        params.put(PASSWORD, patientObject.getPassWord());
                        params.put(BIRTHDAY, patientObject.getBirthDay());
                        params.put(GENDER, patientObject.getGender() + "");
                        params.put(IDENTITY_NUMBER, patientObject.getIdentityNumber());
                        params.put(INSURANCE_CODE, patientObject.getInsuranceCode());
                        params.put(ADDRESS, patientObject.getAddress());
                        params.put(NAME, patientObject.getName());
                        return params;
                    }

                    @Override
                    public Priority getPriority() {
                        return Priority.IMMEDIATE;
                    }
                };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }


    public void setLoginStatus(Listener.loginStatus loginStatus) {
        this.loginStatus = loginStatus;
    }

    public void setRegisterStatus(Listener.registerStatus registerStatus) {
        this.registerStatus = registerStatus;
    }
}
