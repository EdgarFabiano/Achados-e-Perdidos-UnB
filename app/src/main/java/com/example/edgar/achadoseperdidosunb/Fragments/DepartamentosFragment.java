package com.example.edgar.achadoseperdidosunb.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cleveroad.fanlayoutmanager.FanLayoutManager;
import com.cleveroad.fanlayoutmanager.FanLayoutManagerSettings;
import com.example.edgar.achadoseperdidosunb.ObjetoAdapter;
import com.example.edgar.achadoseperdidosunb.ObjetoInfo;
import com.example.edgar.achadoseperdidosunb.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edgar on 02/11/2016.
 */

public class DepartamentosFragment extends Fragment {
    FanLayoutManager fanLayoutManager;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_departamentos, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.cardList);

        FanLayoutManagerSettings fanLayoutManagerSettings = FanLayoutManagerSettings
                .newBuilder(getContext())
                .withFanRadius(true)
                .withAngleItemBounce(5)
                .withViewWidthDp(120)
                .withViewHeightDp(160)
                .build();

        fanLayoutManager = new FanLayoutManager(getContext(), fanLayoutManagerSettings);
        recyclerView.setLayoutManager(fanLayoutManager);


        List<ObjetoInfo> lista = new ArrayList<>();
        lista.add(new ObjetoInfo("Celular Motorola","Cor branca", "FT", "Auditório da Elétrica"));
        lista.add(new ObjetoInfo("Notebook Lenovo", "Cor cinza", "CIC", "Sala de reuniões 1"));
        lista.add(new ObjetoInfo("Guarda-chuva", "Verde", "PAT", "BT-45"));
        lista.add(new ObjetoInfo("Carregador de celular", "não informado", "BSA", "AT-13/47"));
        lista.add(new ObjetoInfo("Caderno", "Capa da Hotwheels", "ICC Sul", "BT-160"));

        ObjetoAdapter objetoAdapter = new ObjetoAdapter(lista);

        RecyclerView recList = (RecyclerView) view.findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        recList.setAdapter(objetoAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        //Inflate the layout for this fragment
        return view;

    }

}
