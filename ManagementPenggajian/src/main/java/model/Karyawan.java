package model;

public abstract class Karyawan {
    private String idKaryawan;
    private String nama;
    private double gajiPokok;

    public Karyawan(String idKaryawan, String nama, double gajiPokok) {
        this.idKaryawan = idKaryawan;
        this.nama = nama;
        this.gajiPokok = gajiPokok;
    }

    // Encapsulation: Getter & Setter
    public String getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(String idKaryawan) {
        if (idKaryawan != null && !idKaryawan.trim().isEmpty()) {
            this.idKaryawan = idKaryawan;
        }
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama != null && !nama.trim().isEmpty()) {
            this.nama = nama;
        }
    }

    public double getGajiPokok() {
        return gajiPokok;
    }

    public void setGajiPokok(double gajiPokok) {
        if (gajiPokok >= 0) {
            this.gajiPokok = gajiPokok;
        }
    }

    // Abstract Methods
    public abstract double hitungTotalGaji();
    public abstract String getStatusKaryawan();

    public void tampilkanInfo() {
        System.out.println("ID Karyawan     : " + idKaryawan);
        System.out.println("Nama Karyawan   : " + nama);
        System.out.println("Status Karyawan : " + getStatusKaryawan());
        System.out.printf("Total Gaji      : Rp %,.2f\n", hitungTotalGaji());
    }
}