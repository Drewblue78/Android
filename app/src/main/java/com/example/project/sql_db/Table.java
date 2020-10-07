package com.example.project.sql_db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class Table {
    public static final String TABLE_NAME = "QuestDB";
    public static final String COL_id = "id";
    public static final String COL_question = "question";
    public static final String COL_answer_a = "answer_a";
    public static final String COL_answer_b = "answer_b";
    public static final String COL_answer_c = "answer_c";
    public static final String COL_answer_d = "answer_d";
    public static final String COL_correct = "correct";


    public static final String TABLE_CREATE_QUERY = "CREATE TABLE" + TABLE_NAME + " (" +
            COL_id + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            COL_question + " TEXT NOT NULL," +
            COL_answer_a + " TEXT NOT NULL," +
            COL_answer_b + " TEXT NOT NULL," +
            COL_answer_c + " TEXT NOT NULL," +
            COL_answer_d + " TEXT NOT NULL," +
            COL_correct + " INTEGER NOT NULL );";

    public static void insert(SQLiteDatabase db, Question q) {
        ContentValues values = new ContentValues();
        values.put(COL_question, q.getQuestion());
        values.put(COL_answer_a, q.getAnswer_a());
        values.put(COL_answer_b, q.getAnswer_b());
        values.put(COL_answer_c, q.getAnswer_c());
        values.put(COL_answer_d, q.getAnswer_d());
        values.put(COL_correct, q.getCorrect());
        long id = db.insert(TABLE_NAME, null, values);
        q.setId(id);

    }
}
