package com.bob.cvdocapp.utils;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.EditText;

import com.bob.cvdocapp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationText {

    public static boolean isPhoneValid(Activity activity, String phone, TextInputLayout inputLayout) {

        if (phone.length() < 9) {
            inputLayout.setError(activity.getString(R.string.required));
            return false;
        }
        return true;
    }

    public static boolean isPhoneValid(Activity activity, String phone, EditText editText) {

        if (phone.length() < 9) {
            editText.setError(activity.getString(R.string.invalid_phone_number));
            return false;
        }
        return true;
    }

    public static boolean isFieldValid(Activity activity, String text, TextInputLayout inputLayout) {

        if (text.trim().isEmpty()){
            inputLayout.setError(activity.getString(R.string.required));
            return false;
        }
        return true;
    }

    public static void changeFields(TextInputEditText textInputEditText, TextInputLayout inputLayout) {

        textInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (!editable.toString().trim().isEmpty()) {
                    inputLayout.setErrorEnabled(false);
                }
                else {
                    inputLayout.setErrorEnabled(true);
                }
            }
        });
    }

    public static boolean isFieldPassword(Activity activity, String password, TextInputLayout inputLayout) {

        if (password.length() < 6){
            inputLayout.setError(activity.getString(R.string.short_password));
            return false;
        }
        return true;
    }

    public static boolean isMatchesPassword(Activity activity, String password, String passwordConfirm, TextInputLayout inputLayoutPassConfirm) {

        if (!passwordConfirm.equals(password)) {
            inputLayoutPassConfirm.setError(activity.getString(R.string.password_is_different));
            return false;
        }
        return true;
    }

    public static boolean isTextNull(Activity activity, String text, TextInputLayout inputLayout) {

        if (text.trim().isEmpty()){
            inputLayout.setError(activity.getString(R.string.required));
            return false;
        }
        return true;
    }

    public static boolean isTextNull(Activity activity, String text, EditText editText) {

        if (text.trim().isEmpty()){
            editText.setError(activity.getString(R.string.required));
            return false;
        }
        return true;
    }

    public static boolean isValidEmail(Activity activity, String email, TextInputLayout inputLayout) {

        if (!isValidEmail(email)){
            inputLayout.setError(activity.getString(R.string.wrong_email));
            return false ;
        }
        return true;
    }

    public static boolean isValidEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
