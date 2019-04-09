package com.kreasi.beautyclass.Model;

public class GalleryModel {
    private String imgName;
    private String imgUrl;
    private String idImg;

    public GalleryModel(){
        this.imgName = getImgName();
        this.imgUrl = getImgUrl();
        this.idImg = getIdImg();
    }

    public GalleryModel(String nama,String url,String id){
        this.imgName = nama;
        this.imgUrl = url;
        this.idImg = id;
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
