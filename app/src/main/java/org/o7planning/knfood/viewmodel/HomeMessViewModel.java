package org.o7planning.knfood.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.o7planning.knfood.Model.Conversation;
import org.o7planning.knfood.Model.Message;
import org.o7planning.knfood.Model.User;
import org.o7planning.knfood.base.BaseViewModel;

import java.util.ArrayList;

public class HomeMessViewModel extends BaseViewModel {
    private ArrayList<User> userArrayList;
    private ArrayList<Conversation> conversationArrayList;
    private MutableLiveData<ArrayList<User>> users;
    private MutableLiveData<ArrayList<Conversation>> conversations;
    private User currentUser;
    private DatabaseReference reference;
    private DatabaseReference lastMessReference;
    private ValueEventListener eventListener;//AIzaSyDIhaYXvMmfWXk8bozAcMPpZC4rrMu8gT8

    public HomeMessViewModel() {
        userArrayList = new ArrayList<>();
        conversationArrayList = new ArrayList<>();
        users = new MutableLiveData<>();
        conversations = new MutableLiveData<>();
        reference = firebaseDatabase.getReference().child("users-reg");
        lastMessReference = firebaseDatabase
                .getReference("all-chat")
                .child("last_mess");
    }

    public void loadUser(){
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (firebaseAuth.getCurrentUser() != null) {
                    userArrayList.clear();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        User user = dataSnapshot.getValue(User.class)
                                ;
                        if (user.getId().equals(firebaseAuth.getCurrentUser().getUid())){
                            currentUser = user;
                        } else {
                            userArrayList.add(user);
                        }
                    }
                    users.postValue(userArrayList);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void searchUser(String s){
        Query query = reference.orderByChild("userName")
                .startAt(s)
                .endAt(s+"\uf8ff");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (firebaseAuth.getCurrentUser() != null) {
                    userArrayList.clear();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        User user = dataSnapshot.getValue(User.class);
                        if (user.getId().equals(firebaseAuth.getCurrentUser().getUid())){
                            currentUser = user;
                        } else {
                            userArrayList.add(user);
                        }
                    }
                    users.postValue(userArrayList);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void loadRecentConversation() {
        if (eventListener != null) {
            lastMessReference.removeEventListener(eventListener);
        }
        eventListener = lastMessReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                conversationArrayList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Message mess = dataSnapshot.getValue(Message.class);
                    if (mess.getReceiverUid().equals(firebaseAuth.getCurrentUser().getUid())) {
                        for (User u : userArrayList) {
                            if (u.getId().equals(mess.getSenderUid())) {
                                conversationArrayList.add(new Conversation(mess, u));
                            }
                        }
                    } else if (mess.getSenderUid().equals(firebaseAuth.getCurrentUser().getUid())) {
                        for (User u : userArrayList) {
                            if (u.getId().equals(mess.getReceiverUid())) {
                                conversationArrayList.add(new Conversation(mess, u));
                            }
                        }
                    }
                    conversations.postValue(conversationArrayList);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public MutableLiveData<ArrayList<User>> getUsers() {
        return users;
    }

    public MutableLiveData<ArrayList<Conversation>> getConversations() {
        return conversations;
    }

    public ArrayList<User> getUserArrayList(){
        return  userArrayList;
    }

    public ArrayList<Conversation> getConversationArrayList() {
        return conversationArrayList;
    }

    public User getCurrentUser() {
        return currentUser;
    }

}
