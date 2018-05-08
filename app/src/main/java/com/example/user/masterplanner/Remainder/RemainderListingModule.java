package com.example.user.masterplanner.Remainder;


import com.example.user.masterplanner.Manager.DataManagerImpl;
import dagger.Module;
import dagger.Provides;

/**
 * Created by emmanuel on 2018-04-20.
 */

@Module
public class RemainderListingModule {

    @Provides
    RemainderListingInteractor getReminderInteractor(DataManagerImpl dataManager){
        return new RemainderListingInteractorImpl(dataManager);
    }

    @Provides
    Presenter getPresenter(RemainderListingInteractor remainderInteractor){
        return new PresenterImpl(remainderInteractor);
    }
}
