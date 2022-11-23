package org.o7planning.knfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.o7planning.knfood.Login.LoginActivity;
import org.o7planning.knfood.Menu.MenuActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        DBHelper dbHelper = new DBHelper(this);
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        db.close();
        logo = findViewById(R.id.logo);
        logo.setOnClickListener(this);
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
//                    101);
//        }

    }
    private void gotoMainActivity() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
      //  finish();
    }

    private void gotoLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
      //  finish();
    }

    @Override
    public void onClick(View view) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null) new Handler().postDelayed(this::gotoMainActivity, 2000);
        else new Handler().postDelayed(this::gotoLoginActivity, 2000);
    }
}

