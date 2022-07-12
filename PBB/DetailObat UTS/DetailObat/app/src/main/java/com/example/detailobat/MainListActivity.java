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

        String nama_obat[]={"Amoxylin", "Dextamine", "Candesartan",
                "Ambroxol", "Paracetamol", "Dextral",
                "Allopurinol", "Bisoprolol"
        };

        String harga_obat[]={"1500", "2000", "2100",
                "4500", "1200", "8500",
                "2500", "2000"
        };

        String tipe_obat[]={"Kapsul", "Kapsul", "Kapusl",
                "Kapsul", "Kapsul", "Kapsul",
                "Kapsul", "Kapsul"
        };

        int gambar_obat[]={R.drawable.mkapak, R.drawable.obhcombi, R.drawable.salonpas,
                R.drawable.rohto, R.drawable.bodrex, R.drawable.catrambut,
                R.drawable.promag, R.drawable.milton};

        String keterangan[]={"Amoxylin obat untuk antibiotik tubuh.",
                "Dextamine obat untuk meredakan sakit radang.",
                "Candesartan obat untuk meredakan darah tinggi.",
                "Ambroxol obat untuk meredakan sakit batuk.",
                "Paracetamol obat untuk meredakan sakit panas.",
                "Dextral obat untuk meredakan sakit batuk",
                "Allopurinol obat untuk meredakan sakit batuk.",
                "Bisoprolol obat untuk penyakit jantung."};

        listView=findViewById(R.id.listdataobat);
        AdapterObat adapterObat=new AdapterObat(this,nama_obat, harga_obat, tipe_obat, gambar_obat, keterangan);
        listView.setAdapter(adapterObat);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String nm_obat=nama_obat[position].toString();
                String hrg_obat=harga_obat[position].toString();
                String tp_obat=tipe_obat[position].toString();
                int gbr_obat=gambar_obat[position];
                String ket=keterangan[position].toString();

                Intent intent=new Intent(MainListActivity.this,DetailObat.class);
                intent.putExtra("Namaobat",nm_obat);
                intent.putExtra("Hargaobat",hrg_obat);
                intent.putExtra("Tipeobat",tp_obat);
                intent.putExtra("gambarobat",gbr_obat);
                intent.putExtra("keter", ket);
                startActivity(intent);
            }
        });
    }
}