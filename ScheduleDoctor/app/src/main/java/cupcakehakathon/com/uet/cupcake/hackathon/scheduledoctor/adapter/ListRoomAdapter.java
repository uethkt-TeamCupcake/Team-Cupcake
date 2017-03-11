package cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.R;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.adapter.holder.RoomHolder;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.common.object.RoomObject;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.ui.activity.DetailRequestActivity;

/**
 * Created by Dat UET on 3/11/2017.
 */

public class ListRoomAdapter extends RecyclerView.Adapter<RoomHolder> {

    private Context context;
    private ArrayList<RoomObject> roomObjects;

    public ListRoomAdapter(Context context, ArrayList<RoomObject> roomObjects) {
        this.context = context;
        this.roomObjects = roomObjects;
    }

    @Override
    public RoomHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.room_item,parent,false);
        RoomHolder roomHolder = new RoomHolder(view);
        roomHolder.setContext(context);
        roomHolder.setRoomObjects(roomObjects);
        return roomHolder;
    }
    @Override
    public void onBindViewHolder(RoomHolder holder, int position) {
        RoomObject roomObject = roomObjects.get(position);
        if(roomObject.getId() == DetailRequestActivity.positionSelected){
            holder.getTvName().setTextColor(ContextCompat.getColor(context,R.color.colorPrimary));
            holder.getTvTime().setTextColor(ContextCompat.getColor(context,R.color.colorPrimary));
        } else {
            holder.getTvName().setTextColor(ContextCompat.getColor(context,android.R.color.black));
            holder.getTvTime().setTextColor(ContextCompat.getColor(context,android.R.color.black));
        }
        holder.getTvName().setText(roomObject.getName());
        holder.getTvTime().setText(roomObject.getTimeAvailable());
    }

    @Override
    public int getItemCount() {
        return roomObjects.size();
    }
}
