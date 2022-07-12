package com.example.kalkulatorku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnPlus, btnMin, btnBagi, btnKali;
    EditText angka1, angka2;
    TextView hasilhitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angka1 = findViewById(R.id.angka1);
        angka2 = findViewById(R.id.angka2);
        hasilhitung =  findViewById(R.id.hasilhitung);

        btnPlus = findViewById(R.id.tbplus);
        btnMin = findViewById(R.id.tbmin);
        btnKali = findViewById(R.id.tbkali);
        btnBagi = findViewById(R.id.tbbagi);

        btnPlus.setOnClickListener(this);
        btnMin.setOnClickListener(this);
        btnKali.setOnClickListener(this);
        btnBagi.setOnClickListener(this);
    }
    @Override
    public void  onClick(View v) {
        switch (v.getId()) {
            case R.id.tbplus:
                tambah();
                break;
            case R.id.tbmin:
                kurang();
                break;
            case R.id.tbkali:
                kali();
                break;
            case R.id.tbbagi:
                bagi();
                break;
        }
    }
    private void tambah(){
        if (angka1.getText().toString().trim().isEmpty() || angka2.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Data Masih Kosong !", Toast.LENGTH_SHORT).show();
        }
        else {
            float ang1 = Float.parseFloat(String.valueOf(angka1.getText()));
            float ang2 = Float.parseFloat((String.valueOf(angka2.getText())));

            float hasil = (ang1 + ang2);
            hasilhitung.setText("" + hasil);
        }
    }

    private void kurang(){
        if (angka1.getText().toString().trim().isEmpty() || angka2.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Data Masih Kosong !", Toast.LENGTH_SHORT).show();
        }
        else {
            float ang1 = Float.parseFloat(String.valueOf(angka1.getText()));
            float ang2 = Float.parseFloat((String.valueOf(angka2.getText())));

            float hasil = (ang1 - ang2);
            hasilhitung.setText("" + hasil);
        }
    }

    private void kali(){
        if (angka1.getText().toString().trim().isEmpty() || angka2.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Data Masih Kosong !", Toast.LENGTH_SHORT).show();
        }
        else {
            float ang1 = Float.parseFloat(String.valueOf(angka1.getText()));
            float ang2 = Float.parseFloat((String.valueOf(angka2.getText())));

            float hasil = (ang1 * ang2);
            hasilhitung.setText("" + hasil);
        }
    }

    private void bagi(){
        if (angka1.getText().toString().trim().isEmpty() || angka2.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Data Masih Kosong !", Toast.LENGTH_SHORT).show();
        }
        else {
            float ang1 = Float.parseFloat(String.valueOf(angka1.getText()));
            float ang2 = Float.parseFloat((String.valueOf(angka2.getText())));

            float hasil = (ang1 / ang2);
            hasilhitung.setText("" + hasil);
        }
    }
}