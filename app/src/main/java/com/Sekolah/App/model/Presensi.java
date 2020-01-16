package com.Sekolah.App.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Presensi {

    @PrimaryKey(autoGenerate = true)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @ColumnInfo(name = "mapel")
    private String mapel;

    @ColumnInfo(name = "kehadiran")
    private String kehadiran;

    public Presensi () {

    }
    @Ignore
    public Presensi(String mapel,String kehadiran) {
        this.mapel = mapel;
        this.kehadiran = kehadiran;
    }

    public String getMapel() {
        return mapel;
    }

    public void setMapel(String mapel) {
        this.mapel = mapel;
    }

    public String getKehadiran() {
        return kehadiran;
    }

    public void setKehadiran(String kehadiran) {
        this.kehadiran = kehadiran;
    }
}
