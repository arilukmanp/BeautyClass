package com.kreasi.beautyclass.Data;

import com.kreasi.beautyclass.Model.ScheduleModel;

import java.util.ArrayList;

public class ScheduleData {
    public static String[][] schedule = new String[][] {
            {"Course 1","08.00","Convention Hall UIN Suka lt 3","1"},
            {"Breakfast","09.00","Teatrikal Saintek","2"},
            {"Course 3","10.00","Convention Hall UIN Suka lt 3","1"},
            {"Lunch","11.00","Teatrikal Saintek","2"},
            {"Course 5","12.00","Convention Hall UIN Suka lt 3","1"},
            {"Dinner","13.00","Teatrikal Saintek","2"},
            {"Course 7","14.00","Convention Hall UIN Suka lt 3","1"},
    };

    public static ArrayList<ScheduleModel> getSchedule(){
        ScheduleModel scheduleModel = null;
        ArrayList<ScheduleModel> list = new ArrayList<>();
        for (String[] item: schedule ){
            scheduleModel = new ScheduleModel();
            scheduleModel.setNameCourse(item[0]);
            scheduleModel.setPlaceCourse(item[2]);
            scheduleModel.setTimeCourse(item[1]);
            scheduleModel.setStat(item[3]);

            list.add(scheduleModel);
        }
        return list;
    }
}
