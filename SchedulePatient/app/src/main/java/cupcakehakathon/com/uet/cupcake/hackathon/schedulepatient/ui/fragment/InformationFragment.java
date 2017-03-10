package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.R;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.Constrants;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.PostDataUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Utils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.listener.Listener;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.object.PatientObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformationFragment extends BaseFragment implements Listener.registerStatus {

    private TextInputLayout inputRegisterIdentity;
    private AppCompatEditText edtRegisterIdentity;
    private TextInputLayout inputRegisterInsurance;
    private AppCompatEditText edtRegisterInsurance;
    private TextInputLayout inputRegisterAddress;
    private AppCompatEditText edtRegisterAddress;
    private TextInputLayout inputRegisterGender;
    private AppCompatEditText edtRegisterGender;
    private TextView btnRegister;

    private String name, userName, pass, birthday, address, identityNumber, insuranceCode, gender;

    private Listener.listenerLogin listenerLogin;


    public InformationFragment(String name, String userName, String pass, String birthday) {
        this.name = name;
        this.userName = userName;
        this.pass = pass;
        this.birthday = birthday;
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_information;
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
                insuranceCode = edtRegisterInsurance.getText().toString();
                identityNumber = edtRegisterIdentity.getText().toString();
                address = edtRegisterAddress.getText().toString();
                gender = edtRegisterGender.getText().toString();
                PostDataUtils postDataUtils = new PostDataUtils();
                postDataUtils.setRegisterStatus(InformationFragment.this);
                postDataUtils.register(getActivity(), new PatientObject(name, userName, Integer.parseInt(gender), birthday, identityNumber, insuranceCode, pass, address));
            }
        });
    }

    private void findViews(View rootView) {
        inputRegisterIdentity = (TextInputLayout) rootView.findViewById(R.id.inputRegisterIdentity);
        edtRegisterIdentity = (AppCompatEditText) rootView.findViewById(R.id.edtRegisterIdentity);
        inputRegisterInsurance = (TextInputLayout) rootView.findViewById(R.id.inputRegisterInsurance);
        edtRegisterInsurance = (AppCompatEditText) rootView.findViewById(R.id.edtRegisterInsurance);
        inputRegisterAddress = (TextInputLayout) rootView.findViewById(R.id.inputRegisterAddress);
        edtRegisterAddress = (AppCompatEditText) rootView.findViewById(R.id.edtRegisterAddress);
        inputRegisterGender = (TextInputLayout) rootView.findViewById(R.id.inputRegisterGender);
        edtRegisterGender = (AppCompatEditText) rootView.findViewById(R.id.edtRegisterGender);
        btnRegister = (TextView) rootView.findViewById(R.id.btnRegister);
    }

    @Override
    public void registerSuccess(int id) {
        Utils.setValueToPreferences(Constrants.PRERERENCES_ID_PATIENT, id + "", getActivity());
        Utils.setValueToPreferences(Constrants.PREFERENCES_LOGIN, Constrants.LOGIN_TRUE, getActivity());
        listenerLogin.startMain();
    }

    @Override
    public void registerExist() {

    }

    @Override
    public void registerFail() {

    }

    public void setListenerLogin(Listener.listenerLogin listenerLogin) {
        this.listenerLogin = listenerLogin;
    }
}
