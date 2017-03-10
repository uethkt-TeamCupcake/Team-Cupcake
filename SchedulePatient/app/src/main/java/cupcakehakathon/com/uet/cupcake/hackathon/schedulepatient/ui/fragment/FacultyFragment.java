package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.R;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.RecycleUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.ToastUtils;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.adapter.FacultyAdapter;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.listener.Listener;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.object.FacultyObject;
import java.util.ArrayList;

/**
 * Created by Luong Tran on 3/11/2017.
 */

public class FacultyFragment
    extends BaseFragment {

    private ArrayList<FacultyObject> lsFaculty;
    private FacultyAdapter adapter;
    private RecyclerView recyclerView;

    public FacultyFragment(ArrayList<FacultyObject> ls) {
        this.lsFaculty = ls;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_faculty;
    }

    @Override
    protected void initVariables(Bundle saveInstanceState, View rootView) {

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rcvFaculty);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void initData(Bundle saveInstanceState) {
        adapter = new FacultyAdapter(lsFaculty, getActivity());
        RecycleUtils.showListRcv(recyclerView, adapter, new Listener.listenFaculty() {
            @Override
            public void onClick(int id) {
                ToastUtils.quickToast(getActivity(), "ID = " + id);
            }
        }, getActivity());
    }
}

