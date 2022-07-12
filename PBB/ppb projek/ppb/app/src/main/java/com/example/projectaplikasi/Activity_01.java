package com.example.projectaplikasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Activity_01 extends AppCompatActivity {
    Button button;
    ImageView imageView;
    EditText mnama,mnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_01);

        imageView=findViewById(R.id.tarissa);
        mnama=findViewById(R.id.xnama);
        mnim=findViewById(R.id.xnim);

        button=findViewById(R.id.tblkirim);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cnama=mnama.getText().toString();
                String cnim=mnim.getText().toString();
                Intent intent=new Intent(Activity_01.this, Activity_02.class);
                intent.putExtra("nim", cnim);
                intent.putExtra("nama", cnama);
                intent.putExtra("gambar",R.drawable.fotoku);
                        startActivity(intent);
            }
        });
    }
}