package ro.scoalainformala.travroad.scenes.splash;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ro.scoalainformala.travroad.scenes.trips.activity.TripsActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startMainActivity();
    }

    private void startMainActivity() {
        Intent mainActivityIntent = new Intent(this, TripsActivity.class);
        startActivity(mainActivityIntent);
    }

}
