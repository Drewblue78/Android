package com.example.project.sql_db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class Table {
    public static final String TABLE_NAME = "QuestDB";
    public static final String COL_id = "id";
    public static final String COL_question = "question";
    public static final String COL_answer_a = "answer_a";
    public static final String COL_answer_b = "answer_b";
    public static final String COL_answer_c = "answer_c";
    public static final String COL_answer_d = "answer_d";
    public static final String COL_correct = "correct";
    public static final String COL_category = "category";


    public static final String TABLE_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + " (" +
            COL_id + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            COL_question + " TEXT NOT NULL," +
            COL_answer_a + " TEXT NOT NULL," +
            COL_answer_b + " TEXT NOT NULL," +
            COL_answer_c + " TEXT NOT NULL," +
            COL_answer_d + " TEXT NOT NULL," +
            COL_correct + " INTEGER NOT NULL," +
            COL_category + " TEXT NOT NULL );";

    public static void insert(SQLiteDatabase db, Question q) {
        ContentValues values = new ContentValues();
        values.put(COL_question, q.getQuestion());
        values.put(COL_answer_a, q.getAnswer_a());
        values.put(COL_answer_b, q.getAnswer_b());
        values.put(COL_answer_c, q.getAnswer_c());
        values.put(COL_answer_d, q.getAnswer_d());
        values.put(COL_correct, q.getCorrect());
        values.put(COL_category, q.getCategory());
        long id = db.insert(TABLE_NAME, null, values);
        q.setId(id);
    }

    public static List<Question> getQuestions(SQLiteDatabase db){
        List<Question> results = new ArrayList<>();

        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            int iId = cursor.getColumnIndex(COL_id);
            int iQuestion = cursor.getColumnIndex(COL_question);
            int iAnswer_a = cursor.getColumnIndex(COL_answer_a);
            int iAnswer_b = cursor.getColumnIndex(COL_answer_b);
            int iAnswer_c = cursor.getColumnIndex(COL_answer_c);
            int iAnswer_d = cursor.getColumnIndex(COL_answer_d);
            int iCorrect = cursor.getColumnIndex(COL_correct);
            int iCategory = cursor.getColumnIndex(COL_category);
            Question question = new Question(
                    cursor.getInt(iId),
                    cursor.getString(iQuestion),
                    cursor.getString(iAnswer_a),
                    cursor.getString(iAnswer_b),
                    cursor.getString(iAnswer_c),
                    cursor.getString(iAnswer_d),
                    cursor.getInt(iCorrect),
                    cursor.getString(iCategory));
            results.add(question);
        }
        return results;
    }
}
