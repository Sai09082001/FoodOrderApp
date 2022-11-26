package org.o7planning.knfood.Menu.Messenger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.o7planning.knfood.Adapter.ChatAdapter;
import org.o7planning.knfood.Menu.MenuActivity;
import org.o7planning.knfood.Model.User;
import org.o7planning.knfood.R;
import org.o7planning.knfood.base.BaseActivity;
import org.o7planning.knfood.viewmodel.RoomMessViewModel;


public class RoomMessActivity extends BaseActivity<RoomMessViewModel> {
    private Toolbar tb;
    private User receiverUser;
    private String senderUserUid;
    private ChatAdapter chatAdapter;


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
        tb.setNavigationIcon(R.drawable.ic_back);
        tb.setTitle("username"+"");
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MenuActivity.class);
                startActivity(i);
            }
        });
    }
}
