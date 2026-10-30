package com.mycompany.framely;

public class Pelanggan extends Pengguna {

    private String noHp;

    public Pelanggan(String nama, String noHp) {
        super(nama);
        this.noHp = noHp;
    }

    public String getNoHp() {
        return noHp;
    }

    @Override
    public String getPeran() {
        return "Pelanggan";
    }
}


