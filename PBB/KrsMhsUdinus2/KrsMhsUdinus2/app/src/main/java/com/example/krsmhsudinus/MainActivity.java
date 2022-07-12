package com.example.krsmhsudinus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper dbh;
    ListView listView;
    Button tblinput;
    ArrayList<String> listitem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_data);
        tblinput = findViewById(R.id.tombol_input);
        dbh = new DatabaseHelper(this);
        listitem = new ArrayList<>();

        // input data ke dalam table mahasiswa
        /*String nim = "A11.2020.12667";
        String nama = "Ikromi Latifano";

        dbh.tambah_data(nim,nama);
         */

        // tampilkan data mahasiswa
        Cursor cursor = dbh.baca_data();

        listitem.clear();
        while (cursor.moveToNext())
        {
            listitem.add(cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2)+" "
                    +cursor.getString(3)+" "+cursor.getString(4)+" "+cursor.getString(5));
        }
        adapter = new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,listitem);
        listView.setAdapter(adapter);


        tblinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, InputMhs.class);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent=new Intent(MainActivity.this, EditMhs.class);

                String mkode = (listitem.get(position).substring(0,9));
                int panjang = (listitem.get(position).length());
                String mmatkul = (listitem.get(position).substring(9,panjang));
                String msks = (listitem.get(position).substring(9,panjang));
                String mangka = (listitem.get(position).substring(9,panjang));
                String mhuruf = (listitem.get(position).substring(9,panjang));
                String mpredikat = (listitem.get(position).substring(9,panjang));

                Toast.makeText(getApplicationContext(), ""+mmatkul,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), ""+msks,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), ""+mangka,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), ""+mhuruf,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), ""+mpredikat,Toast.LENGTH_LONG).show();

                intent.putExtra("kodenya",mkode);
                intent.putExtra("matkulnya",mmatkul);
                intent.putExtra("sksnya",msks);
                intent.putExtra("angkanya",msks);
                intent.putExtra("hurufnya",msks);
                intent.putExtra("predikatnya",msks);

                startActivity(intent);
                return false;
            }
        });

    }
}