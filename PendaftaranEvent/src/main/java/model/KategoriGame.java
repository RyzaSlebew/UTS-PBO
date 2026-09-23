package model;

public class KategoriGame extends Tournament {
    private String namaGame;
    private double biayaSlotTambahan;

    public KategoriGame(String idPendaftaran, String namaTim, double biayaPendaftaranDasar, String namaGame, double biayaSlotTambahan) {
        super(idPendaftaran, namaTim, biayaPendaftaranDasar);
        this.namaGame = namaGame;
        this.biayaSlotTambahan = biayaSlotTambahan;
    }

    // Encapsulation: Getter dan Setter
    public String getNamaGame() {
        return namaGame;
    }

    public void setNamaGame(String namaGame) {
        if (namaGame != null && !namaGame.trim().isEmpty()) {
            this.namaGame = namaGame;
        }
    }

    public double getBiayaSlotTambahan() {
        return biayaSlotTambahan;
    }

    public void setBiayaSlotTambahan(double biayaSlotTambahan) {
        if (biayaSlotTambahan >= 0) {
            this.biayaSlotTambahan = biayaSlotTambahan;
        }
    }

    // Method Overriding 1
    @Override
    public double hitungTotalBiaya() {
        return getBiayaPendaftaranDasar() + biayaSlotTambahan;
    }

    // METHOD OVERLOADING (Nama method sama: hitungTotalBiaya dengan parameter diskonPromo)
    public double hitungTotalBiaya(double diskonPromo) {
        double totalAwal = hitungTotalBiaya();
        return totalAwal - (totalAwal * (diskonPromo / 100));
    }

    // Method Overriding 2
    @Override
    public String getJenisPendaftaran() {
        return "Kategori Game (" + namaGame + ")";
    }
}