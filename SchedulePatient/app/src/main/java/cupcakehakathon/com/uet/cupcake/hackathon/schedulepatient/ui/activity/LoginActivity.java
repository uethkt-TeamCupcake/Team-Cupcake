package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.ui.activity;

import android.os.Bundle;

import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.R;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.FragmentUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.ui.fragment.LoginFragment;

public class LoginActivity extends BaseActivity {

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
        FragmentUtils.replaceFragment(loginFragment, R.id.frmLogin, "LOGIN", this);
    }

}
