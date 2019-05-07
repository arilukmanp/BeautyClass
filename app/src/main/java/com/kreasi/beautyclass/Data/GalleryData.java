package com.kreasi.beautyclass.Data;


import com.kreasi.beautyclass.Model.GalleryModel;

import java.util.ArrayList;

public class GalleryData {
    public static String[][] galeri= new String[][] {
            {"Morning Vibes Course 1","http://3.bp.blogspot.com/-LryiA6S7Y_8/U8keJ5kOSUI/AAAAAAAABVg/nR5q__JCaeA/s1600/20140712_161450.jpg","1","12/04/19"},
            {"Morning Vibes Course 2","http://farm7.static.flickr.com/6194/6036663353_8204201c49.jpg","2","12/04/19"},
            {"Evening Vibes Course 3","http://www.infobdg.com/v2/wp-content/uploads/2017/08/BDGBEAUTY_170831_0028-1024x576.jpg","3","12/04/19"},
            {"Evening Vibes Course 4","https://i1.wp.com/radarpekalongan.co.id/wp-content/uploads/2018/01/Beauty-Class-1.jpg?resize=700%2C467","4","12/04/19"},
            {"Breakfast Vibes","https://ak6.picdn.net/shutterstock/videos/21398986/thumb/1.jpg?i10c=img.resize(height:160)","8","12/04/19"},
            {"Afternoon Vibes Course 5","https://cdn1-production-images-kly.akamaized.net/0Dt3zoH7FXifmLChJ9xbqt4ulmU=/680x383/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2455486/original/036397400_1543123875-55056-beauty-class-with-allyssa-hawadi-sukses-digelar-102328.jpg","5","13/04/19"},
            {"Afternoon Vibes Course 6","https://photos.smugmug.com/CMC-Makeup-School-class-photos/Behind-the-Scenes/i-mLR3RH6/0/f67fa045/L/Class%20photos%20dallas%20december-0082-L.jpg","6","13/04/19"},
            {"Lunch Vibes ","https://ak5.picdn.net/shutterstock/videos/28158655/thumb/11.jpg","7","13/04/19"},
    } ;
    public static ArrayList<GalleryModel> getGallery(String date){
        GalleryModel galleryModel = null;
        ArrayList<GalleryModel> list = new ArrayList<>();
        for (String[] item : galeri){
            if (date.equals(item[3])) {
                galleryModel = new GalleryModel();
                galleryModel.setImgName(item[0]);
                galleryModel.setImgUrl(item[1]);
                galleryModel.setIdImg(item[2]);
                galleryModel.setDate(item[3]);

                list.add(galleryModel);
            }
        }
        return list;
    }
    public static ArrayList<GalleryModel> getImg(){
        GalleryModel galleryModel = null;
        ArrayList<GalleryModel> list = new ArrayList<>();
        for (String[] item : galeri){
            galleryModel = new GalleryModel();
            galleryModel.setImgName(item[0]);
            galleryModel.setImgUrl(item[1]);
            galleryModel.setIdImg(item[2]);
            galleryModel.setDate(item[3]);

            list.add(galleryModel);
        }
        return list;
    }
}
