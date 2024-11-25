package com.example.myapplication;

import static java.lang.System.load;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.Instant;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ViewHolder> {

    private List<HotelService> servicesList;

    public ServicesAdapter(List<HotelService> servicesList) {
        this.servicesList = servicesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HotelService service = servicesList.get(position);
        holder.serviceName.setText(service.getName());

    }

    @Override
    public int getItemCount() {
        return servicesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView serviceName;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            serviceName = itemView.findViewById(R.id.service_name);
            img=itemView.findViewById(R.id.img1);
        }
    }
}