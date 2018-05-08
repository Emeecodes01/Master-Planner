package com.example.user.masterplanner.Remainder;

import com.example.user.masterplanner.Manager.DataManagerImpl;
import com.example.user.masterplanner.Models.Remainder;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by emmanuel on 2018-04-20.
 */

public class RemainderListingInteractorImpl implements RemainderListingInteractor{
    private DataManagerImpl dataManagerImpl;

    @Inject
    public RemainderListingInteractorImpl(DataManagerImpl dataManagerImpl){
        this.dataManagerImpl = dataManagerImpl;
    }

    @Override
    public Observable<List<Remainder>> fetchReminders(){
        return null;
    }
}
