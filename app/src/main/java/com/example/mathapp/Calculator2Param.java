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

public class Calculator2Param extends AppCompatActivity {

    ImageView imageShape;
    TextView nama2Param, rumus2Param, hasil2Param;
    EditText editTextNumber1, editTextNumber2;
    Button buttonHitung2Param;
    double angka1;
    double angka2;
    float rumus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator2_param);

        imageShape = findViewById(R.id.imageShape);
        nama2Param = findViewById(R.id.nama2Param);
        rumus2Param = findViewById(R.id.rumus2Param);
        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        buttonHitung2Param = findViewById(R.id.buttonHitung2Param);
        hasil2Param = findViewById(R.id.hasil2Param);

        Intent intent= getIntent();
        String name = intent.getStringExtra("name");
        String imageUrl = intent.getStringExtra("image");

        nama2Param.setText(name);

        Glide.with(this).load(imageUrl).into(imageShape);

        switch (name){
            case "Segitiga":
                rumus2Param.setText("Luas = ½ × a × t");
                editTextNumber1.setHint("Masukkan tinggi");
                editTextNumber2.setHint("Masukkan alas");
                break;
            case "Belah Ketupat":
                rumus2Param.setText("Luas = ½ × d1 × d2");
                editTextNumber1.setHint("Masukkan diagonal 1");
                editTextNumber2.setHint("Masukkan diagonal 2");
                break;
            case "Persegi Panjang" :
                rumus2Param.setText("Luas = p × ℓ");
                editTextNumber1.setHint("Masukkan tinggi");
                editTextNumber2.setHint("Masukkan lebar");
                break;
            case "Jajar Genjang":
                rumus2Param.setText("Luas = a × t satuan persegi");
                editTextNumber1.setHint("Masukkan tinggi");
                editTextNumber2.setHint("Masukkan alas");
                break;
            case "Tabung":
                rumus2Param.setText("Volume = π × r² × t");
                editTextNumber1.setHint("Masukkan Jari-Jari");
                editTextNumber2.setHint("Masukkan Tinggi");
                break;
            case "Kerucut":
                rumus2Param.setText("Luas = 4 × π × r²");
                editTextNumber1.setHint("Masukkan Jari-Jari");
                editTextNumber2.setHint("Masukkan Tinggi");
                break;
        }

        buttonHitung2Param.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextNumber1.getText().toString().isEmpty() || editTextNumber2.getText().toString().isEmpty()) {
                    Toast.makeText(Calculator2Param.this, "Isi dengan benar!", Toast.LENGTH_SHORT).show();
                } else {
                    angka1 = Double.parseDouble(editTextNumber1.getText().toString());
                    angka2 = Double.parseDouble(editTextNumber2.getText().toString());

                    switch (name) {
                        case "Segitiga":
                            rumus = (float) (0.5*angka1*angka2);
                            break;
                        case "Belah Ketupat":
                            rumus = (float) (0.5*angka1*angka2);
                            break;
                        case "Persegi Panjang" :
                            rumus = (float) (angka1*angka2);
                            break;
                        case "Jajar Genjang":
                            rumus = (float) (angka1*angka2);
                            break;
                        case "Tabung":
                            rumus = (float) (Math.PI*Math.pow(angka1,2)*angka2);
                            break;
                        case "Kerucut":
                            rumus = (float) ((1/3)*Math.PI*Math.pow(angka1,2)*angka2);
                            break;
                    }
                    hasil2Param.setText("Hasilnya : " + String.valueOf(rumus));
                }
            }
        });

    }
}