package com.example.user.masterplanner.Remainder;

import com.example.user.masterplanner.Models.Remainder;

/**
 * Created by emmanuel on 2018-04-20.
 */

public interface Presenter{
    void setView(RemainderListingView view);
    void destory();
    void destroyView();
}
