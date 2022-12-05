package org.o7planning.knfood.Menu.Messenger;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

import org.o7planning.knfood.Adapter.ChatAdapter;
import org.o7planning.knfood.Constants;
import org.o7planning.knfood.Model.Message;
import org.o7planning.knfood.Model.User;
import org.o7planning.knfood.R;
import org.o7planning.knfood.base.BaseActivity;
import org.o7planning.knfood.viewmodel.RoomMessViewModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class RoomMessActivity extends BaseActivity<RoomMessViewModel> {
    private Toolbar tb;
    private User receiverUser;
    private Button btSend;
    private EditText edtMessSend;
    private String senderUserUid;
    private ChatAdapter chatAdapter;
    private RecyclerView rcvMessRoom;

    @Override
    protected Class<RoomMessViewModel> getClassViewModel() {
        return RoomMessViewModel.class;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_mess_room;
    }

    @Override
    protected void initViews() {
        tb=findViewById(R.id.tb_mess);
        getUser((User) getIntent().getExtras().get("user"));
        rcvMessRoom = findViewById(R.id.rcv_mess_room);
        edtMessSend = findViewById(R.id.edt_mess_send);
        tb.setNavigationIcon(R.drawable.ic_back);
        btSend = findViewById(R.id.bt_send);
        tb.setTitle("username"+"");
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        senderUserUid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mModel.setChatRoom(senderUserUid, receiverUser.getId());
        mModel.loadMessage();
        tb.setTitle(receiverUser.getUserName());
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messText = edtMessSend.getText().toString();
                if(!messText.equals("")){
                    DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
                    String date = df.format(Calendar.getInstance().getTime());
                    mModel.sendMessage(senderUserUid, receiverUser.getId(), messText, date);
                    edtMessSend.setText("");
                }
            }
        });
        rcvMessRoom.setHasFixedSize(true);
        rcvMessRoom.setLayoutManager(new LinearLayoutManager(this));
        rcvMessRoom.setNestedScrollingEnabled(false);
        chatAdapter = new ChatAdapter(mModel.getMessages());
        rcvMessRoom.setAdapter(chatAdapter);

        mModel.getMessageLiveData().observe(this, new Observer<ArrayList<Message>>() {
            @Override
            public void onChanged(ArrayList<Message> messages) {
                chatAdapter.notifyDataSetChanged();
            }
        });
    }
    @Override
    public void onResume() {
        super.onResume();
        mModel.seenMess();
        mModel.setStatus(Constants.ONLINE);
    }

    @Override
    public void onPause() {
        super.onPause();
        mModel.setStatus(Constants.OFFLINE);
        mModel.removeSeenListener();
    }
    public void getUser(User user){
        this.receiverUser = user;
    }
}
