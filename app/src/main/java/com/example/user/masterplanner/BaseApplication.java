package com.example.user.masterplanner;

import android.app.Application;

import com.example.user.masterplanner.Remainder.RemainderModule;
import com.example.user.masterplanner.di.AppComponent;
import com.example.user.masterplanner.di.AppModule;
import com.example.user.masterplanner.di.DaggerAppComponent;

/**
 * Created by emmanuel on 2018-04-20.
 */

public class BaseApplication extends Application{
    protected AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .remainderModule(new RemainderModule())
                .build();
        appComponent.inject(this);
    }

    AppComponent getAppComponent(){return appComponent;}
}
