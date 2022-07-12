package com.example.kalkulatorku;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnTambah,btnBagi,btnKurang,btnKali;
    EditText angka01,angka02;
    TextView hasilperhitungan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angka01=findViewById(R.id.angka1);
        angka02=findViewById(R.id.angka2);
        hasilperhitungan=findViewById(R.id.hasiloperasi);

        btnTambah=findViewById(R.id.tbtambah);
        btnBagi=findViewById(R.id.tbbagi);
        btnKurang=findViewById(R.id.tbkurang);
        btnKali=findViewById(R.id.tbkali);

        btnTambah.setOnClickListener(this);
        btnKali.setOnClickListener(this);
        btnBagi.setOnClickListener(this);
        btnKurang.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch (v.getId())
        {
            case R.id.tbtambah:
                tambah();
                break;
            case R.id.tbbagi:
                bagi();
                break;
            case R.id.tbkali:
                kali();
                break;
            case R.id.tbkurang:
                kurang();
                break;
        }
    }

    private void kurang() {
        if(angka01.getText().toString().trim().isEmpty() || angka02.getText().toString().trim().isEmpty())
        {
            Toast.makeText(this, "Data Masih Kosong!", Toast.LENGTH_SHORT).show();
        } else {
            float ang1 = Float.parseFloat(String.valueOf(angka01.getText()));
            float ang2 = Float.parseFloat(String.valueOf(angka02.getText()));

            float hasil = (ang1 - ang2);
            hasilperhitungan.setText("" + hasil);
        }
    }

    private void kali() {
        if(angka01.getText().toString().trim().isEmpty() || angka02.getText().toString().trim().isEmpty())
        {
            Toast.makeText(this, "Data Masih Kosong!", Toast.LENGTH_SHORT).show();
        } else {
            float ang1 = Float.parseFloat(String.valueOf(angka01.getText()));
            float ang2 = Float.parseFloat(String.valueOf(angka02.getText()));

            float hasil = (ang1 * ang2);
            hasilperhitungan.setText("" + hasil);
        }
    }

    private void bagi() {
        if(angka01.getText().toString().trim().isEmpty() || angka02.getText().toString().trim().isEmpty())
        {
            Toast.makeText(this, "Data Masih Kosong!", Toast.LENGTH_SHORT).show();
        } else {
            float ang1 = Float.parseFloat(String.valueOf(angka01.getText()));
            float ang2 = Float.parseFloat(String.valueOf(angka02.getText()));

            float hasil = (ang1 / ang2);
            hasilperhitungan.setText("" + hasil);
        }
    }

    private void tambah() {
        if(angka01.getText().toString().trim().isEmpty() || angka02.getText().toString().trim().isEmpty())
        {
            Toast.makeText(this, "Data Masih Kosong!", Toast.LENGTH_SHORT).show();
        } else {
            float ang1 = Float.parseFloat(String.valueOf(angka01.getText()));
            float ang2 = Float.parseFloat(String.valueOf(angka02.getText()));

            float hasil = (ang1 + ang2);
            hasilperhitungan.setText("" + hasil);
        }
    }

}