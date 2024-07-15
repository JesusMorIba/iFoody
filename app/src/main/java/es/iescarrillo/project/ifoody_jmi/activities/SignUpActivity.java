package es.iescarrillo.project.ifoody_jmi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import es.iescarrillo.project.ifoody_jmi.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Back button click listener to finish the activity
        ImageView ivBack = findViewById(R.id.ivBack);

        ivBack.setOnClickListener(v -> {
            finish();
        });

        // "Login" TextView click listener to navigate to LoginActivity
        TextView tvLogin = findViewById(R.id.tvLogin);

        tvLogin.setOnClickListener(v -> {
            Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(loginIntent);
        });

        // SignUp button click listener to navigate to PhoneRegistrationActivity
        Button btnSingUp = findViewById(R.id.btnSingUp);

        btnSingUp.setOnClickListener(v -> {
            Intent phoneRegistrationIntent = new Intent(getApplicationContext(), PhoneRegistrationActivity.class);
            startActivity(phoneRegistrationIntent);
        });
    }
}