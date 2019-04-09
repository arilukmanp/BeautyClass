package com.kreasi.beautyclass.Model;

public class MealsModel {

    public String getMealPic() {
        return mealPic;
    }

    public void setMealPic(String mealPic) {
        this.mealPic = mealPic;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealDate() {
        return mealDate;
    }

    public void setMealDate(String mealDate) {
        this.mealDate = mealDate;
    }

    public String getMealTime() {
        return mealTime;
    }

    public void setMealTime(String mealTime) {
        this.mealTime = mealTime;
    }

    public String getMealPlace() {
        return mealPlace;
    }

    public void setMealPlace(String mealPlace) {
        this.mealPlace = mealPlace;
    }

    private String mealPic;
    private String mealName;
    private String mealDate;
    private String mealTime;
    private String mealPlace;

    public MealsModel(){
        this.mealPic = getMealPic();
        this.mealName = getMealName();
        this.mealDate = getMealDate();
        this.mealTime = getMealTime();
        this.mealPlace = getMealPlace();
    }

    public MealsModel(String pic,String name, String date,String time, String place){
        this.mealPic = pic;
        this.mealName = name;
        this.mealDate = date;
        this.mealTime = time;
        this.mealPlace = place;
    }

}
