package model;

public class AnggotaReguler extends Anggota {
    private double biayaLoker;

    public AnggotaReguler(String idAnggota, String nama, double biayaDasar, double biayaLoker) {
        super(idAnggota, nama, biayaDasar);
        this.biayaLoker = biayaLoker;
    }

    public double getBiayaLoker() {
        return biayaLoker;
    }

    public void setBiayaLoker(double biayaLoker) {
        this.biayaLoker = biayaLoker;
    }

    @Override
    public double hitungTotalBiaya() {
        return getBiayaDasar() + biayaLoker;
    }

    @Override
    public String getTipeKeanggotaan() {
        return "Reguler";
    }
}