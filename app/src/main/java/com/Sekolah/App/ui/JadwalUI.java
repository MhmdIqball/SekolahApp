package com.Sekolah.App.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.Sekolah.App.R;
import com.Sekolah.App.adapter.JadwalAdapter;
import com.Sekolah.App.dao.JadwalDAO;
import com.Sekolah.App.jadwal.TambahJadwalActivity;
import com.Sekolah.App.model.Jadwal;
//import com.Sekolah.App.room.AppDatabase;
//import com.Sekolah.App.room.JadwalRoom;

import java.util.List;

public class JadwalUI extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private RecyclerView recyclerView;
    private List<Jadwal> list;
    private JadwalAdapter adapter;
    private JadwalDAO dao;
  //  private JadwalRoom room;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dao = new JadwalDAO();
   //     room = AppDatabase.db(getContext()).jadwalRoom();
        list = dao.selectAll();
     //   list = room.selectAll();
        adapter = new JadwalAdapter(getContext(), list, this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ui_jadwal, container, false);
        recyclerView = view.findViewById(R.id.recycler_jadwal);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(manager);
        FloatingActionButton fab = view.findViewById(R.id.fab_jadwal);
        fab.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), TambahJadwalActivity.class);
        startActivityForResult(intent, 30);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 30 && resultCode == Activity.RESULT_OK) {
            //dao.insert(jadwal);
            list.clear();
           // list.addAll(room.selectAll());
            list.addAll(dao.selectAll());
            adapter.notifyDataSetChanged();
        }
        if (requestCode == 50 && resultCode == Activity.RESULT_OK) {
            list.clear();
        //    list.addAll(room.selectAll());
            list.addAll(dao.selectAll());
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Jadwal jadwal = list.get(position);
        Intent intent = new Intent(getContext(), TambahJadwalActivity.class);
        intent.putExtra("id", jadwal.getId());
        startActivityForResult(intent, 50);
    }
}
