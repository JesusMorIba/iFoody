package es.iescarrillo.project.ifoody_jmi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.iescarrillo.project.ifoody_jmi.R;

public class VerificationCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code);

        // Back button click listener to finish the activity
        ImageView ivBack = findViewById(R.id.ivBack);

        ivBack.setOnClickListener(v -> {
            finish();
        });

        // "Forgot Password" TextView click listener to navigate to ResetPasswordActivity
        TextView tvForgotP = findViewById(R.id.tvForgotP);

        tvForgotP.setOnClickListener(v -> {
            Intent resetPIntent = new Intent(getApplicationContext(), ResetPasswordActivity.class);
            startActivity(resetPIntent);
        });

        // Submit button click listener to navigate to MainActivity
        Button btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(mainIntent);
        });
    }
}