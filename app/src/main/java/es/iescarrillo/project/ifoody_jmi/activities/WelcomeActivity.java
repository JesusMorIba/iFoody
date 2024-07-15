package es.iescarrillo.project.ifoody_jmi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.iescarrillo.project.ifoody_jmi.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Find the TextView by ID
        TextView tvSignIn = findViewById(R.id.tvSignIn);

        // Set a click listener for the "Sign In" TextView to navigate to the LoginActivity
        tvSignIn.setOnClickListener(v -> {
            Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(loginIntent);
        });

        // Find the Skip button by ID
        Button btnSkip = findViewById(R.id.btnSkip);

        // Set a click listener for the Skip button to navigate to the SignUpActivity
        btnSkip.setOnClickListener(v -> {
            Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(mainIntent);
        });

        // Find the SignUp button by ID
        Button btnSingUp = findViewById(R.id.btnSingUp);

        // Set a click listener for the SignUp button to navigate to the SignUpActivity
        btnSingUp.setOnClickListener(v-> {
            Intent mainIntent = new Intent(getApplicationContext(), SignUpActivity.class);
            startActivity(mainIntent);
        });
    }
}