package org.o7planning.knfood.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.o7planning.knfood.AdapterListener;
import org.o7planning.knfood.Constants;
import org.o7planning.knfood.Model.Conversation;
import org.o7planning.knfood.Model.Message;
import org.o7planning.knfood.Model.User;
import org.o7planning.knfood.R;

import java.util.ArrayList;

public class MessengerAdapter extends RecyclerView.Adapter<MessengerAdapter.ViewHolder>{
    private final ArrayList<Conversation> conversations;
    private AdapterListener listener;


    public MessengerAdapter(ArrayList<Conversation> conversations) {
        this.conversations = conversations;
    }

    public void setListener(AdapterListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public MessengerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_messenger, parent, false);
        return new MessengerAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MessengerAdapter.ViewHolder holder, int position) {
        Conversation con = conversations.get(position);
        User data = con.getOtherUser();
        Message lastMess = con.getLastMessage();

        holder.userName.setText(data.getUserName());
        holder.userLastMess.setText(lastMess.getMessage());
        holder.userTimeSeen.setText(lastMess.getTimeStamp());

        Typeface typeface = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            typeface = holder.itemView.getResources().getFont(R.font.freehani);
        }
        if ((!lastMess.getSeen()) && (lastMess.getSenderUid().equals(data.getId()))) {
            holder.userLastMess.setTypeface(typeface);
        }

        if (data.getStatus().equals(Constants.ONLINE)) {
            holder.tvStatusUser.setText("Trạng thái: Online");
        } else {
            holder.tvStatusUser.setText("Trạng thái: Offline");
        }

        holder.u = data;

    }

    @Override
    public int getItemCount() {
        return conversations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView userAvatar;
        public TextView userName, userLastMess, userTimeSeen , tvStatusUser;
        public LinearLayout lnItemMess;
        public User u;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userAvatar = itemView.findViewById(R.id.mess_avarta);
            userName = itemView.findViewById(R.id.mess_username);
            userLastMess = itemView.findViewById(R.id.mess_content);
            lnItemMess = itemView.findViewById(R.id.ln_item_mess);
            tvStatusUser = itemView.findViewById(R.id.mess_status);
            userTimeSeen = itemView.findViewById(R.id.tv_time_seen);
            lnItemMess.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onClick(u);
                    }
                }
            });

        }
    }
}
