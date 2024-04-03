package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Calculator1Param extends AppCompatActivity {

    ImageView imageShape;
    TextView nama1Param, rumus1Param, hasil1Param;
    EditText editTextNumber1;
    Button buttonHitung1Param;
    double angka1;
    float rumus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator1_param);

        imageShape = findViewById(R.id.imageShape);
        nama1Param = findViewById(R.id.nama1Param);
        rumus1Param = findViewById(R.id.rumus1Param);
        editTextNumber1 = findViewById(R.id.editTextNumber1);
        buttonHitung1Param = findViewById(R.id.buttonHitung1Param);
        hasil1Param = findViewById(R.id.hasil1Param);

        Intent intent= getIntent();
        String name = intent.getStringExtra("name");
        String imageUrl = intent.getStringExtra("image");

        nama1Param.setText(name);

        Glide.with(this).load(imageUrl).into(imageShape);

        switch (name){
            case "Persegi":
                rumus1Param.setText("Luas = sisi × sisi");
                editTextNumber1.setHint("Masukkan Sisi");
                break;
            case "Lingkaran":
                rumus1Param.setText("Luas = π × r × r");
                editTextNumber1.setHint("Masukkan Jari-Jari");
                break;
            case "Kubus" :
                rumus1Param.setText("Luas = 6 × s²");
                editTextNumber1.setHint("Masukkan Sisi");
                break;
            case "Bola":
                rumus1Param.setText("Luas = 4 × π × r²");
                editTextNumber1.setHint("Masukkan Jari-Jari");
                break;
        }

        buttonHitung1Param.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextNumber1.getText().toString().isEmpty()) {
                    Toast.makeText(Calculator1Param.this, "Isi dengan benar!", Toast.LENGTH_SHORT).show();
                }else {
                    angka1 = Double.parseDouble(editTextNumber1.getText().toString());

                    switch (name) {
                        case "Persegi":
                            rumus = (float) Math.pow(angka1, 2);
                            break;
                        case "Lingkaran":
                            rumus = (float) (Math.PI * Math.pow(angka1, 2));
                            break;
                        case "Kubus" :
                            rumus = (float) Math.pow(angka1, 3);
                            break;
                        case "Bola":
                            rumus = (float) ((4.0 / 3.0) * Math.PI * Math.pow(angka1, 3));
                            break;
                    }
                    hasil1Param.setText("Hasilnya : " + String.valueOf(rumus));
                }
            }
        });

    }
}