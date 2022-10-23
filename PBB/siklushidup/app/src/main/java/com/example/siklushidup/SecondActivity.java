package com.example.siklushidup;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toast.makeText(Toast.LENGTH_SHORT).show();Toast.makeText(getApplicationContext(), "Ini Halaman kedua", Toast.LENGTH_LONG).show();
    }

    private Context getApplicationContext() {
    }
}
