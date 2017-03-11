package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.R;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.DialogUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.ToastUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.listener.Listener;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment
    extends BaseFragment
    implements View.OnClickListener {



    private AppCompatEditText edtRegisterName;


    private AppCompatEditText edtRegisterUserName;


    private AppCompatEditText edtRegisterPass;

    private TextInputLayout inputRegisterBirthDay;
    private AppCompatEditText edtRegisterBirthDay;


    private AppCompatEditText edtRegisterAddress;

    private ImageView imgBack;

    private RadioGroup mRadioGroup;
    //private TextInputLayout inputRegisterGender;
    //private AppCompatEditText edtRegisterGender;
    private TextView btnRegister;
    DialogUtils du = new DialogUtils();

    private String name, userName, pass, birthday, address, identityNumber, insuranceCode, gender;
    private boolean checkFirst = true;
    private Listener.listenerInformation listenerInformation;

    @Override
    protected int getLayoutResource() {
        return R.layout.register_fragment;
    }

    @Override
    public void onClick(View v) {
        du.dialogShowDate(getActivity(), "Choose Date", new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePickerDialog view,
                                  int year,
                                  int monthOfYear,
                                  int dayOfMonth) {
                String date = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                edtRegisterBirthDay.setText(date);
            }
        });
    }

    private void findViews(View rootView) {


        edtRegisterName = (AppCompatEditText) rootView.findViewById(R.id.edtRegisterName);

        edtRegisterUserName = (AppCompatEditText) rootView.findViewById(R.id.edtRegisterUserName);

        edtRegisterPass = (AppCompatEditText) rootView.findViewById(R.id.edtRegisterPass);

        inputRegisterBirthDay = (TextInputLayout) rootView.findViewById(R.id.inputRegisterBirthDay);

        edtRegisterBirthDay = (AppCompatEditText) rootView.findViewById(R.id.edtRegisterBirthDay);

        edtRegisterAddress = (AppCompatEditText) rootView.findViewById(R.id.edtRegisterAddress);

        mRadioGroup = (RadioGroup) rootView.findViewById(R.id.rdGender);

        imgBack = (ImageView) rootView.findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        //inputRegisterGender = (TextInputLayout) rootView.findViewById(R.id.inputRegisterGender);
        //edtRegisterGender = (AppCompatEditText) rootView.findViewById(R.id.edtRegisterGender);

        btnRegister = (TextView) rootView.findViewById(R.id.btnRegister);
    }

    @Override
    protected void initVariables(Bundle saveInstanceState, View rootView) {
        findViews(rootView);
    }

    @Override
    protected void initData(Bundle saveInstanceState) {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = edtRegisterName.getText().toString();
                userName = edtRegisterUserName.getText().toString();
                pass = edtRegisterPass.getText().toString();
                birthday = edtRegisterBirthDay.getText().toString();
                if (name.matches("")
                    || userName.matches("")
                    || pass.matches("")
                    || birthday.matches("")) {
                    ToastUtils.quickToast(getActivity(), "Please input missing");
                } else {
                    listenerInformation.showInformation(name, userName, pass, birthday);
                }
            }
        });
        inputRegisterBirthDay.setClickable(true);
        edtRegisterBirthDay.setClickable(true);
        edtRegisterBirthDay.setOnClickListener(this);
        inputRegisterBirthDay.setOnClickListener(this);


    }

    public void setListenerInformation(Listener.listenerInformation listenerInformation) {
        this.listenerInformation = listenerInformation;
    }
}
