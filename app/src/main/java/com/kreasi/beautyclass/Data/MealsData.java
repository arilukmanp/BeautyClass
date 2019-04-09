package com.kreasi.beautyclass.Data;

import com.kreasi.beautyclass.Model.MealsModel;

import java.util.ArrayList;

public class MealsData {
    public static String[][] meals = new String[][]{
            {"https://img.taste.com.au/p8F3dc6I/w506-h253-cfill/taste/2016/11/top-50-budget-meals-117761-1.jpeg","Gado-Gado Mang Ujang","Monday, 12 April 2019","08.00 a.m","White House DiningRoom fl.3"},
            {"https://www.bbcgoodfood.com/sites/default/files/recipe-collections/collection-image/2017/06/600-calorie-meal-collection-main-image.jpg","Gado-Gado Mang Ujang","Monday, 12 April 2019","08.00 a.m","White House DiningRoom fl.3"},
            {"https://img.taste.com.au/p8F3dc6I/w506-h253-cfill/taste/2016/11/top-50-budget-meals-117761-1.jpeg","Gado-Gado Mang Ujang","Monday, 12 April 2019","08.00 a.m","White House DiningRoom fl.3"},
            {"https://www.bbcgoodfood.com/sites/default/files/recipe-collections/collection-image/2017/06/600-calorie-meal-collection-main-image.jpg","Gado-Gado Mang Ujang","Monday, 12 April 2019","08.00 a.m","White House DiningRoom fl.3"},
            {"https://img.taste.com.au/p8F3dc6I/w506-h253-cfill/taste/2016/11/top-50-budget-meals-117761-1.jpeg","Gado-Gado Mang Ujang","Monday, 12 April 2019","08.00 a.m","White House DiningRoom fl.3"},
            {"https://www.bbcgoodfood.com/sites/default/files/recipe-collections/collection-image/2017/06/600-calorie-meal-collection-main-image.jpg","Gado-Gado Mang Ujang","Monday, 12 April 2019","08.00 a.m","White House DiningRoom fl.3"},
            {"https://img.taste.com.au/p8F3dc6I/w506-h253-cfill/taste/2016/11/top-50-budget-meals-117761-1.jpeg","Gado-Gado Mang Ujang","Monday, 12 April 2019","08.00 a.m","White House DiningRoom fl.3"},
            {"https://www.bbcgoodfood.com/sites/default/files/recipe-collections/collection-image/2017/06/600-calorie-meal-collection-main-image.jpg","Gado-Gado Mang Ujang","Monday, 12 April 2019","08.00 a.m","White House DiningRoom fl.3"},
            {"https://img.taste.com.au/p8F3dc6I/w506-h253-cfill/taste/2016/11/top-50-budget-meals-117761-1.jpeg","Gado-Gado Mang Ujang","Monday, 12 April 2019","08.00 a.m","White House DiningRoom fl.3"},
            {"https://www.bbcgoodfood.com/sites/default/files/recipe-collections/collection-image/2017/06/600-calorie-meal-collection-main-image.jpg","Gado-Gado Mang Ujang","Monday, 12 April 2019","08.00 a.m","White House DiningRoom fl.3"},
    };
    public static ArrayList<MealsModel> getMeals(){
        MealsModel mealsModel = null;
        ArrayList<MealsModel> list = new ArrayList<>();
        for(String[] item : meals){
            mealsModel = new MealsModel();
            mealsModel.setMealPic(item[0]);
            mealsModel.setMealName(item[1]);
            mealsModel.setMealDate(item[2]);
            mealsModel.setMealTime(item[3]);
            mealsModel.setMealPlace(item[4]);

        list.add(mealsModel);
        }
        return list;
    }
}
