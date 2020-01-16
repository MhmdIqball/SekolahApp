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

import com.Sekolah.App.R;
import com.Sekolah.App.adapter.NilaiAdapter;
import com.Sekolah.App.dao.NilaiDAO;
import com.Sekolah.App.model.Nilai;
import com.Sekolah.App.nilai.TambahNilaiActivity;
//import com.amikom.two.room.AppDatabase;
//import com.amikom.two.room.BeritaRoom;


import java.util.ArrayList;
import java.util.List;

public class NilaiUI extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private RecyclerView recyclerView;
    private NilaiAdapter nilaiAdapter;
    private List<Nilai> list = new ArrayList<>();
    private NilaiDAO nilaiDAO;
    //  private BeritaRoom beritaRoom;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nilaiDAO = new NilaiDAO();
        //    beritaRoom = AppDatabase.db(getContext()).beritaRoom();
        list.addAll( nilaiDAO.selectAll());
        //    list = beritaRoom.selectAll() ;
        nilaiAdapter = new NilaiAdapter(getContext(), list, this);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ui_nilai, container, false);
        recyclerView = view.findViewById(R.id.recycler_nilai);
        recyclerView.setAdapter(nilaiAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(llm);
        FloatingActionButton fab = view.findViewById(R.id.fab_nilai);
        fab.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), TambahNilaiActivity.class);
        startActivityForResult(intent, 30);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 30 && resultCode == Activity.RESULT_OK) {
            String judulnilai = data.getStringExtra("judulnilai");
            String mapel = data.getStringExtra("mapel");
            String nilai = data.getStringExtra("nilai");
            String mapel2 = data.getStringExtra("mapel2");
            String nilai2 = data.getStringExtra("nilai2");
            String mapel3 = data.getStringExtra("mapel3");
            String nilai3 = data.getStringExtra("nilai3");
            String mapel4 = data.getStringExtra("mapel4");
            String nilai4 = data.getStringExtra("nilai4");


            Nilai baru = new Nilai(judulnilai,mapel,nilai,mapel2,nilai2,mapel3,nilai3,mapel4,nilai4);
            nilaiDAO.insert(baru);
            //  beritaRoom.insert(baru);
            list.clear();
            list.addAll(nilaiDAO.selectAll());  // biasa
            //list.addAll(beritaRoom.selectAll());  // database
            nilaiAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}

