package com.example.cruddatakhsmhs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper dbh;
    ListView listView;
    Button tblinput;

    ArrayList<String> listdata;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.list_view);
        tblinput=findViewById(R.id.tombol_input);
        dbh=new DatabaseHelper(this);
        listdata=new ArrayList<>();

        Cursor cursor= dbh.baca_data();

        listdata.clear();
        while(cursor.moveToNext()) {
            listdata.add(cursor.getString(0)+" | "+cursor.getString(1)+" | "+cursor.getString(2)+" | "+cursor.getString(3)+" | "+cursor.getString(4));
        }
        adapter=new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,listdata);
        listView.setAdapter(adapter);

        tblinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Input_KHS.class);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,Edit_KHS.class);
                String xkode=(listdata.get(position).substring(0,8));
                int panjang=listdata.get(position).length();
                String xn_huruf=(listdata.get(position).substring(panjang-1,panjang));
                String xn_angka=(listdata.get(position).substring(panjang-6,panjang-4));
                String xsks=(listdata.get(position).substring(panjang-10,panjang-9));
                String xmatkul=(listdata.get(position).substring(7,panjang-13));

                //Toast.makeText(getApplicationContext(), xmatkul, Toast.LENGTH_SHORT).show();

                intent.putExtra("kodenya",xkode);
                intent.putExtra("matkulnya",xmatkul);
                intent.putExtra("sksnya",xsks);
                intent.putExtra("nangkanya",xn_angka);
                intent.putExtra("nhurufnya",xn_huruf);

                startActivity(intent);
                return false;
            }
        });
    }
}