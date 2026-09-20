package model;

public class AnggotaVIP extends Anggota {
    private double diskon;
    private double biayaPersonalTrainer;

    public AnggotaVIP(String idAnggota, String nama, double biayaDasar, double diskon, double biayaPersonalTrainer) {
        super(idAnggota, nama, biayaDasar);
        this.diskon = diskon;
        this.biayaPersonalTrainer = biayaPersonalTrainer;
    }

    public double getDiskon() {
        return diskon;
    }

    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }

    public double getBiayaPersonalTrainer() {
        return biayaPersonalTrainer;
    }

    public void setBiayaPersonalTrainer(double biayaPersonalTrainer) {
        this.biayaPersonalTrainer = biayaPersonalTrainer;
    }

    @Override
    public double hitungTotalBiaya() {
        double biayaSetelahDiskon = getBiayaDasar() - (getBiayaDasar() * diskon);
        return biayaSetelahDiskon + biayaPersonalTrainer;
    }

    @Override
    public String getTipeKeanggotaan() {
        return "VIP";
    }
}