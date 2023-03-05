package com.app.card;

public class SilverAtmCard extends Card {

  private String jenisTabungan;
  private double balance;
  private double charge;


  public SilverAtmCard(String pin, double balance) {
    super(pin);
    this.balance = balance;
    this.jenisTabungan = "Silver";
    this.charge = 2;
  }

  public String getJenisTabungan() {
    return jenisTabungan;
  }

  @Override
  public void debet(double nominal) {
    if (this.balance < 50 || this.balance - nominal < 50) {
      System.out.println("Saldo tidak mencukupi");
    } else {
      this.balance -= nominal;
      this.getCharge();
      System.out.println("Berhasil melakukan penarikan");
      System.out.println("Saldo saat ini: " + this.balance);
    }
  }
  @Override
  public void simpan(double nominal) {
    this.balance += nominal;
    this.getCharge();
    System.out.println("Berhasil melakukan simpanan");
    System.out.println("Saldo saat ini: " + this.balance);
  }

  @Override
  public boolean cekPin(String pin) {
    // Ternary operator
    return this.getPin().equalsIgnoreCase(pin);
  }
  @Override
  public double infoSaldo() {
    return this.balance;
  }
  @Override
  public double getCharge() {
    return this.balance -= this.charge;
  }

}
