package com.example.pas_27_10rpl1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        String nama = getIntent().getExtras().getString("nama");
        String deskripsi = getIntent().getExtras().getString("deskripsi");
        int image = getIntent().getExtras().getInt("image");
        ImageView profil = findViewById(R.id.imageView);
        TextView namaView = findViewById(R.id.textView5);
        TextView penjelasan = findViewById(R.id.desc);
        profil.setImageResource(image);
        namaView.setText(nama);
        penjelasan.setText(deskripsi);
//        Toast.makeText(this, getIntent().getExtras().getString("deskripsi"),Toast.LENGTH_SHORT).show();

    }
}