package com.example.krsmhsudinus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputMhs extends AppCompatActivity {

    Button tblsave , tblview;
    EditText xkode , xmatkul , xsks , xangka , xhuruf , xpredikat;
    DatabaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_mhs);

        xkode=findViewById(R.id.kodemhs);
        xmatkul=findViewById(R.id.matkulmhs);
        xsks=findViewById(R.id.sksmhs);
        xangka=findViewById(R.id.angkamhs);
        xhuruf=findViewById(R.id.hurufmhs);
        xpredikat=findViewById(R.id.predikatmhs);

        dbh=new DatabaseHelper(this);

        tblsave=findViewById(R.id.tombol_simpan);
        tblview=findViewById(R.id.tombol_view);

        tblsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(xkode.getText().length()<9 || xkode.getText().length()>9){
                    xkode.setError("wajib 9 karakter !");
                    Toast.makeText(getApplicationContext(), "Maaf Kode Harus 9 Karakter !", Toast.LENGTH_SHORT).show();
                    xkode.requestFocus();
                }else {
                    dbh.tambah_data(xkode.getText().toString(), xmatkul.getText().toString() ,
                            xsks.getText().toString() , xangka.getText().toString(),xhuruf.getText().toString(),
                            xpredikat.getText().toString());
                }
            }
        });

        tblview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(InputMhs.this, com.example.krsmhsudinus.MainActivity.class);
                startActivity(intent);
            }
        });

    }
}