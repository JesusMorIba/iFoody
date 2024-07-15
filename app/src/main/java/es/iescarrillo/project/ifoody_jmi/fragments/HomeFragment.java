package es.iescarrillo.project.ifoody_jmi.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import es.iescarrillo.project.ifoody_jmi.R;
import es.iescarrillo.project.ifoody_jmi.activities.FoodDetailsActivity;
import es.iescarrillo.project.ifoody_jmi.adapters.CategoryAdapter;
import es.iescarrillo.project.ifoody_jmi.adapters.RestaurantAdapter;
import es.iescarrillo.project.ifoody_jmi.models.Category;
import es.iescarrillo.project.ifoody_jmi.models.Restaurant;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerViewCategory, recyclerViewRestaurant;
    private List<Category> categoryList;
    private List<Restaurant> restaurantList;
    private CategoryAdapter categoryAdapter;
    private RestaurantAdapter restaurantAdapter;


    public HomeFragment() {
        // Empty constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize and set up the Category RecyclerView
        recyclerViewCategory = view.findViewById(R.id.rcCategory);

        // Create a list of categories with associated images and names
        categoryList = new ArrayList<>();
        categoryList.add(new Category(R.drawable.img_burguer, "Burger"));
        categoryList.add(new Category(R.drawable.img_donut, "Donut"));
        categoryList.add(new Category(R.drawable.img_pizza_r, "Pizza"));
        categoryList.add(new Category(R.drawable.img_asian, "Asian"));
        categoryList.add(new Category(R.drawable.img_mexican, "Mexican"));
        categoryList.add(new Category(R.drawable.img_icecream, "Cream "));

        // Initialize the CategoryAdapter with the category list
        categoryAdapter = new CategoryAdapter(getContext(), categoryList);

        // Set up the Category RecyclerView with layout manager and touch listener
        recyclerViewCategory.setAdapter(categoryAdapter);
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        recyclerViewCategory.setHasFixedSize(true);
        recyclerViewCategory.setNestedScrollingEnabled(false);

        recyclerViewCategory.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                if (e.getAction() == MotionEvent.ACTION_UP) {
                    View child = rv.findChildViewUnder(e.getX(), e.getY());
                    if (child != null) {
                        int position = rv.getChildAdapterPosition(child);
                        categoryAdapter.setSelectedItem(position);
                    }
                }
                return super.onInterceptTouchEvent(rv, e);
            }
        });

        // Initialize and set up the Restaurant RecyclerView
        recyclerViewRestaurant = view.findViewById(R.id.rcRestaurant);

        // Create a list of restaurants with associated images and names
        restaurantList = new ArrayList<>();
        restaurantList.add(new Restaurant(R.drawable.img_taco, "Mc Donald's"));
        restaurantList.add(new Restaurant(R.drawable.img_enchilada, "Starbucks"));

        // Initialize the RestaurantAdapter with the restaurant list
        restaurantAdapter = new RestaurantAdapter(getContext(), restaurantList);

        // Set up the Restaurant RecyclerView with layout manager
        recyclerViewRestaurant.setAdapter(restaurantAdapter);
        recyclerViewRestaurant.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        recyclerViewRestaurant.setHasFixedSize(true);
        recyclerViewRestaurant.setNestedScrollingEnabled(false);

        return view;
    }
}
