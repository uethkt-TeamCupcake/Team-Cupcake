package cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.R;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.adapter.ListRoomAdapter;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.common.object.RoomObject;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.data.SQLController;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.data.SQLHelper;

/**
 * Created by Dat UET on 3/11/2017.
 */

public class ListRoomFragment extends BaseFragment {

    private ListRoomAdapter listRoomAdapter;
    private RecyclerView recyclerView;
    private SQLController sqlController;
    ArrayList<RoomObject> roomObjects;
    @Override
    protected int getLayoutResource() {
        return R.layout.list_room_fragment;
    }

    @Override
    protected void initVariables(Bundle saveInstanceState, View rootView) {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        sqlController = new SQLController(getActivity());
        recyclerView.setLayoutManager( new LinearLayoutManager(getActivity()));
        roomObjects = new ArrayList<>();
        listRoomAdapter = new ListRoomAdapter(getActivity(),roomObjects);
    }

    @Override
    protected void initData(Bundle saveInstanceState) {
        roomObjects.addAll(sqlController.queryListRoom(SQLHelper.SQL_QUERY_ALL_ROOM));
        recyclerView.setAdapter(listRoomAdapter);
        listRoomAdapter.notifyDataSetChanged();
    }
}
