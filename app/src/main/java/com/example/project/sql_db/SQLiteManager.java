package com.example.project.sql_db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SQLiteManager extends SQLiteOpenHelper {
    public static final String DATABASE = "QuestDB.db";
    public static final int DB_VERSION = 1;

    public SQLiteManager(@Nullable Context context) {
        super(context,DATABASE, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Table.TABLE_CREATE_QUERY);
        Table.insert(db, new Question("what is the answer to this?",
                "cow", "chicken","water", "bread",1));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
