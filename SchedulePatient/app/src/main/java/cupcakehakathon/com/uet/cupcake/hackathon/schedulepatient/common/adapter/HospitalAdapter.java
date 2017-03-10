package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.adapter;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.andexert.library.RippleView;
import com.nostra13.universalimageloader.core.ImageLoader;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.R;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.listener.Listener;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.object.HospitalObject;
import java.util.ArrayList;
import jp.wasabeef.recyclerview.animators.holder.AnimateViewHolder;

/**
 * Created by Luong Tran on 3/11/2017.
 */

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.ViewHolder> {

    private ArrayList<HospitalObject> lsHospital;
    private Listener.listenHospital listenHospital;
    private Context context;

    public class ViewHolder
        extends RecyclerView.ViewHolder
        implements AnimateViewHolder {

        private RippleView rvHospital;
        private ImageView imgItemHospital;
        private TextView txtItemHospitalName, txtItemHospitalPhone, txtItemHospitalAddress;
        private RatingBar mRatingBar;

        public ViewHolder(View v) {
            super(v);
            rvHospital = (RippleView) v.findViewById(R.id.rvHospital);
            imgItemHospital = (ImageView) v.findViewById(R.id.imgItemHospital);
            txtItemHospitalName = (TextView) v.findViewById(R.id.txtItemHospitalName);
            txtItemHospitalPhone = (TextView) v.findViewById(R.id.txtItemHospitalPhone);
            txtItemHospitalAddress = (TextView) v.findViewById(R.id.txtItemHospitalAddress);
            mRatingBar = (RatingBar) v.findViewById(R.id.ratingBar);
            txtItemHospitalName.setSelected(true);
            txtItemHospitalAddress.setSelected(true);
        }

        @Override
        public void preAnimateAddImpl(RecyclerView.ViewHolder holder) {
            ViewCompat.setTranslationY(itemView, -itemView.getHeight() * 0.3f);
            ViewCompat.setAlpha(itemView, 0);
        }

        @Override
        public void preAnimateRemoveImpl(RecyclerView.ViewHolder holder) {

        }

        @Override
        public void animateAddImpl(RecyclerView.ViewHolder holder, ViewPropertyAnimatorListener listener) {
            ViewCompat.animate(itemView)
                .translationY(0)
                .alpha(1)
                .setDuration(300)
                .setListener(listener)
                .start();
        }

        @Override
        public void animateRemoveImpl(RecyclerView.ViewHolder holder, ViewPropertyAnimatorListener listener) {
            ViewCompat.animate(itemView)
                .translationY(-itemView.getHeight() * 0.3f)
                .alpha(0)
                .setDuration(300)
                .setListener(listener)
                .start();
        }
    }

    public HospitalAdapter(ArrayList<HospitalObject> ls, Context context) {
        this.context = context;
        this.lsHospital = ls;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =
            LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hospital, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        HospitalObject hospitalObject = lsHospital.get(position);
        holder.txtItemHospitalName.setText(hospitalObject.getName());
        try {
            ImageLoader.getInstance()
                .displayImage(hospitalObject.getImage(), holder.imgItemHospital);
        } catch (Exception e) {
            e.printStackTrace();
        }
        holder.txtItemHospitalAddress.setText(hospitalObject.getAddress());
        holder.txtItemHospitalPhone.setText(hospitalObject.getPhone().toString());
        holder.mRatingBar.setRating((float) hospitalObject.getRate());
        holder.rvHospital.setRippleDuration(250);
        holder.rvHospital.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                listenHospital.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lsHospital.size();
    }

    public ArrayList<HospitalObject> getLsHospital() {
        return lsHospital;
    }

    public void setLsHospital(ArrayList<HospitalObject> lsHospital) {
        this.lsHospital = lsHospital;
    }

    public void setListenHospital(Listener.listenHospital listenHospital) {
        this.listenHospital = listenHospital;
    }
}
