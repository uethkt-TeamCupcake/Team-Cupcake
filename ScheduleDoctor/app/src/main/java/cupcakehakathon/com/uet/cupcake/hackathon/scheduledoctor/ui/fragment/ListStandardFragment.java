package cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListStandardFragment extends Fragment {


    public ListStandardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_standard, container, false);
    }

}
