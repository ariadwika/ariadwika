package com.example.projectaplikasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_02 extends AppCompatActivity {
    ImageView imageView;
    TextView mnama,mnim;
    String xnama="nim";
    String xnim="nim";

    String gambar="gambar";
    String nama,nim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_02);

        imageView=findViewById(R.id.tarissamasuk);
        mnama=findViewById(R.id.nama_siswa);
        mnim=findViewById(R.id.nim_siswa);

        Bundle bundle=getIntent().getExtras();
        nama=bundle.getString(xnama);
        nim=bundle.getString(xnim);

        int tampilgambar=bundle.getInt(gambar);
        mnama.setText(nama);
        mnim.setText(nim);
        imageView.setImageResource(tampilgambar);
    }
}