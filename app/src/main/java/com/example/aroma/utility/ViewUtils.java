package com.example.aroma.utility;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

public class ViewUtils {
    public  static  void showProgressDialog(Context context,boolean isCancalabe)
    {
        ProgressDialog progress = new ProgressDialog(BaseApp.getAppContext());
        progress.setCancelable(isCancalabe);
        progress.show();

    }


    public  static  void showProgressDialog(Context context,String title,boolean isCancalabe)
    {
        ProgressDialog progress = new ProgressDialog(BaseApp.getAppContext());
        progress.setTitle(title);
        progress.setCancelable(isCancalabe);
        progress.show();
    }


    public  static  void showProgressDialog(Context context,String title,String des,boolean isCancalabe)
    {
        ProgressDialog progress = new ProgressDialog(BaseApp.getAppContext());
        progress.setTitle(title);
        progress.setMessage(des);
        progress.setCancelable(isCancalabe);
        progress.show();

    }

    public  static  void message(Context context,String title,String des)
    {

        new AlertDialog.Builder(BaseApp.getAppContext())
                .setTitle(title)
                .setMessage(des)

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with delete operation
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }


    public  static  void message(Context context, String des)
    {
        new AlertDialog.Builder(context)
                .setMessage(des)

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with delete operation

                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }






}
