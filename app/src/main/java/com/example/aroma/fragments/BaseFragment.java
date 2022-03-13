package com.example.aroma.fragments;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

import androidx.fragment.app.Fragment;

import com.example.aroma.utility.BaseApp;

public  class BaseFragment extends Fragment {
    ProgressDialog progress=null;
    public    void showProgressDialog(boolean isCancalabe)
    {
       this.progress   = new ProgressDialog(getActivity());
        progress.setCancelable(isCancalabe);
        progress.show();

    }



    public    void showProgressDialog(String title, boolean isCancalabe)
    {
         progress = new ProgressDialog(getActivity());
        progress.setTitle(title);
        progress.setCancelable(isCancalabe);
        progress.show();
    }


    public  void showProgressDialog(String title,String des,boolean isCancalabe)
    {
         progress = new ProgressDialog(getActivity());
        progress.setTitle(title);
        progress.setMessage(des);
        progress.setCancelable(isCancalabe);
        progress.show();

    }

    public void dismissDialog()
    {
        if(progress!=null)
        {
            progress.dismiss();
            progress=null;
        }
    }



    public   void message(String title,String des)
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


    public  void message( String des)
    {
        new AlertDialog.Builder(getActivity())
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