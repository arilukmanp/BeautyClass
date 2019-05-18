package com.kreasi.beautyclass.Data;

import com.kreasi.beautyclass.Model.CouponModel;
import com.kreasi.beautyclass.Model.DownloadModel;

import java.util.ArrayList;
import java.util.List;

public class FileData {
    public static List<DownloadModel> getFile(){
        List<DownloadModel> file=new ArrayList<>();
        file.add(0,new DownloadModel(1,"#","Blush On","20/05/2000",1));
        file.add(1,new DownloadModel(2,"#","Foundation","20/05/2000",1));
        file.add(2,new DownloadModel(3,"#","Make Up","20/05/2000",2));
        file.add(3,new DownloadModel(4,"#","eye whell","20/05/2000",2));
        file.add(4,new DownloadModel(5,"#","Maskara","20/05/2000",2));
        file.add(5,new DownloadModel(6,"#","Bedak airy","20/05/2000",1));
        file.add(6,new DownloadModel(7,"#","Relaxing","20/05/2000",1));
        file.add(7,new DownloadModel(8,"#","Comfort moment","20/05/2000",2));
        file.add(8,new DownloadModel(9,"#","hair Style","20/05/2000",1));
        file.add(9,new DownloadModel(10,"#","Blush On","20/05/2000",2));
        return file;
    }
}
