package com.example.user.masterplanner.Remainder.RemainderDialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

import com.example.user.masterplanner.R;

import butterknife.Unbinder;

/**
 * Created by emmanuel on 2018-05-08.
 */

public class LoadingDialog extends DialogFragment{


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View dialogView = inflater.inflate(R.layout.loading_view, null);
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(dialogView);
        return dialog;
    }

    public void dismissLoadingDialog(){
        dismiss();
    }
}
