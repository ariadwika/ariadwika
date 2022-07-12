package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormPegawai extends AppCompatActivity {

    EditText xnopeg, xnampeg, xjabatan;
    Button tblSimpan;
    DatabaseReference dbref;
    Pegawai pegawai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pegawai);

        xnopeg=findViewById(R.id.no_pegawai);
        xnampeg=findViewById(R.id.nama_pegawai);
        xjabatan=findViewById(R.id.jabatan);
        tblSimpan=findViewById(R.id.tombolsimpan);

        pegawai=new Pegawai();
        dbref= FirebaseDatabase.getInstance().getReference().child("AbsenPegawai");

        tblSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pegawai.setNomor_peg(xnopeg.getText().toString().trim());
                pegawai.setNama_peg(xnampeg.getText().toString().trim());
                pegawai.setJabatan(xjabatan.getText().toString().trim());

                dbref.push().setValue(pegawai);
            }
        });
    }
}
