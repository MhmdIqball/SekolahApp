package com.Sekolah.App.room;

import android.content.Context;

import com.Sekolah.App.model.Presensi;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;



@Database(entities = {Presensi.class}, version = 1, exportSchema = false)
public abstract class SekolahDatabase extends RoomDatabase {

    public static SekolahDatabase db(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                SekolahDatabase.class, "SekolahApps")
                .allowMainThreadQueries()
                .build();
    }

    public abstract PresensiRoom presensiRoom();
}
