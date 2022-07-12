package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Tampil_data_guru extends AppCompatActivity implements
com.example.firebaseuas12607.PegawaiAdaptor.datalistener {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampil_data_guru);
        recyclerView = findViewById(R.id.masterdatabarang);
        MyRecyclerView();
        GetData();
    }

    //Deklarasi Variable Database Reference dan ArrayList dengan Parameter Class Model kita.
    private DatabaseReference reference;
    private ArrayList<com.example.projectfirebase.Barang> dataBarangs;

    private void GetData() {
        //Mendapatkan Referensi Database
        reference = FirebaseDatabase.getInstance().getReference();
        reference.child("DataBarang").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataBarangs = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    com.example.projectfirebase.Barang produk = snapshot.getValue(com.example.projectfirebase.Barang.class);
                    produk.setKey(snapshot.getKey());
                    dataBarangs.add(produk);
                }

                //Inisialisasi Adapter dan data Mahasiswa dalam bentuk Array
                adapter = new com.example.projectfirebase.PegawaiAdaptor(dataBarangs, Tampil_data_guru.this);

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
    public void onDeleteData(com.example.projectfirebase.Barang data, int position) {
        if (reference != null) {
            reference.child("DataBarang")
                    .child(data.getKey())
                    .removeValue()
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(Tampil_data_guru.this, "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
}

    public void add_entry(View view) {
        Intent intent=new Intent(Tampil_data_guru.this, com.example.projectfirebase.FormulirPegawai.class);
        startActivity(intent);
    }
}