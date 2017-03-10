package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.ui.fragment;

import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by NgocThai on 10/03/2017.
 */

public abstract class BaseFragment extends Fragment {

    protected abstract int getLayoutResource();

    protected abstract void initVariables(Bundle saveInstanceState, View rootView);

    protected abstract void initData(Bundle saveInstanceState);

    public BroadcastReceiver mReceiver = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutResource(), null, false);
        initVariables(savedInstanceState, rootView);
        initData(savedInstanceState);
        return rootView;
    }


}

