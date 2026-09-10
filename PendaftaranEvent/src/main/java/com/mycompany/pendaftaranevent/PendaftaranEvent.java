package com.mycompany.pendaftaranesports;

import Model.Tournament;
import Model.KategoriGame;
import Model.TimEsports;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<TimEsports> daftarTim = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        Tournament tournament = new Tournament(
                1,
                "Samarinda E-Sports Championship 2026",
                "Samarinda Convention Center"
        );

        boolean berjalan = true;

        while (berjalan) {

            System.out.println("=== SISTEM PENDAFTARAN EVENT E-SPORTS ===");
            System.out.println("Turnamen : " + tournament.getNamaTournament());
            System.out.println("Lokasi   : " + tournament.getLokasi());
            System.out.println("-----------------------------------------");
            System.out.println("1. Pendaftaran Tim Baru");
            System.out.println("2. Tampilkan Daftar Tim");
            System.out.println("3. Ubah Data Tim");
            System.out.println("4. Hapus Pendaftaran Tim");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {

                case 1 -> {
                    System.out.println("\n=== PENDAFTARAN TIM BARU ===");

                    System.out.print("ID Tim: ");
                    int idTim = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nama Tim: ");
                    String namaTim = scanner.nextLine();

                    System.out.print("Nama Kapten: ");
                    String kaptenTim = scanner.nextLine();

                    System.out.print("Kategori Game (MOBA/FPS/dll): ");
                    String namaKategori = scanner.nextLine();

                    KategoriGame kategoriGame = new KategoriGame(namaKategori);

                    TimEsports timBaru = new TimEsports(
                            idTim,
                            namaTim,
                            kaptenTim,
                            kategoriGame,
                            tournament
                    );

                    daftarTim.add(timBaru);

                    System.out.println(">> Tim berhasil terdaftar dalam turnamen!");
                }

                case 2 -> {
                    System.out.println("\n=== DAFTAR TIM TERDAFTAR ===");

                    if (daftarTim.isEmpty()) {
                        System.out.println("Belum ada tim yang terdaftar.");
                    } else {
                        for (TimEsports t : daftarTim) {
                            t.tampilkanInfo();
                        }
                    }
                }

                case 3 -> {
                    System.out.println("\n=== UBAH DATA TIM ===");

                    System.out.print("Masukkan ID Tim: ");
                    int idTarget = scanner.nextInt();
                    scanner.nextLine();

                    boolean ditemukan = false;

                    for (TimEsports t : daftarTim) {

                        if (t.getIdTim() == idTarget) {

                            System.out.print("Nama Tim Baru: ");
                            t.setNamaTim(scanner.nextLine());

                            System.out.print("Nama Kapten Baru: ");
                            t.setKaptenTim(scanner.nextLine());

                            System.out.print("Kategori Game Baru: ");
                            String namaKategori = scanner.nextLine();

                            t.setKategoriGame(new KategoriGame(namaKategori));

                            System.out.println(">> Data tim berhasil diperbarui!");

                            ditemukan = true;
                            break;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println(">> Tim tidak ditemukan!");
                    }
                }

                case 4 -> {
                    System.out.println("\n=== HAPUS PENDAFTARAN TIM ===");

                    System.out.print("Masukkan ID Tim: ");
                    int idTarget = scanner.nextInt();

                    boolean ditemukan = false;

                    for (TimEsports t : daftarTim) {

                        if (t.getIdTim() == idTarget) {

                            daftarTim.remove(t);

                            System.out.println(">> Pendaftaran tim berhasil dibatalkan/dihapus!");

                            ditemukan = true;
                            break;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println(">> Tim tidak ditemukan!");
                    }
                }

                case 5 -> {
                    berjalan = false;
                    System.out.println(">> Program selesai.");
                }

                default -> System.out.println(">> Pilihan tidak valid!");
            }
            System.out.println();
        }

        scanner.close();
    }
}