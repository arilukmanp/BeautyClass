package com.kreasi.beautyclass.Model;

public class AgendaModel {

    public AgendaModel(String nameCourse, String timeCourse, String placeCourse, String stat, String desc, String img, String speak,String date,String themeCourse) {
        this.nameCourse = nameCourse;
        this.timeCourse = timeCourse;
        this.placeCourse = placeCourse;
        this.stat = stat;
        this.speaker=speak;
        this.descCourse=desc;
        this.imgCourse=img;
        this.themeCourse=themeCourse;
        this.dateCourse=date;
    }

    public AgendaModel() {
        this.nameCourse = getNameCourse();
        this.placeCourse = getPlaceCourse();
        this.timeCourse = getTimeCourse();
        this.stat = getStat();
        this.descCourse=getDescCourse();
        this.imgCourse=getImgCourse();
        this.speaker=getSpeaker();
        this.themeCourse=getThemeCourse();
        this.dateCourse=getDateCourse();
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

    public String getImgCourse() {
        return imgCourse;
    }

    public void setImgCourse(String imgCourse) {
        this.imgCourse = imgCourse;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getDescCourse() {
        return descCourse;
    }

    public void setDescCourse(String descCourse) {
        this.descCourse = descCourse;
    }

    private String imgCourse;
    private String speaker;
    private String descCourse;

    public String getThemeCourse() {
        return themeCourse;
    }

    public void setThemeCourse(String themeCourse) {
        this.themeCourse = themeCourse;
    }

    public String getDateCourse() {
        return dateCourse;
    }

    public void setDateCourse(String dateCourse) {
        this.dateCourse = dateCourse;
    }

    private String themeCourse;
    private String dateCourse;

}
