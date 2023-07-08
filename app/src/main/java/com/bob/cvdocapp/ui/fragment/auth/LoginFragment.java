package com.bob.cvdocapp.ui.fragment.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import com.bob.cvdocapp.AppController.AppController;
import com.bob.cvdocapp.R;
import com.bob.cvdocapp.databinding.FragmentLoginBinding;
import com.bob.cvdocapp.model.User;
import com.bob.cvdocapp.ui.activity.HomeActivity;
import com.bob.cvdocapp.utils.ParentFragment;
import com.bob.cvdocapp.utils.ValidationText;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class LoginFragment extends ParentFragment {

    private FragmentLoginBinding binding;

    private FirebaseAuth mAuth;

    private String emailPhone = "";

    private int type;

    private String typeName = "";;
    private DatabaseReference mDatabaseReference;

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

        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Users");

        makeCallbackActions();

        return binding.getRoot();
    }

    private void makeCallbackActions() {

        if (type == 1) {
            typeName = "Student";
        } else if (type == 2) {
            typeName = "Doctor";
        } else if (type == 3) {
            typeName = "Company";
        }

        binding.txtTitle.setText(getString(R.string.login) + " " + getString(R.string.as) + " " + typeName);

        binding.btnNext.setOnClickListener(v -> {

            String email = binding.etEmail.getText().toString();
            String password = binding.etPassword.getText().toString();

            if (ValidationText.isTextNull(mActivity, email, binding.etEmail)
                    && ValidationText.isTextNull(mActivity, password, binding.layoutPassword)) {

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");

                                    Map<String, Object> mapToken = new HashMap<>();

                                    mapToken.put("fcmToken", userToken);

                                    mDatabaseReference.child(typeName)
                                            .child(mAuth.getUid())
                                            .addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot snapshot) {

                                                    if (snapshot.exists()) {

                                                        User user = snapshot.getValue(User.class);

                                                        if (user.getEmail().equals(email)) {

                                                            AppController.getInstance().loginUser(user, type);

                                                            startActivity(new Intent(mActivity, HomeActivity.class));
                                                            mActivity.finish();
                                                        } else {
                                                            Toast.makeText(mActivity, "this is not a " + typeName + " of login.",
                                                                    Toast.LENGTH_SHORT).show();

                                                            mAuth.signOut();
                                                        }
                                                    } else {

                                                        Toast.makeText(mActivity, "this is not a " + typeName + " of login.",
                                                                Toast.LENGTH_SHORT).show();
                                                    }
                                                }

                                                @Override
                                                public void onCancelled(@NonNull DatabaseError error) {

                                                }
                                            });

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                                    Toast.makeText(mActivity, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                    Toast.makeText(mActivity, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                Toast.makeText(mActivity, "this is not a " + typeName + " of login.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        binding.tvCreateAccount.setText(Html.fromHtml(mActivity.getString(R.string.don_t_have_an_account_registration_color)));

        binding.tvCreateAccount.setOnClickListener(v -> {
            Navigation.findNavController(getView()).navigate(R.id.action_loginFragment_to_authRegFragment);
        });
    }
}