package model;

public abstract class Anggota {
    private String idAnggota;
    private String nama;
    private double biayaDasar;

    public Anggota(String idAnggota, String nama, double biayaDasar) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.biayaDasar = biayaDasar;
    }

    public String getIdAnggota() {
        return idAnggota;
    }

    public void setIdAnggota(String idAnggota) {
        this.idAnggota = idAnggota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getBiayaDasar() {
        return biayaDasar;
    }

    public void setBiayaDasar(double biayaDasar) {
        this.biayaDasar = biayaDasar;
    }

    public abstract double hitungTotalBiaya();
    public abstract String getTipeKeanggotaan();

    public void tampilkanInfo() {
        System.out.println("ID           : " + idAnggota);
        System.out.println("Nama         : " + nama);
        System.out.println("Tipe Member  : " + getTipeKeanggotaan());
        System.out.printf("Total Biaya  : Rp %,.2f\n", hitungTotalBiaya());
    }
}