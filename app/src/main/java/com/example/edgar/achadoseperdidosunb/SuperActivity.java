package com.example.edgar.achadoseperdidosunb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by edgar on 23/09/2016.
 */
public class SuperActivity extends AppCompatActivity {

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



}
