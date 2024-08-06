package com.example.kontak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapterkontak adapter;
    private ArrayList<kontakmodel>kontaklist;
    private RelativeLayout lay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lay = findViewById(R.id.tambahtab);

        kontaklist = new ArrayList<>();
        kontaklist.add(new kontakmodel("Rizaldi","085236471522",R.drawable.ic_launcher_foreground));
        kontaklist.add(new kontakmodel("Pardede","085236471658",R.drawable.ic_launcher_foreground));
        kontaklist.add(new kontakmodel("205150700111018","089613730876",R.drawable.ic_launcher_foreground));
        kontaklist.add(new kontakmodel("Rival","085236471111",R.drawable.ic_launcher_foreground));

        Button btntambah;
        btntambah = findViewById(R.id.tambah);
        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setVisibility(view.GONE);
                lay.setVisibility(view.VISIBLE);
                EditText evnama,evnomor;

                Button btntambah2;
                btntambah2 = findViewById(R.id.tambahkontak);
                evnama = findViewById(R.id.tambahnama);
                evnomor = findViewById(R.id.tambahnomor);

                btntambah2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nama, nomor;
                        nama = evnama.getText().toString();
                        nomor = evnomor.getText().toString();
                        kontaklist.add(new kontakmodel(nama,nomor,R.drawable.ic_launcher_foreground));
                        lay.setVisibility(view.GONE);
                        recyclerView.setVisibility(view.VISIBLE);
                    }
                });
            }
        });



        if (savedInstanceState!=null){
            kontaklist = savedInstanceState.getParcelableArrayList("key");
            adapter = new Adapterkontak(kontaklist);
        }
        recyclerView =findViewById(R.id.recycleview);
        adapter = new Adapterkontak(kontaklist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }





    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelableArrayList("key",kontaklist);
        super.onSaveInstanceState(outState);



    }
}