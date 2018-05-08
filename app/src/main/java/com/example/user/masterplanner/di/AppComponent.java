package com.example.user.masterplanner.di;


import com.example.user.masterplanner.Remainder.AddReminder.AddRemainderComponent;
import com.example.user.masterplanner.Remainder.AddReminder.AddRemainderModule;
import com.example.user.masterplanner.Remainder.RemainderListingComponent;
import com.example.user.masterplanner.Remainder.RemainderListingModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by emmanuel on 2018-04-20.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent{
    RemainderListingComponent plus(RemainderListingModule remainderListingModule);
    AddRemainderComponent plus(AddRemainderModule addRemainderModule);
}
