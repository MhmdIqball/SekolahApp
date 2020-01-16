package com.Sekolah.App.dao;

import com.Sekolah.App.model.Presensi;


import java.util.ArrayList;
import java.util.List;

public class PresensiDAO {
    private List<Presensi> list = new ArrayList<>();

    public PresensiDAO() {
        list.add(new Presensi(" MATEMATIKA ","10"));

    }

    public void insert(Presensi presensi) {
        list.add(presensi);
    }

    public void update(int id, Presensi presensi) {
        Presensi old = list.get(id);
        old.setMapel(presensi.getMapel());
        old.setKehadiran(presensi.getKehadiran());
    }

    public void delete(int id) {
        list.remove(id);
    }

  //  public Presensi select(int id) {
 //       return list.get(id);
 //   }

 //   public List<Presensi> selectAll() {
 //       return list;
 //   }
}
