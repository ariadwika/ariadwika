package com.example.detailobat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailKlub extends AppCompatActivity {
    ImageView gambarklub_masuk;
    TextView nama_klub_masuk, tahun_klub_masuk, stadion_klub_masuk, pelatih_klub_masuk, lokasi_klub_masuk;

    String nm_kunci = "namaklub";
    String thn_kunci = "hargaobat";
    String st_kunci = "tipeobat";
    String pl_kunci = "keter";
    String lk_kunci = "lokasi";
    int gambarklub;

    String namaklub;
    String tahunklub;
    String stadionklub;
    String pelatihklub;
    String lokasiklub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_klub);
        gambarklub_masuk = findViewById(R.id.gambarterima);
        nama_klub_masuk = findViewById(R.id.nama_klub);
        tahun_klub_masuk = findViewById(R.id.tahun_klub);
        stadion_klub_masuk = findViewById(R.id.stadion_klub);
        pelatih_klub_masuk = findViewById(R.id.pelatih_klub);
        lokasi_klub_masuk = findViewById(R.id.lokasi_klub);


        Bundle bundle = getIntent().getExtras();

        gambarklub = bundle.getInt(String.valueOf("gambarklub"));
        gambarklub_masuk.setImageResource(gambarklub);

        namaklub = bundle.getString("Namaklub");
        tahunklub = bundle.getString("Tahunklub");
        stadionklub = bundle.getString("Stadionklub");
        pelatihklub = bundle.getString("Pelatihklub");
        lokasiklub = bundle.getString("Lokasiklub");

        nama_klub_masuk.setText(namaklub);
        tahun_klub_masuk.setText(tahunklub);
        stadion_klub_masuk.setText(stadionklub);
        pelatih_klub_masuk.setText(pelatihklub);
        lokasi_klub_masuk.setText(lokasiklub);
    }
}

