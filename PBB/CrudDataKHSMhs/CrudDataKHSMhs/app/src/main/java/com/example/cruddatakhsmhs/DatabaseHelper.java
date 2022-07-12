package com.example.cruddatakhsmhs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public final static String nama_db="DB_MHS";
    public final static String nama_table="KHS";

    public final static String field_01="kode";
    public final static String field_02="matkul";
    public final static String field_03="sks";
    public final static String field_04="n_angka";
    public final static String field_05="n_huruf";

    public DatabaseHelper(Context context) {
        super(context, nama_db, null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+nama_table+"(kode text primary key, matkul text, sks text, n_angka text, n_huruf text, predikat text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST"+nama_table);
        onCreate(db);
    }

    public void tambah_data(String kode, String matkul, String sks, String n_angka, String n_huruf) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(field_01,kode);
        contentValues.put(field_02,matkul);
        contentValues.put(field_03,sks);
        contentValues.put(field_04,n_angka);
        contentValues.put(field_05,n_huruf);

        db.insert(nama_table,null,contentValues);
    }

    public Cursor baca_data() {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+nama_table,null );
        return res;
    }

    public void update_data(String toString, String toString1, String toString2, String toString3, String toString4) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(field_01,toString);
        contentValues.put(field_02,toString1);
        contentValues.put(field_03,toString2);
        contentValues.put(field_04,toString3);
        contentValues.put(field_05,toString4);

        db.update(nama_table,contentValues,"kode=?",new String[] {toString});
    }

    public void hapus_data(String toString, String toString1, String toString2, String toString3, String toString4) {
        SQLiteDatabase db=this.getWritableDatabase();

        db.delete(nama_table,"kode=?",new String[] {toString});
    }
}
