package com.app.card;

public abstract class Card implements Transactionable, Updateable {

  // Atribut
  private String pin;

  // Constructor
  public Card(String pin) {
    this.pin = pin;
  }

  public String getPin() {
    return pin;
  }

  public abstract boolean cekPin(String pin);
  public abstract double infoSaldo();
  public abstract double getCharge();

  @Override
  public void ubahPin(String newPin) {
    this.pin = newPin;
  }
  // Kalau implementasi interface, harus override semua method yg ada di interface
  // Sebuah asbtract class minimal wajib memiliki 1 method abstract
  // Interface wajib semua method abstract
  // Method abstract adalah method yg gaada isinya
}
