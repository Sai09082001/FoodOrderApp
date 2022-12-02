package org.o7planning.knfood.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.o7planning.knfood.Model.Food;
import org.o7planning.knfood.Model.Voucher;
import org.o7planning.knfood.R;


import java.util.List;

public class VoucherAdapter extends RecyclerView.Adapter<VoucherAdapter.ViewHolder> {
    private List<Voucher> voucherList;
    public VoucherAdapter(List<Voucher> voucherList){this.voucherList=voucherList;}

    public void setOnItemClick(OnItemClick event) {
        callBack = event;
    }

    private OnItemClick callBack;

    public interface OnItemClick {
        void onItemClick(Voucher data);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_listticket, parent, false);

        // Return a new holder instance
        VoucherAdapter.ViewHolder viewHolder = new VoucherAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Voucher voucher = voucherList.get(position);
        holder.tv_title.setText(voucher.getTitle());
        holder.tv_date.setText(voucher.getTime());
        holder.tv_status.setText(voucher.getStatus());
        holder.voucher =  voucherList.get(position);
    }

    @Override
    public int getItemCount() {
        return voucherList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_title;
        public TextView tv_date;
        public TextView tv_status;
        public Voucher voucher;
        public Boolean status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title_voucher);
            tv_date = itemView.findViewById(R.id.tv_time_voucher);
            tv_status = itemView.findViewById(R.id.tv_status_voucher);
            itemView.setTag(this);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  callBack.onItemClick(voucher);
                }
            });
        }
    }
}

