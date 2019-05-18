package com.kreasi.beautyclass.Data;

import com.kreasi.beautyclass.Model.TransaksiModel;

import java.util.ArrayList;
import java.util.List;

public class TransData {
    public static List<TransaksiModel> getTrans(){
        List<TransaksiModel> trans = new ArrayList<>();
        trans.add(0,new TransaksiModel(1,"TR67898371001",250000,100000));
        trans.add(0,new TransaksiModel(1,"TR67898371001",350000,0));
        trans.add(0,new TransaksiModel(1,"TR67898371001",200000,0));
        trans.add(0,new TransaksiModel(1,"TR67898371001",240000,100000));
        trans.add(0,new TransaksiModel(1,"TR67898371001",455000,200000));
        return trans;
    }
}
