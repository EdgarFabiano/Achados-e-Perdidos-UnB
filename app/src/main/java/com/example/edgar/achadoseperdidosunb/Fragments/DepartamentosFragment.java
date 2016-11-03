package com.example.edgar.achadoseperdidosunb.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cleveroad.fanlayoutmanager.FanLayoutManager;
import com.cleveroad.fanlayoutmanager.FanLayoutManagerSettings;
import com.example.edgar.achadoseperdidosunb.R;

/**
 * Created by edgar on 02/11/2016.
 */

public class DepartamentosFragment extends Fragment {
    FanLayoutManager fanLayoutManager;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_departamentos, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        FanLayoutManagerSettings fanLayoutManagerSettings = FanLayoutManagerSettings
                .newBuilder(getContext())
                .withFanRadius(true)
                .withAngleItemBounce(5)
                .withViewWidthDp(120)
                .withViewHeightDp(160)
                .build();

        fanLayoutManager = new FanLayoutManager(getContext(), fanLayoutManagerSettings);
        recyclerView.setLayoutManager(fanLayoutManager);

        //Inflate the layout for this fragment
        return view;

    }

}
