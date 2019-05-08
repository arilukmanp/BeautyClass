package com.kreasi.beautyclass.Model;

import java.util.Date;

public class DownloadModel {
    private String idDokumen;
    private String UrlDokumen;
    private String namaDokumen;
    private Date dateDokumen;

    public DownloadModel(String idDokumen, String urlDokumen, String namaDokumen, Date dateDokumen) {
        this.idDokumen = idDokumen;
        this.UrlDokumen = urlDokumen;
        this.namaDokumen = namaDokumen;
        this.dateDokumen = dateDokumen;
    }

    public String getIdDokumen() {
        return idDokumen;
    }

    public void setIdDokumen(String idDokumen) {
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

    public Date getDateDokumen() {
        return dateDokumen;
    }

    public void setDateDokumen(Date dateDokumen) {
        this.dateDokumen = dateDokumen;
    }
}
