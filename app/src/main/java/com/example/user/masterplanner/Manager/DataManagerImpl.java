package com.example.user.masterplanner.Manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.user.masterplanner.DataBase.MasterPlannerDb;
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
    private MasterPlannerDb masterPlannerDb;
    private SharedPreferences sharedPreferences;


    @Inject
    public DataManagerImpl(@AnnoHelper.ApplicationContext Context context, MasterPlannerDb masterPlannerDb, SharedPreferences sharedPreferences) {
        this.context = context;
        this.masterPlannerDb = masterPlannerDb;
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public Observable<List<Remainder>> fetchRemindersFromDb(){
        return masterPlannerDb.getAllRemaindersInDb();
    }

    @Override
    public long putReminderIntoDb(Remainder remainder){
        return masterPlannerDb.putRemainderInDb(remainder);
    }
}
