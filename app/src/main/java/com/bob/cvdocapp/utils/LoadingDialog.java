package com.bob.cvdocapp.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.KeyEvent;

import com.bob.cvdocapp.R;

public class LoadingDialog {

    private Activity mActivity;
    private Dialog dialog;

    public LoadingDialog(Activity mActivity) {
        this.mActivity = mActivity;
    }

    public void showDialog() {

        dialog = new Dialog(mActivity, R.style.ic_loading);

        dialog.setContentView(R.layout.custom_progress_dialog);
        dialog.setCancelable(false);

        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialogInterface, int keyCode, KeyEvent keyEvent) {

                Log.e("Abanoob", "dialog.dismiss");

                if (keyCode == KeyEvent.KEYCODE_BACK && keyEvent.getAction() == KeyEvent.ACTION_UP) {

                    dialog.dismiss();
                    return true;
                }
                return false;
            }
        });

        dialog.show();
    }

    public void dismissDialog() {

        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    public Boolean isShowing() {
        if (dialog != null) {
            return dialog.isShowing();
        } else {
            return false;
        }
    }

    public void dismissDialogProcess() {

        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    public void setCancelable(boolean isCancelable) {

        if (dialog != null) {
            dialog.setCancelable(isCancelable);
        }
    }

    public void onDialogKeyListener() {

        if (dialog != null) {

            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                @Override
                public boolean onKey(DialogInterface dialogInterface, int keyCode, KeyEvent keyEvent) {
                    Log.e("Abanoob", "dialog.dismiss");
                    if (keyCode == KeyEvent.KEYCODE_BACK && keyEvent.getAction() == KeyEvent.ACTION_UP) {

                        dialog.dismiss();
                        return true;
                    }
                    return false;
                }
            });
        }
    }
}
