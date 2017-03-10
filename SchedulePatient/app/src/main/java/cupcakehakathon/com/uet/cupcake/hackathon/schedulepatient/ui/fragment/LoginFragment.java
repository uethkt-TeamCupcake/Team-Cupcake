package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.R;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.PostDataUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.ToastUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.listener.Listener;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends BaseFragment implements Listener.loginStatus {

    private String TAG = "LOGIN FARGMENT";

    private TextInputLayout inputUsername, inputPassword;
    private EditText edtUsername, edtPassword;
    private TextView txtLogin;

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
        edtUsername = (EditText) rootView.findViewById(R.id.edtPassword);
        edtPassword = (EditText) rootView.findViewById(R.id.edtPassword);
        txtLogin = (TextView) rootView.findViewById(R.id.btnLogin);
    }

    @Override
    protected void initData(Bundle saveInstanceState) {
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtUsername.getText().toString();
                String pass = edtPassword.getText().toString();
                if (name.matches("")) {
                    ToastUtils.quickToast(getActivity(), "Enter your name");
                } else if (pass.matches("")) {
                    ToastUtils.quickToast(getActivity(), "Enter pass");
                } else {
                    PostDataUtils postDataUtils = new PostDataUtils();
                    postDataUtils.setLoginStatus(LoginFragment.this);
                    postDataUtils.login(getActivity(), name, pass);
                }
            }
        });
    }

    @Override
    public void loginSuccess(int id) {
        Log.i(TAG, "loginSuccess: id " + id);
    }

    @Override
    public void loginFail() {

    }

    @Override
    public void loginRequestError() {

    }
}
