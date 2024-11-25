package ca.projects.project_prototype;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;

public class PostRequestActivity extends AppCompatActivity{

    private TextView datePicker;
    private Button postButton;
    private EditText originInput, destinationInput, seatsInput;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_request);

        // Initialize views
        originInput = findViewById(R.id.originInput);
        destinationInput = findViewById(R.id.destinationInput);
        seatsInput = findViewById(R.id.seatsInput);
        datePicker = findViewById(R.id.datePicker);
        postButton = findViewById(R.id.postButton);


        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        TextView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String origin = originInput.getText().toString();
                String destination = destinationInput.getText().toString();
                String date = datePicker.getText().toString();
                String seats = seatsInput.getText().toString();

                if (origin.isEmpty() || destination.isEmpty() || date.isEmpty() || seats.isEmpty()) {
                    Toast.makeText(PostRequestActivity.this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PostRequestActivity.this, "Trip Posted Successfully!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(PostRequestActivity.this, TripsPageActivity.class);
                    intent.putExtra("origin", origin);
                    intent.putExtra("destination", destination);
                    intent.putExtra("date", date);
                    intent.putExtra("seats", seats);
                    startActivity(intent);
                }
            }
        });
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                        datePicker.setText(selectedDate);
                    }
                },
                year, month, day
        );
        datePickerDialog.show();
    }
}