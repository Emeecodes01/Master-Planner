package com.example.user.masterplanner.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by emmanuel on 2018-04-20.
 */

public class Remainder implements Parcelable{
    private String reminderTitle;
    private String priority;
    private int hour, minutes, seconds, day, month, year;


    public Remainder(){}

    protected Remainder(Parcel in) {
        reminderTitle = in.readString();
        priority = in.readString();
        hour = in.readInt();
        minutes = in.readInt();
        seconds = in.readInt();
        day = in.readInt();
        month = in.readInt();
        year = in.readInt();
    }

    public static final Creator<Remainder> CREATOR = new Creator<Remainder>() {
        @Override
        public Remainder createFromParcel(Parcel in) {
            return new Remainder(in);
        }

        @Override
        public Remainder[] newArray(int size) {
            return new Remainder[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(reminderTitle);
        parcel.writeString(priority);
        parcel.writeInt(hour);
        parcel.writeInt(minutes);
        parcel.writeInt(seconds);
        parcel.writeInt(day);
        parcel.writeInt(month);
        parcel.writeInt(year);
    }


    public String getReminderTitle() {
        return reminderTitle;
    }

    public void setReminderTitle(String reminderTitle) {
        this.reminderTitle = reminderTitle;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
