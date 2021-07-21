package ro.scoalainformala.travroad.scenes.trips.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ro.scoalainformala.travroad.R;
import ro.scoalainformala.travroad.scenes.trips.adapter.TripsAdapter;
import ro.scoalainformala.travroad.scenes.trips.models.Trip;

public class TripsActivity extends AppCompatActivity {

    private RecyclerView tripsRecyclerView;
    ArrayList<Trip> trips = new ArrayList<>();
    TripsAdapter adapter = new TripsAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips);

        setUpTripsRecyclerView();
        populateTripList();
        setTripsInAdapter();
        setUpRecyclerViewAdapter();
    }

    private void setUpRecyclerViewAdapter() {
        tripsRecyclerView.setAdapter(adapter);
        tripsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setTripsInAdapter() {
        adapter.setTrips(trips);
    }

    private void populateTripList() {
        trips.add(new Trip("La mare cu baietii", "Mamaia", "Sea Side", 230, "30/07/2020","33/07/2020", 4.7, true, "https://adevarul.ro/assets/adevarul.ro/MRImage/2021/07/18/60f4029d5163ec427130648a/646x404.jpg"));
        trips.add(new Trip("La munte cu baietii", "Busteni", "Mountains", 120, "19/02/2021", "22/02/2021", 4.2, false, "https://casa-marica.ro/wp-content/uploads/2015/12/vacanta-de-vara-la-munte-1440x900.jpg"));
        trips.add(new Trip("La club cu fetele", "Nuba", "City break", 50, "25/07/2021", "26/07/2021", 3.7, true, "https://2.bp.blogspot.com/-Kwzf2bPrlRE/WnCC0ATvRoI/AAAAAAABbkY/lC2hsHu92oIS5XTXVxFqLWxojqZokTr8ACLcBGAs/s1600/26239132_806717759532563_7991647634809958508_n.jpg"));

    }

    private void setUpTripsRecyclerView() {
        tripsRecyclerView = findViewById(R.id.tripsRecyclerView);
    }
}
