package com.example.cruddatakhsmhs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View.OnKeyListener;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class Input_KHS extends AppCompatActivity {
    EditText ikode, imatkul, isks, in_angka, in_huruf, ipredikat;
    DatabaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_khs);

        ikode = findViewById(R.id.kodekhs);
        imatkul = findViewById(R.id.makulkhs);
        isks = findViewById(R.id.skskhs);
        in_angka = findViewById(R.id.angkakhs);
        in_huruf = findViewById(R.id.hurufkhs);
        ipredikat = findViewById(R.id.predikatkhs);

        dbh = new DatabaseHelper(this);

    }

    public void act_plus(View view) {
        dbh.tambah_data(ikode.getText().toString(), imatkul.getText().toString(), isks.getText().toString(), in_angka.getText().toString(), in_huruf.getText().toString());
        Toast.makeText(getApplicationContext(), "Update Success", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Input_KHS.this, MainActivity.class);
        startActivity(intent);
    }

    public void act_view(View view) {
        Intent intent = new Intent(Input_KHS.this, MainActivity.class);
        startActivity(intent);
    }

    public void act_pred(View view) {
        int nilait = Integer.parseInt(in_angka.getText().toString());
        if (nilait <= 100 && nilait >= 85) {
            in_huruf.setText("A");
            ipredikat.setText("Istimewa");
        } else if (nilait < 85 && nilait >= 80) {
            in_huruf.setText("AB");
            ipredikat.setText("Amat Baik");
        } else if (nilait < 80 && nilait >= 70) {
            in_huruf.setText("B");
            ipredikat.setText("Baik");
        } else if (nilait < 70 && nilait >= 65) {
            in_huruf.setText("BC");
            ipredikat.setText("Cukup Baik");
        } else if (nilait < 65 && nilait >= 60) {
            in_huruf.setText("C");
            ipredikat.setText("Cukup");
        } else if (nilait < 60 && nilait >= 50) {
            in_huruf.setText("D");
            ipredikat.setText("Kurang Baik");
        } else if (nilait < 50) {
            in_huruf.setText("E");
            ipredikat.setText("Remidi");
        }
    }
}