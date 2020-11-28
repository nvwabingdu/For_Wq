package com.example.myapplication.android.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-11-24
 * Time: 13:24
 */
public class DBHelper extends SQLiteOpenHelper {
//    private static final String DATABASE_NAME = "test.db";  //数据库名字
//    private static final int DATABASE_VERSION = 1;         //数据库版本号

    public DBHelper(Context context) {
        super(context, "test.db", null, 1);
    }

    /**
     * 12      * 创建数据库表：person
     * 13      * _id为主键，自增
     * 14      *
     **/
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i("TAG:", "创建person数据库表！");
        sqLiteDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS person(_id INTEGER PRIMARY KEY AUTOINCREMENT," + " name VARCHAR,info TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    @Override
    public void onOpen(SQLiteDatabase sqLiteDatabase) {
        super.onOpen(sqLiteDatabase);
    }
}
