package ro.scoalainformala.travroad.scenes.trips.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ro.scoalainformala.travroad.R;
import ro.scoalainformala.travroad.scenes.add_trip.AddTripActivity;
import ro.scoalainformala.travroad.scenes.trips.TripsActionListener;
import ro.scoalainformala.travroad.scenes.trips.activity.TripsActivity;
import ro.scoalainformala.travroad.scenes.trips.models.Trip;
import ro.scoalainformala.travroad.scenes.trips.viewHolder.TripViewHolder;

public class TripsAdapter extends RecyclerView.Adapter<TripViewHolder>{

    private List<Trip> trips;
    private TripsActionListener listener;

    public void setListener(TripsActionListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_cell, parent, false);
        TripViewHolder viewHolder = new TripViewHolder(view);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onTripSelected(trips.get(viewHolder.getAdapterPosition()));
            }
        });

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (listener != null)
                    listener.onTripEdit(trips.get(viewHolder.getAdapterPosition()));
                return true;
            }
        });

        viewHolder.favouriteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onTripFavourited(trips.get(viewHolder.getAdapterPosition()));
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TripViewHolder holder, int position) {
        Trip trip = trips.get(position);
        holder.bindTrip(trip);
    }


    @Override
    public int getItemCount() {
        return trips.size();
    }

    public void setTrips(ArrayList<Trip> trips) {
        this.trips = trips;
        notifyDataSetChanged();
    }

}
