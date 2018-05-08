package com.example.user.masterplanner.Remainder.AddReminder;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.user.masterplanner.BaseApplication;
import com.example.user.masterplanner.R;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * Created by emmanuel on 2018-05-04.
 */


public class AddRemainderFragment extends Fragment implements
        View.OnClickListener,
        AddReminderView{

    @Inject
    Presenter presenter;

    @BindView(R.id.reminder_ed)
    EditText reminderTitleEd;
    @BindView(R.id.addRemainderFab)
    FloatingActionButton addRemainderFab;
    @BindView(R.id.remainder_tv)
    TextView remainderTimeTv;
    @BindView(R.id.remainderDate_tv)
    TextView remainderDateTv;
    @BindView(R.id.priority_tv)
    TextView priorityTv;
    @BindView(R.id.time_layout)
    RelativeLayout timeLayout;
    @BindView(R.id.date_layout)
    RelativeLayout dateLayout;
    @BindView(R.id.priority_layout)
    RelativeLayout priorityLayout;

    private AddRemainderFragmentListener listener;
    private Unbinder unbinder;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try {
            listener = (AddRemainderFragmentListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException("Cant cast this class");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BaseApplication)getActivity().getApplication())
                .addRemainderComponent()
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        presenter.setView(this);
        listener.setPresenter(presenter);
        View rootView = inflater.inflate(R.layout.add_reminder_fragment_layout, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        timeLayout = ButterKnife.findById(view, R.id.time_layout);
        dateLayout = ButterKnife.findById(view, R.id.date_layout);
        priorityLayout = ButterKnife.findById(view, R.id.priority_layout);
        addRemainderFab = ButterKnife.findById(view, R.id.addRemainderFab);
        reminderTitleEd = ButterKnife.findById(view, R.id.reminder_ed);
        remainderTimeTv = ButterKnife.findById(view, R.id.remainder_tv);
        remainderDateTv = ButterKnife.findById(view, R.id.remainderDate_tv);
        priorityTv = ButterKnife.findById(view, R.id.priority_tv);

        priorityLayout.setOnClickListener(this);
        timeLayout.setOnClickListener(this);
        dateLayout.setOnClickListener(this);
        addRemainderFab.setOnClickListener(this);
    }

    @OnClick(R.id.date_layout)
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.addRemainderFab:
                addRemainderClicked();
                break;
            case R.id.time_layout:
                listener.showTimeDialog();
                break;
            case R.id.date_layout:
                listener.showDateDialog();
                break;
        }
    }

    private void addRemainderClicked(){
        String reminderEd = reminderTitleEd.getText().toString();
        if (TextUtils.isEmpty(reminderEd)){
            //todo: show a dialog to set the title of the edit text
            showErrorDialog(1);
        }else {
            listener.addRemainder(reminderEd);
        }
    }

    @Override
    public void showTime(String time) {
        remainderTimeTv.setText(time);
    }

    //todo: set up the priority pop up, create added reminder successfully/failure dialog
    @Override
    public void showDate(String date) {
        remainderDateTv.setText(date);
    }

    @Override
    public void showErrorDialog(int type){

    }

    public interface AddRemainderFragmentListener{
        void showTimeDialog();
        void showDateDialog();
        void addRemainder(String remainderTitle);
        void setPresenter(Presenter presenter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.destory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((BaseApplication)getActivity().getApplication()).realeaseAddRemainderComponent();
    }
}