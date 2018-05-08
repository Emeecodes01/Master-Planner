package com.example.user.masterplanner.Remainder.AddReminder;

import com.example.user.masterplanner.Manager.DataManagerImpl;
import com.example.user.masterplanner.Models.Remainder;
import com.example.user.masterplanner.Utils.RxUtils;

/**
 * Created by emmanuel on 2018-05-07.
 */

public class PresenterImpl implements Presenter{
    private DataManagerImpl dataManager;
    private AddReminderView view;


    public PresenterImpl(DataManagerImpl dataManager){
        this.dataManager = dataManager;
    }

    @Override
    public void setView(AddReminderView view){
        this.view = view;
    }

    @Override
    public void setNewTimeTv(String time) {
        if (checkView()){
            view.showTime(time);
        }
    }

    @Override
    public void setNewDateTv(String date) {
        if (checkView()){
            view.showDate(date);
        }
    }

    @Override
    public void setNewPriority(String priority) {
        if (checkView()){
            view.showPriority(priority);
        }
    }

    @Override
    public long addReminder(Remainder remainder){
        return dataManager.putReminderIntoDb(remainder);
    }

    private boolean checkView(){
        return view != null;
    }

    public void destory(){
        view = null;
    }

    @Override
    public void createAddRemainderDialog(){
        if (checkView()){
            view.showAddReminderDialog();
        }

    }
}
