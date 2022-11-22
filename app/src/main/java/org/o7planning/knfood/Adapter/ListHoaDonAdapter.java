package org.o7planning.knfood.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.o7planning.knfood.Model.Bill;
import org.o7planning.knfood.R;

import java.util.ArrayList;

public class ListHoaDonAdapter extends RecyclerView.Adapter<ListHoaDonAdapter.ViewHolder> {
    public ArrayList<Bill> dsBill;
    private View.OnClickListener mOnItemClickListener;
    public ListHoaDonAdapter(ArrayList<Bill> dsBill){this.dsBill = dsBill;}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_lichsu_hoadon, parent, false);

        // Return a new holder instance
        ListHoaDonAdapter.ViewHolder viewHolder = new ListHoaDonAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bill bill = dsBill.get(position);
        TextView tv_title= holder.tv_title;
        TextView tv_rating= holder.tv_rating;
        TextView tv_time = holder.tv_time;
        TextView tv_price = holder.tv_price;
        TextView tv_status = holder.status;
        TextView tv_mahoadon=holder.tv_mahoadon;
        tv_title.setText(bill.getTitle());
        tv_rating.setText(bill.getRating()+"");
        tv_time.setText(bill.getTime());
        tv_price.setText(bill.getPrice()+"đ");
        tv_status.setText(bill.getStatus());
        tv_mahoadon.setText(bill.getBillcode());
    }
    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }
    @Override
    public int getItemCount() { return dsBill.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
    public TextView tv_title;
    public TextView tv_rating;
    public TextView tv_time;
    public TextView tv_price;
    public TextView status;
    public TextView tv_mahoadon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title=itemView.findViewById(R.id.tv_lichsu_title);
            tv_price= itemView.findViewById(R.id.tv_lichsu_giatien);
            tv_rating=itemView.findViewById(R.id.tv_lichsu_rating);
            tv_time=itemView.findViewById(R.id.tv_lichsu_ngaythang);
            status = itemView.findViewById(R.id.tv_lichsu_trangthai);
            tv_mahoadon=itemView.findViewById(R.id.tv_mahoadon);
            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
        }
    }
}
