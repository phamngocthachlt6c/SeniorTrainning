package com.game.thach.seniortrainning;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by phamn on 5/2/2017.
 */

public class StudentsProvider extends ContentProvider {

    static final String PROVIDER_NAME = "thachpro";
    static final String URL = "content://" + PROVIDER_NAME + "/Students";
    static final Uri CONTENT_URI = Uri.parse(URL);

    static final String ID = "ID";
    static final String NAME = "NAME";
    static final String GRADE = "GRADE";

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
