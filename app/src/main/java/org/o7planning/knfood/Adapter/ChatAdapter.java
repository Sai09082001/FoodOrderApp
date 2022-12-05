package org.o7planning.knfood.Adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.o7planning.knfood.Model.Message;
import org.o7planning.knfood.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    public static final int TYPE_LEFT = 0;
    public static final int TYPE_RIGHT = 1;
    private ArrayList<Message> messageArrayList;
    private String receiverUri;
    FirebaseUser currentUser;
    private Message clickedMess;

    public ChatAdapter(ArrayList<Message> messages) {
        messageArrayList = messages;
    }

    @NonNull
    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        if (viewType == TYPE_LEFT){
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_left, parent, false);
        } else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_right, parent, false);
        }
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.ViewHolder holder, int position) {
        Message msg = messageArrayList.get(position);
        holder.showMessage.setText(msg.getMessage());
        holder.data = msg;
    //    Glide.with(holder.itemView.getContext()).load(Uri.parse(receiverUri)).into(holder.receiverAvatar);
        holder.timeText.setText(msg.getTimeStamp());
        if (position == messageArrayList.size() - 1) {
            if (msg.getSeen()){
                holder.textSeen.setText("Seen");
            } else {
                holder.textSeen.setText("Delivered");
            }
        } else {
            holder.textSeen.setVisibility(View.GONE);
        }

        if (msg.equals(clickedMess)) {
            holder.timeText.setVisibility(View.VISIBLE);
        } else {
            holder.timeText.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return messageArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView showMessage, timeText, textSeen;
        public CircleImageView receiverAvatar;
        public Message data;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            showMessage = itemView.findViewById(R.id.show_message);
            receiverAvatar = itemView.findViewById(R.id.receive_user_image);
            timeText = itemView.findViewById(R.id.time_text);
            textSeen = itemView.findViewById(R.id.text_seen);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickedMess = data;
                    notifyDataSetChanged();
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (messageArrayList.get(position).getSenderUid().equals(currentUser.getUid())){
            return TYPE_RIGHT;
        } else {
            return TYPE_LEFT;
        }
    }
}
