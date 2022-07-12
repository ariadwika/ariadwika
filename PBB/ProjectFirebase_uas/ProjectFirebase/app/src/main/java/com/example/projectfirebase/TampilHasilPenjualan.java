package com.example.projectfirebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TampilHasilPenjualan extends AppCompatActivity implements HasilAdaptor.datalistener {
        private RecyclerView recyclerView;
        private RecyclerView.Adapter adapter;
        private RecyclerView.LayoutManager layoutManager;
        private ProgressBar progressBar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tampil_hasil_penjualan);
            recyclerView = findViewById(R.id.masterdatahasil);
            MyRecyclerView();
            GetData();
        }

        //Deklarasi Variable Database Reference dan ArrayList dengan Parameter Class Model kita.
        private DatabaseReference reference;
        private ArrayList<Jual> dataHasils;

        private void GetData() {
            //Mendapatkan Referensi Database
            reference = FirebaseDatabase.getInstance().getReference();
            reference.child("Penjualan").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    dataHasils = new ArrayList<>();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Jual produk = snapshot.getValue(Jual.class);
                        produk.setKey(snapshot.getKey());
                        dataHasils.add(produk);
                    }

                    //Inisialisasi Adapter dan data Mahasiswa dalam bentuk Array
                    adapter = new HasilAdaptor(dataHasils, TampilHasilPenjualan.this);

                    //Memasang Adapter pada RecyclerView
                    recyclerView.setAdapter(adapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
        }

        //Methode yang berisi kumpulan baris kode untuk mengatur RecyclerView
        private void MyRecyclerView() {
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
            recyclerView.setHasFixedSize(true);
        }


        @Override
        public void onDeleteData(Hasil data, int position) {
            if (reference != null) {
                reference.child("Penjualan")
                        .child(data.getKey())
                        .removeValue()
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(TampilHasilPenjualan.this, "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        }

        public void add_entry(View view) {
            Intent intent=new Intent(TampilHasilPenjualan.this,FormulirPegawai.class);
            startActivity(intent);
        }
}