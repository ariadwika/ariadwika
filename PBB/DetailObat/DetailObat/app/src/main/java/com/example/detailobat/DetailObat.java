package com.example.detailobat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailObat extends AppCompatActivity {
    ImageView gambarobat_masuk;
    TextView nama_obat_masuk, harga_obat_masuk, tipe_obat_masuk, ket_obat_masuk;

    String nm_kunci = "namaobat";
    String hrg_kunci = "hargaobat";
    String tp_kunci = "tipeobat";
    String ket_kunci = "keter";
    int gambarobat;

    String namaobate;
    String hargaobate;
    String tipeobate;
    String ketobate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_obat);
        gambarobat_masuk = findViewById(R.id.gambarterima);
        nama_obat_masuk = findViewById(R.id.nm_obat);
        harga_obat_masuk = findViewById(R.id.hrg_obat);
        tipe_obat_masuk = findViewById(R.id.tp_obat);
        ket_obat_masuk = findViewById(R.id.ket_obat);

        Bundle bundle = getIntent().getExtras();

        gambarobat = bundle.getInt(String.valueOf("gambarobat"));
        gambarobat_masuk.setImageResource(gambarobat);

        namaobate = bundle.getString("Namaobat");
        hargaobate = bundle.getString("Hargaobat");
        tipeobate = bundle.getString("Tipeobat");
        ketobate = bundle.getString("keter");

        nama_obat_masuk.setText(namaobate);
        harga_obat_masuk.setText(hargaobate);
        tipe_obat_masuk.setText(tipeobate);
        ket_obat_masuk.setText(ketobate);
    }
}

