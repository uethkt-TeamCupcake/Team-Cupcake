package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.R;

public class ListHistoryActivity extends BaseActivity {
    private Toolbar toolbar;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_list_history;
    }

    @Override
    protected void initVariables(Bundle saveInstanceState) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    protected void initData(Bundle saveInstanceState) {
        setSupportActionBar(toolbar);
    }

}
