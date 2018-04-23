package com.example.user.masterplanner.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.user.masterplanner.Utils.AnnoHelper;

import javax.inject.Inject;

/**
 * Created by emmanuel on 2018-04-22.
 */

public class MaseterPlannerDb extends SQLiteOpenHelper{

    @Inject
    public MaseterPlannerDb(@AnnoHelper.ApplicationContext Context context, @DatabaseInfo String name, @DbInfoNumber int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //todo: create the database here
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //todo: also implement this
    }
}
