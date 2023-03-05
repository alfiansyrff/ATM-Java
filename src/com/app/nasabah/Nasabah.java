package com.app.nasabah;

import com.app.card.Card;

public class Nasabah {
  private Card nasabahCard;

  public Nasabah(Card nasabahCard) {
    this.nasabahCard = nasabahCard;
  }

  public void doSimpan(double nominal) {
    this.nasabahCard.simpan(nominal);
  }

  public void doDebet(double nominal) {
    this.nasabahCard.debet(nominal);
  }

  public void cekSaldoNasabah() {
    System.out.println("Saldo Anda saat ini: " + this.nasabahCard.infoSaldo());
  }

  public void gantiPin(String newPin) {
    this.nasabahCard.ubahPin(newPin);
  }

  public boolean validasiPin(String pinToValidate) {
    return this.nasabahCard.cekPin(pinToValidate);
  }

  public void showPin() {
    System.out.println(this.nasabahCard.getPin());
  }
  
}
