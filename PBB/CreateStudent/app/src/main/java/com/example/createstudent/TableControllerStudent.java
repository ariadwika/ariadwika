package com.example.createstudent;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TableControllerStudent extends DatabaseHandler {
    public TableControllerStudent(Context context) {
        super(context);
    }
    public boolean create(ObjectStudent objectStudent) {
        ContentValues values = new ContentValues();
        values.put("firstname", objectStudent.firstname);
        values.put("email", objectStudent.email);
        SQLiteDatabase db = this.getWritableDatabase();
        boolean createSuccessful = db.insert("students", null, values) > 0;
        db.close();
        return createSuccessful;

    }
    public void countRecords() {
        int count;
        countRecords(); {

            SQLiteDatabase db = this.getWritableDatabase();

            String sql = "SELECT * FROM students";

            int recordCount = db.rawQuery(sql, null).getCount();

            db.close();

        }
    }
    public List<ObjectStudent> read() {
        List<ObjectStudent> recordsList = new ArrayList<ObjectStudent>();
        String sql = "SELECT * FROM students ORDER BY id DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                @SuppressLint("Range") String studentFirstname = cursor.getString(cursor.getColumnIndex("firstname"));
                @SuppressLint("Range") String studentEmail = cursor.getString(cursor.getColumnIndex("email"));
                ObjectStudent objectStudent = new ObjectStudent();
                objectStudent.id = id;
                objectStudent.firstname = studentFirstname;
                objectStudent.email = studentEmail;
                recordsList.add(objectStudent);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return recordsList;

    }

    public int count() {
        return 0;
    }

}

