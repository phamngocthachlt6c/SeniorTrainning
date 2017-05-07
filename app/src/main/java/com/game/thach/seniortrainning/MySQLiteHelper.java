package com.game.thach.seniortrainning;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by phamn on 5/2/2017.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "comments.db";
    public static final int DATABASE_VERSION = 1;

    public static final String COLUM_ID = "ID";
    public static final String COLUM_COMMENT = "COMMENT";

    public static final String CREATE_TABLE = "create table COMMENTS(" +
            COLUM_ID + " integer primary key autoincrement, " +
            COLUM_COMMENT + " text not null);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists COMMENTS");
        onCreate(db);
    }
}
