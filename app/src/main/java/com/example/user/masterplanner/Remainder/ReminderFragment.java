package com.example.user.masterplanner.Remainder;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.masterplanner.Models.Remainder;
import com.example.user.masterplanner.R;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by emmanuel on 2018-04-20.
 */

public class ReminderFragment extends Fragment implements RemainderView, View.OnClickListener{
    private OnRemainderFragmentAttach fragmentAttach;

    @BindView(R.id.addFab)
    private FloatingActionButton addFab;

    @Inject
    Presenter presenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            fragmentAttach = (OnRemainderFragmentAttach) context;
        }catch (ClassCastException e){
            throw new ClassCastException("Can't cast this shitty class: piss off man");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_reminder_content, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addFab.setOnClickListener(this);
    }


    @Override
    public void displayReminders(List<Remainder> remainderList) {
        //todo: display data
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.addFab:
                fragmentAttach.onAddReminderClicked();
                break;
        }
    }

    interface OnRemainderFragmentAttach{
        void onAddReminderClicked();
    }
}
