package model;

public abstract class Tournament {
    private String idPendaftaran;
    private String namaTim;
    private double biayaPendaftaranDasar;

    public Tournament(String idPendaftaran, String namaTim, double biayaPendaftaranDasar) {
        this.idPendaftaran = idPendaftaran;
        this.namaTim = namaTim;
        this.biayaPendaftaranDasar = biayaPendaftaranDasar;
    }

    // Encapsulation: Getter dan Setter
    public String getIdPendaftaran() {
        return idPendaftaran;
    }

    public void setIdPendaftaran(String idPendaftaran) {
        if (idPendaftaran != null && !idPendaftaran.trim().isEmpty()) {
            this.idPendaftaran = idPendaftaran;
        }
    }

    public String getNamaTim() {
        return namaTim;
    }

    public void setNamaTim(String namaTim) {
        if (namaTim != null && !namaTim.trim().isEmpty()) {
            this.namaTim = namaTim;
        }
    }

    public double getBiayaPendaftaranDasar() {
        return biayaPendaftaranDasar;
    }

    public void setBiayaPendaftaranDasar(double biayaPendaftaranDasar) {
        if (biayaPendaftaranDasar >= 0) {
            this.biayaPendaftaranDasar = biayaPendaftaranDasar;
        }
    }

    // Abstract Methods
    public abstract double hitungTotalBiaya();
    public abstract String getJenisPendaftaran();

    public void tampilkanInfo() {
        System.out.println("ID Pendaftaran   : " + idPendaftaran);
        System.out.println("Nama Tim         : " + namaTim);
        System.out.println("Jenis Pendaftaran: " + getJenisPendaftaran());
        System.out.printf("Total Biaya      : Rp %,.2f\n", hitungTotalBiaya());
    }
}