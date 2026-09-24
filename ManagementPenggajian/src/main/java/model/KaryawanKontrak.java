package model;

public class KaryawanKontrak extends Karyawan {
    private int jumlahJamLembur;
    private double upahLemburPerJam;

    public KaryawanKontrak(String idKaryawan, String nama, double gajiPokok, int jumlahJamLembur, double upahLemburPerJam) {
        super(idKaryawan, nama, gajiPokok);
        this.jumlahJamLembur = jumlahJamLembur;
        this.upahLemburPerJam = upahLemburPerJam;
    }

    public int getJumlahJamLembur() {
        return jumlahJamLembur;
    }

    public void setJumlahJamLembur(int jumlahJamLembur) {
        if (jumlahJamLembur >= 0) {
            this.jumlahJamLembur = jumlahJamLembur;
        }
    }

    public double getUpahLemburPerJam() {
        return upahLemburPerJam;
    }

    public void setUpahLemburPerJam(double upahLemburPerJam) {
        if (upahLemburPerJam >= 0) {
            this.upahLemburPerJam = upahLemburPerJam;
        }
    }

    // Polymorphism: Method Overriding 1
    @Override
    public double hitungTotalGaji() {
        return getGajiPokok() + (jumlahJamLembur * upahLemburPerJam);
    }

    // Polymorphism: Method Overloading (Opsi menghitung gaji tanpa upah lembur)
    public double hitungTotalGaji(boolean tanpaLembur) {
        // Condition (If-Else)
        if (tanpaLembur) {
            return getGajiPokok();
        }
        return hitungTotalGaji();
    }

    // Polymorphism: Method Overriding 2
    @Override
    public String getStatusKaryawan() {
        return "Karyawan Kontrak";
    }
}