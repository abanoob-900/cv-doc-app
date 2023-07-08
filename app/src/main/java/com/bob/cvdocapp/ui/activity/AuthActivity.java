package com.bob.cvdocapp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;

import com.bob.cvdocapp.R;

public class AuthActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        navController = Navigation.findNavController(this, R.id.host_auth_fragment_activity_nav);

        Navigation.findNavController(this, R.id.host_auth_fragment_activity_nav).navigate(R.id.authFragment);
    }

    @Override
    public void onBackPressed() {

        if (navController.getCurrentDestination().getId() == R.id.authFragment) {
            super.finish();
        } else {
            super.onBackPressed();
        }
    }
}