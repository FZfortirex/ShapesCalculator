package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.mathapp.fragments.BangunDatarFragment;
import com.example.mathapp.fragments.BangunRuangFragment;
import com.example.mathapp.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomePage extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    BangunDatarFragment bangunDatarFragment = new BangunDatarFragment();
    BangunRuangFragment bangunRuangFragment = new BangunRuangFragment();

    ProfileFragment profileFragment = new ProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        bottomNavigationView = findViewById(R.id.bottomNavbar);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,bangunDatarFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int itemId = item.getItemId();

                if(itemId == R.id.bangunDatar){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,bangunDatarFragment).commit();
                }else if(itemId == R.id.bangunRuang){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,bangunRuangFragment).commit();
                }else if(itemId == R.id.profile){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment).commit();
                }
                return true;
            }
        });
    }
}