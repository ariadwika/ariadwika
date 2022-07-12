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

public class AdapterObat extends ArrayAdapter {
    String namaobat[];
    String hargaobat[];
    String tipeobat[];
    String ket_obat[];
    int gambar_obat[];
    Activity activity;

    public AdapterObat(MainListActivity activity, String[] nama_obat, String[] harga_obat, String[] tipe_obat, int[] gambar_obat, String[] keterangan) {
        super(activity, R.layout.list_item, nama_obat);
        this.namaobat = nama_obat;
        this.hargaobat = harga_obat;
        this.tipeobat = tipe_obat;
        this.ket_obat = ket_obat;
        this.gambar_obat = gambar_obat;
        this.activity = activity;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View v=inflater.inflate(R.layout.list_item, null);

        ImageView gambare;
        TextView nama_obat;
        TextView harga_obat;
        TextView tipe_obat;

        gambare=v.findViewById(R.id.gambar_obat);
        nama_obat=v.findViewById(R.id.nama_obat);
        harga_obat=v.findViewById(R.id.harga_obat);
        tipe_obat=v.findViewById(R.id.tipe_obat);

        gambare.setImageResource(gambar_obat[position]);
        nama_obat.setText(namaobat[position]);
        harga_obat.setText(hargaobat[position]);
        tipe_obat.setText(tipeobat[position]);

        return v;
    }
}
