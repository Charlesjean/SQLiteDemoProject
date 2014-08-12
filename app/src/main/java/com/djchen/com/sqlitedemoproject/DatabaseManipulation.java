package com.djchen.com.sqlitedemoproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Administrator on 2014/8/10.
 */
public class DatabaseManipulation {
    DBHelper mSqliteOpenHelper;
    public DatabaseManipulation(Context context) {

        mSqliteOpenHelper = new DBHelper(context);
    }

    /**
     *This method is just for demo, we did not add uniqueness check for
     * student id.
     * @param id, student id, this is the primary key should be unique
     * @param name, student name
     * @param tel, student telephone
     */
    public void addNewStudentInfo(String id, String name, String tel) {
        SQLiteDatabase db = mSqliteOpenHelper.getWritableDatabase();
        String insertNewInfo = "INSERT INTO " + DBGeneric.STUDENT_TABLE_NAME +
                " ( " + DBGeneric.KEY_ID + ", " + DBGeneric.STUDENT_NAME +
                ", " + DBGeneric.STUDENT_TEL + " ) VALUES ( " + "'" + id + "'" + ", " +
                "'" + name + "'" + ", " + "'" + tel + "'" + " )";
        db.execSQL(insertNewInfo);
    }

    /**
     *
     * @param id
     * @param name
     * @param price
     */
    public void addNewBookInfo(String id, String name, double price) {
        SQLiteDatabase db = mSqliteOpenHelper.getWritableDatabase();
        String insertNewInfo = "INSERT INTO " + DBGeneric.BOOK_TABLE_NAME +
                " ( " + DBGeneric.KEY_ID + ", " + DBGeneric.BOOK_NAME +
                ", " + DBGeneric.BOOK_PRICE + ") VALUES ( " + "'" + id + "'"
                + ", " + "'" + name + "'" + ", " + price + " )";
        db.execSQL(insertNewInfo);
    }

    /**
     *
     * @param stu_id
     * @param book_id
     * @param date
     */
    public void addNewRentInfo(String stu_id, String book_id, String date) {
        SQLiteDatabase db = mSqliteOpenHelper.getWritableDatabase();
        String insertNewInfo = "INSERT INTO " + DBGeneric.RENT_INFO_TABLE_NAME +
                " ( " + DBGeneric.RENT_STUDENT_ID +", " + DBGeneric.RENT_BOOK_ID +
                ", " + DBGeneric.RENT_DATE + " ) VALUES (" + "'" + stu_id + "', " +
                "'" + book_id +"', " + "'" + date +"' )";
        db.execSQL(insertNewInfo);

    }

    public void Test(String table) {
        Cursor c;
        String test = "SELECT * FROM " + table;//DBGeneric.STUDENT_TABLE_NAME;
        c = mSqliteOpenHelper.getReadableDatabase().rawQuery(test, null);
        System.out.println(c);
        if(c != null)
            c.moveToFirst();
        do {

           Log.i("DJ", c.getString(1));

        }while(c.moveToNext());
    }

    public void Test() {
        Cursor c;
        String test = "SELECT stu."+DBGeneric.STUDENT_NAME+", book."+DBGeneric.BOOK_NAME+" FROM "
                + DBGeneric.STUDENT_TABLE_NAME + " stu," + DBGeneric.BOOK_TABLE_NAME
                + " book," + DBGeneric.RENT_INFO_TABLE_NAME + " rent "
                + "WHERE stu."+DBGeneric.KEY_ID + "= rent." + DBGeneric.RENT_STUDENT_ID
                + " AND book." + DBGeneric.KEY_ID + " = rent." + DBGeneric.RENT_BOOK_ID;
        c = mSqliteOpenHelper.getReadableDatabase().rawQuery(test, null);
        if (c != null)
            c.moveToFirst();
        do {
            Log.i("DJ", c.getString(0) + " " + c.getString(1));
        }while (c.moveToNext());
    }
    /**
     * Need to call this method to close database if it's not
     * needed anymore.
     */
    public void close() {
        mSqliteOpenHelper.close();
    }
}
