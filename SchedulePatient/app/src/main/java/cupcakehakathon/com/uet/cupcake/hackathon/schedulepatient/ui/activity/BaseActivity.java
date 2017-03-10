package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by NgocThai on 10/03/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int getLayoutResource();

    protected abstract void initVariables(Bundle saveInstanceState);

    protected abstract void initData(Bundle saveInstanceState);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        initVariables(savedInstanceState);
        initData(savedInstanceState);
    }

}