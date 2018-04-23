package com.example.user.masterplanner.Manager;

import android.content.Context;

import com.example.user.masterplanner.DataBase.MaseterPlannerDb;
import com.example.user.masterplanner.Models.Remainder;
import com.example.user.masterplanner.Utils.AnnoHelper;
import com.example.user.masterplanner.Utils.SharedPrefHelper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by emmanuel on 2018-04-20.
 */

public class DataManagerImpl implements DataManager{
    private Context context;
    private MaseterPlannerDb maseterPlannerDb;
    private SharedPrefHelper sharedPrefHelper;


    @Inject
    public DataManagerImpl(@AnnoHelper.ApplicationContext Context context, MaseterPlannerDb maseterPlannerDb, SharedPrefHelper sharedPrefHelper) {
        this.context = context;
        this.maseterPlannerDb = maseterPlannerDb;
        this.sharedPrefHelper = sharedPrefHelper;
    }

    @Override
    public Observable<List<Remainder>> fetchRemindersFromDb(){
        return null;
    }

    @Override
    public void putStringValIntoPref(String key, String value) {
        sharedPrefHelper.putStringValInPref(key, value);
    }

    @Override
    public void putIntValIntoPref(String key, int value) {
        sharedPrefHelper.putIntValInPref(key, value);
    }

    @Override
    public void putBoolValIntoPref(String key, boolean value) {
        sharedPrefHelper.putBoolValInPref(key, value);
    }

    @Override
    public String getStringValFromPref(String key) {
        return null;
    }

    @Override
    public int getIntValueFromPref(String key) {
        return 0;
    }

    @Override
    public boolean getBoolValueFromPref(String key) {
        return false;
    }

    @Override
    public void putReminderIntoDb(Remainder remainder) {

    }
}
