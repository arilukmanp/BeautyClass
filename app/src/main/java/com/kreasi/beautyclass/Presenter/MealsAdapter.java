package com.kreasi.beautyclass.Presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kreasi.beautyclass.Model.MealsModel;
import com.kreasi.beautyclass.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MealsAdapter extends RecyclerView.Adapter<MealsAdapter.CategoryViewHolder>{

    private Context context;

    public ArrayList<MealsModel> getListMeals() {
        return listMeals;
    }

    public void setListMeals(ArrayList<MealsModel> listMeals) {
        this.listMeals = listMeals;
    }

    private ArrayList<MealsModel> listMeals;

    public MealsAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public MealsAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemMeal = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.meals_pic, viewGroup,false);
        return new CategoryViewHolder(itemMeal);
    }

    @Override
    public void onBindViewHolder(@NonNull final MealsAdapter.CategoryViewHolder categoryViewHolder, final int i) {
        categoryViewHolder.tvName.setText(getListMeals().get(i).getMealName());
        categoryViewHolder.tvDate.setText(getListMeals().get(i).getMealDate());
        categoryViewHolder.tvTime.setText(getListMeals().get(i).getMealTime());
        categoryViewHolder.tvPlace.setText(getListMeals().get(i).getMealPlace());

        Glide.with(context)
                .load(getListMeals().get(i).getMealPic())
                .apply(new RequestOptions().override(100,100))
                .into(categoryViewHolder.imgMeals);
    }

    @Override
    public int getItemCount() {
        return getListMeals().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDate;
        TextView tvTime;
        TextView tvPlace;
        ImageView imgMeals;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.rv_name_meals);
            tvDate = itemView.findViewById(R.id.rv_date_meals);
            tvTime = itemView.findViewById(R.id.rv_time_meal);
            tvPlace = itemView.findViewById(R.id.rv_place_meal);
            imgMeals = itemView.findViewById(R.id.mealsPic);
        }
    }
}
