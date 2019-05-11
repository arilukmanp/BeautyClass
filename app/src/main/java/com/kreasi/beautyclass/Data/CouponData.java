package com.kreasi.beautyclass.Data;

import com.kreasi.beautyclass.Model.CouponModel;

import java.util.ArrayList;
import java.util.List;

public class CouponData {
    public static List<CouponModel> getKupon(){
        List<CouponModel> kupon=new ArrayList<>();
        kupon.add(0,new CouponModel(11,130021,22));
        kupon.add(1,new CouponModel(12,130504,22));
        kupon.add(2,new CouponModel(13,139103,22));
        kupon.add(3,new CouponModel(14,130056,22));
        return kupon;
    }

}
