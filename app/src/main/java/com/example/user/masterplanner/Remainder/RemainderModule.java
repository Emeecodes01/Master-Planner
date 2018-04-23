package com.example.user.masterplanner.Remainder;


import com.example.user.masterplanner.Manager.DataManagerImpl;
import dagger.Module;
import dagger.Provides;

/**
 * Created by emmanuel on 2018-04-20.
 */

@Module
public class RemainderModule{

    @Provides
    RemainderInteractor getReminderInteractor(DataManagerImpl dataManager){
        return new RemainderInteractorImpl(dataManager);
    }

    @Provides
    Presenter getPresenter(RemainderInteractor remainderInteractor){
        return new PresenterImpl(remainderInteractor);
    }
}
