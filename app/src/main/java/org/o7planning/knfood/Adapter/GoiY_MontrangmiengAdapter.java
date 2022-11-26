package org.o7planning.knfood.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.o7planning.knfood.Model.FoodDesserts;
import org.o7planning.knfood.R;

import java.util.ArrayList;
import java.util.List;

public class GoiY_MontrangmiengAdapter extends RecyclerView.Adapter<GoiY_MontrangmiengAdapter.ViewHolder> {
    ArrayList<FoodDesserts> listdesert;
    public GoiY_MontrangmiengAdapter(List<FoodDesserts> listdesert){this.listdesert= (ArrayList<FoodDesserts>) listdesert;}

    @NonNull
    @Override
    public GoiY_MontrangmiengAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_homefood, parent, false);

        // Return a new holder instance
        GoiY_MontrangmiengAdapter.ViewHolder viewHolder = new GoiY_MontrangmiengAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GoiY_MontrangmiengAdapter.ViewHolder holder, int position) {
        FoodDesserts mtm = listdesert.get(position);
        TextView tv_namefood = holder.tv_namefood;
        tv_namefood.setText(mtm.getNamefood());
    }

    @Override
    public int getItemCount() {
        return listdesert.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_namefood;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_namefood = (TextView) itemView.findViewById(R.id.tv_namefood);
        }
    }
}
