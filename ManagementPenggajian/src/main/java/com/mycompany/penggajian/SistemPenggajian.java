package com.mycompany.penggajian;

import model.Karyawan;
import model.KaryawanTetap;
import model.KaryawanKontrak;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemPenggajian {
    private static ArrayList<Karyawan> daftarKaryawan = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Mengisi Dummy Data Awal
        isiDummyData();

        int pilihan = 0;

        // Looping (Do-While)
        do {
            System.out.println("\n=== SISTEM MANAJEMEN PENGGAJIAN KARYAWAN ===");
            System.out.println("1. Tambah Karyawan Tetap");
            System.out.println("2. Tambah Karyawan Kontrak");
            System.out.println("3. Tampilkan Semua Data Gaji");
            System.out.println("4. Keluar");
            
            pilihan = inputIntegerValid("Pilih menu (1-4): ");

            // Condition (Switch-Case)
            switch (pilihan) {
                case 1:
                    tambahKaryawanTetap();
                    break;
                case 2:
                    tambahKaryawanKontrak();
                    break;
                case 3:
                    tampilkanSemuaGaji();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan sistem penggajian karyawan!");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid. Harap pilih angka 1-4.");
            }
        } while (pilihan != 4);
    }

    private static void isiDummyData() {
        daftarKaryawan.add(new KaryawanTetap("NIK-001", "Budi Pratama", 5000000, 1000000, 500000));
        daftarKaryawan.add(new KaryawanKontrak("NIK-002", "Siti Rahma", 3500000, 10, 50000));
    }

    private static void tambahKaryawanTetap() {
        System.out.println("\n--- Tambah Karyawan Tetap ---");
        String id = inputStringValid("ID Karyawan (NIK)   : ");
        String nama = inputStringValid("Nama Karyawan       : ");
        double gajiPokok = inputDoubleValid("Gaji Pokok          : Rp ");
        double tunjangan = inputDoubleValid("Tunjangan Keluarga  : Rp ");
        double bonus = inputDoubleValid("Bonus Kinerja       : Rp ");

        daftarKaryawan.add(new KaryawanTetap(id, nama, gajiPokok, tunjangan, bonus));
        System.out.println("-> Data Karyawan Tetap Berhasil Ditambahkan!");
    }

    private static void tambahKaryawanKontrak() {
        System.out.println("\n--- Tambah Karyawan Kontrak ---");
        String id = inputStringValid("ID Karyawan (NIK)   : ");
        String nama = inputStringValid("Nama Karyawan       : ");
        double gajiPokok = inputDoubleValid("Gaji Pokok          : Rp ");
        int jamLembur = inputIntegerValid("Jumlah Jam Lembur   : ");
        double upahLembur = inputDoubleValid("Upah Lembur / Jam   : Rp ");

        daftarKaryawan.add(new KaryawanKontrak(id, nama, gajiPokok, jamLembur, upahLembur));
        System.out.println("-> Data Karyawan Kontrak Berhasil Ditambahkan!");
    }

    private static void tampilkanSemuaGaji() {
        System.out.println("\n--- DAFTAR PENGGAJIAN KARYAWAN ---");
        
        // Condition (If-Else)
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Belum ada data karyawan.");
            return;
        }

        // Looping (For Loop)
        for (int i = 0; i < daftarKaryawan.size(); i++) {
            Karyawan k = daftarKaryawan.get(i);
            System.out.println("\nData ke-" + (i + 1));
            
            // Polymorphism Overriding (Panggilan method yang di-override)
            k.tampilkanInfo();

            // Polymorphism Overloading
            if (k instanceof KaryawanTetap) {
                KaryawanTetap tetap = (KaryawanTetap) k;
                System.out.printf("   [Bonus THR] Total jika dapat bonus THR 50%% : Rp %,.2f\n", tetap.hitungTotalGaji(50.0));
            } else if (k instanceof KaryawanKontrak) {
                KaryawanKontrak kontrak = (KaryawanKontrak) k;
                System.out.printf("   [Gaji Pokok] Jika tanpa hitungan lembur    : Rp %,.2f\n", kontrak.hitungTotalGaji(true));
            }
            System.out.println("----------------------------------------");
        }
    }

    // Helper Validasi Input
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
                if (angka >= 0) {
                    valid = true;
                } else {
                    System.out.println("Nilai tidak boleh negatif!");
                }
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