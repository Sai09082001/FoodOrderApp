package org.o7planning.knfood.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.o7planning.knfood.Model.Ticket;
import org.o7planning.knfood.R;


import java.util.List;

public class ListTicketAdapter extends RecyclerView.Adapter<ListTicketAdapter.ViewHolder> {
    private List<Ticket> listticket;
    private View.OnClickListener mOnItemClickListener;
    public ListTicketAdapter(List<Ticket> listticket){this.listticket=listticket;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_listticket, parent, false);

        // Return a new holder instance
        ListTicketAdapter.ViewHolder viewHolder = new ListTicketAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Ticket ticket = listticket.get(position);
        TextView tv_title=holder.tv_title;
        tv_title.setText(ticket.getTitle());
    }
    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }
    @Override
    public int getItemCount() {
        return listticket.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_title;
        public TextView tv_date;
        public TextView img;
        public Boolean status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.title_ticket);
            tv_date = itemView.findViewById(R.id.date_ticket);
            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
        }
    }
}

