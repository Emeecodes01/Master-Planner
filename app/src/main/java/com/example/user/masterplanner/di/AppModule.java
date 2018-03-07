package com.example.user.masterplanner.di;

import android.app.AlarmManager;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.RingtoneManager;

import com.example.user.masterplanner.BaseApplication;
import com.example.user.masterplanner.DataBase.DatabaseInfo;
import com.example.user.masterplanner.DataBase.DbInfoNumber;
import com.example.user.masterplanner.Utils.AnnoHelper;
import java.util.Calendar;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by emmanuel on 2018-04-20.
 */


@Module
public class AppModule{
    Application app;

    public AppModule(BaseApplication application){
        app = application;
    }


    @Provides
    @AnnoHelper.ApplicationContext
    Context getApplicationContext(){
        return app;
    }

    @Provides
    @DatabaseInfo
    String getDatabaseName(){
        return "master.db";
    }

    @Provides
    @DbInfoNumber
    int getDbNumber(){
        return 1;
    }

    @Singleton
    @Provides
    Calendar getCalander(){
        return Calendar.getInstance();
    }

    @Singleton
    @Provides
    SharedPreferences getSharedPreference(@AnnoHelper.ApplicationContext Context context){
        return context.getSharedPreferences("default", Context.MODE_PRIVATE);
    }

    @Singleton
    @Provides
    AlarmManager getAlarmManager(@AnnoHelper.ApplicationContext Context context){
        return (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    }

    @Singleton
    @Provides
    RingtoneManager getRingToneManager(@AnnoHelper.ApplicationContext Context context){
        return new RingtoneManager(context);
    }
}
