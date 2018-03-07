package com.example.user.masterplanner.Remainder.RemainderDialog.RingTone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.util.List;

/**
 * Created by emmanuel on 2018-05-11.
 */

public class RingtoneAdapter extends ArrayAdapter<RingTone> {
    private Context context;
    private int layoutRes;private List<RingTone> ringToneList;

    public RingtoneAdapter(@NonNull Context context, int resource, @NonNull List<RingTone> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutRes = resource;
        this.ringToneList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);

        return super.getView(position, convertView, parent);
    }
}
