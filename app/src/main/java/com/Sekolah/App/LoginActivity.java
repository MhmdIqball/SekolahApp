package com.Sekolah.App;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Sekolah.App.api.ClientService;
import com.Sekolah.App.api.RetrofitClient;
import com.Sekolah.App.api.Session;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    EditText editNim;
    EditText editPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_login);
        editNim = findViewById(R.id.edt_nis);
        editPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        btnLogin.setOnLongClickListener(this);


    }







    @Override
    public void onClick(View view) {
        Retrofit retrofit = RetrofitClient.connect();
        ClientService service = retrofit.create(ClientService.class);
        final Call<ResponseBody> request = service.login(
                editNim.getText().toString(),
                editPassword.getText().toString()
        );

        request.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try{
                    String json = response.body().string();
                    Log.e("Response", json);
                    JSONObject obj = new JSONObject(json);
                    int status = obj.getInt("status");
                    if (status == 200) {
                        Toast.makeText(LoginActivity.this,"Login Berhasil", Toast.LENGTH_SHORT).show();
                        JSONObject user = obj.getJSONObject("user");
                        Session.init(LoginActivity.this)
                                .set("nim", user.getString("nim"))
                                .set("nama", user.getString("nama"))
                                .set("prodi", user.getString("prodi"))
                                .set("foto", user.getString("foto"))
                                .set("status", user.getBoolean("status"));

                        startActivity(new Intent(LoginActivity.this, com.Sekolah.App.MainActivity.class));
                    } else {
                        onFailure(null, null);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public boolean onLongClick(View view) {
        Intent intent = new Intent(this, com.Sekolah.App.MainActivity.class);
        startActivity(intent);
        finish();
        return true;
    }
}
