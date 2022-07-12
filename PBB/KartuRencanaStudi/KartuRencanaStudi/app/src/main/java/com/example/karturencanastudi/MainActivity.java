    package com.example.karturencanastudi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

    public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public CardView card1,card2,card5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String nomer[]={"1","2","3","4","5","6","7","8"};
        String kode[]={"54205","54306","54314","54501","54506","54608","54703","N201706"};
        String matkul[]={"Etika Profesi","Struktur Data","Pemrograman Berbasis Web"
                ,"Jaringan Komputer","Sistem Informasi","Pemrograman Perangkat Bergerak"
                ,"Manajemen Proyek","Pendidikan Kewarganegaraan"};
        String sks[]={"2","4","2","3","3","3","3","2"};
        String angka[]={"80","80","80","80","80","80","80","80"};
        String huruf[]={"B","B","B","B","B","B","B","B"};

        card1 = (CardView) findViewById(R.id.klikentry); // penghubung hasil dengan tombol menu
        card2 = (CardView) findViewById(R.id.kliktampil);
        card5 = (CardView) findViewById(R.id.kliktentang);
        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        Intent i;

        // memilih ketika tombol di klik akan pergi kemana
        switch (view.getId()){
            case R.id.klikentry:
                i = new Intent(this,HasilEntry.class); // nama file activity yg dituju
                startActivity(i);
                break;
            case R.id.kliktampil:
                i = new Intent(this,HasilTampil.class); // nama file activity yg dituju
                startActivity(i);
                break;
            case R.id.kliktentang:
                i = new Intent(this,HasilTentang.class); // nama file activity yg dituju
                startActivity(i);
                break;
            }
        }
    }