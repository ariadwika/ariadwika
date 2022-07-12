package com.example.krsmhsudinus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper  extends SQLiteOpenHelper {
    public final static String nama_db = "DB_MHS";
    public final static String nama_table = "Mahasiswa";

    public final static String field_01 = "nim";
    public final static String field_02 = "nama_mhs";
    public final static String field_03 = "sks";
    public final static String field_04 = "angka";
    public final static String field_05 = "huruf";
    public final static String field_06 = "predikat";


    public DatabaseHelper(Context context) {
        super(context, nama_db, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + nama_table +"(nim text primary key, " +
                "nama_mhs text, sks text,angka text, huruf text , predikat text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXSIST"+ nama_table);
        onCreate(sqLiteDatabase);
    }

    public void tambah_data(String xkode, String xmatkul , String xsks , String xangka, String xhuruf, String xpredikat) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(field_01,xkode);
        contentValues.put(field_02,xmatkul);
        contentValues.put(field_03, xsks);
        contentValues.put(field_04, xangka);
        contentValues.put(field_05, xhuruf);
        contentValues.put(field_06, xpredikat);

        db.insert(nama_table, null, contentValues);
    }

    public Cursor baca_data() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+nama_table,null);
        return res;
    }

    public void update_data(String toString, String toString2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(field_01,toString);
        contentValues.put(field_02,toString2);

        db.update(nama_table,contentValues,"nim=?",new String[] {toString});

    }

    public void hapusData(String toString){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(nama_table , "nim = ?",new String[]{toString});
    }

}