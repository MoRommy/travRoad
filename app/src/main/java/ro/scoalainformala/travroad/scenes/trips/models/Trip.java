package ro.scoalainformala.travroad.scenes.trips.models;

import java.util.Objects;

public class Trip {
    private String name;
    private String destination;
    private String type;
    private int price;
    private String startDate;
    private String endDate;
    double rating;
    boolean isFavourite;
    private String imageUrl;

    public Trip(String name, String destination, String type, int price, String startDate, String endDate, double rating, boolean isFavourite, String imageUrl) {
        this.name = name;
        this.destination = destination;
        this.type = type;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rating = rating;
        this.isFavourite = isFavourite;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return price == trip.price &&
                Double.compare(trip.rating, rating) == 0 &&
                isFavourite == trip.isFavourite &&
                name.equals(trip.name) &&
                destination.equals(trip.destination) &&
                type.equals(trip.type) &&
                startDate.equals(trip.startDate) &&
                endDate.equals(trip.endDate) &&
                imageUrl.equals(trip.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, destination, type, price, startDate, endDate, rating, isFavourite, imageUrl);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "name='" + name + '\'' +
                ", destination='" + destination + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", rating=" + rating +
                ", isFavourite=" + isFavourite +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
