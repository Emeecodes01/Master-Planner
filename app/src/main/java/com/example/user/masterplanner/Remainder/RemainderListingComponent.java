package com.example.user.masterplanner.Remainder;

import dagger.Subcomponent;

/**
 * Created by user on 2018-04-20.
 */


@Subcomponent(modules = RemainderListingModule.class)
public interface RemainderListingComponent {
    void inject(ReminderListingFragment reminderListingFragment);
}
