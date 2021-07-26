package ro.scoalainformala.travroad.scenes.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import ro.scoalainformala.travroad.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MaterialToolbar toolbar = findViewById(R.id.toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.drawer);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        // Header layout
        View headerView = navigationView.getHeaderView(0);
        ImageView headerImage = headerView.findViewById(R.id.avatar);
        TextView headerName = headerView.findViewById(R.id.name);
        TextView headerMail = headerView.findViewById(R.id.email);
        headerImage.setImageResource(R.drawable.ic_person_outline_24dp);
        headerName.setText(R.string.user_name);
        headerMail.setText(R.string.user_email);

        // When pressing the menu icon on the toolbar we open the nav drawer
        toolbar.setNavigationOnClickListener(v -> drawerLayout.open());

        // Listener used to handle menu items being selected from the navigation drawer
        navigationView.setNavigationItemSelectedListener(item -> {
            Toast.makeText(MainActivity.this, "Navigation drawer: onNavigationItemSelected: " + item.getTitle(), Toast.LENGTH_LONG).show();
            drawerLayout.close();
            return true;
        });
    }
}