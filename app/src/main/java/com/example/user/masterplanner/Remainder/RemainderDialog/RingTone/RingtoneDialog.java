package com.example.user.masterplanner.Remainder.RemainderDialog.RingTone;

import android.app.Dialog;
import android.app.DialogFragment;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by emmanuel on 2018-05-11.
 */


public class RingtoneDialog extends DialogFragment{

    @Inject
    RingtoneManager ringtoneManager;

    public static RingtoneDialog newInstance(ArrayList<RingTone> ringToneList) {
        Bundle args = new Bundle();
        args.putParcelableArrayList("data", ringToneList);
        RingtoneDialog fragment = new RingtoneDialog();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        Cursor cursor = ringtoneManager.getCursor();
        if (cursor != null){
            while (cursor.moveToNext()){
//                String ringToneTitle = cursor.getString(cursor.getColumnIndex(RingtoneManager.EXTRA_RINGTONE_TITLE));
//                String uri = cursor.getString(cursor.getColumnIndex(RingtoneManager.))
            }

        }

        return null;
    }
}
