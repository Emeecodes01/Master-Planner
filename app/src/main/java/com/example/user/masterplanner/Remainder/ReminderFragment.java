package com.example.user.masterplanner.Remainder;

import com.example.user.masterplanner.Models.Remainder;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by emmanuel on 2018-04-20.
 */

public class ReminderFragment implements RemainderView{

    @Inject
    Presenter presenter;

    @Override
    public void displayReminders(List<Remainder> remainderList) {
        //todo: display data
    }
}
