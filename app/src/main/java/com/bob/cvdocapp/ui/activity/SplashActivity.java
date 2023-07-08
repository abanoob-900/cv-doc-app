package com.bob.cvdocapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.bob.cvdocapp.AppController.AppController;
import com.bob.cvdocapp.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        
        // Set up the rest of your activity as usual

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (AppController.getInstance().isLoggedIn()) {

                    // Handle deep link if the app was started from a notification
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                    finish();

                } else {
                    startActivity(new Intent(SplashActivity.this, AuthActivity.class));
                    finish();
                }
            }
        }, 3000);
    }
}