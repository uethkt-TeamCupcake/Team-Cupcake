package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.adapter.FacultyAdapter;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.adapter.HospitalAdapter;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.listener.Listener;

/**
 * Created by Luong Tran on 3/11/2017.
 */

public class RecycleUtils {

    public static final void showListRcv(RecyclerView mRecycleView,
                                         HospitalAdapter adapter,
                                         Listener.listenHospital listenHospital,
                                         Context context) {
        LinearLayoutManager linearLayoutManager =
            new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setLayoutManager(linearLayoutManager);
        mRecycleView.setItemAnimator(new DefaultItemAnimator());
        mRecycleView.setAdapter(adapter);
        adapter.setListenHospital(listenHospital);
        adapter.notifyDataSetChanged();
    }

    public static final void showListRcv(RecyclerView mRecycleView,
                                         FacultyAdapter adapter,
                                         Listener.listenFaculty listenFaculty,
                                         Context context) {
        LinearLayoutManager linearLayoutManager =
            new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setLayoutManager(linearLayoutManager);
        mRecycleView.setItemAnimator(new DefaultItemAnimator());
        mRecycleView.setAdapter(adapter);
        adapter.setListenFaculty(listenFaculty);
        adapter.notifyDataSetChanged();
    }
}
