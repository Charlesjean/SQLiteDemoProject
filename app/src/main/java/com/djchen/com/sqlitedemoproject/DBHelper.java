package com.djchen.com.sqlitedemoproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Duanjin Chen on 2014/8/10.
 */
public class DBHelper extends SQLiteOpenHelper {

    public final static String DATABASE_NAME="library";
    public final static int DATABASE_VERSION=1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBGeneric.CREATE_STUDENT_TABLE);
        db.execSQL(DBGeneric.CREATE_BOOK_TABLE);
        db.execSQL(DBGeneric.CREATE_RENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
