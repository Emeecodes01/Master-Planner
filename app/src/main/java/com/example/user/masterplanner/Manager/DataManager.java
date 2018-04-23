package com.example.user.masterplanner.Manager;

import com.example.user.masterplanner.Models.Remainder;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by emmanuel on 2018-04-22.
 */

public interface DataManager{
    Observable<List<Remainder>> fetchRemindersFromDb();
    void putStringValIntoPref(String key, String value);
    void putIntValIntoPref(String key, int value);
    void putBoolValIntoPref(String key, boolean value);
    String getStringValFromPref(String key);
    int getIntValueFromPref(String key);
    boolean getBoolValueFromPref(String key);
    void putReminderIntoDb(Remainder remainder);

}
