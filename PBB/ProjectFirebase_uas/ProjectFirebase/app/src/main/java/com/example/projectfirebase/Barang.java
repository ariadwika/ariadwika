package com.example.projectfirebase;

public class Barang {
    private String kode_pro;
    private String nama_pro;
    private String satuan;
    private String jumlah;
    private String harga;
    private String key;

    public String getKode_pro() { return kode_pro; }

    public void setKode_pro(String kode_pro) {
        this.kode_pro = kode_pro;
    }

    public String getNama_pro() {
        return nama_pro;
    }

    public void setNama_pro(String nama_pro) {
        this.nama_pro = nama_pro;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
