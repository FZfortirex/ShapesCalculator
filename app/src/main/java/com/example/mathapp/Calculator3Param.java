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

public class Calculator3Param extends AppCompatActivity {

    ImageView imageShape;
    TextView nama3Param, rumus3Param, hasil3Param;
    EditText editTextNumber1, editTextNumber2, editTextNumber3;
    Button buttonHitung3Param;
    double angka1;
    double angka2;
    double angka3;
    float rumus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator3_param);

        imageShape = findViewById(R.id.imageShape);
        nama3Param = findViewById(R.id.nama3Param);
        rumus3Param = findViewById(R.id.rumus3Param);
        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        editTextNumber3 = findViewById(R.id.editTextNumber3);
        buttonHitung3Param = findViewById(R.id.buttonHitung3Param);
        hasil3Param = findViewById(R.id.hasil3Param);

        Intent intent= getIntent();
        String name = intent.getStringExtra("name");
        String imageUrl = intent.getStringExtra("image");

        nama3Param.setText(name);

        Glide.with(this).load(imageUrl).into(imageShape);

        switch (name){
            case "Balok":
                rumus3Param.setText("Volume = p × l × t");
                editTextNumber1.setHint("Masukkan Panjang");
                editTextNumber2.setHint("Masukkan Lebar");
                editTextNumber3.setHint("Masukkan Tinggi");
                break;
            case "Limas Persegi":
                rumus3Param.setText("Luas = ⅓ × L (alas) × t");
                editTextNumber1.setHint("Masukkan Panjang");
                editTextNumber2.setHint("Masukkan Lebar");
                editTextNumber3.setHint("Masukkan Tinggi");
                break;
        }

        buttonHitung3Param.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextNumber1.getText().toString().isEmpty() || editTextNumber2.getText().toString().isEmpty() || editTextNumber3.getText().toString().isEmpty()) {
                    Toast.makeText(Calculator3Param.this, "Isi dengan benar!", Toast.LENGTH_SHORT).show();
                } else {
                    angka1 = Double.parseDouble(editTextNumber1.getText().toString());
                    angka2 = Double.parseDouble(editTextNumber2.getText().toString());
                    angka3 = Double.parseDouble(editTextNumber3.getText().toString());

                    switch (name) {
                        case "Balok":
                            rumus = (float) (angka1*angka2*angka3);
                            break;
                        case "Limas Persegi":
                            rumus = (float) ((1/3)*(angka1*angka2)*angka3);
                            break;
                    }
                    hasil3Param.setText("Hasilnya : " + String.valueOf(rumus));
                }
            }
        });

    }
}