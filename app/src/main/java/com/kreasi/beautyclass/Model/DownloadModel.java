package com.kreasi.beautyclass.Model;

import java.util.Date;

public class DownloadModel {
    private int idDokumen;
    private String UrlDokumen;
    private String namaDokumen;
    private String dateDokumen;

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    private  int stat;

    public DownloadModel(int idDokumen, String urlDokumen, String namaDokumen, String dateDokumen, int stak) {
        this.idDokumen = idDokumen;
        this.UrlDokumen = urlDokumen;
        this.namaDokumen = namaDokumen;
        this.dateDokumen = dateDokumen;
        this.stat = stak;
    }

    public int getIdDokumen() {
        return idDokumen;
    }

    public void setIdDokumen(int idDokumen) {
        this.idDokumen = idDokumen;
    }

    public String getUrlDokumen() {
        return UrlDokumen;
    }

    public void setUrlDokumen(String urlDokumen) {
        UrlDokumen = urlDokumen;
    }

    public String getNamaDokumen() {
        return namaDokumen;
    }

    public void setNamaDokumen(String namaDokumen) {
        this.namaDokumen = namaDokumen;
    }

    public String getDateDokumen() {
        return dateDokumen;
    }

    public void setDateDokumen(String dateDokumen) {
        this.dateDokumen = dateDokumen;
    }
}
