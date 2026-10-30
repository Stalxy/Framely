package com.mycompany.framely;

public class Paket {

    private String nama;
    private String kategori;
    private int harga;

    public Paket(String nama, String kategori, int harga) {
        this.nama = nama;
        this.kategori = kategori;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public String getKategori() {
        return kategori;
    }

    public int getHarga() {
        return harga;
    }

    @Override
    public String toString() {
        return nama + " (" + kategori + ") - Rp" + harga;
    }
}