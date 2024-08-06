package com.example.kontak;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapterkontak extends RecyclerView.Adapter<Adapterkontak.kontakviewholder> {
    private ArrayList<kontakmodel> listkontak;

    public Adapterkontak(ArrayList<kontakmodel> listkontak) {
        this.listkontak = listkontak;
    }

    @NonNull
    @Override
    public Adapterkontak.kontakviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.kontaklist,parent,false);

        return new kontakviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapterkontak.kontakviewholder holder, int position) {
        holder.tvnama.setText(listkontak.get(position).getNama());
        holder.tvnumber.setText(listkontak.get(position).getNumber());
        holder.imgfoto.setImageResource(listkontak.get(position).getFoto());



    }

    @Override
    public int getItemCount() {
        return (listkontak!=null) ? listkontak.size() : 0;
    }

    public class kontakviewholder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvnama,tvnumber;
        private ImageView imgfoto;
        private Button btnhapus;
        public kontakviewholder(View view){
            super(view);
            tvnama = view.findViewById(R.id.nama);
            tvnumber=view.findViewById(R.id.number);
            imgfoto = view.findViewById(R.id.foto);
            btnhapus = view.findViewById(R.id.hapus);
            btnhapus.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position =getAdapterPosition();
            Toast.makeText(view.getContext(), listkontak.get(position).getNama()+" telah dihapus dari daftar kontak anda",Toast.LENGTH_SHORT).show();
            listkontak.remove(position);
            notifyItemRemoved(position);
        }
    }
}
