package com.example.user.masterplanner.Remainder;

import com.example.user.masterplanner.Manager.DataManagerImpl;
import com.example.user.masterplanner.Models.Remainder;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by emmanuel on 2018-04-20.
 */

public class RemainderInteractorImpl implements RemainderInteractor{
    private DataManagerImpl dataManagerImpl;

    @Inject
    public RemainderInteractorImpl(DataManagerImpl dataManagerImpl){
        this.dataManagerImpl = dataManagerImpl;
    }

    @Override
    public Observable<List<Remainder>> fetchReminders(){

        return null;
    }

    @Override
    public void putReminderIntoDb(Remainder remainder) {
        dataManagerImpl.putReminderIntoDb(remainder);
    }
}
