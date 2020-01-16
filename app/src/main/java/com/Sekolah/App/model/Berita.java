package com.Sekolah.App.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Berita {

    @PrimaryKey(autoGenerate = true)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @ColumnInfo(name = "judul")
    private String judul;

    @ColumnInfo(name = "keterangan")
    private String keterangan;

    public Berita(String judul,String keterangan) {
        this.judul = judul;
        this.keterangan = keterangan;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
