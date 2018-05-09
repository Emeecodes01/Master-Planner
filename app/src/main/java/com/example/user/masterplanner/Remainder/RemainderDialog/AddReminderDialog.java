package com.example.user.masterplanner.Remainder.RemainderDialog;

import android.app.Dialog;
import android.content.Context;
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
 * Created by emmanuel on 2018-04-22.
 */


public class AddReminderDialog extends DialogFragment implements View.OnClickListener{
    @BindView(R.id.dialog_message)
    TextView dialogMessage;
    @BindView(R.id.okBtn)
    Button okBtn;


    private Unbinder unbinder;
    private AddRemainderCallBack addRemainderCallBack;

    public static AddReminderDialog newInstance(String message) {

        Bundle args = new Bundle();
        args.putString("message", message);
        AddReminderDialog fragment = new AddReminderDialog();
        fragment.setArguments(args);
        return fragment;
    }

    public void setListener(AddRemainderCallBack callBack){
        this.addRemainderCallBack = callBack;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View dialogView = layoutInflater.inflate(R.layout.dialog_message_layout, null);
        unbinder = ButterKnife.bind(this, dialogView);

        okBtn = ButterKnife.findById(dialogView, R.id.okBtn);
        dialogMessage = ButterKnife.findById(dialogView, R.id.dialog_message);
        dialogMessage.setText(getArguments().getString("message"));

        okBtn.setOnClickListener(this);

        Dialog dialog = new Dialog(getContext());
        dialog.setTitle(getArguments().getString("message"));
        dialog.setContentView(dialogView);
        return dialog;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.okBtn){
            dismiss();
            addRemainderCallBack.onOkBtnClicked();
        }
    }

    public interface AddRemainderCallBack{
        void onOkBtnClicked();
    }
}