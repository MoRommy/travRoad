package ro.scoalainformala.travroad.scenes.add_trip;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.slider.Slider;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import ro.scoalainformala.travroad.R;
import ro.scoalainformala.travroad.scenes.trips.activity.TripsActivity;
import ro.scoalainformala.travroad.scenes.trips.models.Trip;

public class AddTripActivity extends AppCompatActivity {

    private TextInputLayout titleTextInputLayout;
    private TextInputLayout destinationTextIntputLayout;
    private RadioButton cityBreakRadioButton;
    private RadioButton seaSideRadioButton;
    private RadioButton mountainsRadioButton;
    private Slider priceSlider;
    private TextView startDate;
    private TextView endDate;
    private RatingBar ratingBar;
    MaterialButton saveButton;
    MaterialButton cancelButton;

    public static final String ADD_TRIP_KEY = "addTrip";
    public static final String EDIT_TRIP_KEY = "editTrip";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);

        setUpElements();
        String tripImageURL = "";
        boolean isFavourite = false;

        if (getIntent() != null) {
            if (getIntent().hasExtra(ADD_TRIP_KEY))
                Log.d("intent", "should add the user");
            else if (getIntent().hasExtra(EDIT_TRIP_KEY)) {
                Log.d("intent", "should edit the user");
                Trip trip = getIntent().getParcelableExtra(EDIT_TRIP_KEY);
                Objects.requireNonNull(titleTextInputLayout.getEditText()).setText(trip.getName());
                Objects.requireNonNull(destinationTextIntputLayout.getEditText()).setText(trip.getDestination());
                checkRadioButton(trip);
                priceSlider.setValue(trip.getPrice());
                startDate.setText(trip.getStartDate());
                endDate.setText(trip.getEndDate());
                ratingBar.setRating((float) trip.getRating());
                tripImageURL = trip.getImageUrl();
                isFavourite = trip.isFavourite();
            }
        }


        boolean finalIsFavourite = isFavourite;
        String finalTripImageURL = tripImageURL;
        saveButton.setOnClickListener(v -> {
            //if (checkAllElements())

            Trip finalTrip = new Trip(
                    String.valueOf(Objects.requireNonNull(titleTextInputLayout.getEditText()).getText()),
                    String.valueOf(Objects.requireNonNull(destinationTextIntputLayout.getEditText()).getText()),
                    getTripType(),
                    ((int) priceSlider.getValue()),
                    startDate.getText().toString(),
                    endDate.getText().toString(),
                    ratingBar.getRating(),
                    finalIsFavourite,
                    finalTripImageURL);

            Intent addTrip = new Intent(AddTripActivity.this, TripsActivity.class);
            addTrip.putExtra("EDIT_TRIP_KEY_RETURN", finalTrip);
            startActivity(addTrip);
        });

        cancelButton.setOnClickListener(v -> finish());



    }

    private String getTripType() {
        if (seaSideRadioButton.isChecked())
            return seaSideRadioButton.getText().toString();
        if (mountainsRadioButton.isChecked())
            return mountainsRadioButton.getText().toString();
        if(cityBreakRadioButton.isChecked())
            return cityBreakRadioButton.getText().toString();
        return "none";
    }

//    private boolean checkAllElements() {
//        return true;
//    }

    private void checkRadioButton(Trip trip) {
        if (trip.getType().matches("Sea Side"))
            seaSideRadioButton.setChecked(true);
        else if (trip.getType().matches("City Break"))
            cityBreakRadioButton.setChecked(true);
        else if (trip.getType().matches("Mountains"))
            mountainsRadioButton.setChecked(true);
    }

    private void setUpElements() {
        titleTextInputLayout = findViewById(R.id.tripNameEditText);
        destinationTextIntputLayout = findViewById(R.id.tripDestinationEditText);
        cityBreakRadioButton = findViewById(R.id.cityBreakRadioButton);
        mountainsRadioButton = findViewById(R.id.mountainsRadioButton);
        seaSideRadioButton = findViewById(R.id.seaSideRadioButton);
        priceSlider = findViewById(R.id.tripPriceSlider);
        startDate = findViewById(R.id.startDateTextView);
        endDate = findViewById(R.id.endDateTextView);
        ratingBar = findViewById(R.id.tripRatingBar);
        saveButton = findViewById(R.id.saveButton);
        cancelButton = findViewById(R.id.cancelButton);
    }

}

