package org.o7planning.knfood.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.o7planning.knfood.Model.FoodHome;
import org.o7planning.knfood.R;

import java.util.List;

public class HomeFoodAdapter extends RecyclerView.Adapter<HomeFoodAdapter.ViewHolder> {
    private List<FoodHome> listfood;
    public HomeFoodAdapter(List<FoodHome> listfood){
        this.listfood=listfood;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_homefood, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodHome foodHome = listfood.get(position);
        TextView tv_namefood = holder.tv_namefood;
        tv_namefood.setText(foodHome.getNamefood());
    }

    @Override
    public int getItemCount() {
        return listfood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_namefood;


        public ViewHolder(View itemView) {
            super(itemView);
            tv_namefood = (TextView) itemView.findViewById(R.id.tv_namefood);

        }
    }
}
