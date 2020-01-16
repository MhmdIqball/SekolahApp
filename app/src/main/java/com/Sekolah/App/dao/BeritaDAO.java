package com.Sekolah.App.dao;

import com.Sekolah.App.model.Berita;


import java.util.ArrayList;
import java.util.List;

public class BeritaDAO {
    private List<Berita> list = new ArrayList<>();

    public BeritaDAO() {
        list.add(new Berita("PENGUMUMAN UAS ","UAS dilakukan pada tanggal 12-20 september 2020"));

    }

    public void insert(Berita berita) {
        list.add(berita);
    }

    public void update(int id, Berita berita) {
        Berita old = list.get(id);
        old.setJudul(berita.getJudul());
        old.setKeterangan(berita.getKeterangan());
    }

    public void delete(int id) {
        list.remove(id);
    }

    public Berita select(int id) {
        return list.get(id);
    }

    public List<Berita> selectAll() {
        return list;
    }
}
