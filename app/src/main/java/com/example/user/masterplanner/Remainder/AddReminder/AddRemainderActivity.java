package com.example.user.masterplanner.Remainder.AddReminder;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.PopupMenu;

import com.example.user.masterplanner.Models.Remainder;
import com.example.user.masterplanner.R;
import com.example.user.masterplanner.Remainder.RemainderDialog.PriorityDialog;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;
import butterknife.ButterKnife;

/**
 * Created by emmanuel on 2018-05-06.
 */

public class AddRemainderActivity extends AppCompatActivity implements
        AddRemainderFragment.AddRemainderFragmentListener,
        TimePickerDialog.OnTimeSetListener,
        DatePickerDialog.OnDateSetListener,
        PriorityDialog.OnPriorityDialogListener{

    private int day, month, year, hours, secs, munites;
    private String priorityStr;

    private Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_remainder);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frag_con, new AddRemainderFragment())
                .commit();

    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void selectPriority(){
        PriorityDialog priorityDialog = new PriorityDialog();
        priorityDialog.show(getSupportFragmentManager(), "PriorityDialog");

    }

    @Override
    public void showTimeDialog(){
        Calendar calendarNow = Calendar.getInstance();
        TimePickerDialog timePickerDialog = TimePickerDialog.newInstance(this,
                calendarNow.get(Calendar.HOUR_OF_DAY), calendarNow.get(Calendar.MINUTE),
                calendarNow.get(Calendar.SECOND), false);
        timePickerDialog.show(getFragmentManager(), "timePickerDialog");
        timePickerDialog.setThemeDark(true);
        timePickerDialog.setVersion(TimePickerDialog.Version.VERSION_2);
    }

    @Override
    public void showDateDialog(){
        Calendar calendarNow = Calendar.getInstance();
        DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(this,
                calendarNow.get(Calendar.YEAR), calendarNow.get(Calendar.MONTH),
                calendarNow.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show(getFragmentManager(),"DatePickerDialog");
        datePickerDialog.setThemeDark(true);
        datePickerDialog.setVersion(DatePickerDialog.Version.VERSION_2);
    }

    @Override
    public void addRemainder(String remainderTitle) {
        Remainder remainder = new Remainder();
        remainder.setReminderTitle(remainderTitle);
        remainder.setHour(hours);
        remainder.setMinutes(munites);remainder.setYear(year);remainder.setPriority(priorityStr);
        remainder.setSeconds(secs);remainder.setDay(day);remainder.setMonth(month);

        long id = presenter.addReminder(remainder);
        if (id > 0){
            presenter.createAddRemainderDialog();
        }
    }


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        this.day = dayOfMonth; this.month = monthOfYear; this.year = year;
        String dateString = dayOfMonth + "/" + monthOfYear + "/" + year;
        presenter.setNewDateTv(dateString);
    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        this.hours = hourOfDay;this.munites = minute;this.secs = second;
        String timeString = hourOfDay + ":" + minute;
        presenter.setNewTimeTv(timeString);
    }

    @Override
    public void onPriorityChecked(String priority) {
        this.priorityStr = priority;
        presenter.setNewPriority(priority);
    }
}
