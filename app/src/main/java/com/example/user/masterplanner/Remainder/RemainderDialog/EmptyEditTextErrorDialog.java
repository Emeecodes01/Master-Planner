package com.example.user.masterplanner.Remainder.RemainderDialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.masterplanner.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by emmanuel on 2018-05-07.
 */

public class EmptyEditTextErrorDialog extends DialogFragment implements View.OnClickListener{

    @BindView(R.id.dialog_message)
    TextView dialogMessage;
    @BindView(R.id.okBtn)
    Button okBtn;

    private Unbinder unbinder;

    public static EmptyEditTextErrorDialog newInstance(String message) {

        Bundle args = new Bundle();
        args.putString("message", message);
        EmptyEditTextErrorDialog fragment = new EmptyEditTextErrorDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View dialogView = layoutInflater.inflate(R.layout.add_remainder_dialog_layout, null);

        unbinder = ButterKnife.bind(this, dialogView);
        okBtn = ButterKnife.findById(dialogView, R.id.okBtn);
        dialogMessage  = ButterKnife.findById(dialogView, R.id.dialog_message);
        okBtn.setOnClickListener(this);

        dialogMessage.setText(getArguments().getString("message"));
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(dialogView);
        dialog.setTitle("Empty Remainder Title");
        return dialog;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.okBtn){
            //todo: open up another fragment --> listing dragment
            this.dismiss();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
