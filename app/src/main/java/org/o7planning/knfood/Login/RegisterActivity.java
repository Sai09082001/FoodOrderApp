package org.o7planning.knfood.Login;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.o7planning.knfood.R;
import org.o7planning.knfood.SQLite.TAIKHOANDAO;
import org.o7planning.knfood.base.BaseActivity;
import org.o7planning.knfood.viewmodel.RegisterViewModel;


public class RegisterActivity extends BaseActivity<RegisterViewModel> implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private TextView tv_quaylaidn;
    private EditText username, password, displayname, repassword;

    @Override
    protected Class<RegisterViewModel> getClassViewModel() {
        return RegisterViewModel.class;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_register;
    }

    @Override
    protected void initViews() {
        mAuth = FirebaseAuth.getInstance();
        username = findViewById(R.id.edt_username);
        password = findViewById(R.id.ed_password);
        displayname = findViewById(R.id.ed_displayname);
        repassword = findViewById(R.id.ed_repassword);
        tv_quaylaidn=findViewById(R.id.tv_quaylaidn_register);
        findViewById(R.id.btn_dangky).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_dangky:
                TAIKHOANDAO tkdao = new TAIKHOANDAO(this);
                String user = username.getText().toString();
                String name = displayname.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                if (name.equals("") || user.equals("") || pass.equals("") || repass.equals("")) {
                    Toast.makeText(this, "Vui lòng điền vào tất cả thông tin", Toast.LENGTH_LONG).show();
                } else {

//                            TAIKHOAN tk = new TAIKHOAN();
//                            tk.setUserName(username.getText().toString());
//                            tk.setPassWord(password.getText().toString());
//                            tk.setDisplayName(displayname.getText().toString());
//                            tkdao.insertAccount(tk);
                           // registerAccount(username.getText().toString(),password.getText().toString());
                    mModel.handleSignUp(user, pass, name);
                    mModel.getIsRegis().observe(this, new Observer<Boolean>() {
                        @Override
                        public void onChanged(Boolean aBoolean) {
                            if (aBoolean) {
                                Toast.makeText(getApplicationContext(), "Đăng ký thành công", Toast.LENGTH_LONG).show();
                                onBackPressed();
                            }
                        }
                    });
                }
                    break;
                case R.id.tv_quaylaidn_register:
                onBackPressed();
                break;
        }

    }

//    private void registerAccount(String email ,String password ){
//        mAuth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Toast.makeText(getApplicationContext(), "Đăng ký thành công", Toast.LENGTH_LONG).show();
//                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
//                            startActivity(intent);
//                            finish();
//                        } else {
//                            Log.i("KMFG", "onComplete:fail ");
//
//                            // If sign in fails, display a message to the user.
//                            //Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            //   updateUI(null);
//                        }
//                    }
//                });
//    }
}
