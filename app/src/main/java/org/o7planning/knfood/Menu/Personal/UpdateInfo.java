package org.o7planning.knfood.Menu.Personal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.o7planning.knfood.Menu.MenuActivity;
import org.o7planning.knfood.R;

public class UpdateInfo extends AppCompatActivity {
    ImageView btn_back_update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_info);
        btn_back_update = findViewById(R.id.btn_back_update);
        btn_back_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MenuActivity.class);
                startActivity(i);
            }
        });
    }
}
