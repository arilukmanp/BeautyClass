package com.kreasi.beautyclass.Model;

public class PromoModel {

    private String promoPic;
    private String promoTitle;
    private String promoDesc;
    private String promoTime;
    private String promoVendor;
    private String idPromo;

    public String getPromoPic() {
        return promoPic;
    }

    public void setPromoPic(String promoPic) {
        this.promoPic = promoPic;
    }

    public String getPromoTitle() {
        return promoTitle;
    }

    public void setPromoTitle(String promoTitle) {
        this.promoTitle = promoTitle;
    }

    public String getPromoDesc() {
        return promoDesc;
    }

    public void setPromoDesc(String promoDesc) {
        this.promoDesc = promoDesc;
    }

    public String getPromoTime() {
        return promoTime;
    }

    public void setPromoTime(String promoTime) {
        this.promoTime = promoTime;
    }

    public String getPromoVendor() {
        return promoVendor;
    }

    public void setPromoVendor(String promoVendor) {
        this.promoVendor = promoVendor;
    }

    public PromoModel(){
        this.promoTitle=getPromoTitle();
        this.promoDesc=getPromoDesc();
        this.promoPic=getPromoPic();
        this.promoTime=getPromoTime();
        this.promoVendor=getPromoVendor();
        this.idPromo=getIdPromo();
    }

    public PromoModel(String pic, String title, String desc, String time, String vendor,String id){
        this.promoPic = pic;
        this.promoTitle = title;
        this.promoDesc = desc;
        this.promoTime = time;
        this.promoVendor = vendor;
        this.idPromo=id;
    }

    public String getIdPromo() {
        return idPromo;
    }

    public void setIdPromo(String idPromo) {
        this.idPromo = idPromo;
    }

}
