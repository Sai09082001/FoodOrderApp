package org.o7planning.knfood.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.o7planning.knfood.Model.Bill;
import org.o7planning.knfood.Model.Food;
import org.o7planning.knfood.R;

import java.util.ArrayList;
import java.util.List;

public class BillAdapter extends RecyclerView.Adapter<BillAdapter.ViewHolder> {
    public List<Food> dsBill;
    private View.OnClickListener mOnItemClickListener;
    public BillAdapter(List<Food> dsBill){this.dsBill = dsBill;}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_history_bill, parent, false);

        // Return a new holder instance
        BillAdapter.ViewHolder viewHolder = new BillAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Food bill = dsBill.get(position);
        TextView tv_title= holder.tv_title;
        TextView tv_rating= holder.tv_rating;
        TextView tv_note = holder.tv_note;
        TextView tv_price = holder.tv_price;
        TextView tv_status = holder.status;
        TextView tv_datebill =holder.tv_datebill;
        tv_title.setText(bill.getfName());
        tv_note.setText(bill.getNote());
       // tv_rating.setText(bill.get()+"");
      //  tv_time.setText(bill.getTime());
        tv_price.setText(bill.getPrice()+" VND");
        tv_datebill.setText(bill.getDate());
        tv_status.setText(bill.getStatus());
    //    tv_status.setText(bill.getStatus());
        //tv_mahoadon.setText(bill.getId());
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
    public TextView tv_note;
    public TextView tv_price;
    public TextView status;
    public TextView tv_datebill;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title=itemView.findViewById(R.id.tv_lichsu_title);
            tv_price= itemView.findViewById(R.id.tv_lichsu_giatien);
            tv_rating=itemView.findViewById(R.id.tv_bill_rating);
            tv_note=itemView.findViewById(R.id.tv_note_bill);
            status = itemView.findViewById(R.id.tv_bill_status);
            tv_datebill=itemView.findViewById(R.id.tv_date_bill);
            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
        }
    }
}
