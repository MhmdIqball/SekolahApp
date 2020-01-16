package com.Sekolah.App.room;



import com.Sekolah.App.model.Presensi;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface PresensiRoom {

    @Query("SELECT * FROM presensi WHERE id = :id")
    Presensi select(int id);

    @Query("SELECT * FROM presensi")
    List<Presensi> selectAll();

    @Insert
    void insert(Presensi presensi);

    @Update
    void update(Presensi presensi);

    @Delete
    void delete(Presensi presensi);
}
