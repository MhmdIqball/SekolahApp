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
import com.Sekolah.App.model.Presensi;


import java.util.List;

public class PresensiAdapter extends RecyclerView.Adapter<PresensiAdapter.ViewHolder> {
    private Context context;
    private List<Presensi> presensi;
    private AdapterView.OnItemClickListener listener;

    public PresensiAdapter(Context context, List<Presensi> presensi,
                         AdapterView.OnItemClickListener listener) {
        this.context = context;
        this.presensi = presensi;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context)
                .inflate( R.layout.item_presensi, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        final Presensi presensi = this.presensi.get(i);
        viewHolder.tvMapel.setText(presensi.getMapel());
        viewHolder.tvKehadiran.setText(presensi.getKehadiran());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(null, viewHolder.itemView, i, i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return presensi.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvMapel;
        public TextView tvKehadiran;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMapel = itemView.findViewById(R.id.presensi_mapel);
            tvKehadiran = itemView.findViewById(R.id.presensi_kehadiran);
        }
    }
}
