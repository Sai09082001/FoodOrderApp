package org.o7planning.knfood.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.o7planning.knfood.R;

public class GetPassword extends AppCompatActivity {
    private TextView tv_quaylaidn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_password);
        tv_quaylaidn=findViewById(R.id.tv_quaylaidn);
        tv_quaylaidn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GetPassword.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
