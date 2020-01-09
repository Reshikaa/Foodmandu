package com.reshika.foodmandu.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.reshika.foodmandu.R;
import com.reshika.foodmandu.model.Detail;

import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailViewHolder> {
    Context mContext;
    List<Detail> detailList;
    public DetailAdapter(Context mContext,List<Detail> detailList){
        this.mContext=mContext;
        this.detailList=detailList;
    }
    @NonNull
    @Override
    public DetailAdapter.DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view,parent,false);
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailAdapter.DetailViewHolder holder, int position) {

        final Detail detail= detailList.get(position);
       // holder.card1.setImageResource(detail.getImage());
        holder.tvname.setText(detail.getName());
        holder.tvtitle.setText(detail.getItem());
        holder.tvaddress.setText(detail.getLocation());

    }

    @Override
    public int getItemCount() {
        return detailList.size();
    }

    public class DetailViewHolder extends RecyclerView.ViewHolder{

        TextView tvtitle,tvname,tvaddress;
        ImageView imgbox,card1;
        public DetailViewHolder(@NonNull View itemView) {
            super(itemView);

            tvtitle=itemView.findViewById(R.id.tvtitle);
            tvname=itemView.findViewById(R.id.tvname);
            tvaddress=itemView.findViewById(R.id.tvaddress);
            imgbox=itemView.findViewById(R.id.imgbox);
            card1=itemView.findViewById(R.id.card1);

        }
    }
}
