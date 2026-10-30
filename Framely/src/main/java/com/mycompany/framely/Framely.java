package com.mycompany.framely;
import java.util.*;

public class Framely {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Paket> paket = new ArrayList<>();
    static ArrayList<Pesanan> pesanan = new ArrayList<>();
    static Admin admin = new Admin("Admin Framely","admin","admin123");
    public static void main(String[] args) {
        paket.add(new Paket("Wedding Silver","Wedding",5000000));
        paket.add(new Paket("Prewedding Basic","Prewedding",2500000));
        paket.add(new Paket("Wisuda Solo","Wisuda",750000));
        paket.add(new Paket("Produk Katalog","Produk",1200000));
        int p;
        do {
            System.out.println("\n=== FRAMELY ===\n1. Pelanggan\n2. Admin\n0. Keluar");
            p=angka("Pilih: ");
            if(p==1) pelanggan();
            else if(p==2) menuAdmin();
        } while(p!=0);
    }
    static int angka(String s) {
        try { System.out.print(s); return Integer.parseInt(sc.nextLine()); }
        catch(Exception e) { return -1; }
    }
    static String teks(String s) { System.out.print(s); return sc.nextLine(); }
    static void tampilPaket() {
        for(int i=0;i<paket.size();i++) System.out.println((i+1)+". "+paket.get(i));
    }
    static void pelanggan() {
        int p;
        do {
            System.out.println("\n1. Paket\n2. Pesan\n3. Cek Status\n4. Portofolio (belum tersedia)\n0. Kembali");
            p=angka("Pilih: ");
            switch(p) {
                case 1 -> tampilPaket();
                case 2 -> pesan();
                case 3 -> cekStatus();
                case 4 -> System.out.println("Fitur portofolio belum tersedia.");
            }
        } while(p!=0);
    }
    static void pesan() {
        String n=teks("Nama: "), h=teks("No HP: ");
        tampilPaket(); int x=angka("Pilih paket: ");
        if(x<1||x>paket.size()) { System.out.println("Paket tidak tersedia."); return; }
        String t=teks("Tanggal sesi: "), k="FRM"+(1001+pesanan.size());
        pesanan.add(new Pesanan(k,new Pelanggan(n,h),paket.get(x-1),t));
        System.out.println("Pesanan berhasil. Kode: "+k);
    }
    static void cekStatus() {
        String k=teks("Kode pesanan: ");
        for(Pesanan p:pesanan) if(p.getKode().equalsIgnoreCase(k)) { System.out.println(p); return; }
        System.out.println("Kode tidak ditemukan.");
    }
    static void menuAdmin() {
        if(!admin.login(teks("Username: "),teks("Password: "))) { System.out.println("Login gagal."); return; }
        int p;
        do {
            System.out.println("\n1. Pesanan\n2. Ubah Status\n3. Tambah Paket\n4. Laporan\n0. Logout");
            p=angka("Pilih: ");
            switch(p) {
                case 1 -> pesanan.forEach(System.out::println);
                case 2 -> ubahStatus();
                case 3 -> tambahPaket();
                case 4 -> laporan();
            }
        } while(p!=0);
    }
    static void ubahStatus() {
        String k=teks("Kode pesanan: ");
        for(Pesanan p:pesanan) if(p.getKode().equalsIgnoreCase(k)) {
            int x=angka("1. Dikonfirmasi 2. Selesai 3. Dibatalkan: ");
            if(x>=1&&x<=3) p.setStatus(new String[]{"Dikonfirmasi","Selesai","Dibatalkan"}[x-1]);
            else System.out.println("Pilihan salah.");
            return;
        }
        System.out.println("Kode tidak ditemukan.");
    }
    static void tambahPaket() {
        String n=teks("Nama paket: "), k=teks("Kategori: "); int h=angka("Harga: ");
        if(h<0) { System.out.println("Harga tidak valid."); return; }
        paket.add(new Paket(n,k,h)); System.out.println("Paket ditambahkan.");
    }
    static void laporan() {
        int t=0,s=0;
        for(Pesanan p:pesanan) if(p.getStatus().equals("Selesai")) { s++; t+=p.getPaket().getHarga(); }
        System.out.println("Total pesanan: "+pesanan.size()+"\nSelesai: "+s+"\nPendapatan: Rp"+t);
    }
}
