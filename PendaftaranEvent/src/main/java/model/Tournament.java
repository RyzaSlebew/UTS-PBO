package Model;

public class Tournament {

    private int idTournament;
    private String namaTournament;
    private String lokasi;

    public Tournament(int idTournament, String namaTournament, String lokasi) {
        this.idTournament = idTournament;
        this.namaTournament = namaTournament;
        this.lokasi = lokasi;
    }

    public int getIdTournament() {
        return idTournament;
    }

    public String getNamaTournament() {
        return namaTournament;
    }

    public String getLokasi() {
        return lokasi;
    }
}