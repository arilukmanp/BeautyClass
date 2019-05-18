package com.kreasi.beautyclass.Model;

public class TransaksiModel {
    private int idTransaksi;
    private String noNota;
    private int total;

    public TransaksiModel() {
        this.idTransaksi = getIdTransaksi();
        this.noNota = getNoNota();
        this.total = getTotal();
        this.cashback = getCashback();
    }

    public TransaksiModel(int idTransaksi, String noNota, int total, int cashback) {
        this.idTransaksi = idTransaksi;
        this.noNota = noNota;
        this.total = total;
        this.cashback = cashback;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getNoNota() {
        return noNota;
    }

    public void setNoNota(String noNota) {
        this.noNota = noNota;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCashback() {
        return cashback;
    }

    public void setCashback(int cashback) {
        this.cashback = cashback;
    }

    private int cashback;
}
