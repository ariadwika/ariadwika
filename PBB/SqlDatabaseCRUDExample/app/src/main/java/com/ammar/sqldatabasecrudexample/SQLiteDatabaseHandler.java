package com.ammar.sqldatabasecrudexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class SQLiteDatabaseHandler extends SQLiteOpenHelper {

    //DATABASE VERSION
    private static final int DATABASE_VERSION = 1;

    //DATABASE NAME
    private static final String DATABASE_NAME = "countryData";

    //Table Name in Database Country
    private static final String TABEL_COUNTRY = "Country";

    //Country Tabel Colums names
    private static final String KEY_ID = "id";
    private static final String COUNTRY_NAME = "Country_Name";
    private static final String POPULATION = "Population";

    public SQLiteDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //CREATING TABLE
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_COUNTRY_TABLE = "CREATE TABLE " + TABEL_COUNTRY + "(" + KEY_ID
                                        + " INTEGER PRIMARY KEY," + COUNTRY_NAME + " TEXT,"
                                        + POPULATION + " LONG" + ")";
                db.execSQL(CREATE_COUNTRY_TABLE);

    }

    //Upgrading Database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABEL_COUNTRY);
        onCreate(db);
    }

    void addCountry(Country country) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COUNTRY_NAME, country.getCountryName()); //input country name
        values.put(POPULATION, country.getPopulation()); //input country population

        //inserting row
        db.insert(TABEL_COUNTRY, null, values);
        db.close();
    }

    //getting single country
    Country getCountry(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABEL_COUNTRY, new String[] {KEY_ID, COUNTRY_NAME, POPULATION}, KEY_ID
                        + "=?", new String[] {String.valueOf(id)}, null, null, null, null);
        if(cursor != null) {
            cursor.moveToFirst();
        }

        Country country = new Country(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getLong(2));

        return country;
    }

    //getting All Country
    public List<Country> getAllCountry() {
        List<Country> countryList = new ArrayList<Country>();
        //select all query
        String selectQuery = "SELECT * FROM " + TABEL_COUNTRY;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()) {
            do {
                Country country = new Country();
                country.setId(Integer.parseInt(cursor.getString(0)));
                country.setCountryName(cursor.getString(1));
                country.setPopulation(cursor.getLong(2));
                countryList.add(country);
            }while(cursor.moveToNext());
        }
        return countryList;
    }

    //updating single country
    public int updateCountry(Country country) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COUNTRY_NAME, country.getCountryName());
        values.put(POPULATION, country.getPopulation());

        //updating row
        return db.update(TABEL_COUNTRY, values, KEY_ID + "=?",
                new String[] {String.valueOf(country.getId())});
    }

    //Deleting Single Country
    public void deleteCountry(Country country){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABEL_COUNTRY,KEY_ID + "=?",
                new String[] {String.valueOf(country.getId()) });
        db.close();
    }

    //Delete all country
    public void deleteAllCountry() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABEL_COUNTRY, null, null);
        db.close();
    }

    //Getting Country count
    public int getCountriesCount() {
        String countQuery = "SELECT * FROM " + TABEL_COUNTRY;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        //return count
        return cursor.getCount();
    }
}
