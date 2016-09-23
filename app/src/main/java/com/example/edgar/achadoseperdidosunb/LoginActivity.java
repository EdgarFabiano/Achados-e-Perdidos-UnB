package com.example.edgar.achadoseperdidosunb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
public class LoginActivity extends SuperActivity {

    LoginButton faceButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        FacebookSdk.setApplicationId(getResources().getString(R.string.facebook_app_id));

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




        Button loginButton = (Button) findViewById(R.id.facebook_login_button);

        // Comparar dados com o banco -> operar login, dependendo se fator já existe
        if (loginButton != null) {
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }
            });
        }

    }
}
