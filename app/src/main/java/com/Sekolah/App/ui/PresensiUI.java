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
import com.Sekolah.App.adapter.PresensiAdapter;
import com.Sekolah.App.dao.PresensiDAO;
import com.Sekolah.App.model.Presensi;
import com.Sekolah.App.presensi.TambahPresensiActivity;
import com.Sekolah.App.room.PresensiRoom;
import com.Sekolah.App.room.SekolahDatabase;


import java.util.List;

public class PresensiUI extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private RecyclerView recyclerView;
    private List<Presensi> list;
    private PresensiAdapter adapter;
  //  private PresensiDAO dao;
     private PresensiRoom room;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  dao = new PresensiDAO();
            room = SekolahDatabase.db(getContext()).presensiRoom();
      //  list = dao.selectAll();
          list = room.selectAll();
        adapter = new PresensiAdapter(getContext(), list, this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ui_presensi, container, false);
        recyclerView = view.findViewById(R.id.recycler_presensi);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(manager);
        FloatingActionButton fab = view.findViewById(R.id.fab_presensi);
        fab.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), TambahPresensiActivity.class);
        startActivityForResult(intent, 30);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 30 && resultCode == Activity.RESULT_OK) {
            //dao.insert(presensi);
            list.clear();
            list.addAll(room.selectAll());
         //   list.addAll(dao.selectAll());
            adapter.notifyDataSetChanged();
        }
        if (requestCode == 50 && resultCode == Activity.RESULT_OK) {
            list.clear();
            list.addAll(room.selectAll());
        //    list.addAll(dao.selectAll());
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Presensi presensi = list.get(position);
        Intent intent = new Intent(getContext(), TambahPresensiActivity.class);
        intent.putExtra("id", presensi.getId());
        startActivityForResult(intent, 50);
    }
}
