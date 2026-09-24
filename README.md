1. Deskripsi Proyek
Program Sistem Manajemen Penggajian Karyawan adalah aplikasi berbasis konsol (Command Line Interface) yang dibangun menggunakan bahasa pemrograman Java. Program ini dirancang untuk mencatat, mengelola, dan menghitung total gaji bulanan karyawan berdasarkan tipe status pekerjaannya, yaitu Karyawan Tetap dan Karyawan Kontrak.
Fungsi dan Kegunaan Program:
	Pengelolaan Data Gaji Berbeda Tipe Pekerja: Memungkinkan sistem membedakan komponen perhitungan gaji antara karyawan tetap (gaji pokok + tunjangan keluarga + bonus kinerja) dan karyawan kontrak (gaji pokok + upah lembur per jam).
	Penyimpanan Data Sementara: Menyimpan daftar seluruh karyawan di dalam memori (in-memory storage) menggunakan struktur data ArrayList selama program berjalan.
	Simulasi Perhitungan Variasi Gaji: Memperhitungkan opsi gaji alternatif, seperti skenario pemberian bonus THR tambahan untuk karyawan tetap atau perhitungan gaji murni tanpa lembur bagi karyawan kontrak.
	Keamanan Input Data: Memastikan input dari pengguna berupa angka valid dan bebas dari kesalahan runtime error (program mendadak berhenti/terkeluar).

2. Alur Program (Petunjuk Eksekusi & Cara Kerja Sistem)
A. Petunjuk Eksekusi (Langkah Menjalankan Proyek)
	Persiapan File:
	Buat package model lalu masukkan file Karyawan.java, KaryawanTetap.java, dan KaryawanKontrak.java.
	Buat package com.mycompany.managementpenggajian lalu masukkan file ManagementPenggajian.java.
	Kompilasi & Pembersihan Build: Klik kanan pada nama project di NetBeans, lalu pilih Clean and Build (Shift + F11).
	Eksekusi Program: Tekan tombol Run Project atau tombol F6 pada keyboard.
B. Cara Kerja Sistem (Flow Logika Program)
	Inisialisasi Data Awal (Dummy Data): Saat program pertama kali dijalankan, fungsi isiDummyData() dieksekusi secara otomatis untuk memasukkan 2 contoh data awal (Budi Pratama sebagai Karyawan Tetap dan Siti Rahma sebagai Karyawan Kontrak) ke dalam ArrayList.
	Tampilan Menu Utama: Program menampilkan menu interaktif dalam perulangan do-while:
	Menu 1: Tambah Karyawan Tetap
	Menu 2: Tambah Karyawan Kontrak
	Menu 3: Tampilkan Semua Data Gaji
	Menu 4: Keluar
	Proses Input dan Validasi: Saat pengguna memilih menu, sistem menggunakan helper method (inputStringValid, inputIntegerValid, inputDoubleValid) untuk memvalidasi bahwa input tidak kosong dan tidak bernilai negatif.
	Pemrosesan Menu (switch-case):
	Jika memilih 1: Pengguna memasukkan ID, Nama, Gaji Pokok, Tunjangan Keluarga, dan Bonus Kinerja. Objek KaryawanTetap baru dibuat dan dimasukkan ke dalam ArrayList.
	Jika memilih 2: Pengguna memasukkan ID, Nama, Gaji Pokok, Jam Lembur, dan Upah Lembur/Jam. Objek KaryawanKontrak baru dibuat dan dimasukkan ke dalam ArrayList.
	Jika memilih 3: Sistem melakukan perulangan (looping) pada ArrayList untuk memanggil method tampilkanInfo() yang mengeksekusi kalkulasi gaji spesifik masing-masing karyawan (polymorphism) serta menampilkan opsi simulasi biayanya.
	Jika memilih 4: Program menampilkan pesan penutup dan perulangan do-while berhenti.

3. Penjelasan Penerapan Encapsulation dan Inheritance
A. Penerapan Encapsulation
Encapsulation diterapkan untuk menyembunyikan detail atribut kelas dan melindungi data dari manipulasi langsung dari luar kelas:
	Access Modifier private: Seluruh atribut data pada kelas Karyawan, KaryawanTetap, dan KaryawanKontrak (seperti idKaryawan, nama, gajiPokok, dll.) dideklarasikan dengan kata kunci private.
	Method Getter & Setter: Pengaksesan dan pengubahan nilai atribut hanya dapat dilakukan melalui method getter (misal: getNama()) dan setter (misal: setNama()). Di dalam setter, terdapat logika validasi dasar untuk memeriksa bahwa teks tidak kosong atau biaya tidak bernilai negatif.
B. Penerapan Inheritance (Pewarisan)
Inheritance adalah mekanisme PBO di mana suatu kelas dapat mewarisi atribut dan method dari kelas lain. Dalam program ini, terdapat 2 tipe subclass yang diturunkan dari 1 superclass:
	Superclass (Karyawan.java): Merupakan abstract class induk yang menampung atribut umum seperti idKaryawan, nama, dan gajiPokok, serta method generik untuk seluruh jenis pekerja.
	Subclass 1 (KaryawanTetap.java): Dibuat menggunakan kata kunci extends Karyawan. Kelas ini mewarisi seluruh data induknya dan menambahkan atribut khusus berupa tunjanganKeluarga dan bonusKinerja.
	Subclass 2 (KaryawanKontrak.java): Diturunkan dari Karyawan menggunakan extends Karyawan. Kelas ini menambahkan atribut spesifik yaitu jumlahJamLembur dan upahLemburPerJam.

4. Penjelasan Polymorphism dan Validasi Input
A. Penerapan Polymorphism (Banyak Bentuk)
Polymorphism memungkinkan suatu method memiliki nama yang sama namun bertindak atau merespons secara berbeda tergantung objek atau parameter yang dipanggil:
	Method Overriding (Polimorfisme Dinamis): Method abstrak hitungTotalGaji() dan getStatusKaryawan() yang dideklarasikan di superclass Karyawan di-override oleh kedua subclass:
	Pada KaryawanTetap, hitungTotalGaji() menghitung: "Gaji Pokok"+"Tunjangan"+"Bonus" .
	Pada KaryawanKontrak, hitungTotalGaji() menghitung: "Gaji Pokok"+("Jam Lembur" ×"Upah Lembur" ).
	Method Overloading (Polimorfisme Statis): Terdapat dua versi method dengan nama sama tetapi beda parameter:
	Pada KaryawanTetap: hitungTotalGaji(double persenBonusTambahan) menerima parameter persen bonus tambahan untuk menghitung simulasi total gaji saat promo/THR.
	Pada KaryawanKontrak: hitungTotalGaji(boolean tanpaLembur) menerima parameter boolean untuk menghitung opsi total gaji murni tanpa lembur.
B. Penerapan Validasi Input
	Mencegah Program Crash: Menggunakan helper method khusus (inputStringValid, inputIntegerValid, inputDoubleValid) pada kelas utama (ManagementPenggajian.java).
	Penanganan Kesalahan Data: Jika pengguna salah memasukkan tipe data (misalnya memasukkan teks saat diminta angka) atau memasukkan angka bernilai negatif, sistem akan menampilkan pesan peringatan dan meminta input ulang secara aman tanpa menghentikan jalannya program.

5. Penjelasan Condition dan Looping
A. Condition (Percabangan / If-Else)
Struktur kondisi digunakan untuk menentukan arah eksekusi kode berdasarkan syarat tertentu:
	Pengambilan Keputusan Menu (switch-case): Pada kelas ManagementPenggajian, ekspresi switch-case digunakan untuk mengeksekusi fungsi berdasarkan pilihan angka menu pengguna (1–4).
	Pengecekan Tipe Objek (instanceof): Pada saat menampilkan daftar seluruh karyawan, digunakan kondisi if (k instanceof KaryawanTetap) atau else if (k instanceof KaryawanKontrak) untuk memanggil method overloading yang sesuai dengan tipe objeknya.
	Validasi Input & Batasan Nilai: Digunakan pada setter dan helper input (misalnya if (angka >= 0)) untuk memastikan input angka tidak negatif dan input teks tidak kosong.
B. Looping (Perulangan)
Looping digunakan untuk mengulang eksekusi blok kode secara efisien:
	Perulangan Menu Utama (do-while): Menggunakan do { ... } while (pilihan != 4) agar tampilan menu utama terus dimunculkan kembali setelah pengguna selesai melakukan suatu aksi, sampai pengguna memilih angka 4untuk keluar.
	Perulangan Menampilkan Data (for loop): Menggunakan for (int i = 0; i < daftarKaryawan.size(); i++) untuk menyisir (traverse) setiap elemen di dalam ArrayList dan mencetak rincian gaji masing-masing karyawan ke layar.
	Perulangan Validasi Input (while loop): Menggunakan while (!valid) pada fungsi helper input agar program terus meminta input ulang jika pengguna memasukkan tipe data yang salah atau bernilai negatif.

<img width="502" height="539" alt="Screenshot 2026-09-24 204907" src="https://github.com/user-attachments/assets/c83ef611-ba43-4ace-83be-ae914f7d9af1" />

