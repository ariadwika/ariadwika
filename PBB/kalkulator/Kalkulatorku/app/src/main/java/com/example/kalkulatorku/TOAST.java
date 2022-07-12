package com.example.kalkulatorku;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TOAST extends AppCompatActivity {
    TextView textView;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        textView = findViewById(R.id.konterview);
    }

    public void tampilpesan(View view) {
        //Toast.makeText(,"",Toast.LENGTH_SHORT).show();
        Toast mytoast = Toast.makeText(TOAST.this,"SAYA ADALAH TOAST", Toast.LENGTH_SHORT);
        mytoast.show();
    }

    public void hitungcount(View view) {
        counter++;
        textView.setText(Integer.toString(counter));
    }
}