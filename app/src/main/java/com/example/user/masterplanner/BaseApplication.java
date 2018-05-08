package com.example.user.masterplanner;

import android.app.Application;

import com.example.user.masterplanner.Remainder.AddReminder.AddRemainderComponent;
import com.example.user.masterplanner.Remainder.AddReminder.AddRemainderModule;
import com.example.user.masterplanner.Remainder.RemainderListingComponent;
import com.example.user.masterplanner.Remainder.RemainderListingModule;
import com.example.user.masterplanner.di.AppComponent;
import com.example.user.masterplanner.di.AppModule;
import com.example.user.masterplanner.di.DaggerAppComponent;

/**
 * Created by emmanuel on 2018-04-20.
 */

public class BaseApplication extends Application{
    protected AppComponent appComponent;
    private RemainderListingComponent remainderListingComponent;
    private AddRemainderComponent addRemainderComponent;


    @Override
    public void onCreate(){
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
    public RemainderListingComponent addRemainderListingComponent(){
        remainderListingComponent= appComponent.plus(new RemainderListingModule());
        return remainderListingComponent;
    }

    public AddRemainderComponent addRemainderComponent(){
        addRemainderComponent = appComponent.plus(new AddRemainderModule());
        return addRemainderComponent;
    }

    public void realeaseAddRemainderComponent(){
        addRemainderComponent = null;
    }

    public void realeaseListingRemainderComponent(){
        remainderListingComponent = null;
    }

    AppComponent getAppComponent(){
        return appComponent;}
}
