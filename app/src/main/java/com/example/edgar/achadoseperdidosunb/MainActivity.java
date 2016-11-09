package com.example.edgar.achadoseperdidosunb;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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

import com.example.edgar.achadoseperdidosunb.Fragments.DepartamentosFragment;
import com.example.edgar.achadoseperdidosunb.Fragments.EncontradosFragment;
import com.example.edgar.achadoseperdidosunb.Fragments.EncontreiFragment;
import com.example.edgar.achadoseperdidosunb.Fragments.HomeFragment;
import com.example.edgar.achadoseperdidosunb.Fragments.PerdiFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private NavigationView navigationView;
    public static List<ObjetoInfo> lista = new ArrayList<>();
    public static List<ObjetoInfo> minhas = new ArrayList<>();

    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);
        else
           drawer.openDrawer(GravityCompat.START);
        
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista.add(new ObjetoInfo("Celular Motorola","Cor branca", "FT", "Auditório da Elétrica"));
        lista.add(new ObjetoInfo("Notebook Lenovo", "Cor cinza", "CIC", "Sala de reuniões 1"));
        lista.add(new ObjetoInfo("Guarda-chuva", "Verde", "PAT", "PAT BT-45"));
        lista.add(new ObjetoInfo("Carregador de celular", "não informado", "BSA", "AT-13/47"));
        lista.add(new ObjetoInfo("Caderno", "Capa da Hotwheels", "ICC Sul", "BT-160"));


        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, new HomeFragment()).commit();

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "Boo",
//                        Toast.LENGTH_LONG).show();
//            }
//        });

        setDrawerView();

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setDrawerView(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                Fragment fragment = null;
                Class fragmentClass = DepartamentosFragment.class;

                if (id == R.id.nav_home) {
                    fragmentClass = HomeFragment.class;
                }else if (id == R.id.nav_encontrei) {
                    fragmentClass = EncontreiFragment.class;

                } else if (id == R.id.nav_perdi) {
                    fragmentClass = PerdiFragment.class;

                } else if (id == R.id.nav_encontrados) {
                    fragmentClass = EncontradosFragment.class;

                } /*else if (id == R.id.nav_departamentos) {
                    fragmentClass = DepartamentosFragment.class;

                }*/else if (id == R.id.nav_share) {

                } else if (id == R.id.nav_send) {

                } else if (id == R.id.nav_logout) {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else if(id == R.id.nav_configuracoes){

                }

                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Insert the fragment by replacing any existing fragment
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

                item.setChecked(true);
                setTitle(item.getTitle());

                // Close the navigation drawer
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);

                return true;
            }
        });
    }

    public void clique(View view){
        Fragment fragment = null;
        Class fragmentClass = DepartamentosFragment.class;
        Menu menu = navigationView.getMenu();
        int item = 0;

        if(view.getId() == R.id.button_achei) {
            fragmentClass = EncontreiFragment.class;
            item = 1;
            setTitle("Encontrei um objeto");

        }
        else if(view.getId() == R.id.button_perdi) {
            fragmentClass = PerdiFragment.class;
            item = 2;
            setTitle("Perdi um objeto");
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

       // menu.getItem(0).getSubMenu().findItem(item).setChecked(true);

        // Close the navigation drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

}
