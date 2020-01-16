package com.Sekolah.App.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.Sekolah.App.model.Jadwal;
import com.Sekolah.App.R;

import java.util.List;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.ViewHolder> {
    private Context context;
    private List<Jadwal> jadwal;
    private AdapterView.OnItemClickListener listener;

    public JadwalAdapter(Context context, List<Jadwal> jadwal,
                         AdapterView.OnItemClickListener listener) {
        this.context = context;
        this.jadwal = jadwal;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context)
                .inflate( R.layout.item_jadwal, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Jadwal jadwal = this.jadwal.get(i);
        viewHolder.tvHari.setText(jadwal.getHari());
        viewHolder.tvMapel.setText(jadwal.getMapel());
        viewHolder.tvJam.setText(jadwal.getJam());
        viewHolder.tvMapel2.setText(jadwal.getMapel2());
        viewHolder.tvJam2.setText(jadwal.getJam2());
        viewHolder.tvMapel3.setText(jadwal.getMapel3());
        viewHolder.tvJam3.setText(jadwal.getJam3());
        viewHolder.tvMapel4.setText(jadwal.getMapel4());
        viewHolder.tvJam4.setText(jadwal.getJam4());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(null, v, i, i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return jadwal.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvHari;
        public TextView tvMapel;
        public TextView tvJam;
        public TextView tvMapel2;
        public TextView tvJam2;
        public TextView tvMapel3;
        public TextView tvJam3;
        public TextView tvMapel4;
        public TextView tvJam4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHari = itemView.findViewById(R.id.jadwal_hari);
            tvMapel = itemView.findViewById(R.id.jadwal_mapel);
            tvJam = itemView.findViewById(R.id.jadwal_jam);
            tvMapel2 = itemView.findViewById(R.id.jadwal_mapel2);
            tvJam2 = itemView.findViewById(R.id.jadwal_jam2);
            tvMapel3 = itemView.findViewById(R.id.jadwal_mapel3);
            tvJam3 = itemView.findViewById(R.id.jadwal_jam3);
            tvMapel4 = itemView.findViewById(R.id.jadwal_mapel4);
            tvJam4 = itemView.findViewById(R.id.jadwal_jam4);
        }
    }
}
