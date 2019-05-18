package com.kreasi.beautyclass.Presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kreasi.beautyclass.Model.TransaksiModel;
import com.kreasi.beautyclass.R;

import java.util.ArrayList;

public class TransaksiAdapter extends RecyclerView.Adapter<TransaksiAdapter.Holder> {
    private Context context;
    private ArrayList<TransaksiModel> listTransaksi;

    public TransaksiAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<TransaksiModel> getListTransaksi() {
        return listTransaksi;
    }

    public void setListTransaksi(ArrayList<TransaksiModel> listTransaksi) {
        this.listTransaksi = listTransaksi;
    }

    @NonNull
    @Override
    public TransaksiAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_transactions,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransaksiAdapter.Holder holder, int i) {
        holder.tvNo.setText(String.valueOf(i));
        int jumlah = getListTransaksi().get(i).getTotal();
        int cashback = getListTransaksi().get(i).getCashback();
        int total = jumlah-cashback;
        holder.tvTotal.setText(String.valueOf(total));
        holder.tvNota.setText(getListTransaksi().get(i).getNoNota());
        holder.tvjumlah.setText(String.valueOf(jumlah));
        holder.tvCashback.setText(String.valueOf(cashback));

    }

    @Override
    public int getItemCount() {
        return getListTransaksi().size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView tvNo;
        TextView tvNota;
        TextView tvjumlah;
        TextView tvCashback;
        TextView tvTotal;
        public Holder(@NonNull View itemView) {
            super(itemView);
            tvCashback = itemView.findViewById(R.id.cashback);
            tvjumlah = itemView.findViewById(R.id.jumlah_trans);
            tvNo = itemView.findViewById(R.id.nomorlistTrans);
            tvNota = itemView.findViewById(R.id.no_trans);
            tvTotal = itemView.findViewById(R.id.total_trans);
        }
    }
}
