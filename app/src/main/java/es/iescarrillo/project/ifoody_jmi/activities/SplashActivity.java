package es.iescarrillo.project.ifoody_jmi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import es.iescarrillo.project.ifoody_jmi.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Load the animation
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        // Set the animation on the ImageView
        ImageView ivLogo = findViewById(R.id.ivLogo);
        ivLogo.startAnimation(fadeIn);

        ImageView ivSplashText = findViewById(R.id.ivSplashText);
        ivSplashText.startAnimation(fadeIn);

        // Set a listener to start the main activity when the animation finishes
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // Animation start
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Animation end, start the main activity
                startActivity(new Intent(getApplicationContext(), WelcomeActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // Animation repeat
            }
        });
    }
}