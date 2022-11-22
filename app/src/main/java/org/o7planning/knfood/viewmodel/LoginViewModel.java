package org.o7planning.knfood.viewmodel;

import android.util.Patterns;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

import org.o7planning.knfood.base.BaseViewModel;

public class LoginViewModel extends BaseViewModel {
    private MutableLiveData<FirebaseUser> userMutableLiveData;

    public LoginViewModel() {
        userMutableLiveData = new MutableLiveData<>();
        if (firebaseAuth.getCurrentUser() != null){
            userMutableLiveData.postValue(firebaseAuth.getCurrentUser());
            loggedOut.postValue(false);
        }
    }

    public void signIn(String email, String password){
        if (email.trim().isEmpty()){
            errorMessage.postValue("Vui lòng nhập email!");
        } else if (password.trim().isEmpty()){
            errorMessage.postValue("Vui lòng nhập mật khẩu!");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            errorMessage.postValue("Vui lòng nhập lại email");
        } else {
            firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                userMutableLiveData.postValue(firebaseAuth.getCurrentUser());
                            } else {
                                errorMessage.postValue(task.getException().toString());
                            }
                        }
                    });
        }
    }

    public MutableLiveData<FirebaseUser> getUserMutableLiveData() {
        return userMutableLiveData;
    }


}
