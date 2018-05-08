package com.example.user.masterplanner.Remainder.AddReminder;

import com.example.user.masterplanner.Models.Remainder;

/**
 * Created by emmanuel on 2018-05-07.
 */

public interface Presenter{
    void setView(AddReminderView view);
    void setNewTimeTv(String time);
    void setNewDateTv(String date);
    void destory();
    void addReminder(Remainder remainder);
}
