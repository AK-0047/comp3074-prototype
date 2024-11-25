package ca.projects.project_prototype;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import ca.projects.project_prototype.R;

public class MainActivity extends AppCompatActivity {

    EditText emailInput, passwordInput, confirmPasswordInput;
    Button continueButton;
    TextView passwordMismatchError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
        continueButton = findViewById(R.id.continueButton);
        passwordMismatchError = findViewById(R.id.passwordMismatchError);

        // Set OnClickListener for the Continue button
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the password and confirm password values
                String password = passwordInput.getText().toString().trim();
                String confirmPassword = confirmPasswordInput.getText().toString().trim();

                // Validate passwords
                if (password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    // Show error if passwords don't match
                    passwordMismatchError.setVisibility(View.VISIBLE);
                } else {
                    // Hide error if passwords match
                    passwordMismatchError.setVisibility(View.GONE);
                    // Proceed to next step (e.g., navigate to dashboard)
                    Toast.makeText(MainActivity.this, "Passwords match, proceeding...", Toast.LENGTH_SHORT).show();
                    // TODO: Proceed to dashboard (start new activity, etc.)

                    // Start the DashboardActivity
                    Intent intent = new Intent(MainActivity.this, HomePage.class);
                    startActivity(intent);
                    finish(); // Optional: Finish MainActivity so the user can't go back to it
                }
            }
        });
    }
}
