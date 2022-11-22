package org.o7planning.knfood.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

public class BaseViewModel extends ViewModel {
    protected final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    protected final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    protected final FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
    protected MutableLiveData<Boolean> loggedOut = new MutableLiveData<>();
    protected MutableLiveData<String> errorMessage = new MutableLiveData<>();

    public MutableLiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public void setStatus(String status){
        DatabaseReference reference = firebaseDatabase.getReference().child("users-reg")
                .child(firebaseAuth.getCurrentUser().getUid()).child("status");
        reference.setValue(status);
    }

}
