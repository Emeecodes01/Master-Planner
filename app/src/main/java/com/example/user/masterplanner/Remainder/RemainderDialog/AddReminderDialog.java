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
 * Created by emmanuel on 2018-04-22.
 */

public class AddReminderDialog extends DialogFragment implements View.OnClickListener{
    @BindView(R.id.dialog_message)
    TextView dialogMessage;
    @BindView(R.id.okBtn)
    Button okBtn;

    public static final int DIALOG_TYPE_ONE = 1;
    public static final int DIALOG_TYPE_TWO = 2;


    private Unbinder unbinder;
    private AddRemainderCallBack addRemainderCallBack;

    public static AddReminderDialog newInstance(int type,String message) {
        Bundle args = new Bundle();
        args.putString("message", message);
        args.putInt("dialogType", type);
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
        int layoutRes = 0;
        int dialogType = getArguments().getInt("dialogType");
        if (dialogType == DIALOG_TYPE_ONE){
            layoutRes = R.layout.add_remainder_dialog_layout;
        }else if (dialogType == DIALOG_TYPE_TWO){
            layoutRes = R.layout.add_remainder_err_dialog_layout;
        }
        View dialogView = layoutInflater.inflate(layoutRes, null);
        unbinder = ButterKnife.bind(this, dialogView);

        setUpViews(dialogView);
        return createDialog(dialogView);
    }

    private void setUpViews(View dialogView){
        okBtn = ButterKnife.findById(dialogView, R.id.okBtn);
        dialogMessage = ButterKnife.findById(dialogView, R.id.dialog_message);
        dialogMessage.setText(getArguments().getString("message"));
        okBtn.setOnClickListener(this);
    }

    private Dialog createDialog(View dialogView){
        Dialog dialog = new Dialog(getContext(), R.style.CustomDialog);
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