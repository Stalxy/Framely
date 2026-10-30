package com.mycompany.framely;

public class Pesanan {

    private String kode;
    private Pelanggan pelanggan;
    private Paket paket;
    private String tanggal;
    private String status;

    public Pesanan(String kode, Pelanggan pelanggan, Paket paket, String tanggal) {
        this.kode = kode;
        this.pelanggan = pelanggan;
        this.paket = paket;
        this.tanggal = tanggal;
        this.status = "Menunggu Konfirmasi";
    }

    public String getKode() {
        return kode;
    }

    public Paket getPaket() {
        return paket;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return kode + " | " + pelanggan.getNama() + " (" + pelanggan.getNoHp() + ") | "
                + paket.getNama() + " | " + tanggal + " | " + status;
    }
}