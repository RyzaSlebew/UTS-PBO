package model;

public class KaryawanTetap extends Karyawan {
    private double tunjanganKeluarga;
    private double bonusKinerja;

    public KaryawanTetap(String idKaryawan, String nama, double gajiPokok, double tunjanganKeluarga, double bonusKinerja) {
        super(idKaryawan, nama, gajiPokok);
        this.tunjanganKeluarga = tunjanganKeluarga;
        this.bonusKinerja = bonusKinerja;
    }

    public double getTunjanganKeluarga() {
        return tunjanganKeluarga;
    }

    public void setTunjanganKeluarga(double tunjanganKeluarga) {
        if (tunjanganKeluarga >= 0) {
            this.tunjanganKeluarga = tunjanganKeluarga;
        }
    }

    public double getBonusKinerja() {
        return bonusKinerja;
    }

    public void setBonusKinerja(double bonusKinerja) {
        if (bonusKinerja >= 0) {
            this.bonusKinerja = bonusKinerja;
        }
    }

    // Polymorphism: Method Overriding 1
    @Override
    public double hitungTotalGaji() {
        return getGajiPokok() + tunjanganKeluarga + bonusKinerja;
    }

    // Polymorphism: Method Overloading (Dengan penambahan persen bonus tambahan)
    public double hitungTotalGaji(double persenBonusTambahan) {
        double totalAwal = hitungTotalGaji();
        // Condition (If-Else)
        if (persenBonusTambahan > 0) {
            return totalAwal + (getGajiPokok() * (persenBonusTambahan / 100));
        }
        return totalAwal;
    }

    // Polymorphism: Method Overriding 2
    @Override
    public String getStatusKaryawan() {
        return "Karyawan Tetap";
    }
}