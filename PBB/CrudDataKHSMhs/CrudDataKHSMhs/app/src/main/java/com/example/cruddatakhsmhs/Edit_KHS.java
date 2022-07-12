package com.example.cruddatakhsmhs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Edit_KHS extends AppCompatActivity {
    DatabaseHelper dbh;
    EditText ekode,ematkul,esks,en_angka,en_huruf,epredikat;

    String dkode = "kodenya";
    String dmatkul = "matkulnya";
    String dsks = "sksnya";
    String dn_angka = "nangkanya";
    String dn_huruf = "nhurufnya";

    String tampungKode,tampungMatkul,tampungSks,tampungN_angka,tampungN_huruf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_khs);

        ekode=findViewById(R.id.kode_edit);
        ematkul=findViewById(R.id.matkul_edit);
        esks=findViewById(R.id.sks_edit);
        en_angka=findViewById(R.id.angka_edit);
        en_huruf=findViewById(R.id.huruf_edit);
        epredikat=findViewById(R.id.predikat_edit);

        dbh=new DatabaseHelper(this);
        Bundle bundle=getIntent().getExtras();
        tampungKode=bundle.getString(dkode);
        tampungMatkul=bundle.getString(dmatkul);
        tampungSks=bundle.getString(dsks);
        tampungN_angka=bundle.getString(dn_angka);
        tampungN_huruf=bundle.getString(dn_huruf);

        ekode.setText(tampungKode);
        ematkul.setText(tampungMatkul);
        esks.setText(tampungSks);
        en_angka.setText(tampungN_angka);
        en_huruf.setText(tampungN_huruf);

    }

    public void act_update(View view) {
        dbh.update_data(ekode.getText().toString(),ematkul.getText().toString(),esks.getText().toString(),en_angka.getText().toString(),en_huruf.getText().toString());
        Toast.makeText(getApplicationContext(), "Update Success", Toast.LENGTH_SHORT).show();
    }

    public void act_delete(View view) {
        dbh.hapus_data(ekode.getText().toString(),ematkul.getText().toString(),esks.getText().toString(),en_angka.getText().toString(),en_huruf.getText().toString());
        Toast.makeText(getApplicationContext(), "Delete Success", Toast.LENGTH_SHORT).show();
    }

    public void act_view(View view) {
        Intent intent = new Intent(Edit_KHS.this, MainActivity.class);
        startActivity(intent);
    }

    public void act_pred(View view) {
        int nilait = Integer.parseInt(en_angka.getText().toString());
        if (nilait <= 100 && nilait >=85){
            en_huruf.setText("A");
            epredikat.setText("Istimewa");
        } else if (nilait < 85 && nilait >= 80){
            en_huruf.setText("AB");
            epredikat.setText("Amat Baik");
        } else if (nilait < 80 && nilait >= 70){
            en_huruf.setText("B");
            epredikat.setText("Baik");
        } else if (nilait < 70 && nilait >= 65){
            en_huruf.setText("BC");
            epredikat.setText("Cukup Baik");
        } else if (nilait < 65 && nilait >= 60){
            en_huruf.setText("C");
            epredikat.setText("Cukup");
        } else if (nilait < 60 && nilait >= 50){
            en_huruf.setText("D");
            epredikat.setText("Kurang Baik");
        } else if (nilait < 50){
            en_huruf.setText("E");
            epredikat.setText("Remidi");
        }
    }
}