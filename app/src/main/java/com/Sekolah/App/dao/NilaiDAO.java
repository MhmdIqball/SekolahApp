package com.Sekolah.App.dao;


import com.Sekolah.App.model.Nilai;

import java.util.ArrayList;
import java.util.List;

public class NilaiDAO {
    private List<Nilai> list = new ArrayList<>();

    public NilaiDAO() {
        insert(new Nilai("NILAI UTS Semester Ganjil 2018/2019", "Matematika", "8",
                "B.Jawa", "7","Penjasorkes", "9","B.Indo","7"));

    }

    public Nilai select(int id) {
        return list.get(id);
    }

    public List<Nilai> selectAll() {
        return list;
    }

    public void insert(Nilai nilai) {
        list.add(nilai);
    }

    public void update(int id, Nilai nilai) {
        Nilai old = list.get(id);
        old.setJudulnilai(nilai.getJudulnilai());
        old.setMapel(nilai.getMapel());
        old.setNilai(nilai.getNilai());
        old.setMapel2(nilai.getMapel2());
        old.setNilai2(nilai.getNilai2());
        old.setMapel3(nilai.getMapel3());
        old.setNilai3(nilai.getNilai3());
        old.setMapel4(nilai.getMapel4());
        old.setNilai4(nilai.getNilai4());

    }

    public void delete(int id) {
        list.remove(id);
    }
}
