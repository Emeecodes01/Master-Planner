package com.example.user.masterplanner.Remainder.AddReminder;

import dagger.Subcomponent;

/**
 * Created by emmanuel on 2018-05-06.
 */

@AddReminderScope
@Subcomponent(modules = AddRemainderModule.class)
public interface AddRemainderComponent{
    void inject(AddRemainderFragment addRemainderFragment);
}
