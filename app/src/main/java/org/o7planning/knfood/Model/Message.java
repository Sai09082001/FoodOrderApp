package org.o7planning.knfood.Model;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Message {
    private String message, senderUid, receiverUid, timeStamp;
    private Boolean isSeen;


    public Message() {
    }

    public Message(String message, String senderUid, String receiverUid , String timeStamp, Boolean isSeen) {
        this.message = message;
        this.senderUid = senderUid;
        this.receiverUid = receiverUid;
        this.timeStamp = timeStamp;
        this.isSeen = isSeen;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderUid() {
        return senderUid;
    }

    public void setSenderUid(String senderUid) {
        this.senderUid = senderUid;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getReceiverUid() {
        return receiverUid;
    }

    public void setReceiverUid(String receiverUid) {
        this.receiverUid = receiverUid;
    }

    public Boolean getSeen() {
        return isSeen;
    }

    public void setSeen(Boolean seen) {
        isSeen = seen;
    }
}