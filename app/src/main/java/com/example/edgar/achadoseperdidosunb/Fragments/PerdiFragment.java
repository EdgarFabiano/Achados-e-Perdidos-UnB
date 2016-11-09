package com.example.edgar.achadoseperdidosunb.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cleveroad.fanlayoutmanager.FanLayoutManager;
import com.cleveroad.fanlayoutmanager.FanLayoutManagerSettings;
import com.example.edgar.achadoseperdidosunb.MainActivity;
import com.example.edgar.achadoseperdidosunb.ObjetoAdapter;
import com.example.edgar.achadoseperdidosunb.ObjetoInfo;
import com.example.edgar.achadoseperdidosunb.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edgar on 02/11/2016.
 */

public class PerdiFragment extends Fragment {
    RecyclerView recList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_perdi, container, false);

        ObjetoAdapter objetoAdapter = new ObjetoAdapter(MainActivity.lista);

        recList = (RecyclerView) view.findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        recList.setAdapter(objetoAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        //Inflate the layout for this fragment
        return view;
    }

}
