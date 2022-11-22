package org.o7planning.knfood.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.o7planning.knfood.Menu.Store.StoreDetails;
import org.o7planning.knfood.Model.Food;
import org.o7planning.knfood.R;

import java.util.List;

public class StoreDetailsAdapter extends RecyclerView.Adapter<StoreDetailsAdapter.ViewHolder> {
    private List<Food> listfood;
    private View.OnClickListener mOnItemClickListener;
    public StoreDetailsAdapter(List<Food> listfood){this.listfood=listfood;}

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
        TextView tv_original_price = holder.tv_original_price;
        TextView tv_price = holder.tv_price;
        tv_title.setText(food.getTitle());
        tv_original_price.setText("Giá gốc "+food.getOriginal_price());
        tv_price.setText(food.getPrice()+"đ");
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
    public TextView tv_original_price;
    public TextView tv_price;
    public TextView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        tv_title=itemView.findViewById(R.id.tv_store_food_title);
        tv_original_price=itemView.findViewById(R.id.tv_store_food_original_price);
        tv_price=itemView.findViewById(R.id.tv_store_food_price);
            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
        }
    }

}
