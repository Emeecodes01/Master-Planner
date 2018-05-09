package com.example.user.masterplanner.Remainder;

import com.example.user.masterplanner.Models.Remainder;

import java.util.List;

/**
 * Created by user on 2018-04-20.
 */

public interface RemainderListingView {
    void displayReminders(List<Remainder> remainderList);
    void displayLoadingView();
}
