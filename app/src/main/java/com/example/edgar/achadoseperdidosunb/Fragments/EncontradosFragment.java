package com.example.edgar.achadoseperdidosunb.Fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.edgar.achadoseperdidosunb.ListaAdapter;
import com.example.edgar.achadoseperdidosunb.MainActivity;
import com.example.edgar.achadoseperdidosunb.ObjetoInfo;
import com.example.edgar.achadoseperdidosunb.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edgar on 02/11/2016.
 */

public class EncontradosFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_encontrados, container, false);


        setListAdapter(new ListaAdapter(getActivity().getApplicationContext(), MainActivity.minhas));
        

        //Inflate the layout for this fragment
        return view;

    }

}
