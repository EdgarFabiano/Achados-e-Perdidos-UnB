package com.example.edgar.achadoseperdidosunb;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends SuperActivity {
    Button perdi_bt, achei_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Lida com a ação do botão de encontar um objeto
        achei_bt = (Button)findViewById(R.id.button_achei);
        achei_bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Devolva então", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        });
        
        //Lida com a ação do botão de perder um objeto
        perdi_bt = (Button)findViewById(R.id.button_perdi);
        perdi_bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Se lascou", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Boo",
                        Toast.LENGTH_LONG).show();
            }
        });

        setDrawerView();

    }

}
