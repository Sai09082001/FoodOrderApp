package org.o7planning.knfood.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.o7planning.knfood.Model.Cart;
import org.o7planning.knfood.Model.Food;
import org.o7planning.knfood.R;

import java.util.ArrayList;
import java.util.List;

public class ListCartAdapter extends RecyclerView.Adapter<ListCartAdapter.ViewHolder> {
    public List<Food> dsFood;
    private View.OnClickListener mOnItemClickListener;
    public ListCartAdapter(List<Food> dsFood){this.dsFood=dsFood;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_cart_food, parent, false);

        // Return a new holder instance
        ListCartAdapter.ViewHolder viewHolder = new ListCartAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Food food = dsFood.get(position);
        TextView tv_title = holder.tv_title;
        TextView tv_price = holder.tv_price;
        TextView tv_note = holder.tv_note;
        TextView tv_count= holder.tv_count;
        tv_title.setText(food.getfName());
        tv_price.setText(food.getPrice()+" VND");
        tv_note.setText(food.getNote());
        holder.food = dsFood.get(position);
    }
    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }
    @Override
    public int getItemCount() {
        return dsFood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    public TextView tv_title;
    public TextView tv_price;
    public TextView tv_note;
    public TextView tv_count;
    public Food food;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
            tv_title= itemView.findViewById(R.id.tv_food_title);
            tv_note=itemView.findViewById(R.id.tv_food_note);
            tv_price=itemView.findViewById(R.id.tv_food_price);
            tv_count=itemView.findViewById(R.id.tv_cart_count);
        }
    }
}
