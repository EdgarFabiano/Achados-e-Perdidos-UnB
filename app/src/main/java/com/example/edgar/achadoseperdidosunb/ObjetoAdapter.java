package com.example.edgar.achadoseperdidosunb;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by edgar on 07/11/2016.
 */

public class ObjetoAdapter extends RecyclerView.Adapter<ObjetoAdapter.ObjetoViewHolder> {

    private List<ObjetoInfo> contactList;

    public ObjetoAdapter(List<ObjetoInfo> contactList) {
        this.contactList = contactList;
    }

    private static Activity activity;


    public ObjetoAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public void onBindViewHolder(ObjetoViewHolder objetoViewHolder, int i) {
        ObjetoInfo objetoInfo = contactList.get(i);
        objetoViewHolder.vTitle.setText(objetoInfo.getmNome());
        objetoViewHolder.vDept.setText("Departamento: " + objetoInfo.getmDept());
        objetoViewHolder.vDesc.setText("Descrição: " + objetoInfo.getmDesc());
        objetoViewHolder.vLocal.setText("Local: " + objetoInfo.getmLocal());
    }

    @Override
    public ObjetoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_view, viewGroup, false);

        return new ObjetoViewHolder(itemView);
    }


    public static class ObjetoViewHolder extends RecyclerView.ViewHolder {
        protected TextView vDesc;
        protected TextView vDept;
        protected TextView vLocal;
        protected TextView vTitle;
        protected CardView container;

        public ObjetoViewHolder(View v) {
            super(v);
            vDesc =  (TextView) v.findViewById(R.id.txtDesc);
            vDept = (TextView)  v.findViewById(R.id.txtDept);
            vLocal = (TextView)  v.findViewById(R.id.txtLocal);
            vTitle = (TextView) v.findViewById(R.id.title);
            container = (CardView) v.findViewById(R.id.card_view);
        }


        public final View.OnClickListener cardViewListener =  new View.OnClickListener() {
            @Override public void onClick(View v) {
                //delete buider
                final AlertDialog.Builder deleteBuilder = new AlertDialog.Builder(activity)
                        .setTitle("Deseja deletar essa ocorrência?")
                        .setCancelable(true)
                        .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                //Detalhes buider
                AlertDialog.Builder detalhesBuider = new AlertDialog.Builder(activity);
                LayoutInflater inflater =  activity.getLayoutInflater();
                View dialog = inflater.inflate(R.layout.detalhesdocard_dialog, null);
                detalhesBuider.setView(dialog);

                AlertDialog detalhesAlertDialog = detalhesBuider.setCancelable(true).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                        .setNegativeButton("Deletar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).create();
                //new carregaDetalhesDialog(item, activity, dialog);
                detalhesAlertDialog.show();
             }
        };
        //container.OnClickListener(cardViewListener);

    }

}

