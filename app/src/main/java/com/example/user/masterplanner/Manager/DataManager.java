package com.example.user.masterplanner.Manager;

import com.example.user.masterplanner.Models.Remainder;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by emmanuel on 2018-04-22.
 */

public interface DataManager{
    Observable<List<Remainder>> fetchRemindersFromDb();
    long putReminderIntoDb(Remainder remainder);
}
