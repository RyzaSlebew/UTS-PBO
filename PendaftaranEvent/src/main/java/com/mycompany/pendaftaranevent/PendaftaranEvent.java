package com.mycompany.pendaftaranevent;

import model.Tournament;
import model.KategoriGame;
import model.TimEsports;

import java.util.ArrayList;
import java.util.Scanner;

public class PendaftaranEvent {
    private static ArrayList<Tournament> daftarPendaftaran = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Mengisi Dummy Data Awal
        isiDummyData();

        int pilihan = 0;

        do {
            System.out.println("\n=== SISTEM MANAJEMEN PENDAFTARAN TOURNAMENT ESPORTS ===");
            System.out.println("1. Tambah Pendaftaran Kategori Game");
            System.out.println("2. Tambah Pendaftaran Tim Esports Pro");
            System.out.println("3. Tampilkan Semua Pendaftaran");
            System.out.println("4. Keluar");
            
            pilihan = inputIntegerValid("Pilih menu (1-4): ");

            switch (pilihan) {
                case 1:
                    tambahKategoriGame();
                    break;
                case 2:
                    tambahTimEsports();
                    break;
                case 3:
                    tampilkanSemuaPendaftaran();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan sistem pendaftaran tournament!");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid. Harap pilih angka 1-4.");
            }
        } while (pilihan != 4);
    }

    // Fungsi Pengisian Dummy Data Awal
    private static void isiDummyData() {
        daftarPendaftaran.add(new KategoriGame("TRN-001", "Evos Squad", 150000, "Mobile Legends", 50000));
        daftarPendaftaran.add(new TimEsports("TRN-002", "RRQ Hoshi", 300000, 5, 0.10, 100000));
    }

    private static void tambahKategoriGame() {
        System.out.println("\n--- Tambah Pendaftaran Kategori Game ---");
        String id = inputStringValid("ID Pendaftaran     : ");
        String nama = inputStringValid("Nama Tim           : ");
        double biayaDasar = inputDoubleValid("Biaya Dasar        : Rp ");
        String namaGame = inputStringValid("Nama Game          : ");
        double biayaSlot = inputDoubleValid("Biaya Slot Tambahan: Rp ");

        daftarPendaftaran.add(new KategoriGame(id, nama, biayaDasar, namaGame, biayaSlot));
        System.out.println("-> Pendaftaran Kategori Game berhasil ditambahkan!");
    }

    private static void tambahTimEsports() {
        System.out.println("\n--- Tambah Pendaftaran Tim Esports Pro ---");
        String id = inputStringValid("ID Pendaftaran       : ");
        String nama = inputStringValid("Nama Tim             : ");
        double biayaDasar = inputDoubleValid("Biaya Dasar          : Rp ");
        int jumlahPemain = inputIntegerValid("Jumlah Pemain        : ");
        double diskonPersen = inputDoubleValid("Diskon Komunitas (%) : ");
        double biayaVIP = inputDoubleValid("Biaya Fasilitas VIP  : Rp ");

        daftarPendaftaran.add(new TimEsports(id, nama, biayaDasar, jumlahPemain, diskonPersen / 100, biayaVIP));
        System.out.println("-> Pendaftaran Tim Esports Pro berhasil ditambahkan!");
    }

    private static void tampilkanSemuaPendaftaran() {
        System.out.println("\n--- DAFTAR PENDAFTARAN TOURNAMENT ---");
        if (daftarPendaftaran.isEmpty()) {
            System.out.println("Belum ada data pendaftaran.");
            return;
        }

        for (int i = 0; i < daftarPendaftaran.size(); i++) {
            Tournament t = daftarPendaftaran.get(i);
            System.out.println("\nData ke-" + (i + 1));
            t.tampilkanInfo(); // Menerapkan Polymorphism Overriding

            // Demonstrasi Polymorphism Overloading
            if (t instanceof KategoriGame) {
                KategoriGame kg = (KategoriGame) t;
                System.out.printf("   [Promo Early] Jika dapat promo 10%%     : Rp %,.2f\n", kg.hitungTotalBiaya(10.0));
            } else if (t instanceof TimEsports) {
                TimEsports te = (TimEsports) t;
                System.out.printf("   [Opsi Hemat] Jika tanpa fasilitas VIP : Rp %,.2f\n", te.hitungTotalBiaya(true));
            }
            System.out.println("----------------------------------------");
        }
    }

    // --- HELPER METHOD UNTUK VALIDASI INPUT ---

    private static String inputStringValid(String pesan) {
        String input = "";
        while (input.trim().isEmpty()) {
            System.out.print(pesan);
            input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Input tidak boleh kosong! Silakan masukkan lagi.");
            }
        }
        return input;
    }

    private static int inputIntegerValid(String pesan) {
        int angka = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print(pesan);
            if (scanner.hasNextInt()) {
                angka = scanner.nextInt();
                scanner.nextLine();
                valid = true;
            } else {
                System.out.println("Input harus berupa angka bulat!");
                scanner.nextLine();
            }
        }
        return angka;
    }

    private static double inputDoubleValid(String pesan) {
        double angka = -1;
        boolean valid = false;
        while (!valid) {
            System.out.print(pesan);
            if (scanner.hasNextDouble()) {
                angka = scanner.nextDouble();
                scanner.nextLine();
                if (angka >= 0) {
                    valid = true;
                } else {
                    System.out.println("Nilai tidak boleh negatif!");
                }
            } else {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        }
        return angka;
    }
}