package com.example.projectfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateData extends AppCompatActivity {

    //Deklarasi Variable
    private EditText kodeBaru;
    private EditText namaBaru;
    private EditText satBaru;
    private EditText jmlBaru;
    private EditText hrgBaru;
    private Button btnupdate,btndelete;
    private DatabaseReference database;
    private String cekKode, cekNama,cekSatuan, cekJumlah,cekHarga;
    Barang barang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);
        kodeBaru = findViewById(R.id.new_kode);
        namaBaru = findViewById(R.id.new_nama);
        satBaru=findViewById(R.id.new_sat);
        jmlBaru = findViewById(R.id.new_jml);
        hrgBaru=findViewById(R.id.new_hrg);

        btnupdate = findViewById(R.id.tblupdate);
        btndelete=findViewById(R.id.tbldelete);

        barang=new Barang();
        database = FirebaseDatabase.getInstance().getReference();
        getData();

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hapusData();
                Intent intent = new Intent(UpdateData.this,Tampil_data_guru.class);
                startActivity(intent);

            }
        });

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Mendapatkan Data Mahasiswa yang akan dicek
                cekKode = kodeBaru.getText().toString();
                cekNama = namaBaru.getText().toString();
                cekSatuan= satBaru.getText().toString();
                cekJumlah = jmlBaru.getText().toString();
                cekHarga= hrgBaru.getText().toString();

                //Mengecek agar tidak ada data yang kosong, saat proses update
                if(isEmpty(cekNama) || isEmpty(cekNama)){
                    Toast.makeText(UpdateData.this, "Data tidak boleh ada yang kosong", Toast.LENGTH_SHORT).show();
                }else {
                    /*
                      Menjalankan proses update data.
                      Method Setter digunakan untuk mendapakan data baru yang diinputkan User.
                    */
                    Barang setbarang = new Barang();
                    setbarang.setKode_pro(kodeBaru.getText().toString());
                    setbarang.setNama_pro(namaBaru.getText().toString());
                    setbarang.setSatuan(satBaru.getText().toString());
                    setbarang.setJumlah(jmlBaru.getText().toString());
                    setbarang.setHarga(hrgBaru.getText().toString());
                    updateBarang(setbarang);
                }
            }
        });
    }

    // Mengecek apakah ada data yang kosong, sebelum diupdate
    private boolean isEmpty(String s){
        return TextUtils.isEmpty(s);
    }

    //Menampilkan data yang akan di update
    private void getData(){
        //Menampilkan data dari item yang dipilih sebelumnya
        final String getkode = getIntent().getExtras().getString("dataKode");
        final String getnama = getIntent().getExtras().getString("dataNama");
        final String getsat = getIntent().getExtras().getString("dataSat");
        final String getjml = getIntent().getExtras().getString("dataJml");
        final String gethrg = getIntent().getExtras().getString("dataHrg");

        kodeBaru.setText(getkode);
        namaBaru.setText(getnama);
        satBaru.setText(getsat);
        jmlBaru.setText(getjml);
        hrgBaru.setText(gethrg);
    }

    //Proses Update data yang sudah ditentukan
    private void updateBarang(Barang barang){
        String getKey = getIntent().getExtras().getString("getPrimaryKey");
        database.child("DataBarang")
                .child(getKey)
                .setValue(barang)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        kodeBaru.setText("");
                        namaBaru.setText("");
                        satBaru.setText("");
                        jmlBaru.setText("");
                        hrgBaru.setText("");
                        Toast.makeText(UpdateData.this, "Data Berhasil diubah",
                                Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
    }
    private void hapusData() {
        String getKey = getIntent().getExtras().getString("getPrimaryKey");
        database.child("DataBarang")
                .child(getKey)
                .removeValue()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(UpdateData.this, "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                    }
         });
 }
}
