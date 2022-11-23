package org.o7planning.knfood.viewmodel;

import android.net.Uri;
import android.util.Patterns;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import org.o7planning.knfood.Constants;
import org.o7planning.knfood.KNFoodApp;
import org.o7planning.knfood.Model.User;
import org.o7planning.knfood.base.BaseViewModel;

public class RegisterViewModel extends BaseViewModel {

    private MutableLiveData<FirebaseUser> userMutableLiveData;
    private DatabaseReference databaseReference;

    public MutableLiveData<Boolean> getIsRegis() {
        return isRegis;
    }

    private MutableLiveData<Boolean> isRegis = new MutableLiveData<>(false);

    public RegisterViewModel() {
        userMutableLiveData = new MutableLiveData<>();

    }

    public void signUp(String email, String password, String name, String cPassword){
        if (!password.equals(cPassword)){
            errorMessage.postValue("Password and confirm password must be the same");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            errorMessage.postValue("Please enter valid email");
        } else  if (email.trim().isEmpty() || name.trim().isEmpty() || password.trim().isEmpty() || cPassword.trim().isEmpty()) {
            errorMessage.postValue("Please fill out the form");
        } else {
            handleSignUp(email, password, name);
        }
    }

    public void handleSignUp(String email, String password, String name){
        isRegis.postValue(true);
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            databaseReference = firebaseDatabase.getReference().child("users-reg").child(firebaseAuth.getUid());
                            upUserToDatabase(firebaseAuth.getUid(), name, email);

                        } else {
                            errorMessage.postValue(task.getException().toString());
                        }
                    }
                });
    }

    public void upUserToDatabase(String uid, String name, String email){
        User user = new User(uid, email, name,Constants.OFFLINE,"Customer");
        databaseReference.setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    userMutableLiveData.postValue(firebaseAuth.getCurrentUser());
                } else {
                    errorMessage.postValue(task.getException().toString());
                }
            }
        });
    }

    public MutableLiveData<FirebaseUser> getUserMutableLiveData() {
        return userMutableLiveData;
    }

}
