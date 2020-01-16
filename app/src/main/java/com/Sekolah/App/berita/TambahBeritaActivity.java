package com.Sekolah.App.berita;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.Sekolah.App.R;

public class TambahBeritaActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtJudul;
    EditText edtKeterangan;
    Button btnTambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_berita);
        edtJudul = findViewById(R.id.berita_tambah_judul);
        edtKeterangan = findViewById(R.id.berita_tambah_keterangan);
        btnTambah = findViewById(R.id.berita_tambah);
        btnTambah.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent result = new Intent();
        result.putExtra("judul", edtJudul.getText().toString());
        result.putExtra("keterangan", edtKeterangan.getText().toString());
        setResult(Activity.RESULT_OK, result);
        finish();
    }
}
