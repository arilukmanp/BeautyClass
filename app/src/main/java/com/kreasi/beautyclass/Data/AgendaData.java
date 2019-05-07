package com.kreasi.beautyclass.Data;

import com.kreasi.beautyclass.Model.AgendaModel;

import java.util.ArrayList;

public class AgendaData {
    public static String[][] schedule = new String[][] {
            {"Course 1","08.00","Convention Hall UIN Suka lt 3","1","https://az616578.vo.msecnd.net/files/2016/07/14/6360413378852919011239156226_635862445001735397413760104_makeeeu.jpg","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin consequat libero eu augue blandit pulvinar. Duis faucibus velit sapien, ac sollicitudin justo ullamcorper sed. Ut mattis ullamcorper viverra. Integer eu felis ac nibh molestie aliquam eu nec nibh. Duis nulla massa, aliquam sit amet leo in, sodales euismod libero. Donec tellus sem, fringilla vitae lacus sed, sagittis suscipit sapien. In faucibus eleifend porttitor. Phasellus dignissim nisl vitae erat facilisis, id rhoncus ligula sollicitudin.","Najwa Shihab","Monday, 12 April 2019","Be your Self"},
            {"Breakfast","09.00","Teatrikal Saintek","2","https://cdn.pixabay.com/photo/2017/06/06/22/36/eat-2378726_960_720.jpg","Ut mattis ullamcorper viverra. Integer eu felis ac nibh molestie aliquam eu nec nibh. Duis nulla massa, aliquam sit amet leo in, sodales euismod libero. Donec tellus sem, fringilla vitae lacus sed, sagittis suscipit sapien. In faucibus eleifend porttitor. Phasellus dignissim nisl vitae erat facilisis, id rhoncus ligula sollicitudin.","Participant","Monday, 12 April 2019","Dont be shy"},
            {"Course 3","10.00","Convention Hall UIN Suka lt 3","1","https://az616578.vo.msecnd.net/files/2016/07/14/6360413378852919011239156226_635862445001735397413760104_makeeeu.jpg","Integer eu felis ac nibh molestie aliquam eu nec nibh. Duis nulla massa, aliquam sit amet leo in, sodales euismod libero. Donec tellus sem, fringilla vitae lacus sed, sagittis suscipit sapien. In faucibus eleifend porttitor. Phasellus dignissim nisl vitae erat facilisis, id rhoncus ligula sollicitudin.","Najwa Shihab","Monday, 12 April 2019","Helpfull people"},
            {"Lunch","11.00","Teatrikal Saintek","2","https://cdn.pixabay.com/photo/2017/06/06/22/36/eat-2378726_960_720.jpg","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin consequat libero eu augue blandit pulvinar. Duis faucibus velit sapien, ac sollicitudin justo ullamcorper sed. Ut mattis ullamcorper viverra. Integer eu felis ac nibh molestie aliquam eu nec nibh. Duis nulla massa, aliquam sit amet leo in, sodales euismod libero. Donec tellus sem, fringilla vitae lacus sed, sagittis suscipit sapien. In faucibus eleifend porttitor. Phasellus dignissim nisl vitae erat facilisis, id rhoncus ligula sollicitudin.","Participant","Monday, 12 April 2019","Eating time"},
            {"Course 5","12.00","Convention Hall UIN Suka lt 3","1","https://az616578.vo.msecnd.net/files/2016/07/14/6360413378852919011239156226_635862445001735397413760104_makeeeu.jpg","Donec tellus sem, fringilla vitae lacus sed, sagittis suscipit sapien. In faucibus eleifend porttitor. Phasellus dignissim nisl vitae erat facilisis, id rhoncus ligula sollicitudin.","Najwa shihab","Monday, 12 April 2019","being kind and poverty"},
            {"Dinner","13.00","Teatrikal Saintek","2","https://cdn.pixabay.com/photo/2017/06/06/22/36/eat-2378726_960_720.jpg","In faucibus eleifend porttitor. Phasellus dignissim nisl vitae erat facilisis, id rhoncus ligula sollicitudin.","Participant","Monday, 12 April 2019","lets break"},
            {"Course 7","14.00","Convention Hall UIN Suka lt 3","1","https://az616578.vo.msecnd.net/files/2016/07/14/6360413378852919011239156226_635862445001735397413760104_makeeeu.jpg","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin consequat libero eu augue blandit pulvinar. Duis faucibus velit sapien, ac sollicitudin justo ullamcorper sed. Ut mattis ullamcorper viverra. Integer eu felis ac nibh molestie aliquam eu nec nibh. Duis nulla massa, aliquam sit amet leo in, sodales euismod libero. Donec tellus sem, fringilla vitae lacus sed, sagittis suscipit sapien. In faucibus eleifend porttitor. Phasellus dignissim nisl vitae erat facilisis, id rhoncus ligula sollicitudin.","Najwa shihab","Monday, 12 April 2019","Build the ideal body from yor own effort"},
            {"Course 5","12.00","Convention Hall UIN Suka lt 3","1","https://az616578.vo.msecnd.net/files/2016/07/14/6360413378852919011239156226_635862445001735397413760104_makeeeu.jpg","Donec tellus sem, fringilla vitae lacus sed, sagittis suscipit sapien. In faucibus eleifend porttitor. Phasellus dignissim nisl vitae erat facilisis, id rhoncus ligula sollicitudin.","Najwa shihab","Thursday, 13 April 2019","being kind and poverty"},
            {"Dinner","13.00","Teatrikal Saintek","2","https://cdn.pixabay.com/photo/2017/06/06/22/36/eat-2378726_960_720.jpg","In faucibus eleifend porttitor. Phasellus dignissim nisl vitae erat facilisis, id rhoncus ligula sollicitudin.","Participant","Thursday, 13 April 2019","lets break"},
            {"Course 7","14.00","Convention Hall UIN Suka lt 3","1","https://az616578.vo.msecnd.net/files/2016/07/14/6360413378852919011239156226_635862445001735397413760104_makeeeu.jpg","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin consequat libero eu augue blandit pulvinar. Duis faucibus velit sapien, ac sollicitudin justo ullamcorper sed. Ut mattis ullamcorper viverra. Integer eu felis ac nibh molestie aliquam eu nec nibh. Duis nulla massa, aliquam sit amet leo in, sodales euismod libero. Donec tellus sem, fringilla vitae lacus sed, sagittis suscipit sapien. In faucibus eleifend porttitor. Phasellus dignissim nisl vitae erat facilisis, id rhoncus ligula sollicitudin.","Najwa shihab","Thursday, 13 April 2019","Build the ideal body from yor own effort"},
    };

    public static ArrayList<AgendaModel> getSchedule(String date){
        AgendaModel agendaModel = null;
        ArrayList<AgendaModel> list = new ArrayList<>();
        for (String[] item: schedule ){
            if (date.equals(item[7])){
                agendaModel = new AgendaModel();
                agendaModel.setNameCourse(item[0]);
                agendaModel.setPlaceCourse(item[2]);
                agendaModel.setTimeCourse(item[1]);
                agendaModel.setStat(item[3]);
                agendaModel.setDescCourse(item[5]);
                agendaModel.setSpeaker(item[6]);
                agendaModel.setImgCourse(item[4]);
                agendaModel.setThemeCourse(item[8]);
                agendaModel.setDateCourse(item[7]);

                list.add(agendaModel);
            }
        }
        return list;
    }
}
