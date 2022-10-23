package com.example.detailobat;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdapterKlub extends ArrayAdapter {
    String namaklub[];
    String tahunklub[];
    String stadionklub[];
    String websiteklub[];
    String pelatihklub[];
    String lokasiklub[];
    int gambar_klub[];
    Activity activity;

    public AdapterKlub(MainListActivity activity, String[] nama_klub, String[] tahun_klub, String[] stadion_klub, String[] website_klub, String[] pelatih_klub, String[] lokasi_klub, int[] gambar_klub) {
        super(activity, R.layout.list_item, nama_klub);
        this.namaklub = nama_klub;
        this.tahunklub = tahun_klub;
        this.stadionklub = stadion_klub;
        this.websiteklub = website_klub;
        this.pelatihklub = pelatih_klub;
        this.lokasiklub = lokasi_klub;
        this.gambar_klub = gambar_klub;
        this.activity = activity;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View v=inflater.inflate(R.layout.list_item, null);

        ImageView gambarklub;
        TextView nama_klub;
        TextView tahun_klub;
        TextView stadion_klub;
        TextView website_klub ;
        TextView pelatih_klub ;
        TextView lokasi_klub;


        gambarklub=v.findViewById(R.id.gambar_klub);
        nama_klub=v.findViewById(R.id.nama_klub);
        tahun_klub=v.findViewById(R.id.tahun_klub);
        stadion_klub=v.findViewById(R.id.stadion_klub);
        website_klub=v.findViewById(R.id.website_klub);
        pelatih_klub=v.findViewById(R.id.pelatih_klub);
        lokasi_klub=v.findViewById(R.id.lokasi_klub);

        gambarklub.setImageResource(gambar_klub[position]);
        nama_klub.setText(namaklub[position]);
        tahun_klub.setText(tahunklub[position]);
        stadion_klub.setText(stadionklub[position]);

        return v;
    }
}
