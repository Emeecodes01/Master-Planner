package com.example.user.masterplanner.Remainder.AddReminder;

import com.example.user.masterplanner.Manager.DataManagerImpl;

import java.util.Calendar;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by emmanuel on 2018-05-04.
 */

@Module
public class AddRemainderModule{


    @Provides
    @AddReminderScope
    Calendar getCalander(){
        return Calendar.getInstance();
    }

    @Provides
    @AddReminderScope
    Presenter presenter(DataManagerImpl dataManager){
        return new PresenterImpl(dataManager);
    }
}
