package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.BreakIterator;
import java.util.List;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.ViewHolder> {

    private List<Offers> offersList;

    public OffersAdapter(List<Offers> offersList) {
        this.offersList = offersList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup
                                                 parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offers, parent, false);
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

