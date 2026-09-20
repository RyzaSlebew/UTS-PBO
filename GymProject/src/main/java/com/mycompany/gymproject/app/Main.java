package com.mycompany.gymproject.app;

import model.Anggota;
import model.AnggotaReguler;
import model.AnggotaVIP;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Anggota> daftarAnggota = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan = 0;

        do {
            System.out.println("\n=== SISTEM MANAJEMEN ANGGOTA GYM ===");
            System.out.println("1. Tambah Anggota Reguler");
            System.out.println("2. Tambah Anggota VIP");
            System.out.println("3. Tampilkan Semua Anggota");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");

            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Pilihan tidak valid! Harap masukkan angka.");
                scanner.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1:
                    tambahAnggotaReguler();
                    break;
                case 2:
                    tambahAnggotaVIP();
                    break;
                case 3:
                    tampilkanSemuaAnggota();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan sistem!");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.");
            }
        } while (pilihan != 4);
    }

    private static void tambahAnggotaReguler() {
        System.out.println("\n--- Tambah Anggota Reguler ---");
        System.out.print("ID Anggota  : ");
        String id = scanner.nextLine();
        System.out.print("Nama        : ");
        String nama = scanner.nextLine();
        System.out.print("Biaya Dasar : Rp ");
        double biayaDasar = scanner.nextDouble();
        System.out.print("Biaya Loker : Rp ");
        double biayaLoker = scanner.nextDouble();

        daftarAnggota.add(new AnggotaReguler(id, nama, biayaDasar, biayaLoker));
        System.out.println("Anggota Reguler berhasil ditambahkan!");
    }

    private static void tambahAnggotaVIP() {
        System.out.println("\n--- Tambah Anggota VIP ---");
        System.out.print("ID Anggota           : ");
        String id = scanner.nextLine();
        System.out.print("Nama                 : ");
        String nama = scanner.nextLine();
        System.out.print("Biaya Dasar          : Rp ");
        double biayaDasar = scanner.nextDouble();
        System.out.print("Diskon (Persen, e.g. 10): ");
        double diskonPersen = scanner.nextDouble();
        System.out.print("Biaya Trainer        : Rp ");
        double biayaTrainer = scanner.nextDouble();

        daftarAnggota.add(new AnggotaVIP(id, nama, biayaDasar, diskonPersen / 100, biayaTrainer));
        System.out.println("Anggota VIP berhasil ditambahkan!");
    }

    private static void tampilkanSemuaAnggota() {
        System.out.println("\n--- DAFTAR ANGGOTA GYM ---");
        if (daftarAnggota.isEmpty()) {
            System.out.println("Belum ada data anggota.");
            return;
        }

        for (int i = 0; i < daftarAnggota.size(); i++) {
            System.out.println("\nData ke-" + (i + 1));
            daftarAnggota.get(i).tampilkanInfo();
            System.out.println("----------------------------");
        }
    }
}