package com.bob.cvdocapp.ui.fragment.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.cvdocapp.AppController.AppController;
import com.bob.cvdocapp.R;
import com.bob.cvdocapp.databinding.FragmentHomeBinding;
import com.bob.cvdocapp.ui.activity.SplashActivity;
import com.bob.cvdocapp.utils.ParentFragment;
import com.bob.cvdocapp.utils.ValidationText;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeFragment extends ParentFragment {

    private FragmentHomeBinding binding;

    private int quantity = 1;

    private FirebaseAuth mAuth;
    private BottomSheetDialog interestsSheetDialog;
    private BottomSheetDialog citySheetDialog;

    private String cityName = "";

//    private ArrayList<Merchant> merchantOrdersList;
//    private Clients clients;

    private Map<String, Object> mapOrder;

    private int counterOrders = 0;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(getLayoutInflater());

        interestsSheetDialog = new BottomSheetDialog(mActivity);
        citySheetDialog = new BottomSheetDialog(mActivity);

        mAuth = FirebaseAuth.getInstance();

        makeCallbackActions();

        return binding.getRoot();
    }

    private void makeCallbackActions() {

        binding.btnLogout.setOnClickListener(view -> {

            mAuth.signOut();
            AppController.getInstance().logout();

            startActivity(new Intent(mActivity, SplashActivity.class));
            mActivity.finish();
        });
    }
}