package com.kreasi.beautyclass.Presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kreasi.beautyclass.Model.AgendaModel;
import com.kreasi.beautyclass.R;

import java.util.ArrayList;

public class AgendaVPAdapter extends PagerAdapter {
    private Context context;

    public ArrayList<AgendaModel> getListAgenda() {
        return listAgenda;
    }

    public void setListAgenda(ArrayList<AgendaModel> listAgenda) {
        this.listAgenda = listAgenda;
    }

    private ArrayList<AgendaModel> listAgenda;
    private LayoutInflater layoutInflater;

    public AgendaVPAdapter(Context context, ArrayList<AgendaModel> listAgenda) {
        this.context = context;
        this.listAgenda = listAgenda;
    }

    @Override
    public int getCount() {
        return listAgenda.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.card_agenda,container,false);

        ImageView cover;
        TextView title,time,date;

        cover=view.findViewById(R.id.coverAgenda);
        title=view.findViewById(R.id.titleAgenda);
        time=view.findViewById(R.id.timeAgenda);
        date=view.findViewById(R.id.dateAgenda);

        title.setText(listAgenda.get(position).getNameCourse());
        time.setText(listAgenda.get(position).getTimeCourse());
        date.setText(listAgenda.get(position).getDateCourse());
        if (listAgenda.get(position).getStat()== "1"){
            Glide.with(context)
                    .load(R.drawable.back_make_up)
                    .apply(new RequestOptions().override(200,200))
                    .into(cover);
        }else {
            Glide.with(context)
                    .load(R.drawable.meals)
                    .apply(new RequestOptions().centerInside())
                    .into(cover);
        }
        container.addView(view,0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
