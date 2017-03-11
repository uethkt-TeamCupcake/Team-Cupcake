package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.model.UrlTileProvider;

import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.MainActivity;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.R;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.FragmentUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.Constants;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Utils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.listener.Listener;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.ui.fragment.InformationFragment;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.ui.fragment.LoginFragment;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.ui.fragment.RegisterFragment;

public class LoginActivity extends BaseActivity
        implements Listener.listenerLogin, Listener.listenerInformation {

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void initVariables(Bundle saveInstanceState) {

    }

    @Override
    protected void initData(Bundle saveInstanceState) {

        if (Utils.getValueFromPreferences(Constants.PREFERENCES_LOGIN, this) == null) {
            Utils.setValueToPreferences(Constants.PREFERENCES_LOGIN, Constants.LOGIN_FALSE, this);
        }

        if (Utils.getValueFromPreferences(Constants.PREFERENCES_LOGIN, this).equalsIgnoreCase(Constants.LOGIN_TRUE)) {
            startMain();
        }

        LoginFragment loginFragment = new LoginFragment();
        loginFragment.setListenerLogin(this);
        FragmentUtils.replaceFragment(loginFragment, R.id.frmLogin, Constants.STACK_LOGIN, this);
    }

    @Override
    public void showRegister() {
        RegisterFragment registerFragment = new RegisterFragment();
        registerFragment.setListenerInformation(this);
        registerFragment.setListenerLogin(this);
        FragmentUtils.replaceFragment(registerFragment, R.id.frmLogin, Constants.STACK_REGISTER, this);
    }

    @Override
    public void showLogin() {
        LoginFragment loginFragment = new LoginFragment();
        loginFragment.setListenerLogin(this);
        FragmentUtils.replaceFragment(loginFragment, R.id.frmLogin, Constants.STACK_LOGIN, this);
    }

    @Override
    public void startMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showInformation(String name, String userName, String pass, String birthDay) {
        InformationFragment informationFragment = new InformationFragment(name, userName, pass, birthDay);
        informationFragment.setListenerLogin(this);
        FragmentUtils.replaceFragment(informationFragment, R.id.frmLogin, Constants.STACK_INFORMATION, this);
    }

}
