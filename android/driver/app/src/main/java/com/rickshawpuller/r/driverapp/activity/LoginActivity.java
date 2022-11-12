package com.rickshawpuller.r.driverapp.activity;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.rickshawpuller.r.driverapp.helper.FirebaseHelper;
import com.rickshawpuller.r.driverapp.R;

public class LoginActivity extends AppCompatActivity {
    private Button btnSignIn, btnLogIn;

    FirebaseHelper firebaseHelper;
    GoogleSignInAccount account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent i = getIntent();
        Bundle extras = i.getExtras();
        if (extras != null) {
            for (String key : extras.keySet()) {
                Object value = extras.get(key);
                Log.d("login :", "Extras received at onCreate: "+ key + ": value" + value);
            }
            String title = extras.getString("title");
            String message = extras.getString("body");
            if (message!=null && message.length()>0) {
                getIntent().removeExtra("body");
                Log.d("login :", "Extras body Value: " + message);
                //dd
            }
        }

        firebaseHelper = new FirebaseHelper(this);
        initViews();
        initListeners();
    }

    private void initViews() {
        btnSignIn = findViewById(R.id.btnSignin);
        btnLogIn = findViewById(R.id.btnLogin);
    }

    private void initListeners() {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseHelper.showRegistrerDialog();
            }
        });
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseHelper.showLoginDialog();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser() != null &&
                !FirebaseAuth.getInstance().getCurrentUser().getUid().equals("")){
//            if (getIntent().hasExtra("pushnotification")) {
//                Intent intent = new Intent(LoginActivity.this, CustomerCallActivity.class);
//                startActivity(intent);
//                finish();
//            }
//            else {
//                startActivity(new Intent(LoginActivity.this, CustomerCallActivity.class));
//                finish();
//            }
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
               finish();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}