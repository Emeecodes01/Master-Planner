package com.example.user.masterplanner.Remainder.RemainderDialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioGroup;

import com.example.user.masterplanner.R;

/**
 * Created by emmanuel on 2018-05-07.
 */

public class PriorityDialog extends DialogFragment implements RadioGroup.OnCheckedChangeListener{
    private RadioGroup radioGroup;
    private OnPriorityDialogListener CallbackListener;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            CallbackListener = (OnPriorityDialogListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException("Cant cast this shitty class mother fucker");
        }

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View dialogView = inflater.inflate(R.layout.priority_dialog_layout, null);
        radioGroup = dialogView.findViewById(R.id.priority_radio_group);

        initViews();
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(dialogView);
        dialog.setTitle("Set Priority");
        return dialog;
    }

    private void initViews(){
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId){
            case R.id.priority_high:
                CallbackListener.onPriorityChecked("high");
                dismissDialog();
                break;
            case R.id.priority_medium:
                CallbackListener.onPriorityChecked("medium");
                dismissDialog();
                break;
            case R.id.priority_low:
                CallbackListener.onPriorityChecked("low");
                dismissDialog();
                break;
        }
    }

    private void dismissDialog(){
        dismiss();
    }

    public interface OnPriorityDialogListener{
        void onPriorityChecked(String priority);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
