package cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.R;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.common.object.RoomObject;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.utils.Constants;

/**
 * Created by Dat UET on 3/11/2017.
 */

public class DetailRoomActivity extends BaseActivity {

    private TextView tvTimeStartEnd;
    private TextView tvTimeAvailable;
    private TextView tvCurrentLimit;
    private TextView tvTitle;
    RoomObject roomObject;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_detail_room;
    }

    @Override
    protected void initVariables(Bundle saveInstanceState) {
        tvTimeStartEnd = (TextView) findViewById(R.id.tvTimeStartEnd);
        tvTimeAvailable = (TextView) findViewById(R.id.tvTimeAvailable);
        tvCurrentLimit = (TextView) findViewById(R.id.tvCurrentLimit);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        Intent intent = getIntent();
        roomObject= (RoomObject) intent.getSerializableExtra(Constants.ROOM_OBJECT);
    }

    @Override
    protected void initData(Bundle saveInstanceState) {
        tvTimeStartEnd.setText(roomObject.getTimeStart()+":"+roomObject.getTimeEnd());
        tvTimeAvailable.setText(roomObject.getTimeAvailable());
        tvCurrentLimit.setText(roomObject.getCurrentLimit()+"/"+roomObject.getLimitOneDay());
        tvTitle.setText(roomObject.getName());
    }


}

