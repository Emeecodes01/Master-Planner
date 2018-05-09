package com.example.user.masterplanner.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.widget.Toast;

import com.example.user.masterplanner.Models.Remainder;
import com.example.user.masterplanner.Utils.AnnoHelper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;

import static io.reactivex.Observable.fromArray;

/**
 * Created by emmanuel on 2018-04-22.
 */

public class MasterPlannerDb extends SQLiteOpenHelper{
    private Context context;

    @Inject
    public MasterPlannerDb(@AnnoHelper.ApplicationContext Context context, @DatabaseInfo String name, @DbInfoNumber int version){
        super(context, name, null, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String CREATE_REMAINDER_DB = "CREATE TABLE " + RemainderDbContract.DB_NAME + "( " +
                RemainderDbContract._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                RemainderDbContract.REMINDER_TITLE + " TEXT NOT NULL, "  +
                RemainderDbContract.HOUR + " INTEGER NOT NULL, " +
                RemainderDbContract.MINUTE + " INTEGER NOT NULL, " +
                RemainderDbContract.SECONDS + " INTEGER NOT NULL, " +
                RemainderDbContract.DAY + " INTEGER NOT NULL, " +
                RemainderDbContract.MONTH + " INTEGER NOT NULL, " +
                RemainderDbContract.YEAR + " INTEGER NOT NULL, " +
                RemainderDbContract.PRIORITY + " TEXT NOT NULL " +
                ");";
        sqLiteDatabase.execSQL(CREATE_REMAINDER_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + RemainderDbContract.DB_NAME);
    }

    public long putRemainderInDb(Remainder remainder){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        int hour, secs, minutes, day, month, year;String title, priority;
        hour = remainder.getHour();secs = remainder.getSeconds();minutes = remainder.getMinutes();
        day = remainder.getDay();month = remainder.getMonth();year = remainder.getYear();
        title = remainder.getReminderTitle();priority = remainder.getPriority();

        ContentValues contentValues = new ContentValues();
        contentValues.put(RemainderDbContract.REMINDER_TITLE, title);
        contentValues.put(RemainderDbContract.HOUR, hour);
        contentValues.put(RemainderDbContract.MINUTE, minutes);
        contentValues.put(RemainderDbContract.SECONDS, secs);
        contentValues.put(RemainderDbContract.DAY, day);
        contentValues.put(RemainderDbContract.MONTH, month);
        contentValues.put(RemainderDbContract.YEAR, year);
        contentValues.put(RemainderDbContract.PRIORITY, priority);


        return sqLiteDatabase.insert(RemainderDbContract.DB_NAME, null, contentValues);
    }

    public Observable<List<Remainder>> getAllRemaindersInDb(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor remaindersCursor = sqLiteDatabase.query(RemainderDbContract.DB_NAME,
                null, null, null, null, null, RemainderDbContract._ID);

        return getRemainders(remaindersCursor);
    }

    private Observable<List<Remainder>> getRemainders(Cursor remaindersCursor){
        List<Remainder> remainderList  = new ArrayList<>();
        if (remaindersCursor != null){

            while (remaindersCursor.moveToNext()){

                String remainderTitle = remaindersCursor.getString(remaindersCursor.getColumnIndex(RemainderDbContract.REMINDER_TITLE));
                String priority = remaindersCursor.getString(remaindersCursor.getColumnIndex(RemainderDbContract.PRIORITY));
                int hour = remaindersCursor.getInt(remaindersCursor.getColumnIndex(RemainderDbContract.HOUR));
                int mins = remaindersCursor.getInt(remaindersCursor.getColumnIndex(RemainderDbContract.MINUTE));
                int secs = remaindersCursor.getInt(remaindersCursor.getColumnIndex(RemainderDbContract.SECONDS));
                int year = remaindersCursor.getInt(remaindersCursor.getColumnIndex(RemainderDbContract.YEAR));
                int month = remaindersCursor.getInt(remaindersCursor.getColumnIndex(RemainderDbContract.MONTH));
                int day = remaindersCursor.getInt(remaindersCursor.getColumnIndex(RemainderDbContract.DAY));

                Remainder remainder = new Remainder();
                remainder.setPriority(priority);remainder.setReminderTitle(remainderTitle);remainder.setHour(hour);
                remainder.setMinutes(mins);remainder.setSeconds(secs);remainder.setYear(year);remainder.setMonth(month);
                remainder.setDay(day);
                remainderList.add(remainder);
            }
        }
//
        return fromArray(remainderList);
    }

    private class RemainderDbContract implements BaseColumns{
        public static final String DB_NAME = "remainderDb";
        public static final String REMINDER_TITLE = "title";
        public static final String HOUR = "hour";
        public static final String MINUTE = "minute";
        public static final String SECONDS = "seconds";
        public static final String DAY = "day";
        public static final String MONTH = "month";
        public static final String YEAR = "year";
        public static final String PRIORITY = "priority";

    }
}
