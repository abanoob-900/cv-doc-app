package com.bob.cvdocapp.ui.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.bob.cvdocapp.R;
import com.bob.cvdocapp.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        navController = Navigation.findNavController(this, R.id.host_home_activity_nav);

        Navigation.findNavController(this, R.id.host_home_activity_nav).navigate(R.id.homeFragment);
    }

    @Override
    public void onBackPressed() {

        if (navController.getCurrentDestination().getId() == R.id.homeFragment) {
            super.finish();
        } else {
            super.onBackPressed();
        }
    }
}