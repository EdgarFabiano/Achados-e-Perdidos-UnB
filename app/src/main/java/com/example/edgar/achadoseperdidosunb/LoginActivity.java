package com.example.edgar.achadoseperdidosunb;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;

import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


/**
 * Created by edgar on 23/09/2016.
 */
public class LoginActivity extends AppCompatActivity {

    LoginButton faceButton;
    RelativeLayout relativeLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        FacebookSdk.setApplicationId(getResources().getString(R.string.facebook_app_id));

        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
//        else{
//            View decorView = getWindow().getDecorView();
//            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//            decorView.setSystemUiVisibility(uiOptions);
//            ActionBar actionBar = getActionBar();
//            actionBar.hide();
//        }
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


        setContentView(R.layout.activity_login);

        CallbackManager callbackManager = CallbackManager.Factory.create();
        faceButton = (LoginButton) findViewById(R.id.facebook_login_button);
        if (faceButton != null) {
            faceButton.setReadPermissions("public_profile", "user_birthday", "email");
        }

        if(LoginManager.getInstance() != null){
            LoginManager.getInstance().logOut();
        }

        faceButton.registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {

                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(getApplicationContext(), "A conexão ao Facebook foi cancelada.",
                                Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Toast.makeText(getApplicationContext(), "Não foi possível conectar ao Facebook.",
                                Toast.LENGTH_LONG).show();
                    }
                });

        relativeLayout = (RelativeLayout) findViewById(R.id.relative_layout);


        Button loginButton = (Button) findViewById(R.id.facebook_login_button);

        if (loginButton != null) {
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), TutorialActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }
            });
        }

    }

    public void login(View view){
        Intent intent = new Intent(getApplicationContext(), TutorialActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void sorry(View view){
        Snackbar snackbar = Snackbar
                .make(relativeLayout, "Sorry :/", Snackbar.LENGTH_LONG);

        snackbar.show();
    }

}
