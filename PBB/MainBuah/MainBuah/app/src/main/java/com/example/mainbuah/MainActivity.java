package com.example.mainbuah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String nama_buah[]={"Mangga", "Pisang", "Semangka",
                            "Salak", "Jeruk", "Apel",
                            "Anggur", "Durian"
                            };

        int gambar_buah[]={R.drawable.mangga, R.drawable.pisang, R.drawable.semangka,
                           R.drawable.salak, R.drawable.jeruk, R.drawable.apel,
                           R.drawable.anggur, R.drawable.durian};

        String keterangan[]={"Buah mangga mengandung vitamin C yang cukup untuk membantu Anda mencegah serangan bakteri penyebab beragam penyakit seperti sakit pilek hingga flu",
                             "Buah pisang merupakan salah satu buah yang kaya akan mineral kalium dan serat pektin.",
                             "Buah semangka yang penuh dengan air itu mengandung vitamin A, vitamin B6m dan vitamin C yang signifikan.",
                             "Buah salak mengandung nutrisi seperti protein, beta karoten, vitamin C, serat makanan, zat besi, kalsium, fosfor dan karbohidrat yang bagus untuk kesehatan secara keseluruhan.",
                             "Buah jeruk sangat identik dengan vitamin C.",
                             "Buah apel merupakan buah yang mengandung bahan kimia flavonoids yang memiliki beragam manfaat yang baik untuk tubuh Anda.",
                             "Buah anggur memiliki kandungan zat gizi yang baik bagi tubuh.",
                             "Buah durian mengandung ragam vitamin dan mineral, karbohidrat, lemak, serta protein."};

        listView=findViewById(R.id.listdatabuah);
        AdapterBuah adapterBuah=new AdapterBuah(this,nama_buah, gambar_buah, keterangan);
        listView.setAdapter(adapterBuah);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String nm_buah=nama_buah[position].toString();
                int gbr_buah=gambar_buah[position];
                String ket=keterangan[position].toString();

                //Toast.makeText(MainActivity.this, ""+gbr_buah, Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,DetailBuah.class);
                intent.putExtra("namabuah",nm_buah);
                intent.putExtra("gambarbuah",gbr_buah);
                intent.putExtra("keter", ket);
                startActivity(intent);
            }
        });
    }
}