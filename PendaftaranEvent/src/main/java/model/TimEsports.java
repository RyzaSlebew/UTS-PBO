package Model;

public class TimEsports {

    private int idTim;
    private String namaTim;
    private String kaptenTim;
    private KategoriGame kategoriGame;
    private Tournament tournament;

    public TimEsports(int idTim, String namaTim, String kaptenTim, 
                      KategoriGame kategoriGame, Tournament tournament) {
        this.idTim = idTim;
        this.namaTim = namaTim;
        this.kaptenTim = kaptenTim;
        this.kategoriGame = kategoriGame;
        this.tournament = tournament;
    }

    public int getIdTim() {
        return idTim;
    }

    public void setNamaTim(String namaTim) {
        this.namaTim = namaTim;
    }

    public void setKaptenTim(String kaptenTim) {
        this.kaptenTim = kaptenTim;
    }

    public void setKategoriGame(KategoriGame kategoriGame) {
        this.kategoriGame = kategoriGame;
    }

    public void tampilkanInfo() {
        System.out.println("ID Tim         : " + idTim);
        System.out.println("Nama Tim       : " + namaTim);
        System.out.println("Kapten Tim     : " + kaptenTim);
        System.out.println("Kategori Game  : " + kategoriGame.getNamaKategori());
        System.out.println("Turnamen       : " + tournament.getNamaTournament());
        System.out.println("Lokasi         : " + tournament.getLokasi());
        System.out.println("-----------------------------------------");
    }
}