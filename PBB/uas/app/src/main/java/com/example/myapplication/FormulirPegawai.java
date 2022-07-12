package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormulirPegawai extends AppCompatActivity {

    EditText xkodbar,xnamabar,xsatuan,xjumlah,xharga;
    Button tblSimpan;
    DatabaseReference dbref;
    Barang barang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulir_pegawai);

        xkodbar=findViewById(R.id.kode_prod);
        xnamabar=findViewById(R.id.nama_prod);
        xsatuan=findViewById(R.id.satuan);
        xjumlah=findViewById(R.id.jumlah);
        xharga=findViewById(R.id.harga);
        tblSimpan=findViewById(R.id.tombolsimpan);

        barang=new Barang();
        dbref= FirebaseDatabase.getInstance().getReference().child("DataBarang");

        tblSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                barang.setKode_pro(xkodbar.getText().toString().trim());
                barang.setNama_pro(xnamabar.getText().toString().trim());
                barang.setSatuan(xsatuan.getText().toString().trim());
                barang.setJumlah(xjumlah.getText().toString().trim());
                barang.setHarga(xharga.getText().toString().trim());

                dbref.push().setValue(barang);
                Toast.makeText(FormulirPegawai.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
            }
        });
    }
}