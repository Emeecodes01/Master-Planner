package com.example.user.masterplanner.Remainder;

import com.example.user.masterplanner.Models.Remainder;
import java.util.List;
import io.reactivex.Observable;


/**
 * Created by emmanuel on 2018-04-20.
 */

public interface RemainderListingInteractor {
    Observable<List<Remainder>> fetchReminders();
}
