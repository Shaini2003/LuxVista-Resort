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

import java.util.List;

public class ServiAdapter extends RecyclerView.Adapter<ServiAdapter.ViewHolder> {

    private List<Service> serviceList;
    private Context context;

    public ServiAdapter(List<Service> serviceList, Context context) {
        this.serviceList = serviceList;
        this.context = context;
    }
    public void updateData(List<Service> newServiceList) {
        this.serviceList = newServiceList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup
                                                 parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.servi_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Service service = serviceList.get(position);
        holder.serviceName.setText(service.name);

        holder.servicePrice.setText(service.Price);
        holder.serviceDetails.setText(service.details);
        Glide.with(holder.itemView.getContext()).load(service.image).into(holder.serviceImage);


    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView
                serviceName, servicePrice, serviceDetails;
        ImageView serviceImage;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            serviceName = itemView.findViewById(R.id.service_name);
            servicePrice = itemView.findViewById(R.id.service_price);
            serviceDetails = itemView.findViewById(R.id.service_details);
            serviceImage = itemView.findViewById(R.id.service_image);

        }
    }
}

