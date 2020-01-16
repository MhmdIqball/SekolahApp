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
import com.Sekolah.App.model.Nilai;


import java.util.List;

public class NilaiAdapter extends RecyclerView.Adapter<NilaiAdapter.ViewHolder> {
    private Context context;
    private List<Nilai> nilai;
    private AdapterView.OnItemClickListener listener;

    public NilaiAdapter(Context context, List<Nilai> nilai,
                         AdapterView.OnItemClickListener listener) {
        this.context = context;
        this.nilai = nilai;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context)
                .inflate( R.layout.item_nilai, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        final Nilai nilai = this.nilai.get(i);
        viewHolder.tvJudulnilai.setText(nilai.getJudulnilai());
        viewHolder.tvMapel.setText(nilai.getMapel());
        viewHolder.tvNilai.setText(nilai.getNilai());
        viewHolder.tvMapel2.setText(nilai.getMapel2());
        viewHolder.tvNilai2.setText(nilai.getNilai2());
        viewHolder.tvMapel3.setText(nilai.getMapel3());
        viewHolder.tvNilai3.setText(nilai.getNilai3());
        viewHolder.tvMapel4.setText(nilai.getMapel4());
        viewHolder.tvNilai4.setText(nilai.getNilai4());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(null, viewHolder.itemView, i, i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nilai.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvJudulnilai;
        public TextView tvMapel;
        public TextView tvNilai;
        public TextView tvMapel2;
        public TextView tvNilai2;
        public TextView tvMapel3;
        public TextView tvNilai3;
        public TextView tvMapel4;
        public TextView tvNilai4;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJudulnilai = itemView.findViewById(R.id.nilai_judulnilai);
            tvMapel = itemView.findViewById(R.id.nilai_mapel);
            tvNilai = itemView.findViewById(R.id.nilai_nilai);
            tvMapel2 = itemView.findViewById(R.id.nilai_mapel2);
            tvNilai2 = itemView.findViewById(R.id.nilai_nilai2);
            tvMapel3 = itemView.findViewById(R.id.nilai_mapel3);
            tvNilai3 = itemView.findViewById(R.id.nilai_nilai3);
            tvMapel4 = itemView.findViewById(R.id.nilai_mapel4);
            tvNilai4 = itemView.findViewById(R.id.nilai_nilai4);

        }
    }
}
