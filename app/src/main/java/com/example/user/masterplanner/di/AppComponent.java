package com.example.user.masterplanner.di;

import android.app.Application;

import com.example.user.masterplanner.Remainder.RemainderComponent;
import com.example.user.masterplanner.Remainder.RemainderModule;
import dagger.Component;

/**
 * Created by emmanuel on 2018-04-20.
 */


@Component(modules = {AppModule.class,
        RemainderModule.class})
public interface AppComponent{
    RemainderComponent plus(RemainderModule remainderModule);
}
