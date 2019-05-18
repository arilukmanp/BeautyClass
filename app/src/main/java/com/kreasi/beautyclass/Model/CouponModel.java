package com.kreasi.beautyclass.Model;

public class CouponModel {
    private int idKupon;
    private int noKupon;
    private int idUser;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    private int day;

    public CouponModel() {
        this.idKupon=getIdKupon();
        this.noKupon=getNoKupon();
        this.idUser=getIdUser();
    }

    public CouponModel(int idKupon, int noKupon, int idUser) {
        this.idKupon = idKupon;
        this.noKupon = noKupon;
        this.idUser = idUser;
    }

    public int getIdKupon() {
        return idKupon;
    }

    public void setIdKupon(int idKupon) {
        this.idKupon = idKupon;
    }

    public int getNoKupon() {
        return noKupon;
    }

    public void setNoKupon(int noKupon) {
        this.noKupon = noKupon;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
