package cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.common.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.R;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.common.object.RequestObject;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.ui.activity.DetailRequestActivity;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.utils.Constants;

/**
 * Created by Dat UET on 3/10/2017.
 */

public class RequestHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private Context context;
    private ArrayList<RequestObject> requestObjects;
    private ImageView btnOption;
    private TextView tvName;
    private TextView tvBirthday;
    private TextView tvAddress;

    public RequestHolder(View itemView) {
        super(itemView);
        btnOption = (ImageView) itemView.findViewById(R.id.btnOption);
        tvName = (TextView) itemView.findViewById(R.id.tvName);
        tvBirthday = (TextView) itemView.findViewById(R.id.tvBirthday);
        tvAddress = (TextView) itemView.findViewById(R.id.tvAddress);
        itemView.setOnClickListener(this);
        btnOption.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnOption:
                break;
            default:
                Intent intent = new Intent(context, DetailRequestActivity.class);
                intent.putExtra(Constants.REQUEST_OBJECT, requestObjects.get(getAdapterPosition()));
                context.startActivity(intent);
                break;
        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ImageView getBtnOption() {
        return btnOption;
    }

    public void setBtnOption(ImageView btnOption) {
        this.btnOption = btnOption;
    }

    public TextView getTvName() {
        return tvName;
    }

    public void setTvName(TextView tvName) {
        this.tvName = tvName;
    }

    public TextView getTvBirthday() {
        return tvBirthday;
    }

    public void setTvBirthday(TextView tvBirthday) {
        this.tvBirthday = tvBirthday;
    }

    public TextView getTvAddress() {
        return tvAddress;
    }

    public void setTvAddress(TextView tvAddress) {
        this.tvAddress = tvAddress;
    }

    public ArrayList<RequestObject> getRequestObjects() {
        return requestObjects;
    }

    public void setRequestObjects(ArrayList<RequestObject> requestObjects) {
        this.requestObjects = requestObjects;
    }
}