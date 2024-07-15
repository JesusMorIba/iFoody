package es.iescarrillo.project.ifoody_jmi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import es.iescarrillo.project.ifoody_jmi.R;
import es.iescarrillo.project.ifoody_jmi.fragments.CartFragment;
import es.iescarrillo.project.ifoody_jmi.fragments.FavoriteFoodFragment;
import es.iescarrillo.project.ifoody_jmi.fragments.HomeFragment;
import es.iescarrillo.project.ifoody_jmi.fragments.MyOrdersFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView nvMenu;
    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogOut = findViewById(R.id.btnLogOut);

        btnLogOut.setOnClickListener(v -> {
            Intent welcomeIntent = new Intent(getApplicationContext(), WelcomeActivity.class);
            startActivity(welcomeIntent);
        });

        // Load UI components
        loadComponents();
        setSupportActionBar(toolbar);

        // Set up ActionBarDrawerToggle for drawer layout
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open_menu, R.string.close_menu);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // NavigationView item click listener
        nvMenu.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.orders) {
                replaceFragment(new MyOrdersFragment());
            }
            return true;
        });

        // BottomNavigationView item click listener
        bottomNavigation.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.navigation) {
                replaceFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.cart) {
                replaceFragment(new CartFragment());
            } else if (item.getItemId() == R.id.favorite) {
                replaceFragment(new FavoriteFoodFragment());
            }
            return true;
        });

        // Set the initial fragment and item selected
        bottomNavigation.setSelectedItemId(R.id.navigation);
        replaceFragment(new HomeFragment());
    }

    // Replace the current fragment with the given fragment
    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flContent, fragment)
                .commit();
        drawerLayout.closeDrawers();
    }

    // Load UI components from the layout
    private void loadComponents() {
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        nvMenu = findViewById(R.id.nvMenu);
        bottomNavigation = findViewById(R.id.bottomNavigation);
    }
}
