package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.MainActivity;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.R;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.FragmentUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.listener.Listener;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.ui.fragment.InformationFragment;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.ui.fragment.LoginFragment;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.ui.fragment.RegisterFragment;

public class LoginActivity extends BaseActivity implements Listener.listenerLogin, Listener.listenerInformation {

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void initVariables(Bundle saveInstanceState) {

    }

    @Override
    protected void initData(Bundle saveInstanceState) {
        LoginFragment loginFragment = new LoginFragment();
        loginFragment.setListenerLogin(this);
        FragmentUtils.replaceFragment(loginFragment, R.id.frmLogin, "LOGIN", this);
    }

    @Override
    public void showRegister() {
        RegisterFragment registerFragment = new RegisterFragment();
        registerFragment.setListenerInformation(this);
        FragmentUtils.replaceFragment(registerFragment, R.id.frmLogin, "REGISTER", this);
    }

    @Override
    public void showLogin() {

    }

    @Override
    public void startMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void showInformation(String name, String userName, String pass, String birthDay) {
        InformationFragment informationFragment = new InformationFragment(name, userName, pass, birthDay);
        informationFragment.setListenerLogin(this);
        FragmentUtils.replaceFragment(informationFragment, R.id.frmLogin, "INFORMATION", this);
    }

}
