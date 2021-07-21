package ro.scoalainformala.travroad.scenes.trips.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ro.scoalainformala.travroad.R;
import ro.scoalainformala.travroad.scenes.trips.models.Trip;
import ro.scoalainformala.travroad.scenes.trips.viewHolder.TripViewHolder;

public class TripsAdapter extends RecyclerView.Adapter<TripViewHolder>{

    private List<Trip> trips;

    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_cell, parent, false);
        return new TripViewHolder(view);
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
