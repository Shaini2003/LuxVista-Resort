package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.BreakIterator;
import java.util.List;

public class OffAdapter extends RecyclerView.Adapter<OffAdapter.ViewHolder> {

    private List<Offers> offersList;
    private Context context;

    public OffAdapter(List<Offers> offersList, Context context) {
        this.offersList = offersList;
        this.context = context;
    }
    public void updateData(List<Offers> newOfferList) {
        this.offersList = newOfferList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup
                                                 parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_offer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Offers offers= offersList.get(position);
        holder.offerName.setText(offers.name);
        holder.offerPrice.setText(offers.Price);
        holder.offerDetails.setText(offers.details);
        Glide.with(holder.itemView.getContext()).load(offers.image).into(holder.offerImage);


    }


    @Override
    public int getItemCount() {
        return offersList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView
                offerName, offerPrice, offerDetails;
        ImageView offerImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            offerName = itemView.findViewById(R.id.name);
            offerPrice = itemView.findViewById(R.id.price);
            offerDetails = itemView.findViewById(R.id.details);
            offerImage = itemView.findViewById(R.id.image);

        }
    }
}


