package com.bob.cvdocapp.ui.fragment.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;

import com.bob.cvdocapp.R;
import com.bob.cvdocapp.databinding.FragmentAuthBinding;
import com.bob.cvdocapp.utils.ParentFragment;

public class AuthFragment extends ParentFragment {

    private FragmentAuthBinding binding;

    public AuthFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAuthBinding.inflate(getLayoutInflater());

        makeCallbackActions();

        return binding.getRoot();
    }

    private void makeCallbackActions() {

        binding.btnLogin.setOnClickListener(v -> {

            Bundle bundle = new Bundle();
            bundle.getString("login", "login");

            Navigation.findNavController(getView()).navigate(R.id.action_authFragment_to_authLogFragment, bundle);
        });

        binding.tvNewAccount.setOnClickListener(v -> {

            Bundle bundle = new Bundle();
            bundle.getString("register", "register");

            Navigation.findNavController(getView()).navigate(R.id.action_authFragment_to_authRegFragment, bundle);
        });
    }
}