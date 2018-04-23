package com.example.user.masterplanner.Remainder;

import dagger.Subcomponent;

/**
 * Created by user on 2018-04-20.
 */

@Subcomponent(modules = RemainderModule.class)
public interface RemainderComponent{
    void inject(ReminderFragment reminderFragment);
}
