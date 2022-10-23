package com.example.detailobat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainListActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_list);

        String nama_klub[]={"Arema", "Bali United", "Bhayangkara", "Borneo",
                "Dewa United", "Madura United", "Persebaya", "Persib", "Persija", "Persik",
                "Persikabo", "Persis", "Persita", "Barito", "PSIS", "PSM", "PSS", "Rans"
        };

        String tahun_klub[]={"1987", "2015", "2016", "2014", "2009", "2016", "1927",
                "1970", "1970", "1976", "1915", "1932", "1970", "1953", "1923", "2016", "1950",
                "1970"
        };

        String stadion_klub[]={ "Kanjuruhan Malang", " Kapten I Wayan Dipta", "Wibawa Mukti", "Segiri", "Indomilk Arena",
                "Gelora Pamelingan", "Gelora Bung Tomo", "Gelora Bandung Lautan Api", "Pakansari", "Maguwoharjo", "Gelora B.J Habibie",
                "Jatidiri", "Demang Lehman", "Indomilk Arena", "Manahan", "Pakansari", "Brawijaya", "Patriot Chandra Bhaga",
        };

        String website_klub[]={
        };

        String pelatih_klub[]={ "Eduardo Almeida","Stefano Cugurra", "Widodo Cahyono Putro", "Milomir Seslija", "Nil Mayzar", "Fabio Araujo",
        ""
        };

        String lokasi_klub[]={ "Jl.Mayjen Panjaitan No.42 Malang", "Jl.Pararaton 2, Legian Kuta Bali", "Jl.Wijaya XIV No.7 Jakarta Selatan", "Jl.Kesuma Bangsa Stadion Segiri Lorong Vip No 3/4", "Stadion Demang Lehman Kav A1 Martapura",
                "Jl.Raya Panglegur 10 Km 1,Tlanakan"
        };



        int gambar_klub[]={R.drawable.arema, R.drawable.baliunited, R.drawable.sambo,
                R.drawable.bornean, R.drawable.dewaunited, R.drawable.madurey,
                R.drawable.persebaya, R.drawable.persib, R.drawable.jekardah, R.drawable.dewipersik,
                R.drawable.persikabo, R.drawable.sologatuh, R.drawable.persita, R.drawable.barito,
                R.drawable.semarangnichh, R.drawable.masrizal, R.drawable.sleman, R.drawable.rafathar};


        listView=findViewById(R.id.listdataklub);
        AdapterKlub AdapterKlub= new AdapterKlub (this,nama_klub, tahun_klub, stadion_klub, website_klub, pelatih_klub, lokasi_klub, gambar_klub);
        listView.setAdapter(AdapterKlub);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String nm_klub=nama_klub[position].toString();
                String thn_klub=tahun_klub[position].toString();
                String st_klub=stadion_klub[position].toString();
                String wb_klub=website_klub[position].toString();
                String pl_klub=pelatih_klub[position].toString();
                String lk_klub=lokasi_klub[position].toString();
                int gbr_klub=gambar_klub[position];


                Intent intent=new Intent(MainListActivity.this, DetailKlub.class);
                intent.putExtra("Nama Klub",nm_klub);
                intent.putExtra("Tahun Berdiri",thn_klub);
                intent.putExtra("Stadion",st_klub);
                intent.putExtra("Website Klub",wb_klub);
                intent.putExtra("Pelatih Klub",pl_klub);
                intent.putExtra("Lokasi Klub",lk_klub);
                intent.putExtra("Gambar Klub",gbr_klub);
                intent.putExtra("Website Klub", website_klub);
                startActivity(intent);
            }
        });
    }
}