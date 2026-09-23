package model;

public class TimEsports extends Tournament {
    private int jumlahPemain;
    private double diskonKomunitas; // Format desimal (misal 0.10 untuk 10%)
    private double biayaFasilitasVIP;

    public TimEsports(String idPendaftaran, String namaTim, double biayaPendaftaranDasar, int jumlahPemain, double diskonKomunitas, double biayaFasilitasVIP) {
        super(idPendaftaran, namaTim, biayaPendaftaranDasar);
        this.jumlahPemain = jumlahPemain;
        this.diskonKomunitas = diskonKomunitas;
        this.biayaFasilitasVIP = biayaFasilitasVIP;
    }

    // Encapsulation: Getter dan Setter
    public int getJumlahPemain() {
        return jumlahPemain;
    }

    public void setJumlahPemain(int jumlahPemain) {
        if (jumlahPemain > 0) {
            this.jumlahPemain = jumlahPemain;
        }
    }

    public double getDiskonKomunitas() {
        return diskonKomunitas;
    }

    public void setDiskonKomunitas(double diskonKomunitas) {
        if (diskonKomunitas >= 0 && diskonKomunitas <= 1) {
            this.diskonKomunitas = diskonKomunitas;
        }
    }

    public double getBiayaFasilitasVIP() {
        return biayaFasilitasVIP;
    }

    public void setBiayaFasilitasVIP(double biayaFasilitasVIP) {
        if (biayaFasilitasVIP >= 0) {
            this.biayaFasilitasVIP = biayaFasilitasVIP;
        }
    }

    // Method Overriding 1
    @Override
    public double hitungTotalBiaya() {
        double biayaSetelahDiskon = getBiayaPendaftaranDasar() - (getBiayaPendaftaranDasar() * diskonKomunitas);
        return biayaSetelahDiskon + biayaFasilitasVIP;
    }

    // METHOD OVERLOADING (Nama method sama: hitungTotalBiaya dengan parameter tanpaVIP)
    public double hitungTotalBiaya(boolean tanpaVIP) {
        if (tanpaVIP) {
            return getBiayaPendaftaranDasar() - (getBiayaPendaftaranDasar() * diskonKomunitas);
        }
        return hitungTotalBiaya();
    }

    // Method Overriding 2
    @Override
    public String getJenisPendaftaran() {
        return "Tim Esports Pro (" + jumlahPemain + " Pemain)";
    }
}