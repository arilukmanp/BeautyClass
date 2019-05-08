package com.kreasi.beautyclass.Data;



import com.kreasi.beautyclass.Model.SpeakerModel;

import java.util.ArrayList;

public class SpeakerData {
    public static String[][] speaker = new String[][] {
            {"Pevita Pearce","Brand Ambassador Ponds","Actress/Model","Donec tellus sem, fringilla vitae lacus sed, sagittis suscipit sapien. In faucibus eleifend porttitor. Phasellus dignissim nisl vitae erat facilisis, id rhoncus ligula sollicitudin.","S1 Pariwisata, S2 Ekonomi Universitas Indonesia"},
            {"Najwa Shihab","Brand Ambassador Ponds","Actress/Model","Donec tellus sem, fringilla vitae lacus sed, sagittis suscipit sapien. In faucibus eleifend porttitor. Phasellus dignissim nisl vitae erat facilisis, id rhoncus ligula sollicitudin.","S1 Pariwisata, S2 Ekonomi Universitas Indonesia"},
            {"Saskia Sungkar","Brand Ambassador Ponds","Actress/Model","Donec tellus sem, fringilla vitae lacus sed, sagittis suscipit sapien. In faucibus eleifend porttitor. Phasellus dignissim nisl vitae erat facilisis, id rhoncus ligula sollicitudin.","S1 Pariwisata, S2 Ekonomi Universitas Indonesia"},
            {"Paramitha Rusady","Brand Ambassador Ponds","Actress/Model","Donec tellus sem, fringilla vitae lacus sed, sagittis suscipit sapien. In faucibus eleifend porttitor. Phasellus dignissim nisl vitae erat facilisis, id rhoncus ligula sollicitudin.","S1 Pariwisata, S2 Ekonomi Universitas Indonesia"},
            {"Bunga Citra Lestari","Brand Ambassador Ponds","Actress/Model","Donec tellus sem, fringilla vitae lacus sed, sagittis suscipit sapien. In faucibus eleifend porttitor. Phasellus dignissim nisl vitae erat facilisis, id rhoncus ligula sollicitudin.","S1 Pariwisata, S2 Ekonomi Universitas Indonesia"},
    };

    public static ArrayList<SpeakerModel> getSpeaker(){
        SpeakerModel speakerModel =null;
        ArrayList<SpeakerModel> list=new ArrayList<>();
        for (String[] item : speaker){
            speakerModel.setNameSpeaker(item[0]);
            speakerModel.setAchieveSpeaker(item[1]);
            speakerModel.setJobSpeaker(item[2]);
            speakerModel.setAchieveSpeaker(item[3]);
            speakerModel.setDegreeSpeaker(item[4]);

            list.add(speakerModel);
        }
        return list;
    }
}
