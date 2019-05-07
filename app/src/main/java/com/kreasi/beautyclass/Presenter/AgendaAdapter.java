package com.kreasi.beautyclass.Presenter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kreasi.beautyclass.Model.AgendaModel;
import com.kreasi.beautyclass.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AgendaAdapter extends RecyclerView.Adapter<AgendaAdapter.CategoryViewHolder> {


    public AgendaAdapter(Context context) {
        this.context = context;
    }

    private Context context;

    public ArrayList<AgendaModel> getListSchedule() {
        return listSchedule;
    }

    public void setListSchedule(ArrayList<AgendaModel> listSchedule) {
        this.listSchedule = listSchedule;
    }

    private ArrayList<AgendaModel> listSchedule;

    @NonNull
    @Override
    public AgendaAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemSchedule = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.schedule_item,viewGroup,false);
        return new CategoryViewHolder(itemSchedule);
    }

    @Override
    public void onBindViewHolder(@NonNull AgendaAdapter.CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.tvName.setText(getListSchedule().get(i).getNameCourse());
        categoryViewHolder.tvPlace.setText(getListSchedule().get(i).getPlaceCourse());
        categoryViewHolder.tvTime.setText(getListSchedule().get(i).getTimeCourse());

        List<Integer> colors = new ArrayList<>();
        colors.add(Color.argb(255,115,186,37));
        colors.add(Color.argb(255,246,70,153));
        colors.add(Color.argb(255,249,208,45));
        colors.add(Color.argb(255,62,145,238));
        colors.add(Color.argb(255,255,134,88));

        Random mRandom = new Random();
        final int color = colors.get(mRandom.nextInt(colors.size()));
        categoryViewHolder.background.getBackground().setColorFilter(color, PorterDuff.Mode.ADD);
        if (getListSchedule().get(i).getStat()== "1"){
            Glide.with(context)
                    .load(R.drawable.ic_mic_black_24dp)
                    .apply(new RequestOptions().override(20,20))
                    .into(categoryViewHolder.ikon);
        }else {
            Glide.with(context)
                    .load(R.drawable.ic_local_dining_24px)
                    .apply(new RequestOptions().centerInside())
                    .into(categoryViewHolder.ikon);
        }
    }

    @Override
    public int getItemCount() {
        return getListSchedule().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvTime;
        TextView tvPlace;
        ImageView ikon;
        TextView background;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.name_schedule);
            tvPlace = itemView.findViewById(R.id.place_schedule);
            tvTime = itemView.findViewById(R.id.time_schedule);
            background = itemView.findViewById(R.id.backIconCourse);
            ikon = itemView.findViewById(R.id.iconCourse);
        }
    }
}
