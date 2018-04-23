package com.example.user.masterplanner.Remainder;

import com.example.user.masterplanner.Models.Remainder;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by emmanuel on 2018-04-20.
 */

public class PresenterImpl implements Presenter{
    private RemainderView view;
    private RemainderInteractor remainderInteractor;
    private Disposable disposableReminder;

    public PresenterImpl(RemainderInteractor remainderInteractor){
        this.remainderInteractor = remainderInteractor;
    }


    @Override
    public void setView(RemainderView view){
        //todo: start the loading view
        this.view = view;
        displayReminders();
    }



    @Override
    public void addReminderButtonClick(Remainder remainder){
        remainderInteractor.putReminderIntoDb(remainder);
    }


    private void displayReminders(){
        disposableReminder = remainderInteractor.fetchReminders()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onRemindersFetchSuccess, this::onRemainderFetchFailed, this::onRemainderFetchCompleted);
    }

    private void onRemindersFetchSuccess(List<Remainder> remainderList){
        if (checkView()){
            view.displayReminders(remainderList);
        }

    }

    private void onRemainderFetchCompleted(){

    }

    private void onRemainderFetchFailed(Throwable throwable) {

    }



    private boolean checkView(){
        return view != null;
    }
}
