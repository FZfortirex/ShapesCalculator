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

public class BangunRuangFragment extends Fragment {
    private RecyclerView recyclerView;
    private BangunDatarAdapter adapter;
    private List<Items> items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bangun_ruang, container, false);

        recyclerView = view.findViewById(R.id.rvBangunRuang);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        items = new ArrayList<>();
        items.add(new Items("Tabung", "https://i.ibb.co/wrD4gvd/Desain-tanpa-judul-8.png", 2));
        items.add(new Items("Kerucut", "https://i.ibb.co/hFwNKZ2/Desain-tanpa-judul-9.png", 2));
        items.add(new Items("Balok", "https://i.ibb.co/Tm6btg7/Desain-tanpa-judul-10.png", 3));
        items.add(new Items("Bola", "https://i.ibb.co/Tw4CBzJ/Desain-tanpa-judul-7.png", 1));
        items.add(new Items("Kubus", "https://i.ibb.co/fCqD9Xv/cube.png", 1));

        // Inisialisasi adapter dan set ke RecyclerView
        adapter = new BangunDatarAdapter(getContext(), items);
        recyclerView.setAdapter(adapter);

        return view;
    }
}