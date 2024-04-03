package com.example.mathapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mathapp.BangunDatarAdapter;
import com.example.mathapp.Items;
import com.example.mathapp.R;

import java.util.ArrayList;
import java.util.List;

public class BangunDatarFragment extends Fragment {

    private RecyclerView recyclerView;
    private BangunDatarAdapter adapter;
    private List<Items> items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bangun_datar, container, false);

        recyclerView = view.findViewById(R.id.rvBangunDatar);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        items = new ArrayList<>();
        items.add(new Items("Persegi", "https://i.ibb.co/kJcJM51/Desain-tanpa-judul-1.png", 1));
        items.add(new Items("Persegi Panjang", "https://i.ibb.co/C2Ypxqr/Desain-tanpa-judul-2.png", 2));
        items.add(new Items("Segitiga", "https://i.ibb.co/VjJ7Y2v/Desain-tanpa-judul-3.png", 2));
        items.add(new Items("Jajar Genjang", "https://i.ibb.co/4FKGGcQ/Desain-tanpa-judul-4.png", 2));
        items.add(new Items("Belah Ketupat", "https://i.ibb.co/rp6dsj1/Desain-tanpa-judul-6.png", 2));
        items.add(new Items("Lingkaran", "https://i.ibb.co/Tw4CBzJ/Desain-tanpa-judul-7.png", 1));

        // Inisialisasi adapter dan set ke RecyclerView
        adapter = new BangunDatarAdapter(getContext(), items);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
