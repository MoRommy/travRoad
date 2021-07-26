package ro.scoalainformala.travroad.scenes.trips.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import ro.scoalainformala.travroad.R;
import ro.scoalainformala.travroad.scenes.trips.models.Trip;

public class TripViewHolder extends RecyclerView.ViewHolder {

    private final TextView tripName;
    private final TextView destination;
    private final TextView price;
    private final RatingBar rating;
    public ImageView favouriteIcon;
    private final ImageView imageView;

    public TripViewHolder(@NonNull View itemView) {
        super(itemView);
        tripName = itemView.findViewById(R.id.tripTitleTextView);
        destination = itemView.findViewById(R.id.destinationTextView);
        price = itemView.findViewById(R.id.tripPrice);
        rating = itemView.findViewById(R.id.ratingBar);
        favouriteIcon = itemView.findViewById(R.id.favouriteTripIcon);
        imageView = itemView.findViewById(R.id.imageView);
    }

    public void bindTrip(Trip trip) {
        tripName.setText(trip.getName());
        rating.setRating((float) trip.getRating());
        Picasso.get().load(trip.getImageUrl()).resize(848, 480).centerCrop().into(imageView);
        destination.setText(trip.getDestination());
        price.setText(String.valueOf(trip.getPrice()).concat("$"));
        setFavouriteIcon(trip.isFavourite());
    }


    public void setFavouriteIcon(boolean isFavourite) {
        if (isFavourite)
            favouriteIcon.setImageResource(R.drawable.favourite_on_foreground);
        else
            favouriteIcon.setImageResource(R.drawable.favourite_off_foreground);

    }



}