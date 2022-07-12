package com.example.myresponsi;

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

    public void pindahEntry(View view) {
        Intent intent = new Intent(MainActivity.this, MainEntry.class);
        startActivity(intent);
    }

    public void pindahTampil(View view) {
        Intent intent = new Intent(MainActivity.this, MainTampil.class);
        startActivity(intent);
    }

    public void pindahAbout(View view) {
        Intent intent = new Intent(MainActivity.this, MainAbout.class);
        startActivity(intent);
    }

    public void pindahExit(View view) {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }
}