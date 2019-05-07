package com.kreasi.beautyclass.Model;

public class GalleryModel {
    private String imgName;
    private String imgUrl;
    private String idImg;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date;

    public GalleryModel(){
        this.imgName = getImgName();
        this.imgUrl = getImgUrl();
        this.idImg = getIdImg();
        this.date = getDate();
    }

    public GalleryModel(String nama,String url,String id,String date){
        this.imgName = nama;
        this.imgUrl = url;
        this.idImg = id;
        this.date = date;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getIdImg() {
        return idImg;
    }

    public void setIdImg(String idImg) {
        this.idImg = idImg;
    }
}
