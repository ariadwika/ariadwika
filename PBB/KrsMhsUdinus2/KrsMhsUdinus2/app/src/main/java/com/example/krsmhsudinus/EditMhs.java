package com.example.krsmhsudinus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditMhs extends AppCompatActivity {

    DatabaseHelper dbh;

    EditText ckode, cmatkul,csks,cangka,churuf,cpredikat;
    Button btnUpdate, btnDelete, btnView;

    String dkode="kodenya";
    String dmatkul="matkulnya";
    String dsks="sksnya";
    String dangka="angkanya";
    String dhuruf="hurufnya";
    String dpredikat="predikatnya";

    String tampungKode, tampungMatkul,tampungSks,tampungAngka, tampungHuruf, tampungPredikat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mhs);

        ckode=findViewById(R.id.kodemhs_edit);
        cmatkul=findViewById(R.id.matkulmhs_edit);
        csks=findViewById(R.id.sksmhs_edit);
        cangka=findViewById(R.id.angkamhs_edit);
        churuf=findViewById(R.id.hurufmhs_edit);
        cpredikat=findViewById(R.id.predikatmhs_edit);

        btnUpdate=findViewById(R.id.tombol_update);
        btnDelete=findViewById(R.id.tombol_delete);
        btnView=findViewById(R.id.tombol_view);

        dbh = new DatabaseHelper(this);

        Bundle bundle = getIntent().getExtras();
        tampungKode = bundle.getString(dkode);
        tampungMatkul = bundle.getString(dmatkul);
        tampungSks=bundle.getString(dsks);
        tampungAngka=bundle.getString(dangka);
        tampungHuruf=bundle.getString(dhuruf);
        tampungPredikat=bundle.getString(dpredikat);


        ckode.setText(tampungKode);
        cmatkul.setText(tampungMatkul);
        csks.setText(tampungSks);
        cangka.setText(tampungAngka);
        churuf.setText(tampungHuruf);
        cpredikat.setText(tampungPredikat);


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbh.update_data(ckode.getText().toString(), cmatkul.getText().toString());
                Toast.makeText(getApplicationContext(), "Update Succes !" , Toast.LENGTH_SHORT).show();
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditMhs.this,com.example.krsmhsudinus.MainActivity.class);
                startActivity(intent);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbh.hapusData(ckode.getText().toString());
                Toast.makeText(getApplicationContext(),"DATA TERHAPUS !", Toast.LENGTH_SHORT).show();
            }
        });

    }
}