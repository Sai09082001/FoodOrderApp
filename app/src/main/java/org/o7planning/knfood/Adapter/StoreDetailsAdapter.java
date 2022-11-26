package org.o7planning.knfood.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.o7planning.knfood.Model.Food;
import org.o7planning.knfood.R;

import java.util.List;

public class StoreDetailsAdapter extends RecyclerView.Adapter<StoreDetailsAdapter.ViewHolder> {
    private List<Food> listfood;
    private View.OnClickListener mOnItemClickListener;
    public StoreDetailsAdapter(List<Food> listfood){this.listfood=listfood;}

    public void setOnItemClick(OnItemClick event) {
        callBack = event;
    }

    private OnItemClick callBack;

    public interface OnItemClick {
        void onItemClick(Food data);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_store_food, parent, false);

        // Return a new holder instance
        StoreDetailsAdapter.ViewHolder viewHolder = new StoreDetailsAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Food food = listfood.get(position);
        TextView tv_title=holder.tv_title;
        TextView tv_food_note = holder.tv_food_note;
        TextView tv_price = holder.tv_price;
        tv_title.setText(food.getfName());
        tv_food_note.setText(food.getNote());
        tv_price.setText(food.getPrice()+" VND");
        holder.food = listfood.get(position);
    }
    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }
    @Override
    public int getItemCount() {
        return listfood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    public TextView tv_title;
    public TextView tv_food_note;
    public TextView tv_price;
    public Button btAddFood;
    public Food food;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        tv_title=itemView.findViewById(R.id.tv_store_food_title);
        tv_food_note=itemView.findViewById(R.id.tv_store_food_note);
        tv_price=itemView.findViewById(R.id.tv_store_food_price);
        btAddFood=itemView.findViewById(R.id.btn_store_food_add);
            itemView.setTag(this);
            btAddFood.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    callBack.onItemClick(food);
                }
            });
        }
    }

}
