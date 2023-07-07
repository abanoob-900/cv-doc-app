package com.bob.cvdocapp.ui.fragment.auth;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.bob.cvdocapp.R;
import com.bob.cvdocapp.databinding.FragmentAuthRegBinding;


public class AuthRegFragment extends Fragment {

    private FragmentAuthRegBinding binding;

    /**
     * client = 1;
     * merchant = 2;
     */

    private int type;

    public AuthRegFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAuthRegBinding.inflate(getLayoutInflater());

        makeCallbackActions();

        return binding.getRoot();
    }

    private void makeCallbackActions() {

        binding.rgAuth.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.rbStudent) {
                    type = 1;
                } else if (i == R.id.rbDoc) {
                    type = 2;
                } else if (i == R.id.rbCompany) {
                    type = 3;
                }
            }
        });

        if (binding.rbCompany.isChecked()) {
            type = 3;
        } else if (binding.rbDoc.isChecked()) {
            type = 2;
        } else {
            type = 1;
        }

        binding.btnNext.setOnClickListener(v -> {

            Bundle bundle = new Bundle();
            bundle.putInt("type", type);

            Navigation.findNavController(getView()).navigate(R.id.action_authRegFragment_to_registerFragment, bundle);
        });
    }
}