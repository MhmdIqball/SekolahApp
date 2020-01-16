package com.Sekolah.App.presensi;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.Sekolah.App.MainActivity;
import com.Sekolah.App.R;
import com.Sekolah.App.helper.Notif;
import com.Sekolah.App.model.Presensi;
import com.Sekolah.App.room.PresensiRoom;
import com.Sekolah.App.room.SekolahDatabase;


public class TambahPresensiActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtMapel;
    EditText edtKehadiran;
    Button btnTambah;
    Button btnUpdate;
    Button btnHapus;
    PresensiRoom room;
    Presensi presensi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_presensi);
        Notif.init(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Presensi");
        edtMapel = findViewById(R.id.tambah_presensi_mapel);
        edtKehadiran = findViewById(R.id.tambah_presensi_kehadiran);
        btnTambah = findViewById(R.id.tambah_presensi);
        btnUpdate = findViewById(R.id.update_presensi);
        btnHapus = findViewById(R.id.hapus_presensi);
        btnTambah.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnHapus.setOnClickListener(this);

        room = SekolahDatabase.db(this).presensiRoom();
        int id = getIntent().getIntExtra("id", 0);
        presensi = room.select(id);
        if (presensi != null) {
            edtMapel.setText(presensi.getMapel());
            edtKehadiran.setText(presensi.getKehadiran());
            btnUpdate.setVisibility(View.VISIBLE);
            btnHapus.setVisibility(View.VISIBLE);
        } else {
            btnTambah.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.equals(btnTambah)) {
            Presensi presensiNew = new Presensi();
            presensiNew.setMapel(edtMapel.getText().toString());
            presensiNew.setKehadiran(edtKehadiran.getText().toString());
            room.insert(presensiNew);
            Notif.notify(this, "Tambah", "Berhasil tambah data",
                    new Intent(this, MainActivity.class));
        } else if (v.equals(btnUpdate)) {
            presensi.setMapel(edtMapel.getText().toString());
            presensi.setKehadiran(edtKehadiran.getText().toString());
            room.update(presensi);
            Notif.notify(this, "Update", "Berhasil update data",
                    new Intent(this, MainActivity.class));
        } else if (v.equals(btnHapus)) {
            room.delete(presensi);
            Notif.notify(this, "Hapus", "Berhasil hapus data",
                    new Intent(this, MainActivity.class));
        }
        setResult(Activity.RESULT_OK, new Intent());
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
