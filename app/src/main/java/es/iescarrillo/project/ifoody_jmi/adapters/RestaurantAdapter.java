package es.iescarrillo.project.ifoody_jmi.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.iescarrillo.project.ifoody_jmi.R;
import es.iescarrillo.project.ifoody_jmi.activities.FoodDetailsActivity;
import es.iescarrillo.project.ifoody_jmi.models.Category;
import es.iescarrillo.project.ifoody_jmi.models.Restaurant;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private Context context;
    private List<Restaurant> list;

    public RestaurantAdapter(Context context, List<Restaurant> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RestaurantAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new ViewHolder for the item view
        return new RestaurantAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantAdapter.ViewHolder holder, int position) {
        // Bind data to the ViewHolder
        holder.image.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

        // Set click listener to navigate to FoodDetailsActivity
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foodDetailsIntent = new Intent(v.getContext(), FoodDetailsActivity.class);
                v.getContext().startActivity(foodDetailsIntent);
            }
        });
    }

    // Return the total number of items in the data set
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;
        LinearLayout llItem;

        public ViewHolder(@NonNull View itemView) {
            // Initialize the ViewHolder with the item view
            super(itemView);

            image = itemView.findViewById(R.id.ivImageRestaurant);
            name = itemView.findViewById(R.id.tvNameRestaurant);
            llItem = itemView.findViewById(R.id.llItem);
        }
    }
}

