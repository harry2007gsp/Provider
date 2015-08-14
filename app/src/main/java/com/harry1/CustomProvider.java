package com.harry1;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

//1.make uri
//2.name provider in android manifest
/**
 * Created by Harry on 8/5/15.
 */
public class CustomProvider extends ContentProvider {
    static String s = "com.harry1.CustomProvider";
    private static String url = "content://"+s+"/my_provider";
    public static final Uri uri = Uri.parse(url);
    DBHelper helper;
    @Override
    public boolean onCreate() {
        helper = new DBHelper(getContext());

        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(DBHelper.TABLE_NAME, projection, null, null, null, null, null);
//        cursor.moveToFirst();
//        while (cursor.moveToNext()) {
//            String text = cursor.getString(cursor.getColumnIndex(DBHelper.TEXTT));
//            Log.d("training", text);
//        }
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.insert(DBHelper.TABLE_NAME, null, values);
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
