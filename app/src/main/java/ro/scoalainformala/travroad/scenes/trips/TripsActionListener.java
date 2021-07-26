package ro.scoalainformala.travroad.scenes.trips;

import ro.scoalainformala.travroad.scenes.trips.models.Trip;

public interface TripsActionListener {
    void onTripSelected(Trip trip);
    void onTripEdit(Trip trip);
    void onTripFavourited(Trip trip);
}
