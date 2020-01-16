package com.Sekolah.App.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Nilai {

    @PrimaryKey(autoGenerate = true)
    private  int id;

    @ColumnInfo(name = "judulnilai")
    private String judulnilai;

    @ColumnInfo(name = "mapel")
    private String mapel;

    @ColumnInfo(name = "nilai")
    private String nilai;

    @ColumnInfo(name = "mapel2")
    private String mapel2;

    @ColumnInfo(name = "nilai2")
    private String nilai2;

    @ColumnInfo(name = "mapel3")
    private String mapel3;

    @ColumnInfo(name = "nilai3")
    private String nilai3;

    @ColumnInfo(name = "mapel4")
    private String mapel4;

    @ColumnInfo(name = "nilai4")
    private String nilai4;

    public Nilai() {

    }

    @Ignore
    public Nilai(String judulnilai, String mapel, String nilai, String mapel2, String nilai2, String mapel3, String nilai3, String mapel4, String nilai4) {
        this.judulnilai = judulnilai;
        this.mapel = mapel;
        this.nilai = nilai;
        this.mapel2 = mapel2;
        this.nilai2 = nilai2;
        this.mapel3 = mapel3;
        this.nilai3 = nilai3;
        this.mapel4 = mapel4;
        this.nilai4 = nilai4;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getJudulnilai() {
        return judulnilai;
    }

    public void setJudulnilai(String judulnilai) {
        this.judulnilai = judulnilai;
    }

    public String getMapel() {
        return mapel;
    }

    public void setMapel(String mapel) {
        this.mapel = mapel;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public String getMapel2() {
        return mapel2;
    }

    public void setMapel2(String mapel2) {
        this.mapel2 = mapel2;
    }

    public String getNilai2() {
        return nilai2;
    }

    public void setNilai2(String nilai2) {
        this.nilai2 = nilai2;
    }

    public String getMapel3() {
        return mapel3;
    }

    public void setMapel3(String mapel3) {
        this.mapel3 = mapel3;
    }

    public String getNilai3() {
        return nilai3;
    }

    public void setNilai3(String nilai3) {
        this.nilai3 = nilai3;
    }

    public String getMapel4() {
        return mapel4;
    }

    public void setMapel4(String mapel4) {
        this.mapel4 = mapel4;
    }

    public String getNilai4() {
        return nilai4;
    }

    public void setNilai4(String nilai4) {
        this.nilai4 = nilai4;
    }
}
