package org.o7planning.knfood.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.o7planning.knfood.Model.Messenger;
import org.o7planning.knfood.R;

import java.util.ArrayList;

public class MessengerAdapter extends RecyclerView.Adapter<MessengerAdapter.ViewHolder>{
    public ArrayList<Messenger> dsMess;
    private View.OnClickListener mOnItemClickListener;
    public MessengerAdapter(ArrayList<Messenger> dsMess){this.dsMess=dsMess;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_messenger, parent, false);

        // Return a new holder instance
        MessengerAdapter.ViewHolder viewHolder = new MessengerAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Messenger mess = dsMess.get(position);
        TextView tv_username= holder.tv_username;
        TextView tv_content = holder.tv_content;
        TextView tv_status = holder.tv_status;
        ImageView avarta = holder.avarta;
        tv_username.setText(mess.getUsername());
        tv_content.setText(mess.getContent());
        tv_status.setText("Trạng thái: "+mess.getStatus());

    }
    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }
    @Override
    public int getItemCount() {
        return dsMess.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    public TextView tv_username;
    public TextView tv_content;
    public TextView tv_status;
    public  ImageView avarta;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
            tv_username=itemView.findViewById(R.id.mess_username);
            tv_content=itemView.findViewById(R.id.mess_content);
            tv_status=itemView.findViewById(R.id.mess_status);
            avarta=itemView.findViewById(R.id.mess_avarta);
        }
    }
}
