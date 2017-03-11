package cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.adapter.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.R;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.common.object.RoomObject;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.ui.activity.DetailRequestActivity;

/**
 * Created by Dat UET on 3/11/2017.
 */

public class RoomHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private Context context;
    private ArrayList<RoomObject> roomObjects;
    private TextView tvTime;
    private TextView tvName;

    public RoomHolder(View itemView) {
        super(itemView);
        tvTime = (TextView) itemView.findViewById(R.id.tvTime);
        tvName = (TextView) itemView.findViewById(R.id.tvName);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == itemView){
            DetailRequestActivity.positionSelected = roomObjects.get(getAdapterPosition()).getId();
            Log.e("id",getAdapterPosition()+"");
        }
    }
//    public void changeSelectedPosition(int index) {
//        .notifyItemChanged(songAdapter.getSelectedPosition());
//        selectedPosition = index;
//        songAdapter.setSelectedPosition(selectedPosition);
//        songAdapter.notifyItemChanged(selectedPosition);
//
//    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public TextView getTvTime() {
        return tvTime;
    }

    public void setTvTime(TextView tvTime) {
        this.tvTime = tvTime;
    }

    public TextView getTvName() {
        return tvName;
    }

    public void setTvName(TextView tvName) {
        this.tvName = tvName;
    }

    public ArrayList<RoomObject> getRoomObjects() {
        return roomObjects;
    }

    public void setRoomObjects(ArrayList<RoomObject> roomObjects) {
        this.roomObjects = roomObjects;
    }
}

