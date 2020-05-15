package com.hamoda.secretnote.helper;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class HelperMethod {
    private static SweetAlertDialog sweetAlertDialog;

    private static void showProgressDialog(Activity activity) {
        try {
            sweetAlertDialog = new SweetAlertDialog(activity, SweetAlertDialog.PROGRESS_TYPE);
            sweetAlertDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            sweetAlertDialog.setTitleText("برجاء الإنتظار");
            sweetAlertDialog.setCancelable(false);
            sweetAlertDialog.show();

        } catch (Exception e) {
        }
    }

    public static void showSuccessDialog(Activity activity, String message) {
        try {
            new SweetAlertDialog(activity, SweetAlertDialog.SUCCESS_TYPE)
                    .setContentText(message)
                    .show();
        } catch (Exception e) {

        }
    }

    public static void showErrorDialog(Activity activity, String message) {
        try {
            new SweetAlertDialog(activity, SweetAlertDialog.ERROR_TYPE)
                    .setContentText(message)
                    .show();
        } catch (Exception e) {

        }
    }

    public static void dismissProgressDialog() {
        try {

            sweetAlertDialog.dismiss();

        } catch (Exception e) {

        }
    }

    public static void disappearKeypad(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


}
