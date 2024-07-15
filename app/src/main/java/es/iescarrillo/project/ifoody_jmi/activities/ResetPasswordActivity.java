package es.iescarrillo.project.ifoody_jmi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import es.iescarrillo.project.ifoody_jmi.R;

public class ResetPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        // Back button click listener to finish the activity
        ImageView ivBack = findViewById(R.id.ivBack);

        ivBack.setOnClickListener(v -> {
            finish();
        });
    }
}