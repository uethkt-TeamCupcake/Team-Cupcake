package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends BaseFragment {

    private TextInputLayout inputRegisterName;
    private AppCompatEditText edtRegisterName;
    private TextInputLayout inputRegisterEmail;
    private AppCompatEditText edtRegisterEmail;
    private TextInputLayout inputRegisterPass;
    private AppCompatEditText edtRegisterPass;
    private TextInputLayout inputRegisterBirthDay;
    private AppCompatEditText edtRegisterBirthDay;
    private TextView btnRegister;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_register;
    }

    @Override
    protected void initVariables(Bundle saveInstanceState, View rootView) {
        inputRegisterName = (TextInputLayout) rootView.findViewById(R.id.inputRegisterName);
        edtRegisterName = (AppCompatEditText) rootView.findViewById(R.id.edtRegisterName);
        inputRegisterEmail = (TextInputLayout) rootView.findViewById(R.id.inputRegisterEmail);
        edtRegisterEmail = (AppCompatEditText) rootView.findViewById(R.id.edtRegisterEmail);
        inputRegisterPass = (TextInputLayout) rootView.findViewById(R.id.inputRegisterPass);
        edtRegisterPass = (AppCompatEditText) rootView.findViewById(R.id.edtRegisterPass);
        inputRegisterBirthDay = (TextInputLayout) rootView.findViewById(R.id.inputRegisterBirthDay);
        edtRegisterBirthDay = (AppCompatEditText) rootView.findViewById(R.id.edtRegisterBirthDay);
        btnRegister = (TextView) rootView.findViewById(R.id.btnRegister);
    }

    @Override
    protected void initData(Bundle saveInstanceState) {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtRegisterName.getText().toString();
                String email = edtRegisterEmail.getText().toString();
                String pass = edtRegisterPass.getText().toString();
                String birthDay = edtRegisterBirthDay.getText().toString();

            }
        });
    }

}
