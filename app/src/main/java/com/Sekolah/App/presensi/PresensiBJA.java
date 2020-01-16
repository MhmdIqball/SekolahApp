//package com.Sekolah.App.presensi;

//import android.app.Activity;
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;

//import com.Sekolah.App.R;

//public class TambahPresensiActivity extends AppCompatActivity implements View.OnClickListener {
//    EditText edtMapel;
 //   EditText edtKehadiran;
 //   Button btnTambah;

 //   @Override
 //   protected void onCreate(Bundle savedInstanceState) {
 //       super.onCreate(savedInstanceState);
 //       setContentView(R.layout.activity_tambah_presensi);
 //       edtMapel = findViewById(R.id.tambah_presensi_mapel);
 //       edtKehadiran = findViewById(R.id.tambah_presensi_kehadiran);
 //       btnTambah = findViewById(R.id.tambah_presensi);
 //       btnTambah.setOnClickListener(this);
 //   }

 //   @Override
 //   public void onClick(View v) {
 //       Intent result = new Intent();
//        result.putExtra("mapel", edtMapel.getText().toString());
 //       result.putExtra("kehadiran", edtKehadiran.getText().toString());
 //       setResult(Activity.RESULT_OK, result);
 //       finish();
//    }
//}
