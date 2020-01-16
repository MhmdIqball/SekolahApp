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
import com.Sekolah.App.adapter.BeritaAdapter;
import com.Sekolah.App.berita.TambahBeritaActivity;
import com.Sekolah.App.dao.BeritaDAO;
import com.Sekolah.App.model.Berita;
//import com.amikom.two.room.AppDatabase;
//import com.amikom.two.room.BeritaRoom;


import java.util.ArrayList;
import java.util.List;

public class BeritaUI extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private RecyclerView recyclerView;
    private BeritaAdapter beritaAdapter;
    private List<Berita> list = new ArrayList<>();
    private BeritaDAO beritaDAO;
    //  private BeritaRoom beritaRoom;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beritaDAO = new BeritaDAO();
        //    beritaRoom = AppDatabase.db(getContext()).beritaRoom();
        list.addAll( beritaDAO.selectAll());
        //    list = beritaRoom.selectAll() ;
        beritaAdapter = new BeritaAdapter(getContext(), list, this);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ui_berita, container, false);
        recyclerView = view.findViewById(R.id.recycler_berita);
        recyclerView.setAdapter(beritaAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(llm);
        FloatingActionButton fab = view.findViewById(R.id.fab_berita);
        fab.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), TambahBeritaActivity.class);
        startActivityForResult(intent, 30);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 30 && resultCode == Activity.RESULT_OK) {
            String judul = data.getStringExtra("judul");
            String keterangan = data.getStringExtra("keterangan");
            Berita baru = new Berita(judul,keterangan);
            beritaDAO.insert(baru);
            //  beritaRoom.insert(baru);
            list.clear();
            list.addAll(beritaDAO.selectAll());  // biasa
            //list.addAll(beritaRoom.selectAll());  // database
            beritaAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}

