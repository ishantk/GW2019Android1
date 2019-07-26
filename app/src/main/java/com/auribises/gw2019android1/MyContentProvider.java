package com.auribises.gw2019android1;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {

    SQLiteDatabase db; // Can perform all sql operations in table :)

    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        String tabName = uri.getLastPathSegment();
        int i = db.delete(tabName, selection, null);
        return i;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // This insert is executed from Activity with ContentResolver
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        String tabName = uri.getLastPathSegment(); // Customer
        long id = db.insert(tabName, null, values); // Insert data in Table

        Uri dummyUri = Uri.parse("something://somedummy/"+id);
        return dummyUri;
    }

    @Override
    public boolean onCreate() {

        DBHelper dbHelper = new DBHelper(getContext(), "Customers.db", null, 1);
        db = dbHelper.getWritableDatabase();

        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        String tabName = uri.getLastPathSegment();
        Cursor cursor = db.query(tabName, projection, null, null, null, null, null);
        return cursor; // cursor contains data fetched from database table

    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {

        String tabName = uri.getLastPathSegment();
        int i = db.update(tabName, values, selection, null);
        return i;

    }

    // Nested Class
    class DBHelper extends SQLiteOpenHelper{

        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version); // Create the DataBase
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            String sql = "create table Customer(" +
                    "_ID integer primary key autoincrement, " +
                    "name text, " +
                    "phone text, " +
                    "email text" +
                    ")";

            String sql2 = "";

            sqLiteDatabase.execSQL(sql);    // Create Table
            //sqLiteDatabase.execSQL(sql2);

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
