package com.bob.cvdocapp.ui.fragment.auth;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import com.bob.cvdocapp.R;
import com.bob.cvdocapp.databinding.FragmentRegisterBinding;
import com.bob.cvdocapp.utils.ParentFragment;
import com.bob.cvdocapp.utils.ValidationText;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterFragment extends ParentFragment {

    private FragmentRegisterBinding binding;

    private int type;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseReference;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            type = getArguments().getInt("type");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(getLayoutInflater());

        mAuth = FirebaseAuth.getInstance();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Users");

        makeCallbackActions();

        return binding.getRoot();
    }

    private void makeCallbackActions() {

        binding.btnNext.setOnClickListener(view -> {

            String name = binding.etName.getText().toString();
            String email = binding.etEmail.getText().toString();
            String password = binding.etPassword.getText().toString();

            if (ValidationText.isTextNull(mActivity, name, binding.etName)
                    && ValidationText.isTextNull(mActivity, email, binding.etEmail)
                    && ValidationText.isEmailValid(email)
                    && ValidationText.isTextNull(mActivity, password, binding.etPassword)) {

                Log.d(TAG, "makeCallbackActions: email= " + email);


            }
        });

    }
}