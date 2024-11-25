package ca.projects.project_prototype;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.NonNull;
import android.content.Intent;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;

public class TripsPageActivity extends AppCompatActivity {

    private TextView tripDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips_page);

        // Bottom Navigation (if active)
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_trips);

        // Initialize TextView
        TextView tripDetails = findViewById(R.id.tripDetails);

        // Retrieve data from Intent
        String origin = getIntent().getStringExtra("origin");
        String destination = getIntent().getStringExtra("destination");
        String date = getIntent().getStringExtra("date");
        String seats = getIntent().getStringExtra("seats");

        // Handle null values
        origin = (origin != null) ? origin : "N/A";
        destination = (destination != null) ? destination : "N/A";
        date = (date != null) ? date : "N/A";
        seats = (seats != null) ? seats : "N/A";

        // Display data
        String details = "Origin: " + origin + "\n"
                + "Destination: " + destination + "\n"
                + "Date: " + date + "\n"
                + "Seats: " + seats;
        tripDetails.setText(details);
    }
}
