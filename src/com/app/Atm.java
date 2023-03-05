package com.app;

import com.app.card.GoldAtmCard;
import com.app.card.SilverAtmCard;
import com.app.nasabah.Nasabah;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Atm
 */
public class Atm {
  public static void main(String[] args) {
    // Instansiasi objek
    SilverAtmCard silver1 = new SilverAtmCard("000000", 500);
    Nasabah alfin = new Nasabah(silver1);

    SilverAtmCard silver2 = new SilverAtmCard("123456", 200);
    Nasabah messi = new Nasabah(silver2);

    GoldAtmCard gold = new GoldAtmCard("777777", 10000);
    Nasabah ronaldo = new Nasabah(gold);

    ArrayList <Nasabah> nasabahs = new ArrayList<>();
    nasabahs.add(messi);
    nasabahs.add(alfin);
    nasabahs.add(ronaldo);

    // Deklarasi variabel
    Scanner input = new Scanner(System.in);
    String pilihan, inputPin, ulang, newPin;
    double nominalDebet, nominalSimpan;
    Nasabah getNasabah = null;
    int trial = 0;
    boolean isValidated = false;
    boolean isLagi = true;

    // Proses ATM
    System.out.println("Selamat Datang di ATM Berkah");
    // 1. Input PIN dan validasi
    while (trial < 3 && !isValidated) {
      System.out.print("Masukkan PIN: ");
      inputPin = input.nextLine();
      
      for (Nasabah nasabah : nasabahs) {
        if (nasabah.validasiPin(inputPin)) {
          isValidated = true;
          getNasabah = nasabah;
          break;
        }
      }
      trial++;
      
      if (trial >= 3) System.out.println("ATM terblokir, silahkan hubungi kantor terdekat");
    }

    // 2. Pilih Menu
    while (isValidated && isLagi) {
      System.out.println("Layanan ATM Berkah");
      System.out.println("1. Cek Saldo");
      System.out.println("2. Penarikan");
      System.out.println("3. Simpan");
      System.out.println("4. Ubah PIN");
      System.out.println("5. Cek PIN");
      System.out.println("6. Keluar");
      System.out.print("Masukkan pilihan: ");
      pilihan = input.nextLine();

      switch (pilihan) {
        case "1":
          getNasabah.cekSaldoNasabah();
          break;
        case "2":
          System.out.print("Masukkan nominal: ");
          nominalDebet = input.nextDouble();
          input.nextLine();
          getNasabah.doDebet(nominalDebet);
          break;
        case "3":
          System.out.print("Masukkan nominal: ");
          nominalSimpan = input.nextDouble();
          input.nextLine();
          getNasabah.doSimpan(nominalSimpan);
          break;
        case "4":
          System.out.print("Masukkan PIN baru: ");
          newPin = input.nextLine();
          getNasabah.gantiPin(newPin);
          break;
        case "5":
          getNasabah.showPin();
          break;
        case "6":
          isLagi = false;
          System.out.println("Terimakasih sudah menggunakan layanan kami");
          break;
        default:
          System.out.println("Menu tidak tersedia");
      }
      // Cek apakaah mau diulang nih menunya
      System.out.println("Lakukan transaksi lagi? (Y/T)");
      ulang = input.nextLine();
      isLagi = ulang.equalsIgnoreCase("T") ? false : true;
    }
    // 3. Selesai
    System.out.println("Silahkan ambil kartu Anda kembali");

  }
  
}