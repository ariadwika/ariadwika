package com.example.sqlitemhs;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper dbh;
    ListView listView;

    ArrayList<String> listitem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.list_data);
        dbh=new DatabaseHelper(this);
        listitem=new ArrayList<>();

        String nim="a11202012607";
        String nama="Aria Dwika";

        dbh.tambah_data(nim, nama);

        Cursor cursor=dbh.baca_data();

        listitem.clear();
        while(cursor.moveToNext())
        {
            listitem.add(cursor.getString(0)+" "+(cursor.getString(1)));
        }
        adapter=new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item, listitem);
        listView.setAdapter(adapter);
    }
}