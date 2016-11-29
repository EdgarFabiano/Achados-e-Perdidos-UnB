package com.example.edgar.achadoseperdidosunb.Fragments;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.edgar.achadoseperdidosunb.MainActivity;
import com.example.edgar.achadoseperdidosunb.ObjetoInfo;
import com.example.edgar.achadoseperdidosunb.R;

/**
 * Created by edgar on 02/11/2016.
 */

public class EncontreiFragment extends Fragment {
    TextView title, local, desc;
    ProgressDialog progressDialog;
    Spinner dept;
    Button cadastrar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_encontrei, container, false);

        title = (TextView) view.findViewById(R.id.title);
        dept  = (Spinner) view.findViewById(R.id.spinner);
        local  = (TextView) view.findViewById(R.id.local);
        desc  = (TextView) view.findViewById(R.id.desc);
        cadastrar = (Button) view.findViewById(R.id.button_ok_registro);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjetoInfo objeto = new ObjetoInfo(title.getText().toString()
                        , desc.getText().toString()
                        , dept.getSelectedItem().toString()
                        , local.getText().toString());

                MainActivity.lista.add(0, objeto);
                MainActivity.minhas.add(0, objeto);

                Fragment fragment = null;
                Class fragmentClass = EncontradosFragment.class;

                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Insert the fragment by replacing any existing fragment
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();


            }

        });

        //Inflate the layout for this fragment
        return view;
    }



}
