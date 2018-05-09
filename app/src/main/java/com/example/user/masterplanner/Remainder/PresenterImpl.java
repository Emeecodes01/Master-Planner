package com.example.user.masterplanner.Remainder;

import android.util.Log;
import android.widget.Toast;

import com.example.user.masterplanner.Models.Remainder;
import com.example.user.masterplanner.Utils.RxUtils;

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
    private RemainderListingView view;
    private RemainderListingInteractor remainderInteractor;
    private Disposable disposableReminder;

    public PresenterImpl(RemainderListingInteractor remainderInteractor){
        this.remainderInteractor = remainderInteractor;
    }

    @Override
    public void setView(RemainderListingView view){
        //todo: start the loading view
        this.view = view;
        displayReminders();
    }


    private void displayReminders(){
        disposableReminder = remainderInteractor.fetchReminders()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onRemindersFetchSuccess, this::onRemainderFetchFailed, this::onRemainderFetchCompleted);
    }

    private void onRemindersFetchSuccess(List<Remainder> remainderList){
        Log.i("success", "Successful " + remainderList.size());
        if (checkView()){
            view.displayReminders(remainderList);
        }

    }

    private void onRemainderFetchCompleted(){
        Log.i("completed", "Complete");
    }

    private void onRemainderFetchFailed(Throwable throwable) {
        Log.i("failed", throwable.getMessage() + "This failed");
    }

    public void destory(){
        RxUtils.unSubscribe(disposableReminder);
    }

    @Override
    public void destroyView() {
        view = null;
    }

    private boolean checkView(){
        return view != null;
    }


}
