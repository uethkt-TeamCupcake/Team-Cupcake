package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.R;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.Constants;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.DialogUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.PostDataUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.ToastUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Utils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.listener.Listener;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.object.RequestObject;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.data.SQLController;

/**
 * Created by Luong Tran on 3/11/2017.
 */

public class SendRequestActivity extends BaseActivity implements Listener.requestStatus {

    private String TAG = "REQUEST";

    private EditText edtSymptom, edtDate;
    private Button btnSend;

    private String targetTime = "";
    //private Toolbar toolbar;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_send_request;
    }

    @Override
    protected void initVariables(Bundle saveInstanceState) {
        edtSymptom = (EditText) findViewById(R.id.edtSymptom);
        btnSend = (Button) findViewById(R.id.btnSend);
        edtDate = (EditText) findViewById(R.id.edtDate);
        //toolbar = (Toolbar) findViewById(R.id.toolbarMain);
    }

    @Override
    protected void initData(Bundle saveInstanceState) {
        //setSupportActionBar(toolbar);
        //toolbar.setTitle("Send Request");

        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtils.dialogShowDate(SendRequestActivity.this, "Choose time", new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                        targetTime = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                        edtDate.setText(targetTime);
                    }
                });
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (targetTime.equalsIgnoreCase("")) {
                    ToastUtils.quickToast(SendRequestActivity.this, "Choose time first");
                } else {
                    String timeRequest = Utils.getCurrentTime(Utils.VALUES_DATE) + " " + Utils.getCurrentTime(
                        Utils.VALUES_TIME);
                    String symptom = edtSymptom.getText().toString();
                    PostDataUtils postDataUtils = new PostDataUtils();
                    postDataUtils.setRequestStatus(SendRequestActivity.this);
                    String idPatient = Utils.getValueFromPreferences(Constants.PREFERENCES_LOGIN_ID,
                                                                     SendRequestActivity.this);
                    RequestObject requestObject = new RequestObject(Integer.parseInt(idPatient),
                                                                    symptom,
                                                                    timeRequest,
                                                                    1,
                                                                    0,
                                                                    targetTime);
                    postDataUtils.sendRequest(SendRequestActivity.this,
                                              new RequestObject(Integer.parseInt(idPatient),
                                                                symptom,
                                                                timeRequest,
                                                                1,
                                                                0,
                                                                targetTime));
                    SQLController sqlController = new SQLController(SendRequestActivity.this);
                    boolean insert = sqlController.insertRequest(requestObject);
                    insert = false;
                }
            }
        });

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
}