package ro.scoalainformala.travroad;

import java.util.List;
import java.util.Objects;

import ro.scoalainformala.travroad.scenes.trips.models.Trip;

public class User {
    private String name;
    private String emailAddress;
    private List<Trip> trips;

    public User(String name, String emailAddress, List<Trip> trips) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.trips = trips;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) &&
                emailAddress.equals(user.emailAddress) &&
                trips.equals(user.trips);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, emailAddress, trips);
    }
}
