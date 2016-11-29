package com.example.edgar.achadoseperdidosunb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.edgar.achadoseperdidosunb.Fragments.EncontradosFragment;

import java.util.List;

/**
 * Created by edgar on 10/11/2016.
 */

public class ListaAdapter extends BaseAdapter {
    private Context context;
    private List<ObjetoInfo> objetoList;

    public ListaAdapter(Context context, List<ObjetoInfo> statelist){
        this.context = context;
        this.objetoList = statelist;
    }

    @Override
    public int getCount() {
        return objetoList.size();
    }

    @Override
    public Object getItem(int position) {
        return objetoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Recupera o estado da posição atual
        ObjetoInfo objeto = objetoList.get(position);

        // Cria uma instância do layout XML para os objetos correspondentes
        // na View
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.listview_objects, null);

        // Estado - Abreviação
        TextView textState = (TextView)view.findViewById(R.id.textState);
        textState.setText(objeto.getmNome());

        // Capital
        TextView textCapital = (TextView)view.findViewById(R.id.textCapital);
        textCapital.setText(objeto.getmLocal());

        // Área
        TextView textArea = (TextView)view.findViewById(R.id.textArea);
        textArea.setText(String.valueOf(objeto.getmDept()));

        // Bandeira
//        ImageView img = (ImageView)view.findViewById(R.id.imageState);
//        img.setImageResource(objeto.getBanner());

        return view;
    }
}