package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.ui.fragment;


import android.app.ProgressDialog;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.R;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.Constants;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.PostDataUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.ToastUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Utils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.listener.Listener;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends BaseFragment implements Listener.loginStatus {

    private String TAG = "LOGIN FARGMENT";

    private TextInputLayout inputUsername, inputPassword;
    private EditText edtUsername, edtPassword;
    private TextView txtLogin, txtSignUp;
    private ProgressDialog progressDialog;

    private Listener.listenerLogin listenerLogin;
    private CheckBox checkBox;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initVariables(Bundle saveInstanceState, View rootView) {
        inputUsername = (TextInputLayout) rootView.findViewById(R.id.inputUsername);
        inputPassword = (TextInputLayout) rootView.findViewById(R.id.inputPassword);
        edtUsername = (EditText) rootView.findViewById(R.id.edtUsername);
        edtPassword = (EditText) rootView.findViewById(R.id.edtPassword);
        txtLogin = (TextView) rootView.findViewById(R.id.btnLogin);
        txtSignUp = (TextView) rootView.findViewById(R.id.btnSignUp);
        checkBox = (CheckBox) rootView.findViewById(R.id.checkStoreUsername);

    }

    @Override
    protected void initData(Bundle saveInstanceState) {

        if (Utils.getValueFromPreferences(Constants.STORE_USERNAME, getActivity()) != null) {
            edtUsername.setText(Utils.getValueFromPreferences(Constants.STORE_USERNAME, getActivity()));
            checkBox.setChecked(true);
        }


        edtUsername.getBackground().setColorFilter(getResources().getColor(R.color.md_white_1000)
                , PorterDuff.Mode.SRC_IN);
        edtPassword.getBackground().setColorFilter(getResources().getColor(R.color.md_white_1000)
                , PorterDuff.Mode.SRC_IN);

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtUsername.getText().toString();
                String pass = edtPassword.getText().toString();
                if (name.equals("")) {
                    edtUsername.setError("bạn phải nhập tên đăng nhập");
                    edtUsername.setFocusable(true);
                } else if (pass.equals("")) {
                    edtPassword.setError("bạn phải nhập mật khẩu");
                    edtPassword.setFocusable(true);
                } else {
                    if (checkBox.isChecked()) {
                        Utils.setValueToPreferences(Constants.STORE_USERNAME
                                , edtUsername.getText().toString(), getActivity());
                    }
                    PostDataUtils postDataUtils = new PostDataUtils();
                    postDataUtils.setLoginStatus(LoginFragment.this);
                    postDataUtils.login(getActivity(), name, pass);
                }
            }
        });


        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listenerLogin.showRegister();
            }
        });
    }

    @Override
    public void loginSuccess(int id) {
        Utils.setValueToPreferences(Constants.PREFERENCES_LOGIN_ID, id + "", getActivity());
        Utils.setValueToPreferences(Constants.PREFERENCES_LOGIN, Constants.LOGIN_TRUE, getActivity());
        listenerLogin.startMain();
    }

    @Override
    public void loginFail() {

    }

    @Override
    public void loginRequestError() {

    }

    public void setListenerLogin(Listener.listenerLogin listenerLogin) {
        this.listenerLogin = listenerLogin;
    }
}
