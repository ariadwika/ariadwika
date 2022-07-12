package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Jual_Barang extends AppCompatActivity {
    //Deklarasi Variable
    private TextView kodeJual;
    private TextView namaJual;
    private TextView satJual;
    private TextView jmlStock;
    private EditText jmlJual;
    private EditText hrgJual;
    private EditText totHrg;
    private Button btnJual,btnBatal;
    private DatabaseReference database;
    private String cekKode, cekNama,cekSatuan, cekJumlah,cekHarga;
    DatabaseReference dbref;
    com.example.projectfirebase.Jual jual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jual_barang);
        kodeJual = findViewById(R.id.kodbar_J);
        namaJual = findViewById(R.id.nabar_J);
        satJual=findViewById(R.id.sat_J);
        jmlStock=findViewById(R.id.juml_J);
        jmlJual = findViewById(R.id.jual_jml);
        hrgJual=findViewById(R.id.harg_J);
        totHrg=findViewById(R.id.tot_hrg);

        btnJual = findViewById(R.id.tbljual);
        btnBatal=findViewById(R.id.tblbatal);

        jual=new com.example.projectfirebase.Jual();
        dbref= FirebaseDatabase.getInstance().getReference().child("Penjualan");
        database = FirebaseDatabase.getInstance().getReference();
        getData();

        btnBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Jual_Barang.this, com.example.projectfirebase.Tampil_data_jual.class);
                startActivity(intent);
            }
        });

        btnJual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Mendapatkan Data Mahasiswa yang akan dicek
                jual.setKode_pro_J(kodeJual.getText().toString().trim());
                jual.setNama_pro_J(namaJual.getText().toString().trim());
                jual.setSatuan_J(satJual.getText().toString().trim());
                jual.setHarga_J(hrgJual.getText().toString().trim());
                jual.setJumlah_J(jmlJual.getText().toString().trim());
                jual.setTot_harga_J(totHrg.getText().toString().trim());


                dbref.push().setValue(jual);
                Toast.makeText(Jual_Barang.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();

            }
        });
    }

    //Menampilkan data yang akan di update
    private void getData(){
        //Menampilkan data dari item yang dipilih sebelumnya
        final String getkode = getIntent().getExtras().getString("dataKode");
        final String getnama = getIntent().getExtras().getString("dataNama");
        final String getsat = getIntent().getExtras().getString("dataSat");
        final String getjml = getIntent().getExtras().getString("dataJml");
        final String gethrg = getIntent().getExtras().getString("dataHrg");

        kodeJual.setText(getkode);
        namaJual.setText(getnama);
        satJual.setText(getsat);
        jmlStock.setText(getjml);
        hrgJual.setText(gethrg);
    }

}