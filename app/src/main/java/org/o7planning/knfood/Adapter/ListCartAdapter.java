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
import org.o7planning.knfood.R;

import java.util.ArrayList;

public class ListCartAdapter extends RecyclerView.Adapter<ListCartAdapter.ViewHolder> {
    public ArrayList<Cart> dsCart;
    private View.OnClickListener mOnItemClickListener;
    public ListCartAdapter(ArrayList<Cart> dsCart){this.dsCart=dsCart;}

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
        Cart cart = dsCart.get(position);
        TextView tv_title = holder.tv_title;
        TextView tv_price = holder.tv_price;
        TextView tv_count= holder.tv_count;
        ImageView img_cart = holder.img;
        tv_title.setText(cart.getTitle());
        tv_price.setText(cart.getPrice()+"đ");
        tv_count.setText(cart.getCount()+"");

    }
    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }
    @Override
    public int getItemCount() {
        return dsCart.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    public TextView tv_title;
    public ImageView img;
    public TextView tv_price;
    public TextView tv_count;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
            tv_title= itemView.findViewById(R.id.tv_cart_title);
            tv_price=itemView.findViewById(R.id.tv_cart_price);
            tv_count=itemView.findViewById(R.id.tv_cart_count);
            img=itemView.findViewById(R.id.cart_img);
        }
    }
}
