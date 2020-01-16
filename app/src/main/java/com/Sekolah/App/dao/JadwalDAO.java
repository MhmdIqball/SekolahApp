package com.Sekolah.App.dao;

import com.Sekolah.App.model.Jadwal;

import java.util.ArrayList;
import java.util.List;

public class JadwalDAO {
    private List<Jadwal> list = new ArrayList<>();

    public JadwalDAO() {
        insert(new Jadwal("Rabu", "Matematika", "07:00 - 08: 00",
                "B.Jawa", "08:00 - 09:00","Penjasorkes", "10:00 - 11:00","B.Indo","12:00 - 13:00"));

    }

    public Jadwal select(int id) {
        return list.get(id);
    }

    public List<Jadwal> selectAll() {
        return list;
    }

    public void insert(Jadwal jadwal) {
        list.add(jadwal);
    }

    public void update(int id, Jadwal jadwal) {
        Jadwal old = list.get(id);
        old.setHari(jadwal.getHari());
        old.setMapel(jadwal.getMapel());
        old.setJam(jadwal.getJam());
        old.setMapel2(jadwal.getMapel2());
        old.setJam2(jadwal.getJam2());
        old.setMapel3(jadwal.getMapel3());
        old.setJam3(jadwal.getJam3());
        old.setMapel4(jadwal.getMapel4());
        old.setJam4(jadwal.getJam4());

    }

    public void delete(int id) {
        list.remove(id);
    }
}
