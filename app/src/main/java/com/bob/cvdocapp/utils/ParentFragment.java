package com.bob.cvdocapp.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class ParentFragment extends Fragment {

    protected String TAG = "CV_TAG";

    protected Context mContext;
    protected Activity mActivity;
    protected String userToken = "";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;

        if (context instanceof Activity) {
            mActivity = (Activity) context;
        }
    }


    @Override
    public void onDetach() {
        mContext = null;
        mActivity = null;
        super.onDetach();
    }

    protected void onRetry() {

    }
}