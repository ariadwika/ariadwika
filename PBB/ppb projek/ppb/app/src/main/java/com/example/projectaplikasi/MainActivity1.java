package com.example.projectaplikasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity1 extends AppCompatActivity {
    EditText editText;
    Button button;

    String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        editText=findViewById(R.id.namagua);
    }

    public void KirimData(View view) {
        String namaisi=editText.getText().toString();
        Intent intent=new Intent(MainActivity1.this,MainActivity2.class);
        intent.putExtra( "nama", namaisi);
        startActivity(intent);
    }
}