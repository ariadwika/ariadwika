package com.example.projectfirebase;

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

public class HasilAdaptor extends RecyclerView.Adapter<HasilAdaptor.ViewHolder> {
    private final ArrayList<Jual> listjual;
    private final Context context;

    public HasilAdaptor(ArrayList<Jual> listjual, Context context) {
        this.listjual = listjual;
        this.context = context;
    }

    class ViewHolder extends  RecyclerView.ViewHolder{
        private TextView hslkode, hslnama,hslsatuan,hsljumlah,hslprice,hslprice_tot;
        private LinearLayout ListItem;
        ViewHolder(View itemView) {
            super(itemView);
            hslkode = itemView.findViewById(R.id.kodbar_P);
            hslnama = itemView.findViewById(R.id.nabar_P);
            hslsatuan=itemView.findViewById(R.id.sat_P);
            hsljumlah=itemView.findViewById(R.id.juml_P);
            hslprice=itemView.findViewById(R.id.harg_P);
            hslprice_tot=itemView.findViewById(R.id.harg_tot_P);
            ListItem = itemView.findViewById(R.id.masterdatahasil);
        }
    }

    public HasilAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_format_tampilan_penjualan, parent,false);
        return new HasilAdaptor.ViewHolder(V);
    }

    @Override
    public void onBindViewHolder(HasilAdaptor.ViewHolder holder, final int position) {
        final String kodeh = listjual.get(position).getKode_pro_J();
        final String namah = listjual.get(position).getNama_pro_J();
        final String satuanh = listjual.get(position).getSatuan_J();
        final String jumlahh = listjual.get(position).getJumlah_J();
        final String hargah = listjual.get(position).getHarga_J();
        final String harga_tot_h = listjual.get(position).getTot_harga_J();

        holder.hslkode.setText   (kodeh);
        holder.hslnama.setText   (namah);
        holder.hslsatuan.setText (satuanh);
        holder.hsljumlah.setText (jumlahh);
        holder.hslprice.setText  (hargah);
        holder.hslprice_tot.setText  (harga_tot_h);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("dataKode",listjual.get(position).getKode_pro_J());
                bundle.putString("dataNama",listjual.get(position).getNama_pro_J());
                bundle.putString("dataSat",listjual.get(position).getSatuan_J());
                bundle.putString("dataJml",listjual.get(position).getJumlah_J());
                bundle.putString("dataHrg",listjual.get(position).getHarga_J());
                bundle.putString("dataHrgtot",listjual.get(position).getTot_harga_J());

                bundle.putString("getPrimaryKey",listjual.get(position).getKey());
                Intent intent = new Intent(view.getContext(), UpdateData.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return listjual.size();
    }

    public interface datalistener {
        void onDeleteData(Hasil data, int position);
    }
    HasilAdaptor.datalistener listener;
}