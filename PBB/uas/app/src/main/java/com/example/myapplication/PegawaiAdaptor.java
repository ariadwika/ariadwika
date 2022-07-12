package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PegawaiAdaptor extends RecyclerView.Adapter<PegawaiAdaptor.ViewHolder> {
    private final ArrayList<com.example.firebaseuas12607.Barang> listbarang;
    private final Context context;

    public PegawaiAdaptor(ArrayList<com.example.firebaseuas12607.Barang> listbarang, Context context) {
        this.listbarang = listbarang;
        this.context = context;
    }

    class ViewHolder extends  RecyclerView.ViewHolder{
        private TextView hkode, hnama,hsatuan,hjumlah,hprice;
        private LinearLayout ListItem;
        ViewHolder(View itemView) {
            super(itemView);
            hkode = itemView.findViewById(R.id.kodbar);
            hnama = itemView.findViewById(R.id.nabar);
            hsatuan=itemView.findViewById(R.id.sat);
            hjumlah=itemView.findViewById(R.id.juml);
            hprice=itemView.findViewById(R.id.harg);
            ListItem = itemView.findViewById(R.id.masterdatabarang);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_format_tampilan, parent,false);
        return new ViewHolder(V);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String kodeb = listbarang.get(position).getKode_pro();
        final String namab = listbarang.get(position).getNama_pro();
        final String satuanb = listbarang.get(position).getSatuan();
        final String jumlahb = listbarang.get(position).getJumlah();
        final String hargab = listbarang.get(position).getHarga();

        holder.hkode.setText   (kodeb);
        holder.hnama.setText   (namab);
        holder.hsatuan.setText (satuanb);
        holder.hjumlah.setText (jumlahb);
        holder.hprice.setText  (hargab);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("dataKode",listbarang.get(position).getKode_pro());
                bundle.putString("dataNama",listbarang.get(position).getNama_pro());
                bundle.putString("dataSat",listbarang.get(position).getSatuan());
                bundle.putString("dataJml",listbarang.get(position).getJumlah());
                bundle.putString("dataHrg",listbarang.get(position).getHarga());

                bundle.putString("getPrimaryKey",listbarang.get(position).getKey());
                Intent intent = new Intent(view.getContext(), com.example.projectfirebase.UpdateData.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return listbarang.size();
    }

    public interface datalistener {
        void onDeleteData(com.example.projectfirebase.Barang data, int position);
    }
    datalistener listener;
}
