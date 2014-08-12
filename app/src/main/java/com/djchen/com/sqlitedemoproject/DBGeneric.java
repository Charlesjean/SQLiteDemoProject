package com.djchen.com.sqlitedemoproject;

/**
 * Created by Administrator on 2014/8/10.
 */
public class DBGeneric {
    public final static String KEY_ID = "id";

    public final static String STUDENT_NAME = "name";
    public final static String STUDENT_TEL = "tel";
    public final static String STUDENT_TABLE_NAME = "student_info";

    public final static String BOOK_TABLE_NAME = "book_info";
    public final static String BOOK_NAME="name";
    public final static String BOOK_PRICE="price";

    public final static String RENT_INFO_TABLE_NAME = "rent_info";
    public final static String RENT_STUDENT_ID = "stu_id";
    public final static String RENT_BOOK_ID = "book_id";
    public final static String RENT_DATE = "date";

    public final static String CREATE_STUDENT_TABLE ="CREATE TABLE " +
            STUDENT_TABLE_NAME + " ( " + KEY_ID + " TEXT PRIMARY KEY, " +
            STUDENT_NAME + " TEXT, " +
            STUDENT_TEL + " TEXT " +" ) ";

    public final static String CREATE_BOOK_TABLE = "CREATE TABLE " +
            BOOK_TABLE_NAME + " ( " + KEY_ID + " TEXT PRIMARY KEY, " +
            BOOK_NAME + " TEXT, " +
            BOOK_PRICE + " REAL " + ")";

    public final static String CREATE_RENT_TABLE = "CREATE TABLE " +
            RENT_INFO_TABLE_NAME + " ( " + KEY_ID + "INTEGER PRIMARY KEY, " +
            RENT_STUDENT_ID + " TEXT, " +
            RENT_BOOK_ID + " TEXT, " +
            RENT_DATE + " TEXT " + " )";







}
