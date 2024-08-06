package com.example.kontak;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;

public class kontakmodel implements Parcelable {
    private String nama,number;
    private int foto;

    public kontakmodel(String nama, String number, int foto) {
        this.nama = nama;
        this.number = number;
        this.foto = foto;
    }



    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
