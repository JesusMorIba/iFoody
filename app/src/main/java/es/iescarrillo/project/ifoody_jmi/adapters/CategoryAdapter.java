package es.iescarrillo.project.ifoody_jmi.adapters;

import android.content.Context;
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
import es.iescarrillo.project.ifoody_jmi.models.Category;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private Context context;
    private List<Category> list;
    private int selectedItem = 0;

    public CategoryAdapter(Context context, List<Category> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new ViewHolder for the item view
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        // Bind data to the ViewHolder
        holder.image.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

        // Highlight the selected item
        if (position == selectedItem) {
            holder.llItem.setBackgroundColor(context.getResources().getColor(R.color.primary_color));
            holder.name.setTextColor(context.getResources().getColor(R.color.white));
        } else {
            holder.llItem.setBackgroundColor(context.getResources().getColor(android.R.color.white));
            holder.name.setTextColor(context.getResources().getColor(R.color.black));
        }
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

            image = itemView.findViewById(R.id.ivImageCategory);
            name = itemView.findViewById(R.id.tvNameCategory);
            llItem = itemView.findViewById(R.id.llItem);
        }
    }

    public void setSelectedItem(int position) {
        // Update the selected item and notify data set changes
        int previousSelectedItem = selectedItem;
        selectedItem = position;
        notifyItemChanged(previousSelectedItem);
        notifyItemChanged(selectedItem);
    }
}
