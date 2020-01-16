package com.Sekolah.App.jadwal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.Sekolah.App.R;

public class TambahJadwalActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtHari;
    EditText edtMapel;
    EditText edtJam;
    EditText edtMapel2;
    EditText edtJam2;
    EditText edtMapel3;
    EditText edtJam3;
    EditText edtMapel4;
    EditText edtJam4;
    Button btnTambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_jadwal);
        edtHari = findViewById( R.id.tambah_jadwal_hari );
        edtMapel = findViewById(R.id.tambah_jadwal_mapel);
        edtJam = findViewById(R.id.tambah_jadwal_jam);
        edtMapel2 = findViewById(R.id.tambah_jadwal_mapel2);
        edtJam2 = findViewById(R.id.tambah_jadwal_jam2);
        edtMapel3 = findViewById(R.id.tambah_jadwal_mapel3);
        edtJam3 = findViewById(R.id.tambah_jadwal_jam3);
        edtMapel4 = findViewById(R.id.tambah_jadwal_mapel4);
        edtJam4 = findViewById(R.id.tambah_jadwal_jam4);
        btnTambah = findViewById(R.id.tambah_jadwal);
        btnTambah.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent result = new Intent();
        result.putExtra("hari", edtHari.getText().toString());
        result.putExtra("mapel", edtMapel.getText().toString());
        result.putExtra("jam", edtJam.getText().toString());
        result.putExtra("mapel2", edtMapel2.getText().toString());
        result.putExtra("jam2", edtJam2.getText().toString());
        result.putExtra("mapel3", edtMapel3.getText().toString());
        result.putExtra("jam3", edtJam3.getText().toString());
        result.putExtra("mapel4", edtMapel4.getText().toString());
        result.putExtra("jam4", edtJam4.getText().toString());
        setResult(Activity.RESULT_OK, result);
        finish();
    }
}
