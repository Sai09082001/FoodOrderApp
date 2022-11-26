package org.o7planning.knfood.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.o7planning.knfood.Model.Food;
import org.o7planning.knfood.Model.Store;
import org.o7planning.knfood.base.BaseViewModel;

import java.util.ArrayList;

public class ListStoreViewModel extends BaseViewModel {
    private ArrayList<Store> storeArrayList;
    private DatabaseReference mDatabase;
    private MutableLiveData<ArrayList<Store>> storeList;

    public MutableLiveData<ArrayList<Store>> getStoreList() {
        return storeList;
    }

    public ListStoreViewModel() {
        storeArrayList = new ArrayList<>();
        storeList = new MutableLiveData<>();
        mDatabase = firebaseDatabase.getReference("stores-reg");
    }

    public void loadStoreFood () {

//        mDatabase.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                    storeArrayList.clear();
//                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
//                        Store store = dataSnapshot.getValue(Store.class);
//                            storeArrayList.add(store);
//                    }
//                    storeList.postValue(storeArrayList);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
   //     Store store = new Store("1","1","1","1","1",new Food("1","1",12300));

//        mDatabase.setValue(store).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                Log.i("KMFG", "onComplete:ok ");
//            }
//        });
    }
}
