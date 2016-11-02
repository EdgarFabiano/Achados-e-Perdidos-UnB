package com.example.edgar.achadoseperdidosunb.Fragments;

import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.edgar.achadoseperdidosunb.R;

/**
 * Created by edgar on 02/11/2016.
 */

public class HomeFragment extends Fragment {
    Button perdi_bt, achei_bt;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//        //Lida com a ação do botão de encontar um objeto
//        achei_bt = (Button)findViewById(R.id.button_achei);
//        achei_bt.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Devolva então", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//
//        });
//
//        //Lida com a ação do botão de perder um objeto
//        perdi_bt = (Button)findViewById(R.id.button_perdi);
//        perdi_bt.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Se lascou", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//
//        });

        //Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

}