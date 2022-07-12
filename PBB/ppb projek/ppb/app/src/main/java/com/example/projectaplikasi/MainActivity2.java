package com.example.projectaplikasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView namaKirim;
    String name="nama";
    String namanyo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        namaKirim=findViewById(R.id.namaelu);

        Bundle bundle=getIntent().getExtras();
        namanyo=bundle.getString(name);
        namaKirim.setText("Biodata "+namanyo);

    }
}