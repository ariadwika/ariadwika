package com.example.myresponsi;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterBuah extends ArrayAdapter {
    String[] namabuah;
    String ket_buah;
    int[] gambar_buah;
    Activity activity;
    private View harga_buah;

    public AdapterBuah(MainEntry activity, String[] nama_buah, int[] gambar_buah, String[] keterangan) {
        super(activity, R.layout.list_item, nama_buah);
        this.namabuah = nama_buah;
        this.ket_buah = ket_buah;
        this.gambar_buah = gambar_buah;
        this.activity = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View v=inflater.inflate(R.layout.list_item, null);

        ImageView gambare;
        TextView nama_buah;

        gambare=v.findViewById(R.id.gambar_obat);
        nama_buah=v.findViewById(R.id.nama_obat);
        harga_buah=v.findViewById(R.id.hargaobat);

        gambare.setImageResource(gambar_buah[position]);
        nama_buah.setText(namabuah[position]);

        return v;
    }
}
