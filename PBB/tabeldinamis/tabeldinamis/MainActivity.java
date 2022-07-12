package com.contohprogram.tabel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TableLayout tablelayoutid = (TableLayout)findViewById(R.id.tablelayoutid);
        TableRow row;
        row = (TableRow)getLayoutInflater().inflate(R.layout.layout_row, null);
        ((TextView)row.findViewById(R.id.idno)).setText("0");
        ((TextView)row.findViewById(R.id.idnama)).setText("Produk 0");
        ((TextView)row.findViewById(R.id.idnilai_a)).setText("1000");
        ((TextView)row.findViewById(R.id.idnilai_d)).setText("2000");
        ((TextView)row.findViewById(R.id.idnilai_c)).setText("3000");
        ((TextView)row.findViewById(R.id.idnilai_d)).setText("4000");
        ((TextView)row.findViewById(R.id.idnilai_total)).setText("10000");
        tablelayoutid.addView(row);
        Button buttonLoad = (Button)findViewById(R.id.buttonLoad);
        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] nomor = {"1", "2", "3", "4"};
                String[] alternatif = {"Produk 1", "Produk 2", "Produk 3", "Produk 4"};
                double[] hasil_a = {91000, 84000, 61000, 41000};
                double[] hasil_b = {90000, 81000, 61000, 41000};
                double[] hasil_c = {92000, 82000, 65000, 43000};
                double[] hasil_d = {93000, 82000, 61000, 41000};
                double[] hasil_total = {365000, 328000, 248000, 166000};
                for(int i=0;i<4;i++){
                    TableLayout tablelayoutid = (TableLayout)findViewById(R.id.tablelayoutid);
                    TableRow row = (TableRow)getLayoutInflater().inflate(R.layout.layout_row, null);
                    ((TextView)row.findViewById(R.id.idno)).setText(nomor[i]);
                    ((TextView)row.findViewById(R.id.idnama)).setText(alternatif[i]);
                    ((TextView)row.findViewById(R.id.idnilai_a)).setText(String.valueOf(hasil_a[i]));
                    ((TextView)row.findViewById(R.id.idnilai_b)).setText(String.valueOf(hasil_b[i]));
                    ((TextView)row.findViewById(R.id.idnilai_c)).setText(String.valueOf(hasil_c[i]));
                    ((TextView)row.findViewById(R.id.idnilai_d)).setText(String.valueOf(hasil_d[i]));
                    ((TextView)row.findViewById(R.id.idnilai_total)).setText(String.valueOf(hasil_total[i]));
                    tablelayoutid.addView(row);
                }
            }
        });
    }
}
//http://contohprogram.com
//Tutorial Youtube : https://youtu.be/9x6gSd4Y9kg
//Channel Youtube : https://www.youtube.com/channel/UCqF-ljEUgmYcVm76ffdC-Yg/