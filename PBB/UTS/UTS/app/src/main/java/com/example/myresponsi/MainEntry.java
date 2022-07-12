package com.example.myresponsi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainEntry extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_entry);

        String[] nama_obat ={"Allupurinol", "Ambroxol", "Amoxicillin",
                "Candesartan", "Dextamine", "Dextral",
                "Paracetamol", "Bisoprolol"
        };
        String[] hargaobat ={"1500","1000","2000","2500","3000","1750","1250","2250"
        };

        int[] gambar_buah ={R.drawable.mangga, R.drawable.pisang, R.drawable.semangka,
                R.drawable.salak, R.drawable.jeruk, R.drawable.apel,
                R.drawable.anggur, R.drawable.durian};

        String[] keterangan ={"Obat Allupurinol untuk mengobati sakit asam urat",
                "Obat Ambroxol untuk mengobati sakit batuk",
                "Obati Amoxicilin untuk Antibiotik tubuh.",
                "Obat Candesartan untuk mengobati sakit Tensi (Darah Tinggi).",
                "Obat Dextamine untuk mengobati sakit radang tenggorokan.",
                "Obat Dextral untuk mengobati sakit batuk.",
                "Obat Paracetamol untuk mengobati sakit panas.",
                "Obat Bisoprolol untuk mengobati sakit jantung."};

        listView=findViewById(R.id.listdatabuah);
        AdapterBuah adapterBuah=new AdapterBuah(this,nama_obat, gambar_buah, keterangan);
        listView.setAdapter(adapterBuah);
        listView.setOnItemClickListener((adapterView, view, position, id) -> {
            String nm_buah= nama_obat[position];
            String harga_obat= hargaobat[position];
            int gbr_buah=gambar_buah[position];
            String ket= keterangan[position];

            //Toast.makeText(MainActivity.this, ""+gbr_buah, Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainEntry.this,DetailBuah.class);
            intent.putExtra("namabuah",nm_buah);
            intent.putExtra("gambarbuah",gbr_buah);
            Intent keter = intent.putExtra("keter", ket);
            startActivity(intent);
        });
    }
}