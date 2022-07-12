package com.example.projectfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void menuju_ke(View view) {
        Intent intent=new Intent(MainActivity.this,Tampil_data_guru.class);
        startActivity(intent);
    }

    public void EntryButt(View view) {
        Intent intent=new Intent(MainActivity.this,FormulirPegawai.class);
        startActivity(intent);
    }

    public void TampilButt(View view) {
        Intent intent=new Intent(MainActivity.this,Tampil_data_guru.class);
        startActivity(intent);
    }

    public void TentangButt(View view) {
        Intent intent=new Intent(MainActivity.this,ActivityTentang.class);
        startActivity(intent);
    }

    public void TransButt(View view) {
        Intent intent=new Intent(MainActivity.this,Tampil_data_jual.class);
        startActivity(intent);
    }

    public void LaporanButt(View view) {
        Intent intent=new Intent(MainActivity.this,TampilHasilPenjualan.class);
        startActivity(intent);
    }
}