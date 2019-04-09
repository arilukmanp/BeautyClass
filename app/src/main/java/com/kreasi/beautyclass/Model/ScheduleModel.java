package com.kreasi.beautyclass.Model;

public class ScheduleModel {

    public ScheduleModel(String nameCourse, String timeCourse, String placeCourse, String stat) {
        this.nameCourse = nameCourse;
        this.timeCourse = timeCourse;
        this.placeCourse = placeCourse;
        this.stat = stat;
    }

    public ScheduleModel() {
        this.nameCourse = getNameCourse();
        this.placeCourse = getPlaceCourse();
        this.timeCourse = getTimeCourse();
        this.stat = getStat();
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getTimeCourse() {
        return timeCourse;
    }

    public void setTimeCourse(String timeCourse) {
        this.timeCourse = timeCourse;
    }

    public String getPlaceCourse() {
        return placeCourse;
    }

    public void setPlaceCourse(String placeCourse) {
        this.placeCourse = placeCourse;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    private String nameCourse;
    private String timeCourse;
    private String placeCourse;
    private String stat;


}
