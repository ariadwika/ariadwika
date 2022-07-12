package com.example.sqlitemhs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class input_Mhs extends AppCompatActivity {
    Button tblsave,tblview;
    EditText xnim, xnama;
    DatabaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_mhs);

        xnim = findViewById(R.id.nimmhs);
        xnama = findViewById(R.id.namamhs);

        dbh = new DatabaseHelper(this);

        tblsave = findViewById(R.id.tombol_simpan);
        tblview = findViewById(R.id.tombol_view);

        tblsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbh.tambah_data(xnim.getText().toString(), xnama.getText().toString());
            }
        });

        tblview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(input_Mhs.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}