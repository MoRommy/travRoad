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
    private final ImageView isFavourite;
    private final ImageView imageView;

    public TripViewHolder(@NonNull View itemView) {
        super(itemView);
        tripName = itemView.findViewById(R.id.tripTitleTextView);
        destination = itemView.findViewById(R.id.destinationTextView);
        price = itemView.findViewById(R.id.tripPrice);
        rating = itemView.findViewById(R.id.ratingBar);
        isFavourite = itemView.findViewById(R.id.favouriteTripIcon);
        imageView = itemView.findViewById(R.id.imageView);
    }

    public void bindTrip(Trip trips) {
        tripName.setText(trips.getName());
        rating.setRating((float) trips.getRating());
        Picasso.get().load(trips.getImageUrl()).resize(848, 480).centerCrop().into(imageView);
        destination.setText(trips.getDestination());
        price.setText(String.valueOf(trips.getPrice()).concat("$"));
        if (trips.isFavourite())
            isFavourite.setVisibility(View.VISIBLE);
    }
}