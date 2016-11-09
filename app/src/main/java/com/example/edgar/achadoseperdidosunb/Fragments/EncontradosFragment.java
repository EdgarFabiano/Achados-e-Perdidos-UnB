package com.example.edgar.achadoseperdidosunb.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.edgar.achadoseperdidosunb.MainActivity;
import com.example.edgar.achadoseperdidosunb.ObjetoAdapter;
import com.example.edgar.achadoseperdidosunb.R;

/**
 * Created by edgar on 02/11/2016.
 */

public class EncontradosFragment extends Fragment {
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_encontrados, container, false);
        listView = (ListView) view.findViewById(R.id.list_view);
        

        //Inflate the layout for this fragment
        return view;

    }

}
