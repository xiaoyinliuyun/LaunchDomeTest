package com.yangkunjian.launchmodetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yangkunjian on 2017/9/21.
 */

public class DBHelper extends SQLiteOpenHelper {

    public final static String DB_NAME = "diaryOpenHelper.db";
    public final static int DB_VERSION = 1;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table diary (_id integer primary key auto increment,topic varchar(100),content varcher(1000))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists diary";
        db.execSQL(sql);
        this.onCreate(db);
    }
}
