package com.example.user.masterplanner.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.user.masterplanner.BaseApplication;
import com.example.user.masterplanner.DataBase.DatabaseInfo;
import com.example.user.masterplanner.DataBase.DbInfoNumber;
import com.example.user.masterplanner.Utils.AnnoHelper;
import com.example.user.masterplanner.Utils.SharedPrefHelper;

import javax.inject.Inject;
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
    SharedPreferences getSharedPrefHelper(Context context){
        return context.getSharedPreferences("default", Context.MODE_PRIVATE);
    }
}
