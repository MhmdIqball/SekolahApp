package com.Sekolah.App.nilai;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.Sekolah.App.R;

public class TambahNilaiActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtJudulnilai;
    EditText edtMapel;
    EditText edtNilai;
    EditText edtMapel2;
    EditText edtNilai2;
    EditText edtMapel3;
    EditText edtNilai3;
    EditText edtMapel4;
    EditText edtNilai4;
    Button btnTambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_nilai);
        edtJudulnilai = findViewById(R.id.tambah_nilai_judulnilai);
        edtMapel = findViewById(R.id.tambah_nilai_mapel);
        edtNilai = findViewById(R.id.tambah_nilai_nilai);
        edtMapel2 = findViewById(R.id.tambah_nilai_mapel2);
        edtNilai2 = findViewById(R.id.tambah_nilai_nilai2);
        edtMapel3 = findViewById(R.id.tambah_nilai_mapel3);
        edtNilai3 = findViewById(R.id.tambah_nilai_nilai3);
        edtMapel4 = findViewById(R.id.tambah_nilai_mapel4);
        edtNilai4 = findViewById(R.id.tambah_nilai_nilai4);
        btnTambah = findViewById(R.id.tambah_nilai);
        btnTambah.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent result = new Intent();
        result.putExtra("judulnilai", edtJudulnilai.getText().toString());
        result.putExtra("mapel", edtMapel.getText().toString());
        result.putExtra("nilai", edtNilai.getText().toString());
        result.putExtra("mapel2", edtMapel2.getText().toString());
        result.putExtra("nilai2", edtNilai2.getText().toString());
        result.putExtra("mapel3", edtMapel3.getText().toString());
        result.putExtra("nilai3", edtNilai3.getText().toString());
        result.putExtra("mapel4", edtMapel4.getText().toString());
        result.putExtra("nilai4", edtNilai4.getText().toString());
        setResult(Activity.RESULT_OK, result);
        finish();
    }
}
