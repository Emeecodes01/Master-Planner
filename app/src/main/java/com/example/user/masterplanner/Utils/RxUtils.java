package com.example.user.masterplanner.Utils;

import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by emmanuel on 2018-04-22.
 */

public class RxUtils{

    public static void unSubscribe(Disposable subscription){
        if (subscription != null && !subscription.isDisposed()){
            subscription.dispose();
        }
    }
    public static void unSubscribeList(Disposable ... disposables){
        for(Disposable disposable : disposables){
            unSubscribe(disposable);
        }
    }
}
