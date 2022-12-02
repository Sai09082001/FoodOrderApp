package org.o7planning.knfood.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.o7planning.knfood.CommonUtils;
import org.o7planning.knfood.Menu.MenuActivity;
import org.o7planning.knfood.Model.Voucher;
import org.o7planning.knfood.R;
import org.o7planning.knfood.SQLite.SQLiteHelper;
import org.o7planning.knfood.SQLite.TAIKHOANDAO;
import org.o7planning.knfood.base.BaseActivity;
import org.o7planning.knfood.viewmodel.LoginViewModel;

import java.util.List;

public class LoginActivity extends BaseActivity<LoginViewModel> implements View.OnClickListener {
    private Button btn_dangnhap,btn_dangky;
    private TextView tv_quenmk;
    private EditText username,password;
    private RadioButton radioCus;
    private RadioButton radioShip;
    private FirebaseAuth mAuth;
    private SQLiteHelper db;

    @Override
    protected Class<LoginViewModel> getClassViewModel() {
        return LoginViewModel.class;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews() {
        tv_quenmk=findViewById(R.id.tv_quenmatkhau);
        findViewById(R.id.btn_dangnhap).setOnClickListener(this);
        findViewById(R.id.btn_dangky).setOnClickListener(this);
        db = new SQLiteHelper(this);
        username = findViewById(R.id.ed_username);
        password = findViewById(R.id.ed_password);
        radioCus = findViewById(R.id.radioButton_male);
        radioShip  =  findViewById(R.id.radioButton_female);
        mModel.getUserMutableLiveData().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if (firebaseUser != null) {
                    Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        radioCus.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                doOnClickTypeUser(buttonView,isChecked);
            }
        });

        // When radio button "Male" checked change.
        radioShip.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                doOnClickTypeUser(buttonView,isChecked);
            }

        });
    }

    private void doOnClickTypeUser(CompoundButton buttonView, boolean isChecked) {
            RadioButton radio =(RadioButton) buttonView;

            Log.i("KMFG", "RadioButton "+ radio.getText()+" : "+ isChecked);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_dangnhap:
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if(user.equals("")||pass.equals("")){
                    Toast.makeText(this, "Vui lòng nhập tên tài khoản hoặc mật khẩu", Toast.LENGTH_LONG).show();
                }else{
                    signInUser(user,pass);
                }
                break;
            case R.id.btn_dangky:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void signInUser(String email,String password){
        List<Voucher> voucherList = CommonUtils.getInstance().convertListVoucher(
                CommonUtils.getInstance().getJsonStore(R.raw.voucher));
        Log.i("KMFG", "onCreateView: "+voucherList.toString());
        for (int i = 0; i < voucherList.size(); i++) {
            db.addVoucher(voucherList.get(i));
        }
        mModel.signIn(email, password);
    }

}
