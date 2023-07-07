package com.bob.cvdocapp.ui.fragment.auth;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import com.bob.cvdocapp.R;
import com.bob.cvdocapp.databinding.FragmentLoginBinding;
import com.bob.cvdocapp.ui.activity.HomeActivity;
import com.bob.cvdocapp.utils.ParentFragment;
import com.bob.cvdocapp.utils.ValidationText;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class LoginFragment extends ParentFragment {

    private FragmentLoginBinding binding;

    private FirebaseAuth mAuth;

    private String emailPhone = "";

    private int type;

    public LoginFragment() {
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
        binding = FragmentLoginBinding.inflate(getLayoutInflater());

        mAuth = FirebaseAuth.getInstance();

        makeCallbackActions();

        return binding.getRoot();
    }

    private void makeCallbackActions() {

//        if (type == 1) {
//            binding.txtTitle.setText(getString(R.string.login) + " " + getString(R.string.as) + "" + getString(R.string.client));
//        } else {
//            binding.txtTitle.setText(getString(R.string.login) + " " + getString(R.string.as) + " " + getString(R.string.merchant));
//        }

        binding.btnNext.setOnClickListener(v -> {

            String email = binding.etEmail.getText().toString();
            String password = binding.etPassword.getText().toString();

            if (ValidationText.isTextNull(mActivity, email, binding.etEmail)
                    && ValidationText.isTextNull(mActivity, password, binding.layoutPassword)) {

                if (type == 1) {

                    signInWithData(emailPhone, password);
                } else {


                }
            }
        });

        binding.tvCreateAccount.setText(Html.fromHtml(mActivity.getString(R.string.don_t_have_an_account_registration_color)));

        binding.tvCreateAccount.setOnClickListener(v -> {
            Navigation.findNavController(getView()).navigate(R.id.action_loginFragment_to_authRegFragment);
        });

        binding.tvForgetPassword.setOnClickListener(v -> {

            Bundle bundle = new Bundle();
            bundle.putInt("type", type);

            Navigation.findNavController(getView()).navigate(R.id.action_loginFragment_to_forgetPasswordFragment, bundle);
        });
    }

    private void signInWithData(String email, String password) {

        if (!email.trim().equals("") && !password.trim().equals("")) {

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success");

                                Map<String, Object> mapToken = new HashMap<>();

                                mapToken.put("fcmToken", userToken);

                                if (type == 1) {


                                } else {


                                }
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                                    Toast.makeText(mActivity, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                Toast.makeText(mActivity, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}