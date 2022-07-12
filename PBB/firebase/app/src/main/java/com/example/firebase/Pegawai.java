package com.example.firebase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Pegawai {
    private String nomor_peg;
    private String  nama_peg;
    private String jabatan;

    public String getNomor_peg() { return nomor_peg; }

    public void setNomor_peg(String nomor_peg) { this.nomor_peg = nomor_peg; }

    public String getNama_peg() { return nama_peg; }

    public void setNama_peg(String nama_peg) { this.nama_peg = nama_peg; }

    public String getJabatan() { return jabatan; }

    public void setJabatan(String jabatan) { this.jabatan = jabatan; }
}
