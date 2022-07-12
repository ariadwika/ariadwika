package com.example.projectfirebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PegawaiAdaptor extends RecyclerView.Adapter<PegawaiAdaptor.ViewHolder> {
    private final ArrayList<Pegawai> listpegawai;
    private final Context context;

    public PegawaiAdaptor(ArrayList<Pegawai> listpegawai, Context context) {
        this.listpegawai = listpegawai;
        this.context = context;
    }

    class ViewHolder extends  RecyclerView.ViewHolder{
        private TextView hnip, hnama,hjabatan;
        private LinearLayout ListItem;
        ViewHolder(View itemView) {
            super(itemView);
            hnip = itemView.findViewById(R.id.nopeg);
            hnama = itemView.findViewById(R.id.napeg);
            hjabatan=itemView.findViewById(R.id.jabat);
            ListItem = itemView.findViewById(R.id.masterdataguru);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_format_tampilan, parent,false);
        return new ViewHolder(V);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String nip = listpegawai.get(position).getNomor_peg();
        final String nama = listpegawai.get(position).getNama_peg();
        final String jabatan=listpegawai.get(position).getJabatan();

        holder.hnip.setText("NIP: "+nip);
        holder.hnama.setText("Nama: "+nama);
        holder.hjabatan.setText("Jabatan "+jabatan);

    }

    @Override
    public int getItemCount() {
        return listpegawai.size();
    }

    public interface datalistener {
        void onDeleteData(Pegawai data, int position);
    }
    datalistener listener;
}
