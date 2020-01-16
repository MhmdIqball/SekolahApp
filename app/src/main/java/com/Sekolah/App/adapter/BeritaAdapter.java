package com.Sekolah.App.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.Sekolah.App.R;
import com.Sekolah.App.model.Berita;


import java.util.List;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.ViewHolder> {
    private Context context;
    private List<Berita> berita;
    private AdapterView.OnItemClickListener listener;

    public BeritaAdapter(Context context, List<Berita> berita,
                         AdapterView.OnItemClickListener listener) {
        this.context = context;
        this.berita = berita;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context)
                .inflate( R.layout.item_berita, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        final Berita berita = this.berita.get(i);
        viewHolder.tvJudul.setText(berita.getJudul());
        viewHolder.tvKeterangan.setText(berita.getKeterangan());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(null, viewHolder.itemView, i, i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return berita.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvJudul;
        public TextView tvKeterangan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJudul = itemView.findViewById(R.id.berita_judul);
            tvKeterangan = itemView.findViewById(R.id.berita_keterangan);
        }
    }
}
