package com.game.thach.seniortrainning;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phamn on 5/2/2017.
 */

public class CommentsDataSource {

    private SQLiteDatabase sqLiteDatabase;
    private MySQLiteHelper mySQLiteHelper;

    private String[] allColumns = {MySQLiteHelper.COLUM_ID, MySQLiteHelper.COLUM_COMMENT};

    public CommentsDataSource(Context context){
        mySQLiteHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        sqLiteDatabase = mySQLiteHelper.getWritableDatabase();
    }

    public void close(){
        mySQLiteHelper.close();
    }

    public Comment createComment(String comment){
        if(sqLiteDatabase == null){
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(MySQLiteHelper.COLUM_COMMENT, comment);
        long insertId = sqLiteDatabase.insert("COMMENTS", null, contentValues);
        Cursor cursor = sqLiteDatabase.query("COMMENTS", allColumns, MySQLiteHelper.COLUM_ID + " = ?",
                new String[]{String.valueOf(insertId)},
                null, null, null);
        cursor.moveToFirst();
        Comment newComment = cursorToComment(cursor);
        return newComment;
    }

    private Comment cursorToComment(Cursor cursor){
        Comment comment = new Comment((int) cursor.getLong(0), cursor.getString(1));
        return comment;
    }

    public List<Comment> getAllComments(){
        if(sqLiteDatabase == null){
            return null;
        }
        List<Comment> comments = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query("COMMENTS", allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Comment comment = cursorToComment(cursor);
            comments.add(comment);
            cursor.moveToNext();
        }
        cursor.close();
        return comments;
    }

}
