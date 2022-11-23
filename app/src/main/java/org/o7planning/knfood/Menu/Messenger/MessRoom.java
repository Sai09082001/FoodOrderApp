package org.o7planning.knfood.Menu.Messenger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.o7planning.knfood.Menu.MenuActivity;
import org.o7planning.knfood.R;


public class MessRoom extends AppCompatActivity {
Toolbar tb;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mess_room);
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
