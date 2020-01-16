package com.Sekolah.App.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Jadwal {

    @PrimaryKey(autoGenerate = true)
    private  int id;

    @ColumnInfo(name = "hari")
    private String hari;

    @ColumnInfo(name = "mapel")
    private String mapel;

    @ColumnInfo(name = "jam")
    private String jam;

    @ColumnInfo(name = "mapel2")
    private String mapel2;

    @ColumnInfo(name = "jam2")
    private String jam2;

    @ColumnInfo(name = "mapel3")
    private String mapel3;

    @ColumnInfo(name = "jam3")
    private String jam3;

    @ColumnInfo(name = "mapel4")
    private String mapel4;

    @ColumnInfo(name = "jam4")
    private String jam4;

    public Jadwal() {

    }

    @Ignore
    public Jadwal(String hari, String mapel, String jam, String mapel2, String jam2, String mapel3, String jam3, String mapel4, String jam4) {
        this.hari = hari;
        this.mapel = mapel;
        this.jam = jam;
        this.mapel2 = mapel2;
        this.jam2 = jam2;
        this.mapel3 = mapel3;
        this.jam3 = jam3;
        this.mapel4 = mapel4;
        this.jam4 = jam4;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getMapel() {
        return mapel;
    }

    public void setMapel(String mapel) {
        this.mapel = mapel;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getMapel2() {
        return mapel2;
    }

    public void setMapel2(String mapel2) {
        this.mapel2 = mapel2;
    }

    public String getJam2() {
        return jam2;
    }

    public void setJam2(String jam2) {
        this.jam2 = jam2;
    }

    public String getMapel3() {
        return mapel3;
    }

    public void setMapel3(String mapel3) {
        this.mapel3 = mapel3;
    }

    public String getJam3() {
        return jam3;
    }

    public void setJam3(String jam3) {
        this.jam3 = jam3;
    }

    public String getMapel4() {
        return mapel4;
    }

    public void setMapel4(String mapel4) {
        this.mapel4 = mapel4;
    }

    public String getJam4() {
        return jam4;
    }

    public void setJam4(String jam4) {
        this.jam4 = jam4;
    }
}
