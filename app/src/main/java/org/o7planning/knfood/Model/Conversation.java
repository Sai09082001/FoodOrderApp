package org.o7planning.knfood.Model;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Conversation {
    private Message lastMessage;
    private User otherUser;

    public Conversation(Message lastMessage, User otherUser) {
        this.lastMessage = lastMessage;
        this.otherUser = otherUser;
    }

    public Message getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(Message lastMessage) {
        this.lastMessage = lastMessage;
    }

    public User getOtherUser() {
        return otherUser;
    }

    public void setOtherUser(User otherUser) {
        this.otherUser = otherUser;
    }
}