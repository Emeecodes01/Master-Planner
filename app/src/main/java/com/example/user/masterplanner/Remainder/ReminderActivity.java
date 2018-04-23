package com.example.user.masterplanner.Remainder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.example.user.masterplanner.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by emmanuel on 2018-04-20.
 */

public class ReminderActivity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        ButterKnife.bind(this);

    }

}
