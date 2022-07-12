package com.example.mainbuah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailBuah extends AppCompatActivity {
    ImageView gambarbuah_masuk;
    TextView nama_buah_masuk, ket_buah_masuk;

    String nm_kunci="namabuah";
    String ket_kunci="keter";
    int gambarbuah;

    String namabuahe;
    String ketbuahe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buah);
        gambarbuah_masuk=findViewById(R.id.gambarterima);
        nama_buah_masuk=findViewById(R.id.nmbuah);
        ket_buah_masuk=findViewById(R.id.ket_buah);

        Bundle bundle=getIntent().getExtras();

        gambarbuah=bundle.getInt(String.valueOf("gambarbuah"));
        gambarbuah_masuk.setImageResource(gambarbuah);

        namabuahe=bundle.getString("namabuah");
        ketbuahe=bundle.getString("keter");

        nama_buah_masuk.setText(namabuahe);
        ket_buah_masuk.setText(ketbuahe);
    }
}