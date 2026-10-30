package com.mycompany.framely;

public abstract class Pengguna {

    private String nama;

    public Pengguna(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public abstract String getPeran();
}