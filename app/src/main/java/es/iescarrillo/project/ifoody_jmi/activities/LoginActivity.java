package es.iescarrillo.project.ifoody_jmi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import es.iescarrillo.project.ifoody_jmi.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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

        // "Sign Up" TextView click listener to navigate to SignUpActivity
        TextView tvSignUp = findViewById(R.id.tvSignUp);

        tvSignUp.setOnClickListener(v -> {
            Intent signupIntent = new Intent(getApplicationContext(), SignUpActivity.class);
            startActivity(signupIntent);
        });

        // Login button click listener to navigate to VerificationCodeActivity
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            Intent verificationCodeIntent = new Intent(getApplicationContext(), VerificationCodeActivity.class);
            startActivity(verificationCodeIntent);
        });
    }
}